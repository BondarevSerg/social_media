package com.example.social_media.controller;

import com.example.social_media.dto.request.PostRequest;
import com.example.social_media.dto.request.UserRequest;
import com.example.social_media.dto.response.PostResponse;
import com.example.social_media.dto.response.UserResponse;
import com.example.social_media.service.Imp.PostServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * контроллер работы с постами пользователей
 */
@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostServiceImp postService;

    /**
     * Получение списка постов по id пользователя
     *
     * @return
     */
    @GetMapping("/{id}")
    public List<PostResponse> getAllPostByUserId(@PathVariable("id")Long id) {
        return postService.getAllPostsByUserId(id);
    }

    /**
     * Получение  поста по id
     *
     * @return
     */
    @GetMapping("/post/{id}")
    public PostResponse getPostById(@PathVariable("id")Long id) {
        return postService.getPostById(id);
    }

    /**
     * сохранение нового поcта
     * @param postRequest
     * @return
     */
    @PostMapping()
    public ResponseEntity<HttpStatus> create(@RequestBody PostRequest postRequest) {

        postService.savePost(postRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    /**
     * удаление поста по id
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable ("id")Long id) {

        postService.deletePost(id);
        return ResponseEntity.ok(HttpStatus.OK);

    }

    /**
     * обновление  поcта по id
     * @param id
     * @param postRequest
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable ("id")Long id,
                                             PostRequest postRequest) {

        postService.updatePost(id, postRequest);
        return ResponseEntity.ok(HttpStatus.OK);

    }
}
