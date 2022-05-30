package com.example.navdrawer;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.navdrawer.Entities.Athlete;
import com.example.navdrawer.Entities.Sport;
import com.example.navdrawer.Entities.Team;

@Database(entities = {Sport.class, Athlete.class, Team.class},version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract dbdao dbdaotemp();
}
