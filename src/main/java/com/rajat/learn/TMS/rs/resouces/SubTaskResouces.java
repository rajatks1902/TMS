package com.rajat.learn.TMS.rs.resouces;

import com.rajat.learn.TMS.model.SubTask;
import com.rajat.learn.TMS.rs.managers.SubTaskManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
public class SubTaskResouces {

    @Autowired
    public SubTaskManager subTaskManager;

    @PatchMapping("/UpdateSubTask")
    public void UpdateSubTask(@RequestBody SubTask subTask){

        subTaskManager.updateSubTaskInfo(subTask);

    }

    @GetMapping("/getSubTask/{subTaskID}")
    public SubTask getSubTaskByID(@PathVariable String subTaskID){
        return subTaskManager.getSubTaskById(subTaskID);
    }



}
