package com.example.navdrawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.navdrawer.Entities.Athlete;
import com.example.navdrawer.Entities.Sport;
import com.example.navdrawer.Entities.Team;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class QueryFragment extends Fragment {
    Spinner spinner;
    ArrayAdapter<CharSequence>adapter;
    TextView querytextView,queryTextresult;
    Button bnrun;
    int test;
    public QueryFragment(){

    }



    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_query,container,false );
        final String[] queryArray=getResources().getStringArray(R.array.queries_desc);
        querytextView=view.findViewById(R.id.txtQuery);
        spinner = view.findViewById(R.id.spinner);
        adapter=ArrayAdapter.createFromResource(getContext(),R.array.queries_array,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                querytextView.setText(queryArray[position]);
                test=position+1;
            }

            public void onNothingSelected(AdapterView<?> parent){

            }
        });
        queryTextresult=view.findViewById(R.id.txtRes);
        bnrun=view.findViewById(R.id.querrybtn);
        bnrun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result=" ";
                switch(test){
                    case 1:
                        List<Sport> sports=MainActivity.myDatabase.dbdaotemp().getSports();
                        for(Sport i:sports){
                            int code=i.getId();
                            String name=i.getName();
                            String kind=i.getKind();
                            String gender=i.getGender();
                            result=result +"\n Id: "+code+" \n name: "+name+"\n kind: "+kind+"\n gender: "+gender+"\n";
                        }
                        queryTextresult.setText(result);
                        break;
                    case 2:
                        List<Athlete> athletes=MainActivity.myDatabase.dbdaotemp().getAthletes();
                        for(Athlete i:athletes){
                            int code=i.getAid();
                            String name=i.getAname();
                            String surname=i.getAsurname();
                            String city=i.getAcity();
                            String country=i.getAcountry();
                            int code2=i.getId();
                            int year=i.getAyear();
                            result=result+"\n Athlete id: "+code+"\n Name: "+name+"\n Surname: "+surname+"\n City: "+city+"\n Country: "+country+"\n Sport id: "+code2+"\n Year Born: "+year+"\n";

                        }
                        queryTextresult.setText(result);
                        break;
                    case 3:
                        List<Team> teams=MainActivity.myDatabase.dbdaotemp().getTeams();
                        for(Team i:teams){
                            int code=i.getTid();
                            String name=i.getTname();
                            String pitch=i.getTpitch();
                            String city=i.getTcity();
                            String country=i.getTcountry();
                            int code2=i.getId();
                            int year=i.getTyear();
                            result=result+"\n Team id: "+code+"\n Name: "+name+"\n Pitch: "+pitch+"\n City: "+city+"\n Country: "+country+"\n Sport id: "+code2+"\n Year Founded: "+year+"\n";
                        }
                        queryTextresult.setText(result);
                        break;

                    case 4:
                        List<Athlete> greekAthletes=MainActivity.myDatabase.dbdaotemp().getGreekAthletes();
                        for(Athlete i:greekAthletes){
                            int code=i.getAid();
                            String name=i.getAname();
                            String surname=i.getAsurname();
                            String city=i.getAcity();
                            String country=i.getAcountry();
                            int code2=i.getId();
                            int year=i.getAyear();
                            result=result+"\n Athlete id: "+code+"\n Name: "+name+"\n Surname: "+surname+"\n City: "+city+"\n Country: "+country+"\n Sport id: "+code2+"\n Year Born: "+year+"\n";
                        }
                        queryTextresult.setText(result);
                        break;
                    case 5:
                        List<String> teamsAfterMillennium =MainActivity.myDatabase.dbdaotemp().getTeamsAfterMillennium();
                        for(String i: teamsAfterMillennium){
                            result = result + "\n Team name : " + i + "\n";
                        }
                        queryTextresult.setText(result);
                        break;

                    case 6:
                        List<String> maleSports = MainActivity.myDatabase.dbdaotemp().getMaleSports();
                        for(String i: maleSports){
                            result = result + "\n Sport name : " + i + "\n";
                        }
                        queryTextresult.setText(result);
                        break;
                    case 7:
                        CollectionReference collectionReference=MainActivity.dbf.
                                collection("Matches");
                        Query query=collectionReference.whereEqualTo("country","greece");
                       query.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                            @Override
                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                String result= "";
                                for (QueryDocumentSnapshot documentSnapshot: queryDocumentSnapshots){
                                    Matches matches=documentSnapshot.toObject(Matches.class);
                                    String matchdate=matches.getDate();
                                    String matchcity=matches.getCity();
                                    String matchcountry=matches.getCountry();
                                    String matchsport=matches.getSport();
                                    result+="Ημερομηνία: "+matchdate+" Πόλη: "+matchcity+" Χώρα: "+matchcountry+" Άθλημα: "+matchsport +"\n";
                                }
                               queryTextresult.setText(result);
                            }
                        });
                       break;
                    case 8:
                        CollectionReference collectionReference2=MainActivity.dbf.
                                collection("Matches");
                        Query query2=collectionReference2.whereEqualTo("city","london");
                        query2.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                            @Override
                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                String result= "";
                                for (QueryDocumentSnapshot documentSnapshot: queryDocumentSnapshots){
                                    Matches matches=documentSnapshot.toObject(Matches.class);
                                    String matchdate=matches.getDate();
                                    String matchcity=matches.getCity();
                                    String matchcountry=matches.getCountry();
                                    String matchsport=matches.getSport();
                                    result+="Ημερομηνία: "+matchdate+" Πόλη: "+matchcity+" Χώρα: "+matchcountry+" Άθλημα: "+matchsport +"\n";
                                }
                                queryTextresult.setText(result);
                            }
                        });
                        break;
                    case 9:
                        CollectionReference collectionReference3=MainActivity.dbf
                                .collection("Matches");
                        Query query3=collectionReference3.whereEqualTo("sport","basket");
                        query3.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                            @Override
                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                String result= "";
                                for (QueryDocumentSnapshot documentSnapshot: queryDocumentSnapshots){
                                    Matches matches=documentSnapshot.toObject(Matches.class);
                                    String matchdate=matches.getDate();
                                    String matchcity=matches.getCity();
                                    String matchcountry=matches.getCountry();
                                    String matchsport=matches.getSport();
                                    result+="Ημερομηνία: "+matchdate+" Πόλη: "+matchcity+" Χώρα: "+matchcountry+" Άθλημα: "+matchsport +"\n";
                                }
                                queryTextresult.setText(result);
                            }
                        });
                        break;
                }
            }
        });
        return view;
    }
}
