package com.example.navdrawer.Delete;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.navdrawer.MainActivity;
import com.example.navdrawer.R;

public class DeleteFragment extends Fragment implements View.OnClickListener {
    Button delbutton,datbutton,dtebutton;
    public DeleteFragment(){

    }


    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_delete,container,false);

        delbutton=view.findViewById(R.id.dlsport);
        delbutton.setOnClickListener(this);

        datbutton=view.findViewById(R.id.dlathlete);
        datbutton.setOnClickListener(this);

        dtebutton=view.findViewById(R.id.dlteam);
        dtebutton.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.dlsport:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new DeleteSport()).addToBackStack(null).commit();
                break;
            case R.id.dlathlete:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new DeleteAthlete()).addToBackStack(null).commit();
                break;
            case R.id.dlteam:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new DeleteTeam()).addToBackStack(null).commit();
                break;
        }
    }
}

