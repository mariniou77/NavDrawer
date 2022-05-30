package com.example.navdrawer.Update;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.room.Update;

import com.example.navdrawer.Entities.Team;
import com.example.navdrawer.Insert.InsertFragment;
import com.example.navdrawer.MainActivity;
import com.example.navdrawer.R;

public class UpdateTeam extends Fragment {
    EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7;
    Button addbutton;

    public UpdateTeam() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view=inflater.inflate(R.layout.fragment_updateteam,container,false);
            editText1=view.findViewById(R.id.tidup);
            editText2=view.findViewById(R.id.tnameup);
            editText3=view.findViewById(R.id.tpitchup);
            editText4=view.findViewById(R.id.tcityup);
            editText5=view.findViewById(R.id.tcountryup);
            editText6=view.findViewById(R.id.tspidup);
            editText7=view.findViewById(R.id.tyearup);

            addbutton=view.findViewById(R.id.teambuttonup);
            addbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int Var_tid = 0;
                    try{
                        Var_tid =Integer.parseInt(editText1.getText().toString());
                    }catch (NumberFormatException ex) {
                        System.out.println("Could not parse "+ ex);
                    }
                    String Var_tname=editText2.getText().toString();
                    String Var_tpitch=editText3.getText().toString();
                    String Var_tcity=editText4.getText().toString();
                    String Var_tcountry=editText5.getText().toString();
                    int Var_tspid= 0;
                    try {
                        Var_tspid = Integer.parseInt(editText6.getText().toString());
                    }catch (NumberFormatException ex)   {
                        System.out.println("Could not parse "+ ex);
                    }
                    int Var_tyear=0;
                    try {
                        Var_tyear = Integer.parseInt(editText7.getText().toString());
                    }catch (NumberFormatException ex)   {
                        System.out.println("Could not parse "+ ex);
                    }
                    try{
                        Team team=new Team();
                        team.setTid(Var_tid);
                        team.setTname(Var_tname);
                        team.setTpitch(Var_tpitch);
                        team.setTcity(Var_tcity);
                        team.setTcountry(Var_tcountry);
                        team.setId(Var_tspid);
                        team.setTyear(Var_tyear);
                        MainActivity.myDatabase.dbdaotemp().updateTE(team);
                        Toast.makeText(getActivity(), "Ola kala", Toast.LENGTH_LONG).show();
                    }catch(Exception e){
                        String message=e.getMessage();
                        Toast.makeText(getActivity(),message, Toast.LENGTH_LONG).show();
                    }
                    editText1.setText("");
                    editText2.setText("");
                    editText3.setText("");
                    editText4.setText("");
                    editText5.setText("");
                    editText6.setText("");
                    editText7.setText("");
                }
            });

        return view;
    }
}
