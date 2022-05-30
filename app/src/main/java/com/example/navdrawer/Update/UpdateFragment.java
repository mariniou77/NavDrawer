package com.example.navdrawer.Update;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navdrawer.MainActivity;
import com.example.navdrawer.R;

public class UpdateFragment extends Fragment implements View.OnClickListener {
      Button updSPbtn,updATbtn,updTEbtn;

      public UpdateFragment(){

      }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
          View view=inflater.inflate(R.layout.fragment_update,container,false);

          updSPbtn=view.findViewById(R.id.updateSPbtn);
          updSPbtn.setOnClickListener(this);

        updATbtn=view.findViewById(R.id.updateATbtn);
        updATbtn.setOnClickListener(this);

        updTEbtn=view.findViewById(R.id.updateTEbtn);
        updTEbtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
          switch(v.getId()){
              case R.id.updateSPbtn:
                  MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new UpdateSport()).addToBackStack(null).commit();
                  break;
              case R.id.updateATbtn:
                  MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new UpdateAthlete()).addToBackStack(null).commit();
                  break;
              case R.id.updateTEbtn:
                  MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new UpdateTeam()).addToBackStack(null).commit();
          }

    }
}
