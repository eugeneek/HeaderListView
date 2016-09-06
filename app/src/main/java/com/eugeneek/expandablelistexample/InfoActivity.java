package com.eugeneek.expandablelistexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        int courseId = getIntent().getIntExtra("courseId", 1);
        ArrayList<Course> data = Repository.getInstance().getCoursesByCourseId(courseId);

        getSupportActionBar().setTitle(data.get(0).title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView lvTimetable = (ListView) findViewById(R.id.lvTimetable);
        TimetableAdapter adapter = new TimetableAdapter(this, data);

        lvTimetable.setAdapter(adapter);

        TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        TextView tvDescription = (TextView) findViewById(R.id.tvDescription);

        tvTitle.setText(data.get(0).title);
        tvDescription.setText(data.get(0).description);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();

        return super.onOptionsItemSelected(item);

    }
}
