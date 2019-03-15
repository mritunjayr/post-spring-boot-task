package com.stackroute.musixservice.service;

import com.stackroute.musixservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.musixservice.exceptions.TrackNotFoundException;
import com.stackroute.musixservice.model.Track;
import com.stackroute.musixservice.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService{

    private TrackRepository trackRepository;


    //constructor
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    // add a track
    @Override
    public Track addTrack(Track track)throws TrackAlreadyExistsException {
        if(trackRepository.existsById(track.getTrackId()))
            throw new TrackAlreadyExistsException("track already added");
        return trackRepository.save(track);
    }

    //update a track
    @Override
    public Track updateTrack(Track track){
        return trackRepository.save(track);
    }

    //get all tracks
    @Override
    public List<Track> getAllTracks(){
        return trackRepository.findAll();
    }

    //delete a track
    @Override
    public void deleteTrack(String id) throws TrackNotFoundException {
        if(!trackRepository.existsById(id))
            throw new TrackNotFoundException("track is not found");
         trackRepository.deleteById(id);
    }

    //get track by name
    @Override
    public List<Track> getAllTrackByName(String name){
        return trackRepository.findByTrackName(name);
    }



}
