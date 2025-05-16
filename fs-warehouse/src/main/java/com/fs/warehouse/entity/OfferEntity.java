package com.fs.warehouse.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "offers")
public class OfferEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    public String bidder;
    public double value;
    public String source;
    public String destination;
    public LocalDateTime responseDateTime;

    @Override
    public String toString() {
        return "OfferEntity{" +
                "id=" + id +
                ", bidder='" + bidder + '\'' +
                ", value=" + value +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", responseDateTime=" + responseDateTime +
                '}';
    }
}
