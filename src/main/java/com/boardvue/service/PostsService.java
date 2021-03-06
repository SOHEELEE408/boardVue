package com.boardvue.service;

import com.boardvue.domain.posts.Posts;
import com.boardvue.domain.posts.PostsRepository;
import com.boardvue.web.dto.PostsListResponseDto;
import com.boardvue.web.dto.PostsResponseDto;
import com.boardvue.web.dto.PostsSaveRequestDto;
import com.boardvue.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional(readOnly = true)
    public PageImpl<PostsListResponseDto> findAll(PageRequest pageble){

        Page<Posts> entityList = postsRepository.findAll(pageble);
        List<PostsListResponseDto> result = entityList.stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());

        return new PageImpl<PostsListResponseDto>(result, pageble, entityList.getTotalElements());
    }

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public List<Posts> findAll(){
        List<Posts> contents = postsRepository.findAll();
        return contents;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostsResponseDto(entity);
    }

    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        postsRepository.delete(posts);
    }
}
