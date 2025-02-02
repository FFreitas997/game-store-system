package com.ffreitas.gamestoreserver.platform.services;

import com.ffreitas.gamestoreserver.platform.repository.SupportedPlatformRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DefaultSupportedPlatformService {

    private final SupportedPlatformRepository repository;
}
