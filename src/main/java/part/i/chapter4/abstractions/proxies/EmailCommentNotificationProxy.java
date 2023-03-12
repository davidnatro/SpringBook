package part.i.chapter4.abstractions.proxies;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import part.i.chapter4.abstractions.models.Comment;

@Component
@Qualifier("EMAIL")
public class EmailCommentNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Email notification: " + comment.getText());
    }
}
