package com.crud.tasks.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TrelloCardDto {

    private String name;
    private String desc;
    private String pos;
    private String idList;
    TrelloBadgesDto badges;
}