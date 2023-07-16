package ru.practicum.stat.mapper;


import ru.practicum.stat.model.Stat;
import ru.practicum.stats.StatInDto;

public class StatMapper {
    public static Stat dtoToStat(StatInDto statInDto) {
        Stat stat = new Stat();

        stat.setApp(statInDto.getApp());
        stat.setUri(statInDto.getUri());
        stat.setIp(statInDto.getIp());
        stat.setTimestamp(statInDto.getTimestamp());

        return stat;
    }
}
