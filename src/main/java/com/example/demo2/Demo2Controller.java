package com.example.demo2;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/demo2")

public class Demo2Controller {
    private final List<Comment> comments;

    public Demo2Controller() {
        comments = new ArrayList<>();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
    @GetMapping
    public List<Comment> getComments() {
        return comments;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comment save(@RequestBody CommentRequest request) {
        Comment comment = request.toEntity();
        comments.add(comment);
        return comment;
    }
    @GetMapping("{id}")
    public List<Comment> getBoardById(@PathVariable("id") UUID id) {
        return comments.stream()
                .filter(comment -> comment.boardId().equals(id))
                .toList();

    }

}
