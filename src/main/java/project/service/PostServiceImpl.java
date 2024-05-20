package project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.models.PostEntity;
import project.repository.PostRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostServiceInter {

@Autowired
    PostRepository postRepository;
    @Override
    public PostEntity createPost(PostEntity post) {
        post.setCreated(new Date());

        return postRepository.save(post);
    }

    @Override
    public List<PostEntity> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Optional<PostEntity> getAllPostsByUserid(Long userid) {
        return postRepository.findById(userid);
    }

    @Override
    public PostEntity updatepost(PostEntity post, Long id) {
        PostEntity postresult=postRepository.findById(id).orElse(null);
        if(postresult!=null){


        }
        System.out.println(postresult);



        return postRepository.save(postresult);
    }

    @Override
    public void deletepost(Long id) {
  try {

      postRepository.deleteById(id);
      System.out.println(" successfully deleted post");
  }catch (Exception ex){
      ex.printStackTrace();
  }
    }

    @Override
    public List<PostEntity> getAllPostsByUserId(Long userId) {
        return List.of();
    }

    @Override
    public PostEntity getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }


}
