package part.i.chapter4.abstractions.repositories;

import part.i.chapter4.abstractions.models.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
