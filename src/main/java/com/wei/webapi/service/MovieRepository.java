package com.wei.webapi.service;

import org.springframework.data.jpa.repository.JpaRepository;


import com.wei.webapi.model.movie;

public interface MovieRepository  extends JpaRepository<movie, Long> {

}
