package com.ffreitas.gamestoreserver.game.services;

import com.ffreitas.gamestoreserver.game.repositories.GameRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DefaultGameService implements GameService {

    private final GameRepository repository;
}
