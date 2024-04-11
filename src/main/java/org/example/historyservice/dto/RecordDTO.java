package org.example.historyservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.historyservice.entity.enums.Status;

import java.time.LocalDateTime;


@AllArgsConstructor
@Getter
@Setter
public class RecordDTO {
    private String doctorFIO;
    private Long recordId;
    private LocalDateTime time;
    private String specialization;
    private String organization;
    private Status status;

}
