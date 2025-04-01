package com.ffreitas.gamestoreserver.game.services;

import com.ffreitas.gamestoreserver.category.repositories.CategoryRepository;
import com.ffreitas.gamestoreserver.comment.repositories.CommentRepository;
import com.ffreitas.gamestoreserver.common.ResponsePageDto;
import com.ffreitas.gamestoreserver.game.dto.RequestGameDto;
import com.ffreitas.gamestoreserver.game.dto.ResponseGameDto;
import com.ffreitas.gamestoreserver.game.entities.Game;
import com.ffreitas.gamestoreserver.game.mapper.GameMapper;
import com.ffreitas.gamestoreserver.game.repositories.GameRepository;
import com.ffreitas.gamestoreserver.platform.repository.SupportedPlatformRepository;
import com.ffreitas.gamestoreserver.wishlist.repositories.WishlistRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Default implementation of the GameService interface
 * <p> This service try to follow the <a href="https://en.wikipedia.org/wiki/SOLID">SOLID principles</a> </p>
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
    private final CommentRepository commentRepository;
    private final WishlistRepository wRepository;

    /**
     * Create a new game
     *
     * @param request The request DTO with the game information
     * @throws IllegalArgumentException If the request is null, the game already exists; the category or supported platform is not found
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

    /**
     * Retrieve a game by its ID
     *
     * @param gameID The game ID to search
     * @return The response DTO with the game information
     * @throws IllegalArgumentException If the parameter game ID is null or the game is not found
     * @see ResponseGameDto
     */
    @Override
    public ResponseGameDto retrieveGame(String gameID) {
        if (gameID == null) {
            log.error("Game ID cannot be null");
            throw new IllegalArgumentException("Game ID cannot be null");
        }

        var game = repository.findById(gameID)
                .orElseThrow(() -> new IllegalArgumentException("Game not found with ID " + gameID));

        return GameMapper.toResponse(game);
    }

    /**
     * Retrieve all games
     *
     * @param page The page number requested
     * @param size The number of elements per page
     * @return The custom page response with the list of games requested
     * @see ResponsePageDto
     * @see ResponseGameDto
     */
    @Override
    public ResponsePageDto<ResponseGameDto> retrieveAllGames(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "title"));

        Page<Game> result = repository.findAll(pageable);

        var content = result.map(GameMapper::toResponse).getContent();

        return ResponsePageDto.<ResponseGameDto>builder()
                .content(content)
                .totalElements(result.getTotalElements())
                .totalPages(result.getTotalPages())
                .number(result.getNumber())
                .size(result.getSize())
                .first(result.isFirst())
                .last(result.isLast())
                .build();
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
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "title"));

        var categories = catRepository.findAllById(List.of(categoryID));

        Page<Game> result = repository.findAllByCategories(categories, pageable);

        var content = result.map(GameMapper::toResponse).getContent();

        return ResponsePageDto.<ResponseGameDto>builder()
                .content(content)
                .totalElements(result.getTotalElements())
                .totalPages(result.getTotalPages())
                .number(result.getNumber())
                .size(result.getSize())
                .first(result.isFirst())
                .last(result.isLast())
                .build();
    }

    /**
     * Retrieve all games by platform
     *
     * @param platformID The platform ID to filter the games
     * @param page       The page number requested
     * @param size       The number of elements per page
     * @return The custom page response with the list of games requested
     * @see ResponsePageDto
     * @see ResponseGameDto
     */
    @Override
    public ResponsePageDto<ResponseGameDto> retrieveAllGamesByPlatform(String platformID, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "title"));

        var platforms = sPlatformRepository.findAllById(List.of(platformID));

        Page<Game> result = repository.findAllBySupportedPlatforms(platforms, pageable);

        var content = result.map(GameMapper::toResponse).getContent();

        return ResponsePageDto.<ResponseGameDto>builder()
                .content(content)
                .totalElements(result.getTotalElements())
                .totalPages(result.getTotalPages())
                .number(result.getNumber())
                .size(result.getSize())
                .first(result.isFirst())
                .last(result.isLast())
                .build();
    }

    /**
     * Update a game
     *
     * @param gameID  The game ID to update
     * @param request The request DTO with the game information
     * @throws IllegalArgumentException If the game ID is null, the game is not found, the game already exists; the category or supported platform is not found
     * @see RequestGameDto
     */
    @Override
    public void updateGame(String gameID, RequestGameDto request) {
        if (gameID == null) {
            log.error("Game ID cannot be null");
            throw new IllegalArgumentException("Game ID cannot be null");
        }

        Game game = repository.findById(gameID)
                .orElseThrow(() -> new IllegalArgumentException("Game not found with ID " + gameID));

        if (!game.getTitle().equals(request.title()) && repository.existsGamesByTitle(request.title())) {
            log.error("Game already exists with name {}", request.title());
            throw new IllegalArgumentException("Game already exists with name " + request.title());
        }

        var newPlatforms = sPlatformRepository.findAllById(request.supportedPlatformsID());

        if (newPlatforms.isEmpty())
            throw new IllegalArgumentException("Supported Platform not found");

        if (newPlatforms.size() != request.supportedPlatformsID().size())
            log.warn("Received a non supported platform :: Received: {}", request.supportedPlatformsID());

        game.getSupportedPlatforms().clear();
        newPlatforms.forEach(game::addPlatform);

        var newCategories = catRepository.findAllById(request.categoriesID());

        if (newCategories.isEmpty())
            throw new IllegalArgumentException("Category not found");

        if (newCategories.size() != request.categoriesID().size())
            log.warn("Received a non supported category :: Received: {}", request.categoriesID());

        game.getCategories().clear();
        newCategories.forEach(game::addCategory);

        game.setTitle(request.title());
        game.setDescription(request.description());

        repository.save(game);
    }

    @Override
    public void uploadCover(String gameID, MultipartFile file) {
        // TODO: Implement the upload cover method
    }

    /**
     * Delete a game
     *
     * @param gameID  The game ID to delete
     * @param confirm The complete deletion confirmation of the game
     * @throws IllegalArgumentException If the game ID is null, the game is not found,
     *                                  the game has comments or is in wishlists, and the confirmation is not true
     */
    @Override
    public void deleteGame(String gameID, boolean confirm) {
        if (gameID == null) {
            log.error("Game ID cannot be null");
            throw new IllegalArgumentException("Game ID cannot be null");
        }

        var game = repository.findById(gameID)
                .orElseThrow(() -> new IllegalArgumentException("Game not found with ID " + gameID));

        long commentCount = commentRepository.countByGame(game);
        long wishlistCount = wRepository.countByGames(List.of(game));

        List<String> warnings = new ArrayList<>();

        if (commentCount > 0) {
            warnings.add("Comment count is greater than 0");
            log.warn("Game has comments :: Game ID: {} :: Number of comments: {}", gameID, commentCount);
        }

        if (wishlistCount > 0) {
            warnings.add("Wishlist count is greater than 0");
            log.warn("Game is in wishlists :: Game ID: {} :: Number of wishlists: {}", gameID, wishlistCount);
        }

        if (!warnings.isEmpty() && !confirm) {
            log.warn("Game deletion not confirmed :: Game ID: {} :: Warnings: {}", gameID, warnings);
            throw new IllegalArgumentException("Game deletion not confirmed");
        }
        repository.delete(game);

        var wishlist = wRepository.findAllByGames(List.of(game));
        wishlist.forEach(game::removeWishlist);
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