package blog.jpablog.service;

import java.util.Map;

import blog.jpablog.domain.entity.Post;

public interface PostService {
  
  Map<String, Object> findAllPost();

  Map<String, Object> savePost(Post post);

  Map<String, Object> deletePost(Post post);

  

}
