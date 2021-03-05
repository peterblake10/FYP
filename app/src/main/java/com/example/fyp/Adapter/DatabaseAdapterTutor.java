package com.example.fyp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fyp.Model.Tutor;
import com.example.fyp.R;

import java.util.ArrayList;

// Video showing me how to display database records in a listview - https://youtu.be/6q4-Ge0UMKY

public class DatabaseAdapterTutor extends BaseAdapter {

    Context context;
    String[] values;
    ArrayList<Tutor> arrayList;

    public DatabaseAdapterTutor(Context context, ArrayList<Tutor> arrayList) {
        this.context = context;
        this.values = values;
        this.arrayList = arrayList;
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


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.mycustomlistview, null);

        TextView txtPrefix = (TextView) convertView.findViewById(R.id.txtPrefix);

        TextView txtSubject = (TextView) convertView.findViewById(R.id.txtSubject);

        ImageView imageTutor = (ImageView) convertView.findViewById(R.id.imageTutor);



        Tutor tutor = arrayList.get(position);

        txtPrefix.setText(tutor.getPrefix() + " " + tutor.getName() + " " + tutor.getSurname());

        txtSubject.setText(tutor.getSubject());

        String s = tutor.getSubject();

        if(s.equals("Maths")){
            imageTutor.setImageResource(R.drawable.img_0402);
        } else if(s.equals("Irish")){
            imageTutor.setImageResource(R.drawable.teacher2);
        }


            return convertView;
        }

        @Override
        public int getCount () {
            return this.arrayList.size();
        }
    }
