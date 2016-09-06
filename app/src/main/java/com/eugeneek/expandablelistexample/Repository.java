package com.eugeneek.expandablelistexample;

import java.util.ArrayList;

public class Repository {

    private ArrayList<Course> data = new ArrayList<>();
    private static Repository repository;

    public static Repository getInstance() {
        if (repository == null)
            repository = new Repository();

        return repository;
    }

    private Repository() {
        data.add(new Course(1,
                1,
                "Aerobic",
                "Montag",
                "17:00-17:45",
                "Lisette Karbach/Iryna Korenkova",
                "Aerobic ist Ausdauertraining zu Musik, das durch Schritt- sowie Armkombinationen " +
                        "auch die Koordination schult.\nUngeübte sollten zunächst die Anfängerkurse " +
                        "nutzen. Bitte feste Turnschuhe und ein Handtuch mitbringen!.\nGroße Halle",
                "geradeaus"));

        data.add(new Course(2,
                1,
                "Aerobic",
                "Dienstag",
                "18:30-19:15",
                "Vladislava Schulz",
                "Aerobic ist Ausdauertraining zu Musik, das durch Schritt- sowie Armkombinationen " +
                        "auch die Koordination schult.\nUngeübte sollten zunächst die Anfängerkurse " +
                        "nutzen. Bitte feste Turnschuhe und ein Handtuch mitbringen!.\nGroße Halle",
                "links"));

        data.add(new Course(3,
                1,
                "Aerobic",
                "Mittwoch",
                "17:00-17:40",
                "Ann-Kathrin Keul/ Lisanne Schiller",
                "Aerobic ist Ausdauertraining zu Musik, das durch Schritt- sowie Armkombinationen " +
                        "auch die Koordination schult.\nUngeübte sollten zunächst die Anfängerkurse " +
                        "nutzen. Bitte feste Turnschuhe und ein Handtuch mitbringen!.\nGroße Halle",
                "rechts"));

        data.add(new Course(4,
                2,
                "Aerobic Bodystlysiing",
                "Montag",
                "17:45-18:30",
                "Lisette Karbach/Iryna Korenkova",
                "Bodystyling ist Muskelkräftigung zu Musik.\n" +
                        "Ungeübte sollten zunächst die Anfängerkurse nutzen. Bitte feste " +
                        "Hallen-Turnschuhe und ein Handtuch mitbringen!",
                "fast da"));

        data.add(new Course(5,
                2,
                "Aerobic Bodystlysiing",
                "Dienstag",
                "19:15-20:00",
                "Vladislava Schulz",
                "Bodystyling ist Muskelkräftigung zu Musik.\n" +
                        "Ungeübte sollten zunächst die Anfängerkurse nutzen. Bitte feste " +
                        "Hallen-Turnschuhe und ein Handtuch mitbringen!",
                "noch 5 meter"));

        data.add(new Course(6,
                3,
                "Bodybuilding",
                "Dienstag",
                "19:15-20:00",
                "Andreas Pavlovski",
                "Bodystyling ist Muskelkräftigung zu Musik.\n" +
                        "Ungeübte sollten zunächst die Anfängerkurse nutzen. Bitte feste " +
                        "Hallen-Turnschuhe und ein Handtuch mitbringen!",
                "noch 25 cm"));
    }

    public Course getCourse(int id) {
        for (Course course : data) {
            if (course.id == id)
                return course;
        }

        return null;
    }

    public ArrayList<Course> getAllCourses() {
        return data;
    }

    public ArrayList<Course> getCoursesByCourseId(int courseId) {
        ArrayList<Course> courses = new ArrayList<>();
        for (Course course : data) {
            if (course.courseId == courseId)
                courses.add(course);
        }
        return courses;
    }

    public ArrayList<Course> getDifferentCourses() {
        ArrayList<Integer> selectedId = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();
        for (Course course : data) {
            if (!selectedId.contains(course.courseId)) {
                courses.add(course);
                selectedId.add(course.courseId);
            }
        }
        return courses;
    }
}
