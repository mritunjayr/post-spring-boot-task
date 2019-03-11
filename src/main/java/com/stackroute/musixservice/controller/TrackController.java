package com.stackroute.musixservice.controller;

import com.stackroute.musixservice.TrackService;
import com.stackroute.musixservice.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TrackController {
    @Autowired
    private TrackService trackService;

    public TrackService getTrackService() {
        return trackService;
    }

    public void setTrackService(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("/music")
    public ResponseEntity<Track> addMusic(@RequestBody Track track){
        return new ResponseEntity<>(trackService.addMusic(track), HttpStatus.OK);
    }

    @PutMapping("/music/{id}")
    public ResponseEntity<Track> addMusic(@RequestBody Track track,@PathVariable int id){
        track.setTrackId(id);
        return new ResponseEntity<>(trackService.addMusic(track), HttpStatus.OK);
    }

    @GetMapping("/music")
    public ResponseEntity<List<Track>> addMusic(){
        return new ResponseEntity<>(trackService.getAllMusic(), HttpStatus.OK);
    }
    @DeleteMapping("/music/{id}")
    public ResponseEntity<String> addMusic(@PathVariable int id){
        trackService.deleteMusic(id);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
