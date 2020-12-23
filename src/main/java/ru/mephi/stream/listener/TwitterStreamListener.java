package ru.mephi.stream.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.social.twitter.api.StreamDeleteEvent;
import org.springframework.social.twitter.api.StreamListener;
import org.springframework.social.twitter.api.StreamWarningEvent;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Service;
import ru.mephi.stream.service.TweetCounter;

@Service
@Slf4j
@RequiredArgsConstructor
public class TwitterStreamListener implements StreamListener {

    private final TweetCounter tweetCounter;

    @Override public void onTweet(Tweet tweet) {
        tweetCounter.increment();
    }
    @Override public void onDelete(StreamDeleteEvent deleteEvent) {

    }
    @Override public void onLimit(int numberOfLimitedTweets) {

    }
    @Override public void onWarning(StreamWarningEvent warningEvent) {

    }
}