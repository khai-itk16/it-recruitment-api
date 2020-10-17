package com.itrecruitmentapi.repository;

import com.itrecruitmentapi.entity.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<SkillEntity, Integer> {
    @Query(
            value = "SELECT * FROM skill\n"+
                    "WHERE  account_id = :accountId"
            ,
            nativeQuery = true
    )
    List<SkillEntity> getSkillsByAccountId(@Param("accountId") int accountId);
}
