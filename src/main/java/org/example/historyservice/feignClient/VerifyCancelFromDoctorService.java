package org.example.historyservice.feignClient;


import org.example.historyservice.dto.request.CancelRecordRequestBody;
import org.example.historyservice.dto.request.CancelRecordRequestToDoctorService;
import org.example.historyservice.dto.response.CancelRecordResponseBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "verifyCancelFromDoctorService", url = "${doctor.service.url}")
public interface VerifyCancelFromDoctorService {
    @RequestMapping(method = RequestMethod.POST)
    void cancelRecord(@RequestBody CancelRecordRequestToDoctorService body);
}
