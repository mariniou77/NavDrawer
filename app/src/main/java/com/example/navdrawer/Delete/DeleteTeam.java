package com.example.navdrawer.Delete;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navdrawer.Entities.Athlete;
import com.example.navdrawer.Entities.Team;
import com.example.navdrawer.MainActivity;
import com.example.navdrawer.R;

public class DeleteTeam extends Fragment {
    EditText dltteamText;
    Button dltteamButton;

    public DeleteTeam(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_deleteteam,container,false);
        dltteamText=view.findViewById(R.id.dlteamText);
        dltteamButton=view.findViewById(R.id.dlteambutton);

        dltteamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Var_teid=0;
                try{
                    Var_teid=Integer.parseInt(dltteamText.getText().toString());
                }catch(NumberFormatException ex){
                    System.out.println("Could not parse "+ ex);
                }
                try {
                    Team team = new Team();
                    team.setTid(Var_teid);
                    MainActivity.myDatabase.dbdaotemp().deleteTE(team);
                    Toast.makeText(getActivity(), "Team Deleted", Toast.LENGTH_LONG).show();
                }catch(Exception e){
                    String message=e.getMessage();
                    Toast.makeText(getActivity(),message, Toast.LENGTH_LONG).show();
                }
                dltteamText.setText("");
            }
        });

        return view;
    }
}
