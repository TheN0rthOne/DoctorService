package org.example.historyservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CancelRecordRequestBody {
    private Long recordId;
}
