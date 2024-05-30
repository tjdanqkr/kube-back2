package com.example.demo2;


import java.util.UUID;

public record CommentRequest(
        String content,
        UUID boardId
) {
    public Comment toEntity() {
        return new Comment(UUID.randomUUID(), content, boardId);
    }
}
