package com.stackroute.musixservice.repository;

import com.stackroute.musixservice.model.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@DataMongoTest
public class TrackRepositoryTest {

    @Autowired
    TrackRepository trackRepository;
    Track track;

    @Before
    public void setUp() throws Exception {
        track=new Track();
        track.setTrackId("2");
        track.setTrackName("none of them");
        track.setComment("have you listen it before?");

    }

    @After
    public void tearDown() throws Exception {
        trackRepository.deleteAll();
    }

    @Test
    public void testSaveUser(){
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getTrackId()).get();
        Assert.assertEquals("2",fetchTrack.getTrackId());

    }
    @Test
    public void testGetAllUser(){

        Track u = new Track("21","Johny","Johny12");
        Track u1 = new Track("103","Harry","Harry12");
        trackRepository.save(u);
        trackRepository.save(u1);

        List<Track> list = trackRepository.findAll();
        Assert.assertEquals("Johny",list.get(0).getTrackName());




    }
}