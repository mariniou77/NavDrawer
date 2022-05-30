package com.example.navdrawer.Insert;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.navdrawer.MainActivity;
import com.example.navdrawer.R;
import com.example.navdrawer.Entities.Sport;

public class InsertSport extends Fragment {
    EditText editText1,editText2,editText3,editText4;
    Button addbutton;


    public InsertSport(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_insertsport,container,false);
        editText1=view.findViewById(R.id.sportid);
        editText2=view.findViewById(R.id.sportname);
        editText3=view.findViewById(R.id.sportkind);
        editText4=view.findViewById(R.id.sportgender);
        addbutton=view.findViewById(R.id.submitsport);
        addbutton.setOnClickListener(new View.OnClickListener() {
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
                    MainActivity.myDatabase.dbdaotemp().insert(sport);
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
