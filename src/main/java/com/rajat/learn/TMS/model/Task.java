package com.rajat.learn.TMS.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {

    @Id
    @JsonProperty("taskID")
    private int task_ID;

    @JsonProperty("taskName")
    private String task_Name;

    @JsonProperty("duration")
    private String duration;

    @JsonProperty("state")
    private String state;

    @JsonProperty("userName")
    private String user_name;

    @Transient
    @JsonProperty("subTask")
    private List<SubTask> subTaskList;

    @Transient
    @JsonIgnore
    private LocalDateTime endTime;
}
