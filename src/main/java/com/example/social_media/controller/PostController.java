package com.example.social_media.controller;

import com.example.social_media.dto.request.PostRequest;
import com.example.social_media.dto.request.UserRequest;
import com.example.social_media.dto.response.PostResponse;
import com.example.social_media.dto.response.UserResponse;
import com.example.social_media.service.Imp.PostServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(
        name = "Посты",
        description = "контроллер работы с постами пользователей"
)
public class PostController {

    private final PostServiceImp postService;

    /**
     * Получение списка постов по id пользователя
     *
     * @return
     */
    @GetMapping("/{id}")
    @Operation(summary = "Получение списка постов по id пользователя")
    public List<PostResponse> getAllPostByUserId(@Parameter(description = "id пользователя")@PathVariable("id")Long id) {
        return postService.getAllPostsByUserId(id);
    }

    /**
     * Получение  поста по id
     *
     * @return
     */
    @GetMapping("/post/{id}")
    @Operation(summary = "Получение  поста по id")
    public PostResponse getPostById(@Parameter(description = "id поста")@PathVariable("id")Long id) {
        return postService.getPostById(id);
    }

    /**
     * сохранение нового поcта
     * @param postRequest
     * @return
     */
    @PostMapping()
    @Operation(summary = "сохранение нового поcта")
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
    @Operation(summary = "удаление поста по id")
    public ResponseEntity<HttpStatus> delete(@Parameter(description = "id поста")@PathVariable ("id")Long id) {

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
    @Operation(summary = "обновление  поcта по id")
    public ResponseEntity<HttpStatus> update(@PathVariable ("id")Long id,
                                             PostRequest postRequest) {

        postService.updatePost(id, postRequest);
        return ResponseEntity.ok(HttpStatus.OK);

    }
}
