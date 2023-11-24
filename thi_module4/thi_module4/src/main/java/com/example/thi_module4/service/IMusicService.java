package com.example.thi_module4.service;

import com.example.thi_module4.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMusicService {
    Page<Music> findAll(Pageable pageable, String name);
    void addMusic(Music music);
    void deleteMusic(int id);
}
