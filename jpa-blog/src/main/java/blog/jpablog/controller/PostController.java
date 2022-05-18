package blog.jpablog.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import blog.jpablog.domain.entity.Post;
import blog.jpablog.repository.PostRepository;

@RestController
public class PostController {
  
  @Autowired
  PostRepository postRepository;

  @GetMapping("/post")
  public List<Post> getAllPost() {
    return postRepository.findAll();
  }

  @GetMapping("/post/{id}")
  public Post getPost(@PathVariable String id) {
    Long postId = Long.parseLong(id);

    Optional<Post> post = postRepository.findById(postId);
    return post.get();
  }

  @PostMapping("/post/{id}")
    public Post updatePost(@PathVariable String id, @RequestBody Post newPost){
        Long postId = Long.parseLong(id);

        Optional<Post> post = postRepository.findById(postId);

        post.get().setTitle(newPost.getTitle());
        post.get().setContent(newPost.getContent());

        postRepository.save(post.get());

        return post.get();
    }

  @PutMapping("/post")
    public Post createPost(@RequestBody Post post){
        Post newPost = postRepository.save(post);

        return newPost;
    }


    @DeleteMapping("/post/{id}")
    public String deletePost(@PathVariable String id){
        Long postId = Long.parseLong(id);
        postRepository.deleteById(postId);

        return "delete success";
    }
}