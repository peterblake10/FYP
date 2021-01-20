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
import com.example.fyp.Model.Tutor;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

// Video showing me how to display database records in a listview - https://youtu.be/6q4-Ge0UMKY

public class DisplayTutors extends AppCompatActivity {
    ListView lstTutor;
    DatabaseHelperTutor DatabaseHelperTutor;
    ArrayList<Tutor> arrayList;
    DatabaseAdapterTutor DatabaseAdapterTutor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_tutors);

        lstTutor = (ListView) findViewById(R.id.lstTutor);
        DatabaseHelperTutor = new DatabaseHelperTutor(this);
        arrayList = new ArrayList<>();
        loadDataInListView();

        //Make listview clickable - https://www.youtube.com/watch?v=KvpulitmjbM&pbjreload=101https://www.youtube.com/watch?v=KvpulitmjbM&pbjreload=101
        lstTutor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //Selecting a tutor's profile
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==0) {
                    Intent intent = new Intent(view.getContext(), EoinHurley.class);
                    startActivity(intent);
                } else
                if (position ==1) {
                    Intent intent = new Intent(view.getContext(), ColmDineen.class);
                    startActivity(intent);
                }

            }
        });



        // Linking activities to buttons on bottom nav bar - https://www.youtube.com/watch?v=WOuoolvuvnM
        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.LearningHub);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){

                    case R.id.FindaTutor:


                    case R.id.LearningHub:
                        startActivity(new Intent(getApplicationContext(),LearningHub.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;


                    case R.id.Profile:
                        startActivity(new Intent(getApplicationContext(),Profile.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                }
            }
        });

    }

    private void loadDataInListView() {
        arrayList = DatabaseHelperTutor.getAllData();
        DatabaseAdapterTutor = new DatabaseAdapterTutor(this,arrayList);
        lstTutor.setAdapter(DatabaseAdapterTutor);
        DatabaseAdapterTutor.notifyDataSetChanged();
    }



}