package com.stackroute.musixservice.service;

import com.stackroute.musixservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.musixservice.exceptions.TrackNotFoundException;
import com.stackroute.musixservice.model.Track;

import java.util.List;

public interface TrackService {
     Track addTrack(Track track)throws TrackAlreadyExistsException;
     Track updateTrack(Track track);
     List<Track> getAllTrackByName(String name);
     void deleteTrack(String id) throws TrackNotFoundException;
     List<Track> getAllTracks();
}
