package com.example.service;

import com.example.dao.VideosDao;
import com.example.entity.VideosEntity;
import com.example.entity.VideosKindEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bangae1 on 2016-07-06.
 */
@Service
public class VideosServiceImpl implements VideosService {
    @Autowired
    private VideosDao videosDao;

    @Override
    @Transactional(readOnly = true)
    public List<VideosEntity> findPaging(int page) {
        int view = 20;
        int start = 0;
        if(page == 1) {
            start = page;
        } else {
            start = ((page -1) * view) + 1;
        }
        int end = page * view;
        return videosDao.findPaging(start, end);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public VideosEntity findOne(int id) {
        return this.videosDao.findOne(id);
    }

    @Override
    public List<VideosEntity> findSearch(String text) {
        return this.videosDao.findSearch(text);
    }

    @Override
    public List<VideosEntity> findGenre(String genre) {
        return this.videosDao.findGenre(genre);
    }

    @Override
    public List<VideosEntity> findAllByVideoKindSeq(int video_kind_seq) {
        return this.videosDao.findAllByVideoKindSeq(video_kind_seq);
    }

}
