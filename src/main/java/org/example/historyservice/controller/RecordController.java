package org.example.historyservice.controller;


import org.example.historyservice.dto.request.CancelRecordRequestBody;
import org.example.historyservice.dto.request.SearchRecordRequestBody;
import org.example.historyservice.dto.request.StoreRecordRequestBody;
import org.example.historyservice.dto.response.CancelRecordResponseBody;
import org.example.historyservice.dto.response.SearchRecordResponseBody;
import org.example.historyservice.service.RecordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/history")
public class RecordController {
    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping
    public void storeHistory(@RequestBody StoreRecordRequestBody body,
                            @RequestHeader(name = "user-id") Long userId){
        recordService.storeRecord(body, userId);
    }

    @GetMapping
    public SearchRecordResponseBody searchHistory(@RequestBody SearchRecordRequestBody body,
                                                  @RequestHeader(name = "user-id") Long userId){
       return recordService.searchHistory(body, userId);
    }

    @DeleteMapping
    public CancelRecordResponseBody cancelRecord(@RequestBody CancelRecordRequestBody body,
                                                 @RequestHeader(name = "user-id") Long userId){
        return recordService.cancelRecord(body,userId);
    }


}
