package org.example.historyservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class CancelRecordRequestToDoctorService implements Serializable {
    private String doctorFIO;
    private Long recordId;
    private Long doctorId;
    private LocalDateTime time;
    private String specialization;
    private String organization;
}
