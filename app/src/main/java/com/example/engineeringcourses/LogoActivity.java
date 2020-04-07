package com.example.engineeringcourses;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LogoActivity extends AppCompatActivity {
    TextView overview ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        Intent intent = getIntent();
        overview = (TextView) findViewById(R.id.overview);
        overview.setText("Overview\n" +
                "Vision\n" +
                "To be one of the best colleges are known for their leadership regionally and internationally in engineering education and scientific research through interdisciplinary and unique academic programs meet the needs of the community and contribute to sustainable development.\n" +
                "\n" +
                "Mission\n" +
                "Preparation distinguished graduate capable of keep pace with global technological in various disciplines that meet the needs of local and regional markets, and can conduct scientific research and applied through the creation of appropriate conditions for faculty members and their assistants and students, and to provide educational programs in advanced undergraduate and graduate studies and continuing education, and the establishment of advisory centers and research labs, including sophisticated contribute to community service and to meet its needs.");
    }
}
