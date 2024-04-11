package org.example.historyservice.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SearchRecordRequestBody {
    private String organization;
    private String specialization;
    private String doctorFIO;
    private int limit;
    private int offset;


}
