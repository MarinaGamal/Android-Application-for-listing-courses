package com.example.engineeringcourses;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String[] array = {"Building Engineering Program","Communication Systems Engineering Program","Materials Engineering Program"
    ,"Manufacturing Engineering Program","Energy and Renewable Energy Engineering Program","Computer Engineering and Software Systems Program",
    "Landscape Architecture Program","Mechatronics Engineering and Automation Program","Environmental Architecture and Urbanism Program"};
    ListView listView= null;
    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.Programs_list);
        logo = (ImageView) findViewById(R.id.logo);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_listview,array);
        listView.setAdapter(adapter);
        listView.setClickable(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Object o = listView.getItemAtPosition(position);
                String s = o.toString();
                Intent i = new Intent(getApplicationContext(), CoursesActivity.class);
                i.putExtra("Program", s);
                startActivity(i);
            }
        });


        logo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent i = new Intent(getApplicationContext(), LogoActivity.class);
                startActivity(i);
            }

        });
    }

}
