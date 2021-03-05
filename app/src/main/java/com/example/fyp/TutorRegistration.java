package com.example.fyp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Blob;
import java.util.ArrayList;

public class TutorRegistration extends AppCompatActivity {
    DatabaseHelperTutor myDbTutor;


    //Creating variables for text and button for entering records into database https://www.youtube.com/watch?v=T0ClYrJukPA
    EditText editPrefix, editName, editSurname, editEmail, editPassword, editSubject, editId, editBio;


    Button btnAddTutor;
//    Button btnDeleteTutor;

    private ImageView editImage;


    private static final int PICK_IMAGE_REQUEST = 100;
    private Uri imageFilePath;

    private Bitmap imageToStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_registration);





        myDbTutor = new DatabaseHelperTutor(this);

        editPrefix = (EditText) findViewById(R.id.txtPrefix);
        editName = (EditText) findViewById(R.id.txtFirstNameT);
        editSurname = (EditText) findViewById(R.id.txtSurnameT);
        editEmail = (EditText) findViewById(R.id.txtEmailT);
        editPassword = (EditText) findViewById(R.id.txtPasswordT);
        editSubject = (EditText) findViewById(R.id.txtSubject);
    //    editId = (EditText) findViewById(R.id.txtID);
        editBio = (EditText) findViewById(R.id.txtBio) ;
        editImage = findViewById(R.id.imageT);

        btnAddTutor = (Button) findViewById(R.id.btnAddTutor);

//        btnDeleteTutor = (Button) findViewById(R.id.btnDeleteTutor);

//        //Call Add Tutor method
        AddTutor();
        //Call Delete Tutor Method
//        DeleteTutor();
    }


    public void uploadImage(View objectView) {
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

                editImage.setImageBitmap(imageToStore);
            }
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }

//
//
//Create method for when add user button is clicked - https://www.youtube.com/watch?v=T0ClYrJukPA

    public void AddTutor() {

        btnAddTutor.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDbTutor.InsertTutor(
                                editPrefix.getText().toString(),
                                editName.getText().toString(),
                                editSurname.getText().toString(),
                                editEmail.getText().toString(),
                                editPassword.getText().toString(),
                                editSubject.getText().toString(),
                                editBio.getText().toString(),
                                imageToStore);

                        if (isInserted == true)
                            Toast.makeText(TutorRegistration.this, "Tutor Added", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(TutorRegistration.this, "Tutor Not Added", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(TutorRegistration.this, TutorForms.class);
                        startActivity(intent);
                    }

                }
        );




    }
//    public void DeleteTutor() {
//        btnDeleteTutor.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Integer deletedRows = myDbTutor.deleteTutor(editId.getText().toString());
//                        if (deletedRows > 0)
//                            Toast.makeText(TutorRegistration.this, "User Deleted", Toast.LENGTH_LONG).show();
//                        else
//                            Toast.makeText(TutorRegistration.this, "User Not Deleted", Toast.LENGTH_LONG).show();
//                    }
//                });
//    }
}
