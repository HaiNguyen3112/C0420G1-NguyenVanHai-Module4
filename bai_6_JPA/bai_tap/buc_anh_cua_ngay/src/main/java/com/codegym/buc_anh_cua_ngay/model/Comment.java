package com.codegym.buc_anh_cua_ngay.model;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long mark;
    private String name;
    private String content;
    @Column(name ="total_like")
    private Long totalLike;

    public Comment() {
        totalLike = 0L;
    }

    public Comment(String name, Long mark ,String content,Long totalLike) {
        this.mark = mark;
        this.name = name;
        this.content = content;
        this.totalLike = totalLike;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getMark() {
        return mark;
    }

    public void setMark(Long mark) {
        this.mark = mark;
    }

    public Long getTotalLike() {
        return totalLike;
    }

    public void setTotalLike(Long totalLike) {
        this.totalLike = totalLike;
    }
}

