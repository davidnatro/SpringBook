package part.i.chapter4.abstractions.proxies;

import part.i.chapter4.abstractions.models.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
