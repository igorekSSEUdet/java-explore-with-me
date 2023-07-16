package ru.practicum.stat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.practicum.stat.model.Stat;
import ru.practicum.stats.StatOutDto;

import java.time.LocalDateTime;
import java.util.List;

public interface StatsRepository extends JpaRepository<Stat, Long> {
    @Query("SELECT new ru.practicum.stats.StatOutDto(s.app, s.uri, count(s.id)) " +
            "FROM Stat s " +
            "WHERE s.timestamp BETWEEN :start AND :end " +
            "GROUP BY s.app, s.uri " +
            "ORDER BY count(s.id) DESC")
    List<StatOutDto> countByTimestamp(LocalDateTime start, LocalDateTime end);

    @Query("SELECT new ru.practicum.stats.StatOutDto(s.app, s.uri, count(distinct s.ip)) " +
            "FROM Stat s " +
            "WHERE s.timestamp BETWEEN :start AND :end " +
            "GROUP BY s.app, s.uri " +
            "ORDER BY count(distinct s.ip) DESC")
    List<StatOutDto> countByTimestampUniqueIp(LocalDateTime start, LocalDateTime end);

    @Query("SELECT new ru.practicum.stats.StatOutDto(s.app, s.uri, count(s.id)) " +
            "FROM Stat s " +
            "WHERE s.uri IN :uris AND s.timestamp BETWEEN :start AND :end " +
            "GROUP BY s.app, s.uri " +
            "ORDER BY count(s.id) DESC")
    List<StatOutDto> countByTimestampAndList(LocalDateTime start, LocalDateTime end, List<String> uris);

    @Query("SELECT new ru.practicum.stats.StatOutDto(s.app, s.uri, count(s.id)) " +
            "FROM Stat s " +
            "WHERE s.uri IN :uris AND s.timestamp BETWEEN :start AND :end " +
            "GROUP BY s.app, s.uri, s.ip " +
            "ORDER BY count(s.id) DESC")
    List<StatOutDto> countByTimestampAndListUniqueIp(LocalDateTime start, LocalDateTime end, List<String> uris);
}
