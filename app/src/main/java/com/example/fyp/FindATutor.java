package com.example.fyp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FindATutor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_a_tutor);

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
}