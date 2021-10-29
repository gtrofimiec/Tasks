package com.crud.tasks.domain.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrelloCardDto {

    private String name;
    private String desc;
    private String pos;
    private String idList;
//    TrelloBadgesDto badges;
}