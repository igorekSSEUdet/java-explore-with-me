package ru.practicum.stat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import ru.practicum.stat.mapper.StatMapper;
import ru.practicum.stat.model.Stat;
import ru.practicum.stat.repository.StatsRepository;
import ru.practicum.stats.Constants;
import ru.practicum.stats.StatInDto;
import ru.practicum.stats.StatOutDto;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {
    private final StatsRepository statsRepository;

    @Override
    @Transactional
    public void saveHit(@Valid @RequestBody StatInDto statInDto) {
        Stat stats = StatMapper.dtoToStat(statInDto);
        statsRepository.save(stats);
    }

    @Override
    public List<StatOutDto> getHits(String start, String end, List<String> uris, Boolean unique) {
        List<StatOutDto> stats = List.of();
        if (uris.size() == 0) {
            if (unique) {
                stats = statsRepository.countByTimestampUniqueIp(
                        LocalDateTime.parse(start, Constants.DATE_TIME_SPACE),
                        LocalDateTime.parse(end, Constants.DATE_TIME_SPACE));
            } else {
                stats = statsRepository.countByTimestamp(
                        LocalDateTime.parse(start, Constants.DATE_TIME_SPACE),
                        LocalDateTime.parse(end, Constants.DATE_TIME_SPACE));
            }
        } else {
            if (unique) {
                stats = statsRepository.countByTimestampAndListUniqueIp(
                        LocalDateTime.parse(start, Constants.DATE_TIME_SPACE),
                        LocalDateTime.parse(end, Constants.DATE_TIME_SPACE),
                        uris);
            } else {
                stats = statsRepository.countByTimestampAndList(
                        LocalDateTime.parse(start, Constants.DATE_TIME_SPACE),
                        LocalDateTime.parse(end, Constants.DATE_TIME_SPACE),
                        uris);
            }
        }
        return stats;
    }

    @Override
    public List<Stat> getAllHits(Integer from, Integer size) {
        Pageable pageable = PageRequest.of(from / size, size);
        return statsRepository.findAll(pageable).toList();
    }
}
