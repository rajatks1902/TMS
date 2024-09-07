package com.rajat.learn.TMS.rs.managers;

import com.rajat.learn.TMS.dao.TaskDao;
import com.rajat.learn.TMS.exceptions.InvalidRequestException;
import com.rajat.learn.TMS.model.CompletionTime;
import com.rajat.learn.TMS.model.Task;
import com.rajat.learn.TMS.model.TaskState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskManager {

    @Autowired
    public TaskDao taskDao;

    @Autowired
    public SubTaskManager subTaskManager;

    @Autowired
    public JwtManager token;


    @Autowired
    public TimeManager timeManager;

    public Task getCurrentTaskDetails(int taskId) {
        return taskDao.findById(taskId).orElse(new Task());

    }

    public List<Task> getAllDetails() {
        return taskDao.findAll();

    }

    public void addNewTask(Task task){

            ValidateTaskDuration(task);

            task.setUser_name(token.getUserName());

            updateTaskInfo(task);

        subTaskManager.updateSubTask(task.getTask_Name(), task.getSubTaskList());

            taskDao.save(task);
    }


    private void ValidateTaskDuration(Task task) throws InvalidRequestException{

            try {
                CompletionTime.valueOf(task.getDuration().toUpperCase());
            }catch(Exception e){
                throw new InvalidRequestException("Invalid deadline: Please specify either DAY, WEEK, or MONTH.");

            }



    }

    private void updateTaskInfo(Task task){
            task.setState(String.valueOf(TaskState.CREATED));
            task.setEndTime(timeManager.getEndTime(task.getDuration()));

    }

    public void CheckTaskDetails(Task entity1, Task entity2) {
        // Update only if task_Name is present in entity1
        if (!entity1.getTask_Name().isEmpty()) {
            entity2.setTask_Name(entity1.getTask_Name());
        }

        // Update only if duration is present in entity1
        if (!entity1.getDuration().isEmpty()) {
            entity2.setDuration(entity1.getDuration());
        }

        // Update only if state is present in entity1
        if (entity1.getState() != null && !entity1.getState().isEmpty()) {
            entity2.setState(entity1.getState());
        }

        // Update only if user_name is present in entity1
        if (entity1.getUser_name() != null && !entity1.getUser_name().isEmpty()) {
            entity2.setUser_name(entity1.getUser_name());
        }

        // Optional: Update subTaskList if needed
        if (entity1.getSubTaskList() != null && !entity1.getSubTaskList().isEmpty()) {
            entity2.setSubTaskList(entity1.getSubTaskList());
        }
    }


    public void updatetask(Task task) {
        Task taskfromDb =getCurrentTaskDetails(task.getTask_ID());
        System.out.println("Task from DB : "+taskfromDb);
        System.out.println("Task from Scheduler : "+task);
        CheckTaskDetails(task,taskfromDb);
        taskDao.save(taskfromDb);
    }
}
