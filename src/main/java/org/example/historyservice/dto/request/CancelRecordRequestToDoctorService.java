package org.example.historyservice.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.historyservice.entity.enums.Status;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class CancelRecordRequestToDoctorService {
    private String doctorFIO;
    private Long recordId;
    private LocalDateTime time;
    private String specialization;
    private String organization;
}
