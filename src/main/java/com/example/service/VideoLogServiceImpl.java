package com.example.service;

import com.example.dao.VideoLogDao;
import com.example.entity.VideoLogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by bangae1 on 2016-07-19.
 */
@Service
public class VideoLogServiceImpl implements VideoLogService {
    @Autowired
    private VideoLogDao videoLogDao;

    @Transactional
    public void save(VideoLogEntity videoLogEntity) {
        this.videoLogDao.save(videoLogEntity);
    }
}
