package com.jio.mobiles_service.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "plans")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String validity;
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mobile_id")
    @JsonBackReference
    private Mobile mobile;

    public Plan() {}

    public Plan(String title, String validity, Double price) {
        this.title = title;
        this.validity = validity;
        this.price = price;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getValidity() { return validity; }
    public Double getPrice() { return price; }
    public Mobile getMobile() { return mobile; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setValidity(String validity) { this.validity = validity; }
    public void setPrice(Double price) { this.price = price; }
    public void setMobile(Mobile mobile) { this.mobile = mobile; }  // ✅ must exist
}
