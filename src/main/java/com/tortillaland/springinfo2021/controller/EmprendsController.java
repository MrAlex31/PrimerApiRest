package com.tortillaland.springinfo2021.controller;
import java.util.List;
import java.util.Optional;
import com.tortillaland.springinfo2021.dao.EmprendsDAO;
import com.tortillaland.springinfo2021.entity.Emprend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@RequestMapping("/emprends")
public class EmprendsController {
    @Autowired
    private EmprendsDAO emprendDAO;

    @GetMapping
    public ResponseEntity<List<Emprend>> getEmprend(){
        List<Emprend> emprends = emprendDAO.findAll();
        return ResponseEntity.ok(emprends);
    }
    @RequestMapping(value="{emprendId}")
    public ResponseEntity<Emprend> getEmprendById(@PathVariable("emprendId") Long emprendId){
        Optional<Emprend> Optionalemprends = emprendDAO.findById(emprendId);
        if(Optionalemprends.isPresent()){
            return ResponseEntity.ok(Optionalemprends.get());
        }else{
            return ResponseEntity.noContent().build();
        }
    }
    @PostMapping
   public ResponseEntity<Emprend> createEmprend(@RequestBody Emprend emprend){
       Emprend newEmprend = emprendDAO.save(emprend);
       return ResponseEntity.ok(newEmprend);
   }
   @DeleteMapping(value="{emprendId}")
   public ResponseEntity<Void> deleteEmprend(@PathVariable("EmprendId") Long emprendId){
       emprendDAO.deleteById(emprendId);
       return ResponseEntity.ok(null);
   }
   @PutMapping
   public ResponseEntity<Emprend> updateEmprend(@RequestBody Emprend emprend){
       Optional<Emprend> updateEmprend = emprendDAO.findById(emprend.getId());
       if(updateEmprend.isPresent()){
        Emprend emprendUpdate = updateEmprend.get();
           emprendUpdate.setName(emprend.getName());
           emprendUpdate.setDescription(emprend.getDescription());
           emprendUpdate.setContent(emprend.getContent());
           emprendUpdate.setDateCreation(emprend.getDateCreation());
           emprendUpdate.setCollection(emprend.getCollection());
           emprendUpdate.setPublished(emprend.getPublished());
           emprendUpdate.setUrl(emprend.getUrl());
           emprendUpdate.setTags(emprend.getTags());
           return ResponseEntity.ok(emprendUpdate);
       }else{
           return ResponseEntity.notFound().build();
       }
    }
}
