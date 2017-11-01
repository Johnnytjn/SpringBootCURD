package com.example.service;

import com.example.domain.Poll;
import com.example.domain.pollRespository.PollRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.acl.LastOwnerException;
import java.util.List;

@Service
public class PollService {
    @Autowired
    private PollRespository pollRespository;

    public List<Poll> getAllPolls() {
        return pollRespository.findAll();
    }

    public void savePoll(Poll poll) {
        pollRespository.save(poll);
    }

    public Poll findPollById(Long id) {
        return pollRespository.findById(id);
    }

    public void  deletePollById(Long id) {
        pollRespository.delete(id);
    }

    public List<Poll> findPollsByNameContains(String name) {
        return pollRespository.findByNameContains(name);
    }



}
