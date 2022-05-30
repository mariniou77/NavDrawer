package com.example.navdrawer.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "sport")
public class Sport {
    @PrimaryKey
    @ColumnInfo(name="sports_id")
    private int id;

    @ColumnInfo(name="sports_name")
    private String name;

    @ColumnInfo(name="sports_kind")
    private String kind;

    @ColumnInfo(name="sports_gender")
    private String gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
