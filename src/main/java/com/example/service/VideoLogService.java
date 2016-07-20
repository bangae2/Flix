package com.example.service;

import com.example.entity.VideoLogEntity;

/**
 * Created by bangae1 on 2016-07-19.
 */
public interface VideoLogService {
    public void save(VideoLogEntity videoLogEntity);
    public VideoLogEntity findMaxDateByVideoKindSeq(int video_kind_seq);
}
