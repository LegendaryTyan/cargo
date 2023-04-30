package com.example.cargo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;


@Entity
public class  Cargo {

    private Long id;
    private String cargoName;
    private String cargoContents;
    private String cityOfDispatch;
    private LocalDate shipmentDate;
    private String arrivalCity;
    private LocalDate arrivalDate;

    public Cargo() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCargoName() {
        return cargoName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName;
    }


    public String getCargoContents() {
        return cargoContents;
    }

    public void setCargoContents(String cargoContents) {
        this.cargoContents = cargoContents;
    }


    public String getCityOfDispatch() {
        return cityOfDispatch;
    }

    public void setCityOfDispatch(String cityOfDispatch) {
        this.cityOfDispatch = cityOfDispatch;
    }

    public LocalDate getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(LocalDate shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}
