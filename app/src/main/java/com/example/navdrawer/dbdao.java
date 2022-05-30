package com.example.navdrawer;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.navdrawer.Entities.Athlete;
import com.example.navdrawer.Entities.Sport;
import com.example.navdrawer.Entities.Team;

import java.util.List;

@Dao
public interface dbdao {

    @Insert
    public void insertAT(Athlete athlete);

    @Insert
    public void insert(Sport sport);

    @Insert
    public void insertTE(Team team);

    @Query("select * from team")
    public List<Team> getTeams();

    @Query("select * from athlete")
    public List<Athlete> getAthletes();

    @Query("select * from sport")
    public List<Sport> getSports();

    @Query("select * from athlete where athlete_acountry = 'Greece'")
    public List<Athlete> getGreekAthletes();

    @Query("select team_name from team where team_year > 2000")
    public List<String> getTeamsAfterMillennium();

    @Query("select sports_name from sport where sports_gender = 'A'")
    public List<String> getMaleSports();

    @Delete
    public void delete(Sport sport);

    @Delete
    public void deleteAT(Athlete athlete);

    @Delete
    public void deleteTE(Team team);

    @Update
    public void update(Sport sport);

    @Update
    public void updateAT(Athlete athlete);

    @Update
    public void updateTE(Team team);
}
