package com.rajat.learn.TMS.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sub_task")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubTask {

    @JsonIgnore
    private String task_name;

    @Id
    private String sub_task_name;

//    @JsonIgnore
    private String sub_task_state;


    private String  sub_task_id;

    private String user_name;
}
