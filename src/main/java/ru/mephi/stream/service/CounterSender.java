package ru.mephi.stream.service;

import lombok.RequiredArgsConstructor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
@RequiredArgsConstructor
public class CounterSender {
    private final TweetCounter tweetCounter;

    @Scheduled(fixedDelayString = "${log.count.period}")
    public void logTwitCount() {
        Long count = tweetCounter.getAndSetZeroCount();
        Logger logger = LogManager.getLogger("elasticsearch");
        logger.info(count);
    }
}
