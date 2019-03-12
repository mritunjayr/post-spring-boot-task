package com.stackroute.musixservice;

import com.stackroute.musixservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.musixservice.model.Track;
import com.stackroute.musixservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@SpringBootApplication
public class MusixServiceApplication implements CommandLineRunner, ApplicationListener<ContextRefreshedEvent> {
	@Value(value = "${cdata.name1}")
	String name1;
	@Value("${cdata.comment1}")
	String comment1;
	@Value(value = "${cdata.name2}")
	String name2;
	@Value("${cdata.comment2}")
	String comment2;


	@Autowired
	private TrackService trackService;
	public static void main(String[] args) {
		SpringApplication.run(MusixServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Track track2=new Track(name2,comment2);
		trackService.addMusic(track2);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) throws RuntimeException {


		Track track2=new Track(name1,comment1);

		try {
			trackService.addMusic(track2);
		} catch (TrackAlreadyExistsException e) {
			e.printStackTrace();
		}

	}
}
