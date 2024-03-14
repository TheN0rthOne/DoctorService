package org.example.historyservice.entity;

import jakarta.persistence.*;
import org.example.historyservice.entity.enums.Status;

import java.time.LocalDateTime;

@Entity
@Table(name = "records", schema = "pius_project_history")
public class Record {
    @Id
    private long recordId;

    private long doctorId;

    private String doctorFio;

    private String specialization;

    private String organization;

    private Status status;

    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
