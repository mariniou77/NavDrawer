package com.example.navdrawer.Insert;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.navdrawer.MainActivity;
import com.example.navdrawer.Matches;
import com.example.navdrawer.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;

public class InsertMatch extends Fragment {
    EditText editText1,editText2,editText3,editText4,editText5;
    Button addbutton;

    public InsertMatch(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_insertmatch,container,false);
        editText1=view.findViewById(R.id.matchdate);
        editText2=view.findViewById(R.id.matchcity);
        editText3=view.findViewById(R.id.matchcountry);
        editText4=view.findViewById(R.id.matchsport);
        editText5=view.findViewById(R.id.matchid);
        addbutton=view.findViewById(R.id.matchbn);

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Var_matchid = 0;
                try {
                    Var_matchid = Integer.parseInt(editText5.getText().toString());
                }catch (NumberFormatException exc) {
                    System.out.println("Could not parse " + exc);
                }
                String Var_matchdate = editText1.getText().toString();
                String Var_matchcity = editText2.getText().toString();
                String Var_matchcountry = editText3.getText().toString();
                String Var_matchsport=editText4.getText().toString();
                try {
                    Matches matches = new Matches();
                    matches.setDate(Var_matchdate);
                    matches.setCity(Var_matchcity);
                    matches.setCountry(Var_matchcountry);
                    matches.setSport(Var_matchsport);
                    MainActivity.dbf.
                            collection("Matches").
                            document(""+Var_matchid).
                            set(matches).
                            addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(getActivity(), "Ola kala", Toast.LENGTH_LONG).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getActivity(), "add operation failed", Toast.LENGTH_LONG).show();
                        }
                    });
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
