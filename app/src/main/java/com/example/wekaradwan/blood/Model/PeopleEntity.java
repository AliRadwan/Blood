package com.example.wekaradwan.blood.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by weka radwan on 2/22/2019.
 */

// name of the table in the DB.
@Entity(tableName = "people_table")
public class PeopleEntity {

    // Table Colume
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "people_id")
    private int peopleId;
    @ColumnInfo(name = "blood_kind")
    private String bloodKind;
    private String peopleName;
    // we make age Int because we want to make it the priority of people
    private int peopleAge;
    private String peopleAddress;
    private String phoneNumber;


    // constructor
    // we did not put the id because id will be auto generate
    public PeopleEntity(String bloodKind, String peopleName, int peopleAge, String peopleAddress, String phoneNumber) {
        this.bloodKind = bloodKind;
        this.peopleName = peopleName;
        this.peopleAge = peopleAge;
        this.peopleAddress = peopleAddress;
        this.phoneNumber = phoneNumber;
    }

    // Setter and getter method
    public String getBloodKind() {
        return bloodKind;
    }

    public int getPeopleId() {
        return peopleId;
    }


    public String getPeopleName() {
        return peopleName;
    }

    public int getPeopleAge() {
        return peopleAge;
    }

    public String getPeopleAddress() {
        return peopleAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setBloodKind(String bloodKind) {
        this.bloodKind = bloodKind;
    }

    public void setPeopleId(int peopleId) {
        this.peopleId = peopleId;
    }


    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public void setPeopleAge(int peopleAge) {
        this.peopleAge = peopleAge;
    }

    public void setPeopleAddress(String peopleAddress) {
        this.peopleAddress = peopleAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
