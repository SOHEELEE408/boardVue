package com.boardvue.web;

import com.boardvue.domain.posts.Posts;
import com.boardvue.service.PostsService;
import com.boardvue.web.dto.PostsListResponseDto;
import com.boardvue.web.dto.PostsResponseDto;
import com.boardvue.web.dto.PostsSaveRequestDto;
import com.boardvue.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @GetMapping("/api/v1")
    public PageImpl<PostsListResponseDto> findAll(@RequestParam Integer page){
        PageRequest pageble = PageRequest.of(page -1,10);

        return postsService.findAll(pageble);
    }

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}
