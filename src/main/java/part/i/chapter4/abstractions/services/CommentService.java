package part.i.chapter4.abstractions.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import part.i.chapter4.abstractions.models.Comment;
import part.i.chapter4.abstractions.proxies.CommentNotificationProxy;
import part.i.chapter4.abstractions.repositories.CommentRepository;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    public CommentService(CommentRepository commentRepository, @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
