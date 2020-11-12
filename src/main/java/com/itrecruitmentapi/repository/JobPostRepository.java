package com.itrecruitmentapi.repository;

import com.itrecruitmentapi.entity.AccountEntity;
import com.itrecruitmentapi.entity.EmployerResumeEntity;
import com.itrecruitmentapi.entity.JobPostEntity;
import com.itrecruitmentapi.entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPostRepository extends JpaRepository<JobPostEntity, Integer> {
    List<JobPostEntity> findJobPostEntitiesByStatusEntityOrderByCreatePostTimeDesc(StatusEntity statusEntity);
    List<JobPostEntity> findJobPostEntitiesByEmployerResumeEntityAndStatusEntityOrderByCreatePostTimeDesc(EmployerResumeEntity employerResumeEntity, StatusEntity statusEntity);
    Long countAllByStatusEntity(StatusEntity statusEntity);

    @Query(
            value = "SELECT * FROM job_post\n" +
                    "where job_code like CONCAT('%', :keySearch , '%')\n" +
                    "or job_title like CONCAT('%', :keySearch ,'%')\n" +
                    "and status_id = 2"
            ,
            nativeQuery = true
    )
    List<JobPostEntity> findJobPostsByKeyword(@Param("keySearch") String keySearch);

    @Query(
            value = "SELECT jp.* FROM job_post jp " +
                    "INNER JOIN account acc ON jp.account_id = acc.account_id\n" +
                    "INNER JOIN address ar ON acc.address_id = ar.address_id\n" +
                    "where jp.job_title like CONCAT('%', :keySearch ,'%')\n" +
                    "and ar.province = :provinceId\n" +
                    "and status_id = 2"
            ,
            nativeQuery = true
    )
    List<JobPostEntity> findJobPostsByKeyword(@Param("keySearch") String keySearch,
                                              @Param("provinceId") String provinceId);

    @Query(
            value = "SELECT jp.* FROM job_post jp " +
                    "INNER JOIN account acc ON jp.account_id = acc.account_id\n" +
                    "INNER JOIN address ar ON acc.address_id = ar.address_id\n" +
                    "where jp.job_title like CONCAT('%', :keySearch ,'%')\n" +
                    "and ar.province = :provinceId\n" +
                    "and jp.job_position_id = :positionId\n" +
                    "and status_id = 2"
            ,
                nativeQuery = true
            )
    List<JobPostEntity> findJobPostsByKeyword(@Param("keySearch") String keySearch,
                                              @Param("provinceId") String provinceId,
                                              @Param("positionId") int positionId);

    @Query(
            value = "SELECT * FROM job_post\n" +
                    "where job_title like CONCAT('%', :keySearch ,'%')\n" +
                    "and job_position_id = :positionId\n" +
                    "and status_id = 2"
            ,
            nativeQuery = true
    )
    List<JobPostEntity> findJobPostsByKeyword(@Param("keySearch") String keySearch,
                                              @Param("positionId") int positionId);

}
