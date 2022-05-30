package com.example.navdrawer.Insert;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.navdrawer.MainActivity;
import com.example.navdrawer.R;

public class InsertFragment extends Fragment implements View.OnClickListener {

    Button addbutton,atbutton,tebutton,mabutton;

    public InsertFragment(){

    }
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_insert, container, false);

        addbutton = view.findViewById(R.id.buttonInSport);
        addbutton.setOnClickListener(this);

        atbutton = view.findViewById(R.id.buttonInAthlete);
        atbutton.setOnClickListener(this);

        tebutton = view.findViewById(R.id.buttonInTeam);
        tebutton.setOnClickListener(this);

        mabutton = view.findViewById(R.id.buttonInMatch);
        mabutton.setOnClickListener(this);


        return view;
    }
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.buttonInSport:
                        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new InsertSport()).addToBackStack(null).commit();
                        break;
                    case R.id.buttonInAthlete:
                        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new InsertAthlete()).addToBackStack(null).commit();
                        break;
                    case R.id.buttonInTeam:
                        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new InsertTeam()).addToBackStack(null).commit();
                        break;
                    case R.id.buttonInMatch:
                        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new InsertMatch()).addToBackStack(null).commit();
                }
            }

}
