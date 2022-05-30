package com.example.navdrawer.Entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName ="athlete",
primaryKeys = {"athlete_id"},
foreignKeys = {
        @ForeignKey(entity = Sport.class,
        parentColumns = "sports_id",
        childColumns = "athlete_spid",
        onDelete = ForeignKey.CASCADE)})
public class Athlete {


    @ColumnInfo(name="athlete_id")
    private int aid;

    @ColumnInfo(name="athlete_name")
    private String aname;

    @ColumnInfo(name="athlete_surname")
    private String asurname;

    @ColumnInfo(name="athlete_city")
    private String acity;

    @ColumnInfo(name="athlete_acountry")
    private String acountry;

    @ColumnInfo(name="athlete_spid")
    private int id;

    @ColumnInfo(name="athlete_ayear")
    private int ayear;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAsurname() {
        return asurname;
    }

    public void setAsurname(String asurname) {
        this.asurname = asurname;
    }

    public String getAcity() {
        return acity;
    }

    public void setAcity(String acity) {
        this.acity = acity;
    }

    public String getAcountry() {
        return acountry;
    }

    public void setAcountry(String acountry) {
        this.acountry = acountry;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAyear() {
        return ayear;
    }

    public void setAyear(int ayear) {
        this.ayear = ayear;
    }
}
