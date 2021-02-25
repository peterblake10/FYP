package com.example.fyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    //Creating variables for text and button for entering records into database https://www.youtube.com/watch?v=T0ClYrJukPA
    EditText editName, editSurname, editEmail, editPassword, editId, editConfirmPassword;
    Button btnAddUser;
    Button btnViewUpdate;
    Button btnDelete;
    Button btnView;
    Button btnBack;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Calls databasehelper to create table/database
        myDb = new DatabaseHelper(this);

        editName = (EditText) findViewById(R.id.txtFirstName);
        editSurname = (EditText) findViewById(R.id.txtSurname);
        editEmail = (EditText) findViewById(R.id.txtEmail);
        editPassword = (EditText) findViewById(R.id.txtPassword);
       // editId = (EditText) findViewById(R.id.txtID);
       // editConfirmPassword = (EditText) findViewById(R.id.txtConfirmPassword);
        btnAddUser = (Button) findViewById(R.id.btnAddUser);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
//        btnViewUpdate = (Button)findViewById(R.id.button_update);
//        btnDelete = (Button)findViewById(R.id.btnDelete);
//        btnView = (Button)findViewById(R.id.button_View);
        //Call Add User method
        AddUser();
        SignIn();
//        //Call update user method
//        UpdateUser();
       //Call delete user method
//        DeleteUser();
        //Call view users method
//        ViewUsers();

    }


        //Create method for when add user button is clicked - https://www.youtube.com/watch?v=T0ClYrJukPA

        public void AddUser() {

            btnAddUser.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            boolean isInserted = myDb.InsertUser(editName.getText().toString(),
                                    editSurname.getText().toString(),
                                    editEmail.getText().toString(),
                                    editPassword.getText().toString());

                            if (isInserted == true) {
                                Intent intent = new Intent(MainActivity.this, StudentLogin.class);
                                Toast.makeText(MainActivity.this, "User Added", Toast.LENGTH_LONG).show();
                                startActivity(intent);
                            }

                            else {
                                Toast.makeText(MainActivity.this, "User Not Added", Toast.LENGTH_LONG).show();
                            }

                        }

                    }
            );

        }

    public void SignIn() {

        btnSignIn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(MainActivity.this,StudentLogin.class);
                        startActivity(intent);
                    }

                }
        );

    }

//    // Method for when update user button is clicked - https://youtu.be/PA4A9IesyCg
//    public void UpdateUser() {
//        btnViewUpdate.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        boolean isUpdated = myDb.updateUser(editId.getText().toString(), editName.getText().toString()
//                                , editSurname.getText().toString(), editPassword.getText().toString());
//                        if (isUpdated == true)
//                        Toast.makeText(MainActivity.this,"User Updated",Toast.LENGTH_LONG).show();
//                        else
//                        Toast.makeText(MainActivity.this,"User Not Updated",Toast.LENGTH_LONG).show();
//                    }
//
//
//
//                }
//        );
//    }

//    //Method for when delete user button is clicked - https://www.youtube.com/watch?v=neaCUaHa2Ek
//    public void DeleteUser() {
//        btnDelete.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Integer deletedRows = myDb.deleteUser(editId.getText().toString());
//                        if(deletedRows > 0)
//                            Toast.makeText(MainActivity.this,"User Deleted",Toast.LENGTH_LONG).show();
//                        else
//                            Toast.makeText(MainActivity.this,"User Not Deleted",Toast.LENGTH_LONG).show();
//                    }
//                }   );
//    }

//    //Method for when view users button is clicked - https://www.youtube.com/watch?v=KUq5wf3Mh0c&list=PLS1QulWo1RIaRdy16cOzBO5Jr6kEagA07&index=4
//    public void ViewUsers() {
//        btnView.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Cursor res = myDb.getAllData();
//                        if (res.getCount() == 0) {
//                            //show message
//                            showMessage("Error", "Nothing Found");
//                            return;
//                        }
//                        StringBuffer buffer = new StringBuffer();
//                        //Moves the cursor to the next result
//                        while (res.moveToNext()) {
//                            buffer.append("ID :" + res.getString(0) + "\n");
//                            buffer.append("Name :" + res.getString(1) + "\n");
//                            buffer.append("Surname :" + res.getString(2) + "\n");
//                            buffer.append("Year :" + res.getString(3) + "\n\n");
//
//                        }
//                        // SHow all the users
//                        showMessage("Users", buffer.toString());
//
//                    }
//                }
//
//        );
//    }

//            public void showMessage(String title, String Message)   {
//            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//            builder.setCancelable(true);
//            builder.setTitle(title);
//            builder.setMessage((Message));
//            builder.show();
//        }

    }
