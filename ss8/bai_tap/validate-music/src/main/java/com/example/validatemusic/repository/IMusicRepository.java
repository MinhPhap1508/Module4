package com.example.validatemusic.repository;

import com.example.validatemusic.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMusicRepository extends JpaRepository<Music,Integer> {
}
