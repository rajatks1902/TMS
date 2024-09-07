package com.rajat.learn.TMS.Scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskScheduler {

    public TaskScheduler() {
        System.out.println("TaskScheduler bean initialized");
    }

    @Scheduled(fixedRate = 5000) // Executes every 5 seconds
    public void performTask() {
        // Your task logic here
        System.out.println("Sudar jaa bhai");
        System.out.println("Task executed at " + new java.util.Date());
    }
}
