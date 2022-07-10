package com.example.sberJulia.repository;

import com.example.sberJulia.entity.Content;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


public interface DataContentFromCMSImlp extends CrudRepository<Content, String> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO CONTENT (guid,  data) VALUES (:contentGuid, :data)", nativeQuery = true)
    int setDataContent(@Param("contentGuid") String contentGuid, @Param("data") String data);
}
