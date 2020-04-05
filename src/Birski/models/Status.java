package Birski.models;

public class Status {
    private int stepCount;
    private int extremumCount;
    private Point extremum;

    public Status() {
    }

    public void increaseExtremumCount(){
        extremumCount++;
    }

    public void increaseStepCount() {
        stepCount++;
    }

    public int getStepCount() {
        return stepCount;
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
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
}
