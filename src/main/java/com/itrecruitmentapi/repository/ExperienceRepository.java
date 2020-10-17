package com.itrecruitmentapi.repository;

import com.itrecruitmentapi.entity.EducationEntity;
import com.itrecruitmentapi.entity.ExperienceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepository extends JpaRepository<ExperienceEntity, Integer> {
    @Query(
            value = "SELECT * FROM experience\n"+
                    "WHERE  account_id = :accountId"
            ,
            nativeQuery = true
    )
    List<ExperienceEntity> getExperiencesByAccountId(@Param("accountId") int accountId);
}
