package org.example.historyservice.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
