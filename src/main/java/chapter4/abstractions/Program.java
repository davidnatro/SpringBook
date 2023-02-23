package chapter4.abstractions;

import chapter4.abstractions.models.Comment;
import chapter4.abstractions.proxies.EmailCommentNotificationProxy;
import chapter4.abstractions.repositories.DBCommentRepository;
import chapter4.abstractions.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Program {
    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        var commentService = context.getBean(CommentService.class);

        var comment = new Comment();
        comment.setAuthor("some author");
        comment.setText("some text");

        commentService.publishComment(comment);
    }
}
