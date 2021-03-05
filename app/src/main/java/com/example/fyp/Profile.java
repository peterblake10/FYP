package com.example.fyp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile extends AppCompatActivity {

        Button btnEditDetails;
        Button btnCalendar;
        Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("My Profile");
        setContentView(R.layout.activity_profile);

        btnEditDetails = (Button) findViewById(R.id.btnEditDetails);
        btnCalendar = (Button) findViewById(R.id.btnCalendar);
        btnLogout = (Button) findViewById(R.id.btnLogout);



        // Linking activities to buttons on bottom nav bar - https://www.youtube.com/watch?v=WOuoolvuvnM

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.LearningHub);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){

                    case R.id.DisplayTutors:
                        startActivity(new Intent(getApplicationContext(),DisplayTutors.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;


                    case R.id.LearningHub:
                        startActivity(new Intent(getApplicationContext(),LearningHub.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;


                    case R.id.Profile:

                }
            }
        });


        Details();
        Calendar();

    }

    public void Details() {

        btnEditDetails.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Profile.this, EditDetails.class);
                        startActivity(intent);
                    }

                }
        );

    }

    public void Calendar() {

        btnCalendar.setOnClickListener(
        new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, Calendar.class);
                startActivity(intent);
            }

        }
        );
    }





}