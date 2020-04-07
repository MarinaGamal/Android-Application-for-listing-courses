package com.example.engineeringcourses;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CoursesActivity extends AppCompatActivity {
    ListView listView= null;
    InputStream inputreader;
    TextView name ;
    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        listView = (ListView) findViewById(R.id.Courses_list);
        name = (TextView) findViewById(R.id.name);
        logo = (ImageView) findViewById(R.id.logo);
        Intent intent = getIntent();
        String program = intent.getStringExtra("Program");
        SpannableString str = new SpannableString("Highlighted. Not highlighted.");
        str.setSpan(new BackgroundColorSpan(Color.BLUE), 0, 11, 0);
        name.setText(program);

        if(program.equals("Building Engineering Program"))
        {inputreader = this.getResources().openRawResource(R.raw.building);}
        else if(program.equals("Communication Systems Engineering Program"))
        {inputreader = this.getResources().openRawResource(R.raw.communication);}
        else if(program.equals("Materials Engineering Program"))
        {inputreader = this.getResources().openRawResource(R.raw.materials);}
        else if(program.equals("Manufacturing Engineering Program"))
        {inputreader = this.getResources().openRawResource(R.raw.manufacturing);}
        else if(program.equals("Energy and Renewable Energy Engineering Program"))
        {inputreader = this.getResources().openRawResource(R.raw.energy);}
        else if(program.equals("Computer Engineering and Software Systems Program"))
        {inputreader = this.getResources().openRawResource(R.raw.cess);}
        else if(program.equals("Landscape Architecture Program"))
        {inputreader = this.getResources().openRawResource(R.raw.landscape);}
        else if(program.equals("Environmental Architecture and Urbanism Program"))
        {inputreader = this.getResources().openRawResource(R.raw.environmental);}
        else if(program.equals("Mechatronics Engineering and Automation Program"))
        { inputreader = this.getResources().openRawResource(R.raw.mechatronics); }

        try {
            BufferedReader buffreader = new BufferedReader(new InputStreamReader(inputreader));
            ArrayList<String> lines = new ArrayList<String>();
            String line;
            while ((line = buffreader.readLine()) != null) {
                lines.add(line);
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.result,lines);
            listView.setAdapter(adapter);
        }
        catch (java.io.IOException e){
        }
        logo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent i = new Intent(getApplicationContext(), LogoActivity.class);
                startActivity(i);
            }

        });
    }

}
