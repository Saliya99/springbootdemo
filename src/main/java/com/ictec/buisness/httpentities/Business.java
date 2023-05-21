package com.ictec.buisness.httpentities;

import jakarta.persistence.*;

@Entity
public class Business {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String phone_number;
    @OneToOne(cascade = {CascadeType.ALL})
    private Address address;
    @OneToOne(cascade = {CascadeType.ALL})
    private Location location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

