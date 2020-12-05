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


    public void add(@Nullable Person person) {
             data.add(person);
             notifyDataSetChanged();
    }

    public void remove(int position){
          data.remove(position);
          notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view;
        ViewHolder holder;
        if (convertView!=null){
            view=convertView;
            holder = (ViewHolder) view.getTag();
        }
        else {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(layout,parent,false);
            holder = new ViewHolder();
            holder.firstName = view.findViewById(R.id.firstname);
            holder.lastName = view.findViewById(R.id.lastname);
            view.setTag(holder);
        }


        Person p=data.get(position);

        holder.firstName.setText(p.firstName);
        holder.lastName.setText(p.lastName);

        return view;
    }

    static class ViewHolder {
            TextView firstName, lastName;
    }
}
