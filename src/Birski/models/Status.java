package Birski.models;

public class Status {
    private int stepCount;
    private int extremumCount;
    private Point extremum;
    private  int arraysCount;

    public Status() {
    }

    public void increaseStepCount() {
        stepCount++;
    }

    public int getStepCount() {
        return stepCount;
    }

    public int getExtremumCount() {
        return extremumCount;
    }

    public void setExtremumCount(int extremumCount) {
        this.extremumCount = extremumCount;
    }

    public Point getExtremum() {
        return extremum;
    }

    public void setExtremum(Point extremum) {
        this.extremum = extremum;
    }

    public int getArraysCount() {
        return arraysCount;
    }

    public void setArraysCount(int arraysCount) {
        this.arraysCount = arraysCount;
    }
}
