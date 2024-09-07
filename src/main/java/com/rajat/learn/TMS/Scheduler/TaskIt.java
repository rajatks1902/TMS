package com.rajat.learn.TMS.Scheduler;

import com.rajat.learn.TMS.rs.managers.TaskManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskIt {

    @Autowired
    TaskItManager manager;

    public TaskIt() {
        System.out.println("TaskScheduler1 bean initialized");
    }

    @Scheduled(fixedRate = 5000) // Executes every 5 seconds
    public void performTask() {
        // Your task logic here
        manager.checkSubTaskDeadline();
        manager.checkTaskDeadline();


    }
}
