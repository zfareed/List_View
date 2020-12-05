package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Person> data;
    private ListView listview;
    private EditText fstName;
    private EditText sndName;
    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dummyData();

        fstName = findViewById(R.id.editfName);
        sndName = findViewById(R.id.editsName);
        addBtn = findViewById(R.id.button);

        listview = findViewById(R.id.listview);
        MyPersonAdapter adapter = new MyPersonAdapter(this,R.layout.person_layout,data);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.remove(position);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fName = fstName.getText().toString();
                String sName = sndName.getText().toString();

                Person p = new Person(fName,sName);
                adapter.add(p);


            }
        });

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