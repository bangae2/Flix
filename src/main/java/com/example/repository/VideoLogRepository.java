package com.example.repository;

import com.example.entity.VideoLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by bangae1 on 2016-07-19.
 */
public interface VideoLogRepository extends JpaRepository<VideoLogEntity, Integer> {
    @Query(value = "select * from video_log where id = :id", nativeQuery = true)
    public List<VideoLogEntity> findById(@Param("id")String id);
}
