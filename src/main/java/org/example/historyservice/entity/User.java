package org.example.historyservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name= "user",schema = "pius_project_history")
public class User {
    @Id
    private long id;

    @OneToMany(mappedBy = "user")
    private List<Record> records;

}
