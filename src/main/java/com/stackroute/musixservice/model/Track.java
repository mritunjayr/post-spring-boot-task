package com.stackroute.musixservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int trackId;
    private String trackName;
    private String comment;

    public Track(String trackName, String comment) {
        this.trackName = trackName;
        this.comment = comment;
    }
}
