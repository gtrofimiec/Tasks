package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrelloCardDto {

    private String name;
    private String desc;
    private String pos;
    private String idList;
//    TrelloBadgesDto badges;
}