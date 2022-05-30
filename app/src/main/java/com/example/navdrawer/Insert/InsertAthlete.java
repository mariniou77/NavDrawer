package com.example.navdrawer.Insert;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.navdrawer.Entities.Athlete;
import com.example.navdrawer.MainActivity;
import com.example.navdrawer.R;

public class InsertAthlete extends Fragment {
    EditText editText1,editText2,editText3,editText4,editText5,editText6,editText7;
    Button addbutton;


    public InsertAthlete(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_insertathlete,container,false);
        editText1=view.findViewById(R.id.aid);
        editText2=view.findViewById(R.id.aname);
        editText3=view.findViewById(R.id.asurname);
        editText4=view.findViewById(R.id.acity);
        editText5=view.findViewById(R.id.acountry);
        editText6=view.findViewById(R.id.aspid);
        editText7=view.findViewById(R.id.ayear);

        addbutton=view.findViewById(R.id.abutton);
        addbutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                int Var_aid = 0;
                try{
                    Var_aid =Integer.parseInt(editText1.getText().toString());
                }catch (NumberFormatException ex) {
                    System.out.println("Could not parse "+ ex);
                }
                String Var_aname=editText2.getText().toString();
                String Var_asurname=editText3.getText().toString();
                String Var_acity=editText4.getText().toString();
                String Var_acountry=editText5.getText().toString();
                int Var_spid= 0;
                try {
                    Var_spid = Integer.parseInt(editText6.getText().toString());
                }catch (NumberFormatException ex)   {
                        System.out.println("Could not parse "+ ex);
                }
                int Var_ayear=0;
                try {
                    Var_ayear = Integer.parseInt(editText7.getText().toString());
                }catch (NumberFormatException ex)   {
                    System.out.println("Could not parse "+ ex);
                }
                try {
                    Athlete athlete = new Athlete();
                    athlete.setAid(Var_aid);
                    athlete.setAname(Var_aname);
                    athlete.setAsurname(Var_asurname);
                    athlete.setAcity(Var_acity);
                    athlete.setAcountry(Var_acountry);
                    athlete.setId(Var_spid);
                    athlete.setAyear(Var_ayear);
                    MainActivity.myDatabase.dbdaotemp().insertAT(athlete);
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
