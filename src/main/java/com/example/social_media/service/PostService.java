package com.example.social_media.service;

import com.example.social_media.dto.request.PostRequest;
import com.example.social_media.dto.response.PostResponse;

import java.util.List;

public interface PostService {

    /**
     * Получение поста по id
     *
     * @return
     */
    PostResponse getPostById(Long id);

    /**
     * Получение списка всех постов пользователя (по id)
     *
     * @return
     */
    List<PostResponse> getAllPostsByUserId();
    /**
     * сохранение нового поста
     *
     * @param postRequest
     */
    void savePost(PostRequest postRequest);

    /**
     * удаление поста по id
     *
     * @param id
     */
    void deletePost(Long id);

    /**
     * обновление поста по его id
     */
    void updatePost(Long id, PostRequest postRequest);

}
