package ru.practicum.stat.service;


import ru.practicum.stat.model.Stat;
import ru.practicum.stats.StatInDto;
import ru.practicum.stats.StatOutDto;

import java.util.List;

public interface StatsService {
    void saveHit(StatInDto statInDto);

    List<StatOutDto> getHits(String start, String end, List<String> uris, Boolean unique);

    List<Stat> getAllHits(Integer from, Integer size);
}
