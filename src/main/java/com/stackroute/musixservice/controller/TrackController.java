package com.stackroute.musixservice.controller;

import com.stackroute.musixservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.musixservice.exceptions.TrackNotFoundException;
import com.stackroute.musixservice.service.TrackService;
import com.stackroute.musixservice.model.Track;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "add a track", response = Track.class)
    @PostMapping("/music")
    public ResponseEntity<?> addMusic(@RequestBody Track track) throws Exception {

            return new ResponseEntity<Track>(trackService.addMusic(track), HttpStatus.OK);

    }

    @ApiOperation(value = "update a track with id", response = Track.class)
    @PutMapping("/music/{id}")
    public ResponseEntity<Track> addMusic(@RequestBody Track track, @PathVariable int id) {
        track.setTrackId(id);
        return new ResponseEntity<>(trackService.updateMusic(track), HttpStatus.OK);
    }

    @ApiOperation(value = "get all track")
    @GetMapping("/music")
    public ResponseEntity<List<Track>> addMusic() {
        return new ResponseEntity<>(trackService.getAllMusic(), HttpStatus.OK);
    }

    @ApiOperation(value = "search track with name")
    @GetMapping("/musicbyname")
    public ResponseEntity<List<Track>> addMusic(@RequestParam("name") String name) {

            return new ResponseEntity<>(trackService.getAllMusicByName(name), HttpStatus.OK);

    }

    @ApiOperation(value = "delete track with name")
    @DeleteMapping("/music/{id}")
    public ResponseEntity<String> addMusic(@PathVariable int id) {
        try {
            trackService.deleteMusic(id);
            return new ResponseEntity<>("success", HttpStatus.OK);
        }catch (TrackNotFoundException ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.CONFLICT);
        }
    }
}
