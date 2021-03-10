package com.example.fyp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile extends AppCompatActivity {

        Button btnEditDetails;
        Button btnCalendar;
        Button btnLogout;
        ImageView objectImageView;

    private static final int PICK_IMAGE_REQUEST = 100;
    private Uri imageFilePath;

    private Bitmap imageToStore;

    DatabaseHelperResources objectDatabaseHelperResources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("My Profile");
        setContentView(R.layout.activity_profile);

        btnEditDetails = (Button) findViewById(R.id.btnEditDetails);
        btnCalendar = (Button) findViewById(R.id.btnCalendar);
        btnLogout = (Button) findViewById(R.id.btnLogout);

        try {

            objectImageView = findViewById(R.id.image);

            objectDatabaseHelperResources = new DatabaseHelperResources(this);

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }



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
//Selecting a profile picture

    public void chooseImage(View objectView) {
        try {
            Intent objectIntent = new Intent();
            objectIntent.setType("image/*");

            objectIntent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(objectIntent, PICK_IMAGE_REQUEST);

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        try {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
                imageFilePath = data.getData();
                imageToStore = MediaStore.Images.Media.getBitmap(getContentResolver(), imageFilePath);

                objectImageView.setImageBitmap(imageToStore);
            }
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }
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