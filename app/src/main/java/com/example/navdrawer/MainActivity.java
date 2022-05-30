package com.example.navdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.navdrawer.Delete.DeleteFragment;
import com.example.navdrawer.Insert.InsertFragment;
import com.example.navdrawer.Update.UpdateFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    public static MyDatabase myDatabase;
    public static FragmentManager fragmentManager;
    public static FirebaseFirestore dbf;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dbf=FirebaseFirestore.getInstance();

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigationView);

        fragmentManager=getSupportFragmentManager();
        myDatabase=Room.databaseBuilder(getApplicationContext(),MyDatabase.class,"sportDB").allowMainThreadQueries().build();


        if(findViewById(R.id.fragment_container)!=null){
            if(savedInstanceState!=null){
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container,new StartFragment()).commit();
        }



      navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
              switch (menuItem.getItemId()) {
                  case R.id.insert:
                      MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new InsertFragment()).addToBackStack(null).commit();
                      Toast.makeText(MainActivity.this, "INSERT", Toast.LENGTH_LONG).show();
                      drawerLayout.closeDrawers();
                      return true;
                  case R.id.update:
                      MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new UpdateFragment()).addToBackStack(null).commit();
                      Toast.makeText(MainActivity.this, "UPDATE", Toast.LENGTH_LONG).show();
                      drawerLayout.closeDrawers();
                      return true;
                  case R.id.delete:
                      MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new DeleteFragment()).addToBackStack(null).commit();
                      Toast.makeText(MainActivity.this, "DELETE", Toast.LENGTH_LONG).show();
                      drawerLayout.closeDrawers();
                      return true;
                  case R.id.queries:
                      MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new QueryFragment()).addToBackStack(null).commit();
                      Toast.makeText(MainActivity.this, "QUERIES", Toast.LENGTH_LONG).show();
                      drawerLayout.closeDrawers();
                      return true;
                  case R.id.firebase:
                      MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new FireQueryFragment()).addToBackStack(null).commit();
                      Toast.makeText(MainActivity.this, "FIREBASE", Toast.LENGTH_LONG).show();
                      drawerLayout.closeDrawers();
                      return true;
              }
              return false;
          }
      });





    }


}