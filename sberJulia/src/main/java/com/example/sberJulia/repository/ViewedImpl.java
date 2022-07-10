package com.example.sberJulia.repository;

import com.example.sberJulia.entity.Viewed;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ViewedImpl extends CrudRepository<Viewed, String> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO VIEWED (guid, content_guid, user_guid) VALUES (uuid(), :contentGuid, :userGuid)", nativeQuery = true)
    int setViewed(@Param("contentGuid") String contentGuid, @Param("userGuid") String userGuid);
}
