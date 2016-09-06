package com.eugeneek.expandablelistexample;

public class Course {
    public int id;
    public int courseId;
    public String title;
    public String goal;
    public String time;
    public String coach;
    public String description;
    public String location;

    public Course(int id, int courseId, String title, String goal, String time, String coach, String description, String location) {
        this.id = id;
        this.courseId = courseId;
        this.title = title;
        this.goal = goal;
        this.time = time;
        this.coach = coach;
        this.description = description;
        this.location = location;
    }
}
