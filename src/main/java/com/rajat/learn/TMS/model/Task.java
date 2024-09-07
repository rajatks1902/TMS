package com.rajat.learn.TMS.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {

    @Id
    @JsonProperty("taskID")
    private int task_ID;

    @NonNull
    @JsonProperty("taskName")
    private String task_Name;

    @NonNull
    @JsonProperty("duration")
    private String duration;

    @JsonProperty("state")
    private String state;

    @JsonProperty("userName")
    private String user_name;

    @Transient
    @JsonProperty("subTask")
    private List<SubTask> subTaskList;



    @Column(name = "end_date")
    @JsonIgnore
    private OffsetDateTime endTime;
}
