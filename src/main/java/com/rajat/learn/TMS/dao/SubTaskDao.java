package com.rajat.learn.TMS.dao;

import com.rajat.learn.TMS.model.SubTask;
import com.rajat.learn.TMS.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTaskDao extends JpaRepository<SubTask,String> {


}
