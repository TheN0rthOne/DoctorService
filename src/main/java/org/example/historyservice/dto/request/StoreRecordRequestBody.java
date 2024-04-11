package org.example.historyservice.dto.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import org.example.historyservice.entity.enums.Status;

@AllArgsConstructor
@Getter
@Setter
public class StoreRecordRequestBody {
    private Long recordId;
    private Long doctorId;
    private String doctorFIO;
    private LocalDateTime time;
    private String specialization;
    private String organization;

}
