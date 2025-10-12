package com.jio.mobiles_service.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "mobiles")
public class Mobile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;

    private Long userId; // <--- new field

    @OneToMany(mappedBy = "mobile", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Plan> plans;

    public Mobile() {}

    public Mobile(String name, String brand, Long userId, List<Plan> plans) {
        this.name = name;
        this.brand = brand;
        this.userId = userId;
        setPlans(plans);
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getBrand() { return brand; }
    public Long getUserId() { return userId; }
    public List<Plan> getPlans() { return plans; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setBrand(String brand) { this.brand = brand; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setPlans(List<Plan> plans) {
        if (plans != null) plans.forEach(p -> p.setMobile(this));
        this.plans = plans;
    }
}


