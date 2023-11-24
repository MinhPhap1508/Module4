package com.example.thi_module4.model;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "category")
    Set<Music> musicSet;

    public Category() {
    }

    public Category(int id, String name, String description, Set<Music> musicSet) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.musicSet = musicSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Music> getMusicSet() {
        return musicSet;
    }

    public void setMusicSet(Set<Music> musicSet) {
        this.musicSet = musicSet;
    }
}
