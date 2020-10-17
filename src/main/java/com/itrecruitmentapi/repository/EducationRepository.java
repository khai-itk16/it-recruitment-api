package com.itrecruitmentapi.repository;

import com.itrecruitmentapi.entity.AccountEntity;
import com.itrecruitmentapi.entity.EducationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationRepository extends JpaRepository<EducationEntity, Integer> {
    @Query(
            value = "SELECT * FROM education\n"+
            "WHERE  account_id = :accountId"
            ,
            nativeQuery = true
    )
    List<EducationEntity> getEducationsByAccountId(@Param("accountId") int accountId);
}
