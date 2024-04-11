package org.example.historyservice.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.historyservice.dto.RecordDTO;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CancelRecordResponseBody {
    private List<RecordDTO> cancelRecordResponse;
    private String message;

}
