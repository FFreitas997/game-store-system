package com.ffreitas.gamestoreserver.request.services;

import com.ffreitas.gamestoreserver.request.repositories.GameRequestRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DefaultGameRequestService implements GameRequestService {

    private final GameRequestRepository repository;
}
