package com.example.navdrawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class FireQueryFragment extends Fragment {
    TextView querryresult;

    public FireQueryFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_firequery,container,false);
        querryresult=view.findViewById(R.id.txtResfr);
        CollectionReference collectionReference=MainActivity.dbf.
                collection("Matches");
        collectionReference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                String result= "";
                for (QueryDocumentSnapshot documentSnapshot: queryDocumentSnapshots){
                    Matches matches=documentSnapshot.toObject(Matches.class);
                    String matchdate=matches.getDate();
                    String matchcity=matches.getCity();
                    String matchcountry=matches.getCountry();
                    String matchsports=matches.getSport();
                    result+="Ημερομηνία: "+matchdate+" Πόλη: "+matchcity+" Χώρα: "+matchcountry+" Άθλημα: "+matchsports +"\n";
                }
                querryresult.setText(result);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "operation failed", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
