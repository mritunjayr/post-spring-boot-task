package com.stackroute.musixservice.controller;

import com.stackroute.musixservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.musixservice.exceptions.TrackNotFoundException;
import com.stackroute.musixservice.service.TrackServiceImpl;
import com.stackroute.musixservice.model.Track;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TrackController {


    private TrackServiceImpl trackServiceImpl;


    @Autowired
    public TrackController(TrackServiceImpl trackServiceImpl) {
        this.trackServiceImpl = trackServiceImpl;
    }

    // handle /music url post mapping
    @ApiOperation(value = "add a track", response = Track.class)
    @PostMapping("/music")
    public ResponseEntity<?> addTrack(@Valid @RequestBody Track track) throws MethodArgumentNotValidException, TrackAlreadyExistsException {

            return new ResponseEntity<Track>(trackServiceImpl.addTrack(track), HttpStatus.CREATED);

    }

    // handle /music/{id} put mapping requested to update track
    @ApiOperation(value = "update a track with id", response = Track.class)
    @PutMapping("/music/{id}")
    public ResponseEntity<Track> updateTrack(@RequestBody Track track, @PathVariable String id) {
        track.setTrackId(id);
        return new ResponseEntity<>(trackServiceImpl.updateTrack(track), HttpStatus.OK);
    }

    // handle get mapping request for all tracks
    @ApiOperation(value = "get all track")
    @GetMapping("/music")
    public ResponseEntity<List<Track>> getAllTracks() {
        return new ResponseEntity<>(trackServiceImpl.getAllTracks(), HttpStatus.OK);
    }
    // handle search get request  with name of track
    @ApiOperation(value = "search track with name")
    @GetMapping("/musicbyname")
    public ResponseEntity<List<Track>>getTrackByName(@RequestParam("name") String name) {

            return new ResponseEntity<>(trackServiceImpl.getAllTrackByName(name), HttpStatus.OK);

    }

    //handle delete request to delete track
    @ApiOperation(value = "delete track with name")
    @DeleteMapping("/music/{id}")
    public ResponseEntity<String> deleteTrack(@PathVariable String id) {
        try {
            trackServiceImpl.deleteTrack(id);
            return new ResponseEntity<>("success", HttpStatus.OK);
        }catch (TrackNotFoundException ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.CONFLICT);
        }
    }
}
