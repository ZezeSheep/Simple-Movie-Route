package com.zezesheep.apimovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zezesheep.apimovie.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
