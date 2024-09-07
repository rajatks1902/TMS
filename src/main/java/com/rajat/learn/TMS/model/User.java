package com.rajat.learn.TMS.model;

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
@Table(name = "users")
public class User {

    @Id
    private int userId;  // Maps to the 'user_id' column in the database

    private String userName;  // Maps to the 'user_name' column
    private String name;  // Maps to the 'name' column
    private String password;  // Maps to the 'password' column
    private String email;  // Maps to the 'email' column
}
