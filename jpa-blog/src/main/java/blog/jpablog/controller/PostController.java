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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blog.jpablog.domain.entity.Post;
import blog.jpablog.repository.PostRepository;

@RestController
@RequestMapping("post")
public class PostController {
  
  @Autowired
  PostRepository postRepository;

  @GetMapping("list")
  public List<Post> getPostList() {
    return postRepository.findAll();
}

//   @GetMapping("/list")
//   public List<Post> getPostList(@RequestParam(required = false) Map<String, Object> searchRequest) {
//       Map<SearchKey, Object> searchKeys = new HashMap<>();
//       for (String key : searchRequest.keySet()) {
//           searchKeys.put(SearchKey.valueOf(key.toUpperCase()), searchRequest.get(key));
//       }
//       return searchKeys.isEmpty()
//               ? postRepository.findAll()
//               : postRepository.findAll(PostSpecs.searchWith(searchKeys));
// }

  @GetMapping("/{id}")
  public Post getPost(@PathVariable String id) {
    Long postId = Long.parseLong(id);

    Optional<Post> post = postRepository.findById(postId);
    return post.get();
  }

  @PostMapping("/{id}")
    public Post updatePost(@PathVariable String id, @RequestBody Post newPost){
        Long postId = Long.parseLong(id);

        Optional<Post> post = postRepository.findById(postId);

        post.get().setTitle(newPost.getTitle());
        post.get().setContent(newPost.getContent());

        postRepository.save(post.get());

        return post.get();
    }

  @PutMapping("/put")
    public Post createPost(@RequestBody Post post){
        Post newPost = postRepository.save(post);

        return newPost;
    }


    @DeleteMapping("/delete/{id}")
    public String deletePost(@PathVariable String id){
        Long postId = Long.parseLong(id);
        postRepository.deleteById(postId);

        return "delete success";
    }
}
