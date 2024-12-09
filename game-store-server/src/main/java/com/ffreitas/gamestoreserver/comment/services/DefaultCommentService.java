package com.ffreitas.gamestoreserver.comment.services;

import com.ffreitas.gamestoreserver.comment.repositories.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DefaultCommentService implements CommentService {

    private final CommentRepository repository;
}
