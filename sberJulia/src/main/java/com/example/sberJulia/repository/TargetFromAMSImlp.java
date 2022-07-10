package com.example.sberJulia.repository;

import com.example.sberJulia.entity.Target;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;

public interface TargetFromAMSImlp extends CrudRepository<Target, String> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO TARGET (guid,user_guid, content_guid, page, priority, start_date, end_date) VALUES (uuid(),:userGuid, :contentGuid, :page, :priority, :startDate, :endDate)", nativeQuery = true)
    int setTarget(@Param("userGuid") String userGuid, @Param("contentGuid") String contentGuid,
                  @Param("page") String page, @Param("priority") int priority,
                  @Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
