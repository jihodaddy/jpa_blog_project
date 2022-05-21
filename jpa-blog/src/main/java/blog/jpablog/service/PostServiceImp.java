package blog.jpablog.service;

import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.jpablog.domain.entity.Post;
import blog.jpablog.repository.PostRepository;

@Service
public class PostServiceImp implements PostService {

  @Autowired
  private PostRepository postRepository;
  
  @Override
  public Map<String, Object> findAllPost() {
    
    postRepository.findAll();
    return null;
  }

  @Override
  public Map<String, Object> savePost(Post post) {
    return null;
  }

  @Override
  public Map<String, Object> deletePost(Post post) {
    // TODO Auto-generated method stub
    return null;
  }
  
}
