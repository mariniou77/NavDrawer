package com.example.navdrawer.Entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

import com.example.navdrawer.Entities.Sport;

@Entity(tableName = "team",
primaryKeys ={"team_id"},
foreignKeys = {
        @ForeignKey(entity = Sport.class,
                parentColumns = "sports_id",
                childColumns = "team_spid",
                onDelete = ForeignKey.CASCADE)})
public class Team {

    @ColumnInfo(name="team_id")
    private int tid;

    @ColumnInfo(name="team_name")
    private String tname;

    @ColumnInfo(name="team_pitch")
    private String tpitch;

    @ColumnInfo(name="team_city")
    private String tcity;

    @ColumnInfo(name="team_counrty")
    private String tcountry;

    @ColumnInfo(name="team_spid")
    private int id;

    @ColumnInfo(name="team_year")
    private int tyear;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTpitch() {
        return tpitch;
    }

    public void setTpitch(String tpitch) {
        this.tpitch = tpitch;
    }

    public String getTcity() {
        return tcity;
    }

    public void setTcity(String tcity) {
        this.tcity = tcity;
    }

    public String getTcountry() {
        return tcountry;
    }

    public void setTcountry(String tcountry) {
        this.tcountry = tcountry;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTyear() {
        return tyear;
    }

    public void setTyear(int tyear) {
        this.tyear = tyear;
    }
}
