package com.example.thi_module4.service.impl;

import com.example.thi_module4.model.Music;
import com.example.thi_module4.repository.IMusicRepository;
import com.example.thi_module4.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public Page<Music> findAll(Pageable pageable, String name) {
        return musicRepository.findAllByNameContaining(pageable, name);
    }

    @Override
    public void addMusic(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void deleteMusic(int id) {
        musicRepository.deleteById(id);
    }
}
