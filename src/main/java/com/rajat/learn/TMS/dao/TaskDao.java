package com.rajat.learn.TMS.dao;

import com.rajat.learn.TMS.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDao extends JpaRepository<Task,Integer>{
}
