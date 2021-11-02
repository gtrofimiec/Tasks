package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.domain.Dto.TrelloBoardDto;
import com.crud.tasks.domain.Dto.TrelloCardDto;
import com.crud.tasks.domain.Dto.TrelloListDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrelloMapperTestSuite {

    private TrelloMapper trelloMapper;

    @BeforeEach
    public void setup() {
        trelloMapper = new TrelloMapper();
    }

    @Test
    void shouldMapTrelloBoardsToBoards() {

        //Given
        List<TrelloListDto> trelloListDtoList = List.of((new TrelloListDto("0", "name", false)));
        List<TrelloBoardDto> trelloBoardDtoList = List.of(new TrelloBoardDto("0","name", trelloListDtoList));

        //When
        List<TrelloBoard> mappedTrelloBoard = trelloMapper.mapToBoards(trelloBoardDtoList);
        String trelloBoardId = mappedTrelloBoard.get(0).getId();
        String trelloBoardName =  mappedTrelloBoard.get(0).getName();

        //Then
        assertEquals(trelloBoardId, trelloBoardDtoList.get(0).getId());
        assertEquals(trelloBoardName, trelloBoardDtoList.get(0).getName());
    }

    @Test
    void shouldMapTrelloBoardsToBoardsDto() {

        //Given
        List<TrelloList> trelloLists = List.of(new TrelloList("0", "name", false));
        List<TrelloBoard> trelloBoards = List.of(new TrelloBoard("0", "name", trelloLists));

        //When
        List<TrelloBoardDto> mappedBoardDtoList = trelloMapper.mapToBoardsDto(trelloBoards);
        String boardDtoId = mappedBoardDtoList.get(0).getId();
        String boardDtoName = mappedBoardDtoList.get(0).getName();

        //Then
        assertEquals(boardDtoId, trelloBoards.get(0).getId());
        assertEquals(boardDtoName, trelloBoards.get(0).getName());
    }

    @Test
    void shouldMapTrelloListDtoToList() {

        //Given
        List<TrelloListDto> trelloListDtoLists = List.of(new TrelloListDto("0", "name", false));

        //When
        List<TrelloList> mappedTrelloList = trelloMapper.mapToList(trelloListDtoLists);
        String listId = mappedTrelloList.get(0).getId();
        String listName = mappedTrelloList.get(0).getName();

        //Then
        assertEquals(listId, trelloListDtoLists.get(0).getId());
        assertEquals(listName, trelloListDtoLists.get(0).getName());
    }

    @Test
    void shouldMapTrelloListToListDto() {

        //Given
        List<TrelloList> trelloLists = List.of(new TrelloList("0", "name", false));

        //When
        List<TrelloListDto> mappedTrelloListDto = trelloMapper.mapToListDto(trelloLists);
        String listDtoId = mappedTrelloListDto.get(0).getId();
        String listDtoName = mappedTrelloListDto.get(0).getName();

        //Then
        assertEquals(listDtoId, trelloLists.get(0).getId());
        assertEquals(listDtoName, trelloLists.get(0).getName());
    }

    @Test
    void shouldMapTrelloCardDtoToCardDto() {

        //Given
        TrelloCard trelloCard = new TrelloCard("name", "description", "pos", "listId");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        String cardDtoName = trelloCardDto.getName();
        String cardDtoDesc = trelloCardDto.getDescription();
        String cardDtoPos = trelloCardDto.getPos();
        String cardDtoListId = trelloCardDto.getIdList();

        //Then
        assertEquals(cardDtoName, trelloCard.getName());
        assertEquals(cardDtoDesc, trelloCard.getDescription());
        assertEquals(cardDtoPos, trelloCard.getPos());
        assertEquals(cardDtoListId, trelloCard.getIdList());
    }

    @Test
    void shouldMapTrelloCardToCard() {

        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name", "description", "pos", "listId");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        String cardName = trelloCard.getName();
        String cardDesc = trelloCard.getDescription();
        String cardPos = trelloCard.getPos();
        String cardListId = trelloCard.getIdList();

        //Then
        assertEquals(cardName, trelloCardDto.getName());
        assertEquals(cardDesc, trelloCardDto.getDescription());
        assertEquals(cardPos, trelloCardDto.getPos());
        assertEquals(cardListId, trelloCardDto.getIdList());
    }
}