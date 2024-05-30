package com.example.demo2;


import java.util.UUID;

public record Comment(
        UUID id,
        String content,
        UUID boardId
) {

}
