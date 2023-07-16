package ru.practicum.stats;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatOutDto {
    private String app;
    private String uri;
    private Long hits;

    public StatOutDto(String app, String uri, Long hits) {
        this.app = app;
        this.uri = uri;
        this.hits = hits;
    }
}
