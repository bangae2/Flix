package com.example.repository;

import com.example.entity.VideoLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by bangae1 on 2016-07-19.
 */
public interface VideoLogRepository extends JpaRepository<VideoLogEntity, String> {
    @Query(value = "select * from video_log where video_seq = :video_seq and id = :id", nativeQuery = true)
    public VideoLogEntity findByVideoSeq(@Param("video_seq")int video_seq, @Param("id")String id);

    @Modifying
    @Query(value = "update video_log set insert_date = :insert_date where video_seq = :video_seq and video_kind_seq = :video_kind_seq and id = :id", nativeQuery = true)
    public void update(@Param("id")String id, @Param("insert_date")String insert_date,
                       @Param("video_seq")int video_seq, @Param("video_kind_seq")int video_kind_seq);

    @Query(value = "select * from video_log a inner join (select max(insert_date) as ins_date from video_log) b on a.insert_date = b.ins_date and a.video_kind_seq = :video_kind_seq", nativeQuery = true)
    public VideoLogEntity findMaxDateByVideoKindSeq(@Param("video_kind_seq")int video_kind_seq);
}
