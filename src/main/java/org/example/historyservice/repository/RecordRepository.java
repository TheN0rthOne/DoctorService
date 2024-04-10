package org.example.historyservice.repository;

import org.example.historyservice.dto.RecordDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.example.historyservice.entity.Record;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Long> {

    @Query("select new org.example.historyservice.dto.RecordDTO(r.doctorFio, r.recordId, " +
            "r.dateTime, r.specialization, r.organization,r.status) " +
            "from Record r inner join User u on r.user.id = u.id " +
            "where (u.id = :userId) " +
            "and (:organization is null or r.organization like concat('%', :organization, '%')) " +
            "and (:specialization is null or r.specialization like concat('%', :specialization, '%')) " +
            "and (:doctorFIO is null or r.doctorFio like concat('%', :doctorFIO, '%'))")
    List<RecordDTO> getAllRecords(Long userId, String organization,
                                  String specialization, String doctorFIO, Pageable pageable);

    @Modifying
    @Query(value = "update pius_project_history.records set status = 'запись отменена' " +
            "where record_id = :recordId", nativeQuery = true)
    void cancelRecord(Long recordId);

}
