package dev.davidzhou.streamsscheduledemo.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import dev.davidzhou.streamsscheduledemo.model.ImmutableLiveStream;

import static org.junit.jupiter.api.Assertions.*;


public class LiveStreamTest {

    @Test
    void create_new_mutable_live_stream() {
        MutableLiveStream mutableLiveStream = new MutableLiveStream();
        mutableLiveStream.setId(UUID.randomUUID().toString());
        mutableLiveStream.setTitle("title");
        mutableLiveStream.setDescription("description");
        mutableLiveStream.setUrl("url");
        mutableLiveStream.setStartDate(LocalDateTime.now());
        mutableLiveStream.setEndDate(LocalDateTime.now());

        assertNotNull(mutableLiveStream);
        assertEquals("title", mutableLiveStream.getTitle());
    }

    @Test
    void create_new_immutable_live_stream() {
        ImmutableLiveStream immutableLiveStream = new ImmutableLiveStream(
                UUID.randomUUID().toString(),
                "title",
                "description",
                "url",
                LocalDateTime.now(),
                LocalDateTime.now()
        );


        assertNotNull(immutableLiveStream);
        assertEquals("title", immutableLiveStream.getTitle());
    }

    @Test
    void create_new_record_live_stream() {
        LiveStream stream = new LiveStream(
                UUID.randomUUID().toString(),
                "title",
                "description",
                "url",
                LocalDateTime.now(),
                LocalDateTime.now()
        );


        assertNotNull(stream);
        assertEquals("title", stream.title());
        assertTrue(stream.getClass().isRecord());
        assertEquals(6, stream.getClass().getRecordComponents().length);
    }
}
