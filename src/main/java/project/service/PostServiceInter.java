package project.service;

import project.models.PostEntity;

import java.util.List;
import java.util.Optional;

public interface PostServiceInter {

    PostEntity createPost(PostEntity post);

    List<PostEntity> getAllPosts();

    Optional<PostEntity> getAllPostsByUserid(Long userid);

    PostEntity updatepost(PostEntity post, Long id);

    void deletepost(Long id) ;

     List<PostEntity> getAllPostsByUserId(Long userId) ;

     PostEntity getPostById(Long id) ;




}
