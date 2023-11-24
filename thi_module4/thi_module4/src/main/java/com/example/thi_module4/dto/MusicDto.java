package com.example.thi_module4.dto;

import com.example.thi_module4.model.Category;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

public class MusicDto implements Validator {
    private int id;
    @NotBlank(message = "Mã bài hát không được để trống")
    private String code;
        @NotBlank(message = "Tên bài hát không được để trống")
    private String name;
    @NotBlank(message = "Tác giả không được để trống")
    private String author;
    @NotBlank(message = "Ngày phát hành không được để trống")
    private String releaseDate;
    @NotBlank(message = "Mô tả không được để trống")
    private String description;
    private Category category;

    public MusicDto() {
    }

    public MusicDto(String code, String name, String author, String releaseDate, String description, Category category) {
        this.code = code;
        this.name = name;
        this.author = author;
        this.releaseDate = releaseDate;
        this.description = description;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
//        MusicDto musicDto = (MusicDto) target;
//        if(musicDto.name.equals("")){
//            errors.rejectValue("code",null,"Mã bài hát không được để trống");
//        }else (musicDto.name.length()>80)
//    }
    }
}
