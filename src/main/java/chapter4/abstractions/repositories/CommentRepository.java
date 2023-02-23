package chapter4.abstractions.repositories;

import chapter4.abstractions.models.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
