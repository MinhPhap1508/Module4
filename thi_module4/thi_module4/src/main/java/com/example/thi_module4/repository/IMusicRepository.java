package com.example.thi_module4.repository;

import com.example.thi_module4.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMusicRepository extends JpaRepository<Music, Integer> {
    Page<Music> findAllByNameContaining(Pageable pageable, String name);
    Page<Music> findMusicByNameContaining(Pageable pageable, String name);
}
