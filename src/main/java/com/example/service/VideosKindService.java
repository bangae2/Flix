package com.example.service;

import com.example.entity.VideosKindEntity;

import java.util.List;

/**
 * Created by bangae1 on 2016-07-16.
 */
public interface VideosKindService {
    public VideosKindEntity findOne(int id);
    public List<VideosKindEntity> findAll();
    public List<VideosKindEntity> findSearch(String text);
    public List<VideosKindEntity> findGenre(String genre);
}
