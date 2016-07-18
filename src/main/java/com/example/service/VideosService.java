package com.example.service;

import com.example.entity.VideosEntity;
import com.example.entity.VideosKindEntity;

import java.util.List;

/**
 * Created by bangae1 on 2016-07-06.
 */
public interface VideosService {
    public List<VideosEntity> findPaging(int page);
    public VideosEntity findOne(int id);
    public List<VideosEntity> findSearch(String text);
    public List<VideosEntity> findGenre(String genre);
    public List<VideosEntity> findAllByVideoKindSeq(int video_kind_seq);
}
