package com.hackau20.httpserver.dbClass;

public class course {
    String courseName;
    int degreeID;

    public course(String courseName, int degreeID) {
        this.courseName = courseName;
        this.degreeID = degreeID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getDegreeID() {
        return degreeID;
    }

    public void setDegreeID(int degreeID) {
        this.degreeID = degreeID;
    }
}
