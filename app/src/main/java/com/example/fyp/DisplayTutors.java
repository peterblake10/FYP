package com.example.fyp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.fyp.Adapter.DatabaseAdapterTutor;
import com.example.fyp.Model.Tutor;

import java.util.ArrayList;

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

    }

    private void loadDataInListView() {
        arrayList = DatabaseHelperTutor.getAllData();
        DatabaseAdapterTutor = new DatabaseAdapterTutor(this,arrayList);
        lstTutor.setAdapter(DatabaseAdapterTutor);
        DatabaseAdapterTutor.notifyDataSetChanged();
    }

}