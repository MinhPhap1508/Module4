package com.example.validatemusic.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MusicDto implements Validator {
    private int id;
    private String name;
    private String signer;
    private String kindOfMusic;

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

    public String getSigner() {
        return signer;
    }

    public void setSigner(String signer) {
        this.signer = signer;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MusicDto musicDto = (MusicDto) target;
        if(musicDto.getName().equals("")){
            errors.rejectValue("name",null,"Name Cannot Empty");
        } else if (musicDto.getName().length()>800) {
            errors.rejectValue("name",null,"Name is to long");
        } else if (!musicDto.getName().matches("^[a-zA-Z0-9]*$")) {
            errors.rejectValue("name", null, "Name can't contain special characters");
        }
        if(musicDto.getSigner().equals("")){
            errors.rejectValue("signer",null,"Name Cannot Empty");
        } else if (musicDto.getSigner().length()>300) {
            errors.rejectValue("signer",null,"Name is to long");
        } else if (!musicDto.getSigner().matches("^[a-zA-Z0-9]*$")) {
            errors.rejectValue("signer", null, "Name can't contain special characters");
        }
        if(musicDto.getKindOfMusic().equals("")){
            errors.rejectValue("kindOfMusic",null,"Name Cannot Empty");
        } else if (musicDto.getKindOfMusic().length()>1000) {
            errors.rejectValue("kindOfMusic",null,"Name is to long");
        } else if (!musicDto.getKindOfMusic().matches("^[a-zA-Z0-9,]*$")) {
            errors.rejectValue("kindOfMusic", null, "Name can't contain special characters");
        }
    }
}
