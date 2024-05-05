package com.chipichapa.hospital.model;

import jakarta.persistence.*;

@Entity
@Table(name = "medicine")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "import_date")
    private String importDate;

    @Column(name = "shipment")
    private long shipment;

    @Column(name = "number")
    private long number;

    @Column(name = "expiry")
    private String expiry;

    public Medicine(){}

    public Medicine(String name, String importDate, long shipment, long number, String expiry){
        super();
        this.name = name;
        this.importDate = importDate;
        this.shipment = shipment;
        this.number = number;
        this.expiry = expiry;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }

    public long getShipment() {
        return shipment;
    }

    public void setShipment(long shipment) {
        this.shipment = shipment;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }
}
