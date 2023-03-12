package part.i.chapter4.abstractions.repositories;

import org.springframework.stereotype.Repository;
import part.i.chapter4.abstractions.models.Comment;

@Repository
public class DBCommentRepository implements CommentRepository {
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing: " + comment.getText());
    }
}
