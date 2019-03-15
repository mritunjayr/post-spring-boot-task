package com.stackroute.musixservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;
import java.util.UUID;


@Document("Track")
@Data
@AllArgsConstructor
public class Track {

    @Id
    private String trackId;
    @NotNull(message = "track name should not be null")
    @Size(min = 1,message = "track name should not be empty")
    private String trackName;
    @NotNull(message = "track comment should not be null")
    @Size(min = 1,message = "track comment should not be empty")
    private String comment;

    // to generate random id
    public Track() {
        this.trackId= UUID.randomUUID().toString();
    }

    public Track(String trackName, String comment) {
        this();
        this.trackName = trackName;
        this.comment = comment;
    }
}
