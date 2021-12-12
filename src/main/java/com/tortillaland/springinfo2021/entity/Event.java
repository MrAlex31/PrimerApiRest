package com.tortillaland.springinfo2021.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="events")
public class Event {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String details;
    private LocalDate dateCreation;
    private LocalDate dateCloser;
    private Status status;
    private Long suscribers;
    private Long prize;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDateCreation() {
        return this.dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDate getDateCloser() {
        return this.dateCloser;
    }

    public void setDateCloser(LocalDate dateCloser) {
        this.dateCloser = dateCloser;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getSuscribers() {
        return this.suscribers;
    }

    public void setSuscribers(Long suscribers) {
        this.suscribers = suscribers;
    }

    public Long getPrize() {
        return this.prize;
    }

    public void setPrize(Long prize) {
        this.prize = prize;
    }

}
