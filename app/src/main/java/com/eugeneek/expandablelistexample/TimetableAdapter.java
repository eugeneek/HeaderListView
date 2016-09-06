package com.eugeneek.expandablelistexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TimetableAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Course> courses;

    public TimetableAdapter(Context context, ArrayList<Course> courses) {
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
            view = LayoutInflater.from(context).inflate(R.layout.timetable_item, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder) view.getTag();
        viewHolder.tvTime.setText(item.time);
        viewHolder.tvDay.setText(item.goal);
        viewHolder.tvCoach.setText(item.coach);

        return view;
    }

    private class ViewHolder {
        TextView tvDay, tvTime, tvCoach;

        public ViewHolder(View view) {
            tvDay = (TextView) view.findViewById(R.id.tvDay);
            tvTime = (TextView) view.findViewById(R.id.tvTime);
            tvCoach = (TextView) view.findViewById(R.id.tvCoach);
        }
    }

}
