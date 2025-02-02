package com.ffreitas.gamestoreserver.game.services;

import com.ffreitas.gamestoreserver.category.repositories.CategoryRepository;
import com.ffreitas.gamestoreserver.common.ResponsePageDto;
import com.ffreitas.gamestoreserver.game.dto.RequestGameDto;
import com.ffreitas.gamestoreserver.game.dto.ResponseGameDto;
import com.ffreitas.gamestoreserver.game.entities.Game;
import com.ffreitas.gamestoreserver.game.mapper.GameMapper;
import com.ffreitas.gamestoreserver.game.repositories.GameRepository;
import com.ffreitas.gamestoreserver.platform.repository.SupportedPlatformRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Default implementation of the GameService interface
 *
 * @author FFreitas
 * @see GameService
 */
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DefaultGameService implements GameService {

    private final GameRepository repository;
    private final CategoryRepository catRepository;
    private final SupportedPlatformRepository sPlatformRepository;

    /**
     * Create a new game
     *
     * @param request The request DTO with the game information
     * @throws IllegalArgumentException If the request is null, the game already exists, the category or supported platform is not found
     * @see RequestGameDto
     */
    @Override
    public void createGame(final RequestGameDto request) {
        if (request == null) {
            log.error("Request parameter cannot be null");
            throw new IllegalArgumentException("Request cannot be null");
        }

        var exampleGame = Game
                .builder()
                .title(request.title())
                .build();

        ExampleMatcher matcher = ExampleMatcher
                .matchingAny()
                .withMatcher("title", new ExampleMatcher.GenericPropertyMatcher().contains().ignoreCase());

        Example<Game> example = Example.of(exampleGame, matcher);

        repository.findOne(example)
                .ifPresent(game -> {
                    log.error("Game already exists with name {}", game.getTitle());
                    throw new IllegalArgumentException("Game already exists with name " + game.getTitle());
                });

        var categories = catRepository.findAllById(request.categoriesID());
        var supportedPlatforms = sPlatformRepository.findAllById(request.supportedPlatformsID());

        if (categories.isEmpty())
            throw new IllegalArgumentException("Category not found");

        if (supportedPlatforms.isEmpty())
            throw new IllegalArgumentException("Supported Platform not found");

        if (categories.size() != request.categoriesID().size())
            log.warn("Received a non supported category :: Received: {}", request.categoriesID());

        if (supportedPlatforms.size() != request.supportedPlatformsID().size())
            log.warn("Received a non supported platform :: Received: {}", request.supportedPlatformsID());

        var entity = Game
                .builder()
                .title(request.title())
                .description(request.description())
                .categories(categories)
                .supportedPlatforms(supportedPlatforms)
                .build();

        repository.save(entity);
    }

    @Override
    public ResponseGameDto retrieveGame(String gameID) {
        return null;
    }

    @Override
    public ResponsePageDto<ResponseGameDto> retrieveAllGames(int page, int size) {
        return null;
    }

    /**
     * Retrieve all games by category
     *
     * @param categoryID The category ID to filter the games
     * @param page       The page number requested
     * @param size       The number of elements per page
     * @return The custom page response with the list of games requested
     * @see ResponsePageDto
     * @see ResponseGameDto
     */
    @Override
    public ResponsePageDto<ResponseGameDto> retrieveAllGamesByCategory(String categoryID, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdAt"));

        Page<Game> result = repository.findAllByCategoryId(categoryID, pageable);

        return ResponsePageDto.<ResponseGameDto>builder()
                .content(result.map(GameMapper::toResponse).getContent())
                .totalElements(result.getTotalElements())
                .totalPages(result.getTotalPages())
                .first(result.isFirst())
                .last(result.isLast())
                .build();
    }

    @Override
    public void updateGame(String gameID, ResponseGameDto gameDto) {

    }

    @Override
    public void uploadCover(String gameID, MultipartFile file) {

    }

    @Override
    public void deleteGame(String gameID) {

    }
}

/*
    // Example Case (can be used to search)
    public void queryByExample() {
        Game game = new Game();
        game.setTitle("The Witcher 3: Wild Hunt");

        Example<Game> example = Example.of(game);

        var result = repository.findOne(example);
    }

// Example Case Ignore Case (can be used to search)
   public void queryByExampleIgnoreCase() {
        Game game = new Game();
        game.setTitle("The Witcher 3: Wild Hunt");

        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withIgnoreCase();

        Example<Game> example = Example.of(game, matcher);

        var result = repository.findOne(example);

        log.info("Game found: {}", result);
    }

// Example Case Ignore Case (can be used to search)
   public void queryByExampleCustom() {
        Game game = new Game();
        game.setTitle("The Witcher 3: Wild Hunt");

        ExampleMatcher matcher = ExampleMatcher
                .matchingAny()
                .withMatcher("title", new GenericPropertyMatcher().contains().ignoreCase());

        Example<Game> example = Example.of(game, matcher);

        var result = repository.findOne(example);

        log.info("Game found: {}", result);
    }

// Example Specification
   public void queryBySpecification() {
        Specification<Game> spec = Specification
                .where(GameSpecification.byID("1"))
                .and(GameSpecification.byTitle("The Witcher 3: Wild Hunt"));

        var spec2 = buildSpecification("The Witcher 3: Wild Hunt", "1");

        var result = repository.findAll(spec2, PageRequest.of(0, 10));

        result.forEach(game -> log.info("Game found: {}", game));
    }

    private Specification<Game> buildSpecification(String title, String id) {
        Specification<Game> spec = Specification.where(null);

        if (StringUtils.hasLength(title)) {
            spec = spec.and(GameSpecification.byTitle(title));
        }

        if (StringUtils.hasLength(id)) {
            spec = spec.and(GameSpecification.byID(id));
        }

        return spec;
    }
 */