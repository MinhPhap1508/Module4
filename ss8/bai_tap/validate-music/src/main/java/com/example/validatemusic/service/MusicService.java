package com.example.validatemusic.service;

import com.example.validatemusic.model.Music;
import com.example.validatemusic.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    IMusicRepository musicRepository;

    @Override
    public List<Music> showMusic() {
        return musicRepository.findAll();
    }

    @Override
    public void upload(Music music) {
        musicRepository.save(music);
    }

    @Override
    public Music getById(int id) {
        return musicRepository.findById(id).get();
    }

    @Override
    public void edit(Music music) {
        musicRepository.save(music);
    }
}
