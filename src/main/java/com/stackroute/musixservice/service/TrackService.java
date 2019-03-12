package com.stackroute.musixservice.service;

import com.stackroute.musixservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.musixservice.exceptions.TrackNotFoundException;
import com.stackroute.musixservice.model.Track;
import com.stackroute.musixservice.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackService {
    @Autowired
    private TrackRepository trackRepository;

    public TrackRepository getTrackRepository() {
        return trackRepository;
    }

    public void setTrackRepository(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public Track addMusic(Track track)throws TrackAlreadyExistsException {
        if(trackRepository.existsById(track.getTrackId()))
            throw new TrackAlreadyExistsException("track already added");
        return trackRepository.save(track);
    }
    public Track updateMusic(Track track){
        return trackRepository.save(track);
    }

    public List<Track> getAllMusic(){
        return trackRepository.findAll();
    }
    public void deleteMusic(int id) throws TrackNotFoundException {
        if(!trackRepository.existsById(id))
            throw new TrackNotFoundException("track is not found");
         trackRepository.deleteById(id);
    }
    public List<Track> getAllMusicByName(String name){
        return trackRepository.findByTrackName(name);
    }

}
