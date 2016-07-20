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

    @Override
    @Transactional
    public void save(VideoLogEntity videoLogEntity) {
        this.videoLogDao.save(videoLogEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public VideoLogEntity findMaxDateByVideoKindSeq(int video_kind_seq) {
        return this.videoLogDao.findMaxDateByVideoKindSeq(video_kind_seq);
    }
}
