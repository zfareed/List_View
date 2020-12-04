package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Person> data;
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dummyData();

        listview = findViewById(R.id.listview);
        MyPersonAdapter adapter = new MyPersonAdapter(this,R.layout.person_layout,data);
        listview.setAdapter(adapter);

    }

    public void dummyData(){
        data = new ArrayList<>();
        data.add(new Person("Zain","Fareed"));
        data.add(new Person("Najeeb","Ahmad"));
        data.add(new Person("Mohsin","Saleem"));
        data.add(new Person("Huzaifa","Shah"));
        data.add(new Person("Hammad","Bashir"));
        data.add(new Person("Faisal","Shahzad"));
    }

}