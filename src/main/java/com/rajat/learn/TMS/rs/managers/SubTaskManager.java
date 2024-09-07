package com.rajat.learn.TMS.rs.managers;

import com.rajat.learn.TMS.dao.SubTaskDao;
import com.rajat.learn.TMS.model.SubTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.rajat.learn.TMS.model.TaskState.CREATED;


@Service
public class SubTaskManager {


    @Autowired
    private SubTaskDao subTaskDao;

    @Autowired
    public TimeManager timeManager;


    void updateSubTask(String taskName, List<SubTask> subTaskList) {


        for(int i=0;i<subTaskList.size();i++){
            SubTask subTask = subTaskList.get(i);

            subTask.setTask_name(taskName);
            subTask.setSub_task_id(taskName+"_"+ subTask.getSub_task_name());
            subTask.setSub_task_state(String.valueOf(CREATED));
//            subTask.setEndTime((timeManager.getEndTime(
                    

            subTaskDao.save(subTaskList.get(i));
        }


    }

    public void updateSubTaskInfo(SubTask subTask) {
//        if(subTask.getSub_task_id()==null){
//            throw new InvalidRequestException("Sub task name cannot be null or empty");
//        }
        SubTask subTaskFromDb = getSubTaskById(subTask.getSub_task_name());
        CheckSubTaskDetails(subTask,subTaskFromDb);
        subTaskDao.save(subTaskFromDb);
    }

    public SubTask getSubTaskById(String subTaskID) {

        return subTaskDao.findById(subTaskID).orElse(new SubTask());
    }

    public List<SubTask> getAllSubTask(){

        return subTaskDao.findAll();
    }

    public void CheckSubTaskDetails(SubTask entity1, SubTask entity2) {
        // Update only if task_name is present in entity1
        if (entity1.getTask_name() != null && !entity1.getTask_name().isEmpty()) {
            entity2.setTask_name(entity1.getTask_name());
        }

        // Update only if sub_task_name is present in entity1
        if (entity1.getSub_task_name() != null && !entity1.getSub_task_name().isEmpty()) {
            entity2.setSub_task_name(entity1.getSub_task_name());
        }

        // Update only if sub_task_state is present in entity1
        if (entity1.getSub_task_state() != null && !entity1.getSub_task_state().isEmpty()) {
            entity2.setSub_task_state(entity1.getSub_task_state());
        }

        // Update only if sub_task_id is present in entity1
        if (entity1.getSub_task_id() != null && !entity1.getSub_task_id().isEmpty()) {
            entity2.setSub_task_id(entity1.getSub_task_id());
        }

        // Update only if user_name is present in entity1
        if (entity1.getUser_name() != null && !entity1.getUser_name().isEmpty()) {
            entity2.setUser_name(entity1.getUser_name());
        }
    }

}
