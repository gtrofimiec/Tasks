package com.crud.tasks.mapper;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloListDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapperTestSuite {

    private TrelloMapper trelloMapper;

    @BeforeEach
    public void setup() {
        trelloMapper = new TrelloMapper();
    }

    @Test
    void shouldMapTrelloBoardToBoardTest() {
        //Given
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("0","name", new ArrayList<TrelloListDto>());
        trelloBoardDtoList.add(trelloBoardDto);

        //When
        List<TrelloBoard> trelloBoard = trelloMapper.mapToBoards(trelloBoardDtoList);
        String trelloBoardId = trelloBoard.get(0).getId();
        String trelloBoardName =  trelloBoard.get(0).getName();

        //Then
        assertEquals(trelloBoardId, trelloBoardDto.getId());
        assertEquals(trelloBoardName, trelloBoardDto.getName());
    }

    @Test
    void shouldMapTrelloBoardDtoToBoardsDto() {

    }

    @Test
    void shouldMapTrelloListToList() {

    }

    @Test
    void shouldMapTrelloListDtoToListDto() {

    }

    @Test
    void shouldMapTrelloCardDtoToCardDto() {

    }

    @Test
    void shouldMapTrelloCardToCard() {

    }
}
