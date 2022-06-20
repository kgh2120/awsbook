package com.example.awsbook.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@NoArgsConstructor
@Setter
@Getter
@Entity
public class Post extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    private String author;

    private String description;

    @Builder
    public Post(String author, String description) {
        this.author = author;
        this.description = description;
    }
}
