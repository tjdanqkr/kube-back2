package com.example.demo2;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/demo2")
@RequiredArgsConstructor
public class Demo2Controller {
    private final CommentRepository commentRepository;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
    @GetMapping
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comment save(@RequestBody CommentRequest request) {
        return commentRepository.save(request.toEntity());
    }
    @GetMapping("{id}")
    public List<Comment> getBoardById(@PathVariable("id") UUID id) {
        return commentRepository.findByBoardId(id);

    }

}
