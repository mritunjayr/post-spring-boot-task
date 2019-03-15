package com.stackroute.musixservice.service;

import com.jayway.jsonpath.internal.path.PredicateContextImpl;
import com.stackroute.musixservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.musixservice.model.Track;
import com.stackroute.musixservice.repository.TrackRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TrackServiceTest {

    private Track track;
    // Create a mock for trackRepository
    @Mock
    private TrackRepository trackRepository;

    //Inject the mocks as dependencies into TrackServiceImpl
    @InjectMocks
    private TrackServiceImpl trackService;

    List<Track> list;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        track=new Track();
        track.setTrackName("gone");
        track.setComment("gone for long time");
        list=new ArrayList<>();
        list.add(track);
    }

    @After
    public void tearDown() throws Exception {
        trackRepository.deleteAll();
    }
    @Test
    public void testSaveUserSuccess() throws TrackAlreadyExistsException {
        when(trackRepository.save((Track) any())).thenReturn(track);
        Track savedUser = trackService.addTrack(track);
        Assert.assertEquals(track,savedUser);

        //verify here verifies that trackRepository save method is only called once
        verify(trackRepository,times(1)).save(track);

    }

    @Test
    public void testGetAllUser(){

       trackRepository.save(track);
        //stubbing the mock to return specific data
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> tracklist = trackService.getAllTracks();
        Assert.assertEquals(list,tracklist);



    }
}