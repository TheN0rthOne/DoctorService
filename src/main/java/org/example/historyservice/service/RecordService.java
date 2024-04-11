package org.example.historyservice.service;


import org.example.historyservice.dto.RecordDTO;
import org.example.historyservice.dto.request.CancelRecordRequestBody;
import org.example.historyservice.dto.request.CancelRecordRequestToDoctorService;
import org.example.historyservice.dto.request.SearchRecordRequestBody;
import org.example.historyservice.dto.request.StoreRecordRequestBody;
import org.example.historyservice.dto.response.CancelRecordResponseBody;
import org.example.historyservice.entity.Record;
import org.example.historyservice.entity.User;
import org.example.historyservice.entity.enums.Status;
import org.example.historyservice.exceptions.RecordNotFoundException;
import org.example.historyservice.feignClient.VerifyCancelFromDoctorService;
import org.example.historyservice.repository.RecordRepository;
import org.example.historyservice.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RecordService {
    private final RecordRepository recordRepository;
    private final UserRepository userRepository;
    private final VerifyCancelFromDoctorService verifyCancelFromDoctorService;

    public RecordService(RecordRepository recordRepository, UserRepository userRepository,
                         VerifyCancelFromDoctorService verifyCancelFromDoctorService) {
        this.recordRepository = recordRepository;
        this.userRepository = userRepository;
        this.verifyCancelFromDoctorService = verifyCancelFromDoctorService;
    }

    public void storeRecord(StoreRecordRequestBody body, Long userId) {
        User user = new User(userId);
        userRepository.save(user);
        recordRepository.save(new Record(body.getRecordId(), body.getDoctorId(),
                body.getDoctorFIO(), body.getSpecialization(), body.getOrganization(),
                Status.FUTURE, body.getTime(), user));
    }

    public List<RecordDTO> searchHistory(SearchRecordRequestBody body, Long userId) {
        Pageable pageable = PageRequest.of(body.getOffset(), body.getLimit());
        return recordRepository.getAllRecords(userId, body.getOrganization(),
                body.getSpecialization(), body.getDoctorFIO(), pageable);
    }

    public CancelRecordResponseBody cancelRecord(CancelRecordRequestBody body, Long userId) {
        Record record = recordRepository.findById(body.getRecordId()).orElseThrow(() -> new RecordNotFoundException(body.getRecordId()));

        try {
            verifyCancelFromDoctorService.cancelRecord(
                    new CancelRecordRequestToDoctorService(record.getDoctorFio(), record.getRecordId(),
                            record.getDoctorId(), record.getDateTime(), record.getSpecialization(), record.getOrganization()));
        } catch (HttpStatusCodeException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getMessage(), e);
        }
        try {
            recordRepository.cancelRecord(body.getRecordId());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        Pageable pageable = PageRequest.of(0, 10);
        return new CancelRecordResponseBody(recordRepository.getAllRecords(userId, null,
                null, null, pageable), "Отмена прошло успешно");

    }
}
