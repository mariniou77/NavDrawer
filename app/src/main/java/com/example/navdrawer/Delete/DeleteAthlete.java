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
import com.example.navdrawer.Entities.Sport;
import com.example.navdrawer.MainActivity;
import com.example.navdrawer.R;

public class DeleteAthlete extends Fragment {
    EditText dlAtText;
    Button dlAtbutton;

    public DeleteAthlete(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_deleteathlete,container,false);

        dlAtText=view.findViewById(R.id.dltAtText);
        dlAtbutton=view.findViewById(R.id.dltAtbutton);


        dlAtbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Var_atid=0;
                try{
                    Var_atid=Integer.parseInt(dlAtText.getText().toString());
                }catch(NumberFormatException ex){
                    System.out.println("Could not parse "+ ex);
                }
                try {
                    Athlete athlete = new Athlete();
                    athlete.setAid(Var_atid);
                    MainActivity.myDatabase.dbdaotemp().deleteAT(athlete);
                    Toast.makeText(getActivity(), "Athlete Deleted ", Toast.LENGTH_LONG).show();
                }catch(Exception e){
                    String message=e.getMessage();
                    Toast.makeText(getActivity(),message, Toast.LENGTH_LONG).show();
                }
                dlAtText.setText("");
            }
        });

        return view;
    }
}
