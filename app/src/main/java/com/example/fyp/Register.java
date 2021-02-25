package com.example.fyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//Page for selecting Student registration or Tutor registration

public class Register extends AppCompatActivity {

    DatabaseHelper myDb;

    private Button btnStudentReg;
    private Button btnTutorReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnStudentReg = (Button) findViewById(R.id.btnStudentReg);
        btnTutorReg = (Button) findViewById(R.id.btnTutorReg);

        StudentReg();
        TutorReg();
    }

    //When student registration button is clicked, bring to student registration page.
    public void StudentReg() {

        btnStudentReg.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(Register.this,MainActivity.class);
                        startActivity(intent);
                    }

                }
        );

    }

    //When tutor registration button is clicked, bring to tutor registration page.
    public void TutorReg() {

        btnTutorReg.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(Register.this,TutorRegistration.class);
                        startActivity(intent);
                    }

                }
        );

    }
}