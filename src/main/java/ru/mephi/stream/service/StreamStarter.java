package ru.mephi.stream.service;

import lombok.RequiredArgsConstructor;
import org.springframework.social.twitter.api.StreamListener;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class StreamStarter {

    private final Twitter twitter;
    private final StreamListener twitterStreamListener;

    @PostConstruct
    public void startStream() {
        twitter.streamingOperations().sample(Collections.singletonList(twitterStreamListener));
    }

}
