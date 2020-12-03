package com.example.fyp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class TutorForms extends AppCompatActivity {
    // YOUTUBE VIDEO FOR ACCESSING GALLERY - https://www.youtube.com/watch?v=O6dWwoULFI8
    ImageView imageViewG;
    ImageView imageViewR;
    Button btnGarda;
    Button btnRegistration;

    Button btnRegister1;


    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_forms);
        btnRegister1 = (Button) findViewById(R.id.btnRegister1);
        //VIEWS
        imageViewG = findViewById(R.id.imageViewG);
        btnGarda = findViewById(R.id.btnGarda);

        btnRegister1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Registration Complete", Toast.LENGTH_LONG).show();//display the text of button1
            }
        });
        //handle button click
        btnGarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check permsission
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_DENIED) {
                        //permission not granted, request it
                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        //show popup for runtime permission
                        requestPermissions(permissions, PERMISSION_CODE);
                    } else {
                        //permission already granted
                        pickImageFromGallery();
                    }

                } else {
                    //System os is less than marshmallow
                    pickImageFromGallery();
                }
            }
        });

        imageViewR = findViewById(R.id.imageViewR);
        btnRegistration = findViewById(R.id.btnRegistration);



        //handle button click
        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check permsission
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_DENIED) {
                        //permission not granted, request it
                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        //show popup for runtime permission
                        requestPermissions(permissions, PERMISSION_CODE);
                    } else {
                        //permission already granted
                        pickImageFromGallery1();
                    }

                } else {
                    //System os is less than marshmallow
                    pickImageFromGallery1();
                }
            }
        });


    }

    private void pickImageFromGallery() {
        //intent to pick image
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }

    private void pickImageFromGallery1() {
        //intent to pick image
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }


    //handle result of runtime permission

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_CODE: {
                if (grantResults.length > 0 && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED) {
                    //permission was granted
                    pickImageFromGallery();
                } else {
                    //permission was denied
                    Toast.makeText(this, "Permission denied!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


    //handle result of picked image
    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            //SET IMAGE TO VIEW
            imageViewG.setImageURI(data.getData());

        }
    }





}
