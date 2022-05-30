package com.example.navdrawer.Update;

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

import com.example.navdrawer.Entities.Sport;
import com.example.navdrawer.Insert.InsertSport;
import com.example.navdrawer.MainActivity;
import com.example.navdrawer.R;

public class UpdateSport extends Fragment {
    EditText editText1,editText2,editText3,editText4;
    Button upbutton;

    public UpdateSport(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_updatesport,container,false);
        editText1=view.findViewById(R.id.updsportid);
        editText2=view.findViewById(R.id.updatesportname);
        editText3=view.findViewById(R.id.updatesportkind);
        editText4=view.findViewById(R.id.updatesportgender);
        upbutton=view.findViewById(R.id.updatesubmitsport);

        upbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Var_sportid = 0;
                try{
                    Var_sportid =Integer.parseInt(editText1.getText().toString());
                }catch (NumberFormatException ex) {
                    System.out.println("Could not parse "+ ex);
                }
                String Var_sportname = editText2.getText().toString();
                String Var_sportkind = editText3.getText().toString();
                String Var_sportgender = editText4.getText().toString();
                try {
                    Sport sport = new Sport();
                    sport.setId(Var_sportid);
                    sport.setName(Var_sportname);
                    sport.setKind(Var_sportkind);
                    sport.setGender(Var_sportgender);
                    MainActivity.myDatabase.dbdaotemp().update(sport);
                    Toast.makeText(getActivity(), "Ola kala", Toast.LENGTH_LONG).show();
                }catch(Exception e){
                    String message=e.getMessage();
                    Toast.makeText(getActivity(),message, Toast.LENGTH_LONG).show();
                }
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
                editText4.setText("");

            }
        });
        return view;
    }
}
