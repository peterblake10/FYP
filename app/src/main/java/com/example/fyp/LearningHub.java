package com.example.fyp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fyp.Adapter.DatabaseAdapterTutor;
import com.example.fyp.Model.Tutor;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class LearningHub extends AppCompatActivity {
    ListView lstMyTutors;
    DatabaseHelperTutor DatabaseHelperTutor;
    ArrayList<Tutor> arrayList;
    com.example.fyp.Adapter.DatabaseAdapterTutor DatabaseAdapterTutor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_hub);

        lstMyTutors = (ListView) findViewById(R.id.lstMyTutors);
        DatabaseHelperTutor = new DatabaseHelperTutor(this);
        arrayList = new ArrayList<>();
        getMyTutors();


        // Linking activities to buttons on bottom nav bar - https://www.youtube.com/watch?v=WOuoolvuvnM

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.LearningHub);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){

                    case R.id.FindaTutor:
                        startActivity(new Intent(getApplicationContext(),DisplayTutors.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;

                    case R.id.LearningHub:


                    case R.id.Profile:
                        startActivity(new Intent(getApplicationContext(),Profile.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                }
            }
        });

    }

    private void getMyTutors() {
        arrayList = DatabaseHelperTutor.getMyTutors();
        DatabaseAdapterTutor = new DatabaseAdapterTutor(this,arrayList);
        lstMyTutors.setAdapter(DatabaseAdapterTutor);
        DatabaseAdapterTutor.notifyDataSetChanged();
    }


    }
