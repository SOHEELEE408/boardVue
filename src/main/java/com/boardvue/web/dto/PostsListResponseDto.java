package com.boardvue.web.dto;

import com.boardvue.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;
    private LocalDateTime createdDate;

    public PostsListResponseDto(Posts entity){
        this.id= entity.getId();
        this.title= entity.getTitle();
        this.author= entity.getAuthor();
        this.modifiedDate=entity.getModifiedDate();
        this.createdDate=entity.getCreatedDate();
    }
}
