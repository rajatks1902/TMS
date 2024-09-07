package com.rajat.learn.TMS.rs.managers;

import com.rajat.learn.TMS.dao.TaskDao;
import com.rajat.learn.TMS.model.CompletionTime;
import com.rajat.learn.TMS.model.SubTask;
import com.rajat.learn.TMS.model.Task;
import com.rajat.learn.TMS.model.TaskState;
import com.sun.jdi.request.InvalidRequestStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TaskManager {

    @Autowired
    public TaskDao taskDao;

    @Autowired
    public SubTaskManager subTaskManager;


    public Task getCurrentTaskDetails(int taskId) {
        return taskDao.findById(taskId).orElse(new Task());

    }

    public List<Task> getAllDetails() {
        return taskDao.findAll();

    }

    public void addNewTask(Task task) throws InvalidRequestStateException{

            ValidateTask(task);

            task.setUser_name("rajat");

            updateTaskInfo(task);

        subTaskManager.updateSubTask(task.getTask_Name(), task.getSubTaskList());

            taskDao.save(task);
    }



    private void ValidateTask(Task task)throws InvalidRequestStateException{


        String duration = task.getDuration();

            CompletionTime timeUnit = CompletionTime.valueOf(duration.toUpperCase());

            if (timeUnit != CompletionTime.TODAY && timeUnit != CompletionTime.MONTH && timeUnit != CompletionTime.YEAR) {
                // Do something if it's not TODAY, MONTH, or YEAR
                throw new InvalidRequestStateException("Not a Valid Duration");

            }



    }

    private void updateTaskInfo(Task task){
            task.setState(String.valueOf(TaskState.CREATED));
            task.setEndTime(getEndTime(task.getDuration()));

    }

    private  LocalDateTime getEndTime(String period) {
        LocalDateTime now = LocalDateTime.now();
        LocalDate endDate;
        LocalDateTime endTime = null;

        switch (period.toUpperCase()) {
            case "TODAY":
                endTime = now.toLocalDate().atTime(23, 59, 59);  // End of today
                break;

            case "WEEK":
                endDate = now.toLocalDate().with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
                endTime = endDate.atTime(23, 59, 59);  // End of the week (Sunday 11:59:59 PM)
                break;

            case "MONTH":
                endDate = now.toLocalDate().with(TemporalAdjusters.lastDayOfMonth());
                endTime = endDate.atTime(23, 59, 59);  // End of the month (Last day 11:59:59 PM)
                break;

            default:
                throw new IllegalArgumentException("Invalid period: " + period);
        }
        return endTime;
    }

}
