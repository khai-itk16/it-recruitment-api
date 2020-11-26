package com.itrecruitmentapi.repository;

import com.itrecruitmentapi.entity.EmployerResumeEntity;
import com.itrecruitmentapi.entity.JobPostEntity;
import com.itrecruitmentapi.entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface JobPostRepository extends JpaRepository<JobPostEntity, Integer> {
    List<JobPostEntity> findJobPostEntitiesByStatusEntityOrderByCreatePostTimeDesc(StatusEntity statusEntity);
    List<JobPostEntity> findJobPostEntitiesByEmployerResumeEntityAndStatusEntityOrderByCreatePostTimeDesc(EmployerResumeEntity employerResumeEntity, StatusEntity statusEntity);
    Long countAllByStatusEntity(StatusEntity statusEntity);

    @Query(
            value = "SELECT * FROM job_post\n" +
                    "WHERE job_code LIKE CONCAT('%', :keySearch , '%')\n" +
                    "OR job_title LIKE CONCAT('%', :keySearch ,'%')\n" +
                    "AND status_id = 2"
            ,
            nativeQuery = true
    )
    List<JobPostEntity> findJobPostsByKeyword(@Param("keySearch") String keySearch);

    @Query(
            value = "SELECT jp.* FROM job_post jp " +
                    "INNER JOIN account acc ON jp.account_id = acc.account_id\n" +
                    "INNER JOIN address ar ON acc.address_id = ar.address_id\n" +
                    "WHERE jp.job_title LIKE CONCAT('%', :keySearch ,'%')\n" +
                    "AND ar.province = :provinceId\n" +
                    "AND status_id = 2"
            ,
            nativeQuery = true
    )
    List<JobPostEntity> findJobPostsByKeyword(@Param("keySearch") String keySearch,
                                              @Param("provinceId") String provinceId);

    @Query(
            value = "SELECT jp.* FROM job_post jp " +
                    "INNER JOIN account acc ON jp.account_id = acc.account_id\n" +
                    "INNER JOIN address ar ON acc.address_id = ar.address_id\n" +
                    "WHERE jp.job_title LIKE CONCAT('%', :keySearch ,'%')\n" +
                    "AND ar.province = :provinceId\n" +
                    "AND jp.job_position_id = :positionId\n" +
                    "AND status_id = 2"
            ,
                nativeQuery = true
            )
    List<JobPostEntity> findJobPostsByKeyword(@Param("keySearch") String keySearch,
                                              @Param("provinceId") String provinceId,
                                              @Param("positionId") int positionId);

    @Query(
            value = "SELECT * FROM job_post\n" +
                    "WHERE job_title LIKE CONCAT('%', :keySearch ,'%')\n" +
                    "AND job_position_id = :positionId\n" +
                    "AND status_id = 2"
            ,
            nativeQuery = true
    )
    List<JobPostEntity> findJobPostsByKeyword(@Param("keySearch") String keySearch,
                                              @Param("positionId") int positionId);

    @Modifying()
    @Transactional()
    @Query(
            value = "UPDATE job_post\n" +
                    "SET status_id = 4\n" +
                    "WHERE DATE(expire_post_time) < CURDATE()"
            ,
            nativeQuery = true
    )
    void updateJobPostsExpire();

}
