package ru.mephi.stream.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class TweetCounter {
    private final AtomicLong tweetCount = new AtomicLong(0);

    public void increment() {
        tweetCount.incrementAndGet();
    }

    public Long getAndSetZeroCount() {
        return tweetCount.getAndSet(0);
    }
}
