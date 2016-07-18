package com.example.service;

import com.example.dao.VideosKindDao;
import com.example.entity.VideosKindEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by bangae1 on 2016-07-16.
 */
@Service
public class VideosKindServiceImpl implements VideosKindService {

    @Autowired
    private VideosKindDao videosKindDao;

    @Override
    @Transactional(readOnly = true)
    public VideosKindEntity findOne(int id) {
        return this.videosKindDao.findOne(id);
    }
}
