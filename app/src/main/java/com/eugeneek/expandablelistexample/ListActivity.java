package com.eugeneek.expandablelistexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView lvCourses = (ListView) findViewById(R.id.lvCourses);
        final CourseAdapter adapter = new CourseAdapter(this, Repository.getInstance().getDifferentCourses());
        lvCourses.setAdapter(adapter);

        lvCourses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListActivity.this, InfoActivity.class);
                intent.putExtra("courseId", adapter.getCourseId(i));

                startActivity(intent);
            }
        });
    }
}