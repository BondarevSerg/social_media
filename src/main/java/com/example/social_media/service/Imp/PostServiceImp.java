package com.example.social_media.service.Imp;

import com.example.social_media.dto.request.PostRequest;
import com.example.social_media.dto.response.PostResponse;
import com.example.social_media.entity.Post;
import com.example.social_media.entity.User;
import com.example.social_media.mapper.PostMapper;
import com.example.social_media.repository.PostRepository;
import com.example.social_media.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * сервис работы с постами пользователя
 */
@Service
@RequiredArgsConstructor
public class PostServiceImp implements PostService {

    private final PostRepository postRepository;

    /**
     * получение поста по id
     * @param id
     * @return
     */
    @Override
    public PostResponse getPostById(Long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найден пост по идентификатору: " + id));
        return PostMapper.MAPPER.toDto(post);
    }

    /**
     * получение списка постов пользователя(по его id)
     * @return
     */
    @Override
    public List<PostResponse> getAllPostsByUserId(Long id) {
        return postRepository.findAllByUserId(id).stream()
                .map(PostMapper.MAPPER::toDto)
                .collect(Collectors.toList());
    }

    /**
     * сохранение нового поста
     * @param postRequest
     */
    @Override
    public void savePost(PostRequest postRequest) {
              var post = Post.builder()
                      .message(postRequest.getMessage())
                      .user(User.builder().id(postRequest.getUser_id()).build())
                      .build();
              postRepository.save(post);
    }

    /**
     * удаление поста по id
     * @param id
     */
    @Override
    public void deletePost(Long id) {
      postRepository.deleteById(id);
    }

    /**
     * обновление поста
     * @param id
     * @param postRequest
     */
    @Override
    public void updatePost(Long id, PostRequest postRequest) {
           var post=postRepository.findById(id)
                   .orElseThrow(()-> new RuntimeException("не найден пост по идентификатору: " + id));
           post.setMessage(post.getMessage());


    }
}
