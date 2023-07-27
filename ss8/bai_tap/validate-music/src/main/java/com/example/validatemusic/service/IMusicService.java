package com.example.validatemusic.service;

import com.example.validatemusic.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> showMusic();
    void upload(Music music);
    Music getById(int id);
    void edit(Music music);
}
