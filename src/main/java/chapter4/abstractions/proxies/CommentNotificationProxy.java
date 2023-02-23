package chapter4.abstractions.proxies;

import chapter4.abstractions.models.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
