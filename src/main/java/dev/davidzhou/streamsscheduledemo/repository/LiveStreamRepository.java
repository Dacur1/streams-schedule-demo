package dev.davidzhou.streamsscheduledemo.repository;

import dev.davidzhou.streamsscheduledemo.model.LiveStream;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Repository
public class LiveStreamRepository {

    List<LiveStream> streams = new ArrayList<>();

    public LiveStreamRepository() {
        streams.add(new LiveStream(
                UUID.randomUUID().toString(),
                "Stream 1",
                "Stream 1 Description",
                "https://www.youtube.com/watch?v=1",
                LocalDateTime.of(2023,1,17,14,00),
                LocalDateTime.of(2023,1,17,15,00)
        ));
    }

    public List<LiveStream> findAll() {
        return streams;
    }

    public LiveStream findById(String id) {
        return streams.stream()
                .filter(stream -> stream.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    public LiveStream create(LiveStream stream) {
        streams.add(stream);
        return stream;
    }

    public void update(LiveStream stream, String id) {
        LiveStream existing = streams.stream().filter(s -> s.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Stream not found"));
        int i = streams.indexOf(existing);
        streams.set(i, stream);
    }

    public void delete(String id) {
        streams.removeIf(streams -> streams.id().equals(id));
    }
}
