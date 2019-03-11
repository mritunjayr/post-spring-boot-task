package com.stackroute.musixservice.repository;

import com.stackroute.musixservice.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track,Integer> {

}
