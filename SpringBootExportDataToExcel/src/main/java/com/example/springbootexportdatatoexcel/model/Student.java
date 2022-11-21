package com.example.springbootexportdatatoexcel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sId;

    private String sName;

    private String sAddress;

    private String sCity;

    private String sPin;

    public Student() {
    }

    public Student(Long sId, String sName, String sAddress, String sCity, String sPin) {
        this.sId = sId;
        this.sName = sName;
        this.sAddress = sAddress;
        this.sCity = sCity;
        this.sPin = sPin;
    }

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public String getsCity() {
        return sCity;
    }

    public void setsCity(String sCity) {
        this.sCity = sCity;
    }

    public String getsPin() {
        return sPin;
    }

    public void setsPin(String sPin) {
        this.sPin = sPin;
    }

}
