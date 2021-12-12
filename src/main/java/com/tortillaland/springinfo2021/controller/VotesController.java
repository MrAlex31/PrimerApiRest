package com.tortillaland.springinfo2021.controller;
import java.util.List;
import java.util.Optional;
import com.tortillaland.springinfo2021.dao.VotesDAO;
import com.tortillaland.springinfo2021.entity.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/votes")
public class VotesController {
    @Autowired
    private VotesDAO voteDAO;

    @GetMapping
   public ResponseEntity<List<Vote>> getVote(){
       List<Vote> votes = voteDAO.findAll();
       return ResponseEntity.ok(votes);
   }
   @RequestMapping(value="{voteId}")
   public ResponseEntity<Vote> getVoteById(@PathVariable("voteId") Long voteId){
       Optional<Vote> Optionalvotes = voteDAO.findById(voteId);
       if(Optionalvotes.isPresent()){
           return ResponseEntity.ok(Optionalvotes.get());
       }else{
           return ResponseEntity.noContent().build();
       }
   }
   @PostMapping
   public ResponseEntity<Vote> createVote(@RequestBody Vote vote){
       Vote newVote = voteDAO.save(vote);
       return ResponseEntity.ok(newVote);
   }
   @DeleteMapping(value="{voteId}")
   public ResponseEntity<Void> deleteVote(@PathVariable("voteId") Long voteId){
       voteDAO.deleteById(voteId);
       return ResponseEntity.ok(null);
   }
   @PutMapping
   public ResponseEntity<Vote> updateVote(@RequestBody Vote vote){
       Optional<Vote> updateVote = voteDAO.findById(vote.getId());
       if(updateVote.isPresent()){
        Vote voteUpdate = updateVote.get();
           voteUpdate.setGeneratedFrom(vote.getGeneratedFrom());
           voteUpdate.setUserName(vote.getUserName());
           voteUpdate.setDateCreation(vote.getDateCreation());
           return ResponseEntity.ok(voteUpdate);
       }else{
           return ResponseEntity.notFound().build();
       }
    }
}
