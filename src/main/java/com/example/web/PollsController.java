package com.example.web;

import com.example.domain.Poll;
import com.example.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PollsController {

    @Autowired
    private PollService pollService;

    @RequestMapping(value = "/polls", method = RequestMethod.GET)
    public List<Poll> polls(){
        System.out.println(1245);
        return  pollService.getAllPolls();
    }

    @RequestMapping(value = "/poll/{name}/{description}",method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public Poll createPoll(@PathVariable("name") String name,
                           @PathVariable("description") String description){
        Poll poll = new Poll();
        poll.setName(name);
        poll.setDescription(description);
        poll.setVotesNum(0);
        pollService.savePoll(poll);
        return poll;
    }

    @RequestMapping(value = "/poll/{id}",method= RequestMethod.PUT,
            produces = "application/json; charset=UTF-8")
    public Poll votePoll(@PathVariable("id") Long id){
        Poll poll = pollService.findPollById(id);
        poll.setVotesNum(poll.getVotesNum()+1);
        pollService.savePoll(poll);
        return poll;

    }

    @RequestMapping(value = "/poll/{id}",method = RequestMethod.DELETE,
            produces = "application/json;charset=UTF-8")
    public List<Poll> deletePoll(@PathVariable("id") Long id){
        pollService.deletePollById(id);
        return pollService.getAllPolls();
    }
    @RequestMapping(value = "/polls/{name}", method = RequestMethod.GET,
        produces = "application/json;charset=UTF-8")
    public List<Poll> searchPolls(@PathVariable("name") String name){
        return pollService.findPollsByNameContains(name);
    }

}
