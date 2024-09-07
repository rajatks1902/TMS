package com.rajat.learn.TMS.Scheduler;


import com.rajat.learn.TMS.model.SubTask;
import com.rajat.learn.TMS.model.Task;
import com.rajat.learn.TMS.model.TaskState;
import com.rajat.learn.TMS.rs.managers.SubTaskManager;
import com.rajat.learn.TMS.rs.managers.TaskManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;



@Service
public class TaskItManager {


    @Autowired
    SubTaskManager subTaskManager;

    @Autowired
    TaskManager taskManager;

    public void checkSubTaskDeadline() {
        System.out.println("Updating SubTask Deadline");
        List<SubTask> subtasks=subTaskManager.getAllSubTask();
        OffsetDateTime now = OffsetDateTime.now();
        for(int i=0;i<subtasks.size();i++) {
            if (subtasks.get(i).getEndTime() != null) {
                int validation = subtasks.get(i).getEndTime().compareTo(now);
                if (validation > 0) {
                    //Update the DB
                    System.out.println("DeadLine Passed for subtasks :" + subtasks.get(i).getSub_task_name());
                    subtasks.get(i).setSub_task_state(String.valueOf(TaskState.FAILED));
                    subTaskManager.updateSubTaskInfo(subtasks.get(i));
                }
            }
        }
    }

    public void checkTaskDeadline() {
        System.out.println("Updating Task's Deadline");
        List<Task> tasks = taskManager.getAllDetails();
        OffsetDateTime now = OffsetDateTime.now();
        for(int i=0;i<tasks.size();i++) {
            if (tasks.get(i).getEndTime() != null) {
                int validation = tasks.get(i).getEndTime().compareTo(now);
                if (validation > 0) {
                    //Update the DB
                    System.out.println("DeadLine Passed for task :" + tasks.get(i).getTask_Name());
                    tasks.get(i).setState(String.valueOf(TaskState.FAILED));
                    taskManager.updatetask(tasks.get(i));
                }
            }
        }
    }
}
