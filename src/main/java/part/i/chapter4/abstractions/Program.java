package part.i.chapter4.abstractions;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import part.i.chapter4.abstractions.models.Comment;
import part.i.chapter4.abstractions.services.CommentService;

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
