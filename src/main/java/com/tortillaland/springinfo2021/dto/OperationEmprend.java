package com.tortillaland.springinfo2021.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

public class OperationEmprend {
    @NotEmpty(message = "El nombre no puede ser vacio")
    private String name;

    @NotEmpty(message = "El descripcion no puede ser vacio")
    private String description;

    @NotNull
    @Positive
    @JsonProperty(value = "id_usuario")
    private Long idUser;

    private List<Long> tags;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public List<Long> getTags() {
        return tags;
    }

    public void setTags(List<Long> tags) {
        this.tags = tags;
    }
}
