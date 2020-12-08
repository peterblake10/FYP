package com.example.fyp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fyp.Model.Tutor;
import com.example.fyp.R;

import java.util.ArrayList;

public class DatabaseAdapterTutor extends BaseAdapter {

    Context context;
    ArrayList<Tutor>arrayList;
    public DatabaseAdapterTutor(Context context, ArrayList<Tutor> arrayList){
        this.context=context;
        this.arrayList=arrayList;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.mycustomlistview,null);
            TextView txtPrefix = (TextView)convertView.findViewById(R.id.txtPrefix);
//            TextView txtFirstNameT = (TextView)convertView.findViewById(R.id.txtFirstNameT);
//            TextView txtSurnameT = (TextView)convertView.findViewById(R.id.txtSurnameT);
            TextView txtSubject = (TextView)convertView.findViewById(R.id.txtSubject);


            Tutor tutor = arrayList.get(position);

            txtPrefix.setText(tutor.getPrefix() + " " +  tutor.getName() + " " + tutor.getSurname());
//            txtFirstNameT.setText(tutor.getName());
//            txtSurnameT.setText(tutor.getSurname());
            txtSubject.setText(tutor.getSubject());

        return convertView;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }
}
