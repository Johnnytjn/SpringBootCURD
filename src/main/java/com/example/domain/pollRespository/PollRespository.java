package com.example.domain.pollRespository;

import com.example.domain.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public  interface PollRespository extends JpaRepository<Poll, Long> {

    Poll findById(  long id);

    List<Poll> findByNameContains(String name);

}
