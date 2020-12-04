package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MyPersonAdapter extends ArrayAdapter {

    private Context context;
    private int layout;
    private ArrayList<Person> data;


    public MyPersonAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Person> objects) {
        super(context, resource, objects);

        this.context = context;
        layout = resource;
        data = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(layout,parent,false);
        TextView firstName = view.findViewById(R.id.firstname);
        TextView lastName = view.findViewById(R.id.lastname);

        Person p=data.get(position);

        firstName.setText(p.firstName);
        lastName.setText(p.lastName);

        return view;
    }
}
