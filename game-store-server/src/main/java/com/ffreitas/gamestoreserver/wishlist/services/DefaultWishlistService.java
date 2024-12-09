package com.ffreitas.gamestoreserver.wishlist.services;

import com.ffreitas.gamestoreserver.wishlist.repositories.WishlistRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DefaultWishlistService implements WishlistService {

    private final WishlistRepository repository;
}
