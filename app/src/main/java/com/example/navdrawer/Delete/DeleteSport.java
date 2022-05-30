package com.example.navdrawer.Delete;

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

public class DeleteSport extends Fragment {
    EditText dltText;
    Button dltbutton;
    public DeleteSport(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_deletesport,container,false);

        dltText=view.findViewById(R.id.dlspid);
        dltbutton=view.findViewById(R.id.dlspbutton);

        dltbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Var_spid=0;
                try{
                    Var_spid=Integer.parseInt(dltText.getText().toString());
                }catch(NumberFormatException ex){
                    System.out.println("Could not parse "+ ex);
                }
                try {
                    Sport sport = new Sport();
                    sport.setId(Var_spid);
                    MainActivity.myDatabase.dbdaotemp().delete(sport);
                    Toast.makeText(getActivity(), "Sport Deleted", Toast.LENGTH_LONG).show();
                }catch(Exception e){
                    String message=e.getMessage();
                    Toast.makeText(getActivity(),message, Toast.LENGTH_LONG).show();
                }
                dltText.setText("");
            }
        });

        return view;
    }
}
