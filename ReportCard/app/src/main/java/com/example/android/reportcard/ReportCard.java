package com.example.android.reportcard;

import java.util.ArrayList;

/**
 * Created by Muhammad Muzammil on 02/07/16.
 */
public class ReportCard {
    private ArrayList<Subject> subjects = new ArrayList<>();

    public ReportCard() {
    }

    public ReportCard(ArrayList<Subject> subjects) {
        if (subjects != null)
            setSubjects(subjects);
    }

    //return the Subject on the specified index
    public Subject getSubject(int index) {
        if (index >= subjects.size() || index < 0) {
            throw new RuntimeException("Invalid index");
        }
        return subjects.get(index);
    }

    //return the Subject of the specified name
    public Subject getSubject(String name) {
        for (Subject subject : subjects) {
            if (subject.getName().equalsIgnoreCase(name)) {
                return subject;
            }
        }
        //If no subject of the specified name exist, returns null
        return null;
    }

    //return all the subjects
    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    //set all subjects
    public void setSubjects(ArrayList<Subject> subjects) {
        if (subjects != null)
            this.subjects = subjects;
    }

    //add a subject
    public void addSubject(Subject subject) {
        //if subject of the same name already exist, dont add it
        if (getSubject(subject.getName()) != null)
            throw new RuntimeException("Subject already exist");
        this.subjects.add(subject);
    }

    //remove a specified subject
    //return true if the subject has been removed
    public boolean removeSubject(Subject subject) {
        return subjects.remove(subject);
    }


    //remove a subject of the specified name
    //return true if the subject has been removed
    public boolean removeSubject(String name) {
        Subject subject = getSubject(name);
        if (subject != null){
            removeSubject(subject);
            return true;
        }

        return false;
    }

    //return total marks obtained in all subjects
    public int getTotalMarks() {
        int marks = 0;
        for (Subject subject : subjects) {
            marks += subject.getMarks();
        }
        return marks;
    }

    //return percentage
    public double getPercentage() {
        double percentage = 0;
        //Assuming each subject has 100 maximum marks
        double totalPossibleMarks = subjects.size() * 100;
        percentage = (getTotalMarks() / totalPossibleMarks) * 100;
        return percentage;
    }

    //same as calling the getPercentage
    public double getGrade() {
        return getPercentage();
    }

    //return a human readable format for report card
    @Override
    public String toString() {
        if (subjects.size() == 0)
            return "Report card has no subjects..";

        String string = "";

        for (Subject subject : subjects) {
            string += "*" + subject.getName().toUpperCase() + "*" + "  ";
            string += "Marks: " + subject.getMarks() + " out of 100";
            string += "\n";
        }

        string += "\nTOTAL MARKS = " + getTotalMarks() +"\n";
        string += "Percentage = " + getPercentage() + "%";

        return string;
    }

    //An inner Subject class use to define multiple subjects
    public static class Subject {
        private String name;
        private int marks;

        Subject(String name) {
            setName(name);
        }

        Subject(String name, int marks) {
            setName(name);
            setMarks(marks);
        }

        //set the name of this subject
        private void setName(String name) {
            name = name.trim();

            if (name.equals(""))
                throw new RuntimeException("Invalid name");

            this.name = name;
        }

        public String getName() {
            return name;
        }

        //get marks of this subject out of 100
        public int getMarks() {
            return marks;
        }

        public void setMarks(int marks) {
            if (marks > 100 || marks < 0)
                throw new RuntimeException("Invalid marks");
            this.marks = marks;
        }
    }
}
