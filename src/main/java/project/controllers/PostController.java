package project.controllers;

import org.hibernate.tool.schema.ast.SqlScriptParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.models.PostEntity;
import project.models.UserEntity;
import project.service.PostServiceInter;
import project.service.Userimpl;

import java.util.List;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostController {

    @Autowired
    PostServiceInter postServiceInter;
    @Autowired
    Userimpl userService;

    @PostMapping("/add/{userid}")
    public PostEntity createPost(@RequestBody PostEntity post, @PathVariable("userid") Long userid) throws Exception {
        UserEntity user = userService.findByid(userid);
        post.setUser(user);

        return postServiceInter.createPost(post);
    }

    @GetMapping("/get")
    public List<PostEntity> getAllPosts(){
        return postServiceInter.getAllPosts();
    }


   @DeleteMapping("/delet/{id}")
   public ResponseEntity<String> deletePost(@PathVariable Long id, @RequestParam Long userId){
       PostEntity post = postServiceInter.getPostById(id);

           postServiceInter.deletepost(id);
           return new ResponseEntity<>("Deleted post with id " + id, HttpStatus.OK);

   }

    @PutMapping("/update/{productId}")
    public ResponseEntity<PostEntity> updateProductHandler(@RequestBody PostEntity req,@PathVariable Long productId) throws SqlScriptParserException {
        System.out.println(productId);
        PostEntity updatedProduct=postServiceInter.updatepost( req,productId);

        return new ResponseEntity<PostEntity>(updatedProduct,HttpStatus.OK);
    }
}


