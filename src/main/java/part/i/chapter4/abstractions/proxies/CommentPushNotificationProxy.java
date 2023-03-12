package part.i.chapter4.abstractions.proxies;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import part.i.chapter4.abstractions.models.Comment;

@Component
@Qualifier("PUSH")
public class CommentPushNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Push notification: " + comment.getText());
    }
}
