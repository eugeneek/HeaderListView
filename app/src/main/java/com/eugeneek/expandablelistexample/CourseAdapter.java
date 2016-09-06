package com.eugeneek.expandablelistexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CourseAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Course> courses;

    public CourseAdapter(Context context, ArrayList<Course> courses) {
        this.context = context;
        this.courses = courses;
    }

    @Override
    public int getCount() {
        return courses.size();
    }

    @Override
    public Object getItem(int i) {
        return courses.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Course item = courses.get(i);

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder) view.getTag();
        viewHolder.tvTitle.setText(item.title);
        String header = item.title.substring(0, 1);
        viewHolder.tvHeader.setText(header);

        if (i > 0 && header.equals(courses.get(i - 1).title.substring(0, 1)))
            viewHolder.tvHeader.setVisibility(View.GONE);
        else
            viewHolder.tvHeader.setVisibility(View.VISIBLE);

        return view;
    }

    public int getCourseId(int position) {
        return courses.get(position).courseId;
    }

    private class ViewHolder {
        TextView tvHeader, tvTitle;

        public ViewHolder(View view) {
            tvHeader = (TextView) view.findViewById(R.id.tvHeader);
            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        }
    }
}
