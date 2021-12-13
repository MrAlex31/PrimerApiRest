package com.tortillaland.springinfo2021.service;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import com.tortillaland.springinfo2021.dao.EmprendsDAO;
import com.tortillaland.springinfo2021.dao.TagsDAO;
import com.tortillaland.springinfo2021.dao.UsersDAO;
import com.tortillaland.springinfo2021.dto.OperationEmprend;
import com.tortillaland.springinfo2021.entity.Emprend;
import com.tortillaland.springinfo2021.entity.Tag;
import com.tortillaland.springinfo2021.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmprendService {
    
    private final EmprendsDAO emprendsDAO;
    private final UsersDAO usersDAO;
    private final TagsDAO tagsDAO;

    @Autowired
    public EmprendService(EmprendsDAO emprendsDAO,
                                 UsersDAO usersDAO,
                                 TagsDAO tagsDAO) {
        this.emprendsDAO = emprendsDAO;
        this.usersDAO = usersDAO;
        this.tagsDAO = tagsDAO;
        }

        public Emprend createEmprend(OperationEmprend operationEmprend) {
            User user = usersDAO.findById(operationEmprend.getIdUser())
                    .orElseThrow(() -> new EntityNotFoundException("User No Encontrado"));
            List<Tag> tags = tagsDAO.findAllById(operationEmprend.getTags());
            Emprend emprend = new Emprend();
            emprend.setName(operationEmprend.getName());
            emprend.setDescription(operationEmprend.getDescription());
            emprend.setOwner(user);
            emprend.getTags().addAll(tags);
    
            return emprendsDAO.save(emprend);
        }
}
