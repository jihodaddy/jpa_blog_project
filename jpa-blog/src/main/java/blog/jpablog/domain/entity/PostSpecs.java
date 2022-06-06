// package blog.jpablog.domain.entity;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Map;

// import javax.persistence.criteria.CriteriaBuilder;
// import javax.persistence.criteria.Predicate;
// import javax.persistence.criteria.Root;

// import org.springframework.data.jpa.domain.Specification;

// public class PostSpecs {

//   public enum SearchKey {
//     TITLE("title"),
//     CONTENT("content"),
//     WRITER("writer");

//     private final String value;

//     SearchKey(String value) {
//       this.value = value;
//     }

//     public String getValue() {
//       return value;
//     }
//   }

//   // public static Specification<Post> withTitle(String title) {
//   //   return (Specification<Post>)((root, query, builder) ->
//   //   builder.equal(root.get("title"), title));
//   // }
//   public static Specification<Post> searchWith(Map<SearchKey, Object> searchKeyword) {
//     return (Specification<Post>) ((root, query, builder) -> {
//       List<Predicate> Predicate = getPredicateWithKeyword(searchKeyword, root, builder);
//       return builder.and(Predicate.toArray(new Predicate[0]));
//     });
//   }
    
//   private static List<Predicate> getPredicateWithKeyword(Map<SearchKey, Object> searchKeyword,
//                                                                           Root<Post> root, 
//                                                                           CriteriaBuilder builder) {
//     List<Predicate> predicate = new ArrayList<>();                                                                            
//     for (SearchKey key : searchKeyword.keySet()) {
//       switch (key) {
//         case TITLE:
//         case CONTENT:
//         case WRITER:
//           predicate.add(builder.equal(root.get(key.value), searchKeyword.get(key)));
//           break;
//       }
//     }                 
//     return predicate;
//     }
// }
