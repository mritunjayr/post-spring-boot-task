package com.stackroute.musixservice;

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

    public Track addMusic(Track track){
        return trackRepository.save(track);
    }

    public List<Track> getAllMusic(){
        return trackRepository.findAll();
    }
    public void deleteMusic(int id){
         trackRepository.deleteById(id);
    }

}
