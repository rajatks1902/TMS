package com.rajat.learn.TMS.rs.resouces;

import com.rajat.learn.TMS.exceptions.InvalidRequestException;
import com.rajat.learn.TMS.model.Task;
import com.rajat.learn.TMS.rs.managers.TaskManager;
import com.sun.jdi.request.InvalidRequestStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
public class TaskResouces {

    @Autowired
    public TaskManager taskManager;


    @GetMapping("/task/{taskID}")
    public Task getTask(@PathVariable int taskID){
        return taskManager.getCurrentTaskDetails(taskID);
    }


    @PostMapping("/taskPost")
    public void addTask(@RequestBody Task task)  {
        taskManager.addNewTask(task);
    }

    @GetMapping("/task")
    public List<Task> getAllTask(){
        return taskManager.getAllDetails();
    }

    @PutMapping("/updataTask")
    public void updateTask(@RequestBody Task task){
         taskManager.updatetask(task);
    }
}
