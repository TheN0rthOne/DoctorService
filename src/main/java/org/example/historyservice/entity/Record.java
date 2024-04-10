package org.example.historyservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.historyservice.entity.enums.Status;

import java.time.LocalDateTime;

@Entity
@Table(name = "records", schema = "pius_project_history")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Record {
    @Id
    private Long recordId;

    private Long doctorId;

    private String doctorFio;

    private String specialization;

    private String organization;

    private Status status;

    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
