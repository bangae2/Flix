package com.example.dao;

import com.example.entity.VideoLogEntity;
import com.example.repository.VideoLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by bangae1 on 2016-07-19.
 */
@Repository
public class VideoLogDaoImpl implements VideoLogDao {
    @Autowired
    private VideoLogRepository videoLogRepository;

    public void save(VideoLogEntity videoLogEntity) {
        this.videoLogRepository.save(videoLogEntity);
    }
}
