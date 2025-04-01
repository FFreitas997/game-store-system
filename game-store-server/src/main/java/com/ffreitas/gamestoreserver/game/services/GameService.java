package com.ffreitas.gamestoreserver.game.services;

import com.ffreitas.gamestoreserver.common.ResponsePageDto;
import com.ffreitas.gamestoreserver.game.dto.RequestGameDto;
import com.ffreitas.gamestoreserver.game.dto.ResponseGameDto;
import org.springframework.web.multipart.MultipartFile;

/**
 * Service interface for the Game entity
 * <p>
 * This interface defines the methods that can be used to interact with the Game entity
 * and its repository
 * <p>
 * <p>Represent <a href="https://en.wikipedia.org/wiki/Create,_read,_update_and_delete">CRUD operations</a> for the Game entity</p>
 * <p>Each method receives or sends an object called <a href="https://en.wikipedia.org/wiki/Data_transfer_object">DTO</a> which constraint the information</p>
 */
public interface GameService {

    void createGame(RequestGameDto request);

    ResponseGameDto retrieveGame(String gameID);

    ResponsePageDto<ResponseGameDto> retrieveAllGames(int page, int size);

    ResponsePageDto<ResponseGameDto> retrieveAllGamesByCategory(String categoryID, int page, int size);

    ResponsePageDto<ResponseGameDto> retrieveAllGamesByPlatform(String platformID, int page, int size);

    void updateGame(String gameID,  RequestGameDto request);

    void uploadCover(String gameID, MultipartFile file);

    void deleteGame(String gameID, boolean confirm);
}
