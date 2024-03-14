package org.example.historyservice.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {

    FUTURE(0, "запись предстоит"),
    FINISHED(1, "запись завершена"),
    CANCELED(2, "запись отменена");
    private final int id;
    private final String description;


}
