package com.stackroute.musixservice.seeder;


import com.stackroute.musixservice.model.Track;
import com.stackroute.musixservice.service.TrackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class DbSeeder implements CommandLineRunner, ApplicationListener<ContextRefreshedEvent> {

    // getting data from properties for creation of object
    @Value(value = "${cdata.name1}")
    String name1;
    @Value("${cdata.comment1}")
    String comment1;
    @Value(value = "${cdata.name2}")
    String name2;
    @Value("${cdata.comment2}")
    String comment2;


    private TrackServiceImpl trackServiceImpl;

    @Autowired
    public DbSeeder(TrackServiceImpl trackServiceImpl) {
        this.trackServiceImpl = trackServiceImpl;
    }

    // CommandLineRunner method
    @Override
    public void run(String... args) throws Exception {

        Track track2 = new Track(name2, comment2);
        trackServiceImpl.addTrack(track2);
    }

    // ApplicationListener method
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {


        Track track2 = new Track(name1, comment1);

        try {
            trackServiceImpl.addTrack(track2);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
