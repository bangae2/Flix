package com.example.dao;

import com.example.entity.VideosKindEntity;
import com.example.repository.VideosKindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by bangae1 on 2016-07-16.
 */
@Repository
public class VideosKindDaoImpl implements VideosKindDao {
    @Autowired
    private VideosKindRepository videosKindRepository;

    public VideosKindEntity findOne(int id) {
        return this.videosKindRepository.findOne(id);
    }


    public Sort title_sort() {
        return new Sort(Sort.Direction.ASC, "title2");
    }
}
