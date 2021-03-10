package com.example.fyp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.fyp.Adapter.DatabaseAdapterTutor;
import com.example.fyp.Maths.LearningHubHome;
import com.example.fyp.Model.Tutor;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class LearningHub extends AppCompatActivity {
    ListView lstMyTutors;
    DatabaseHelperTutor DatabaseHelperTutor;
    ArrayList<Tutor> arrayList;
    DatabaseAdapterTutor DatabaseAdapterTutor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("My Tutors");
        setContentView(R.layout.activity_learning_hub);

        lstMyTutors = (ListView) findViewById(R.id.lstMyTutors);
        DatabaseHelperTutor = new DatabaseHelperTutor(this);
        arrayList = new ArrayList<>();

        getMyTutors();


        //Make listview clickable - https://www.youtube.com/watch?v=KvpulitmjbM&pbjreload=101https://www.youtube.com/watch?v=KvpulitmjbM&pbjreload=101
        lstMyTutors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //Selecting a tutor's profile
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(view.getContext(), LearningHubHome.class);
                startActivity(intent);


            }
        });


        // Linking activities to buttons on bottom nav bar - https://www.youtube.com/watch?v=WOuoolvuvnM

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.LearningHub);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {

                    case R.id.DisplayTutors:
                        startActivity(new Intent(getApplicationContext(), DisplayTutors.class));
                        finish();
                        overridePendingTransition(0, 0);
                        return;

                    case R.id.LearningHub:


                    case R.id.Profile:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        finish();
                        overridePendingTransition(0, 0);
                        return;
                }
            }
        });

    }




    //FUNCTION TO POPULATE LISTVIEW - https://youtu.be/6q4-Ge0UMKY
    private void getMyTutors() {
        arrayList = DatabaseHelperTutor.getMyTutors();
        DatabaseAdapterTutor = new DatabaseAdapterTutor(this,arrayList);
        lstMyTutors.setAdapter(DatabaseAdapterTutor);
        DatabaseAdapterTutor.notifyDataSetChanged();
    }


}


