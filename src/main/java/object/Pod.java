package object;

import enums.Diversity;
import enums.Gender;
import enums.Intern;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Pod {
    private final DecimalFormat DF = new DecimalFormat("###.#");

    public String podName;
    public ArrayList<Engineer> engineers;
    public int numberOfFemale, numberOfMale, numberOfPnta, numberOfDiverse, numberOfNotDiverse, numberOfPreviousIntern, numberOfNotPreviousIntern;
    public double percentFemale, percentMale, percentPnta, percentDiverse, percentNotDiverse, percentPreviousIntern, percentNotPreviousIntern;

    public Pod(String podName, ArrayList<Engineer> engineers) {
        this.podName = podName;
        this.engineers = engineers;
        setAll();
    }

    public String getPodName() {
        return podName;
    }

    public ArrayList<Engineer> getEngineers() {
        return engineers;
    }

    public int getNumberOfFemale() {
        return numberOfFemale;
    }

    public int getNumberOfMale() {
        return numberOfMale;
    }

    public int getNumberOfPnta() {
        return numberOfPnta;
    }

    public int getNumberOfDiverse() {
        return numberOfDiverse;
    }

    public int getNumberOfNotDiverse() {
        return numberOfNotDiverse;
    }

    public int getNumberOfPreviousIntern() {
        return numberOfPreviousIntern;
    }

    public int getNumberOfNotPreviousIntern() {
        return numberOfNotPreviousIntern;
    }

    public double getPercentFemale() {
        return percentFemale;
    }

    public double getPercentMale() {
        return percentMale;
    }

    public double getPercentPnta() {
        return percentPnta;
    }

    public double getPercentDiverse() {
        return percentDiverse;
    }

    public double getPercentNotDiverse() {
        return percentNotDiverse;
    }

    public double getPercentPreviousIntern() {
        return percentPreviousIntern;
    }

    public double getPercentNotPreviousIntern() {
        return percentNotPreviousIntern;
    }

    public void setPodName(String podName) {
        this.podName = podName;
    }

    public void setEngineers(ArrayList<Engineer> engineers) {
        this.engineers = engineers;
    }

    @Override
    public String toString() {
        StringBuilder podToString = new StringBuilder();
        podToString.append(podName).append("\n");
        for (Engineer engineer : engineers)
            podToString.append(engineer.toString()).append("\n");

        return podToString + "\n";
    }

    // Helper Functions to set parameters
    public void setAll() {
        int podSize = engineers.size();
        int male = 0;
        int female = 0;
        int pnta = 0;
        int diverse = 0;
        int notDiverse = 0;
        int intern = 0;
        int notIntern = 0;

        for (Engineer engineer : engineers) {
            if (engineer.gender.equals(Gender.MALE)) {
                male++;
            } else if (engineer.gender.equals(Gender.FEMALE)) {
                female++;
            } else if (engineer.gender.equals(Gender.PNTA)) {
                pnta++;
            }
            if (engineer.diverse.equals(Diversity.DIVERSE)) {
                diverse++;
            } else if (engineer.diverse.equals(Diversity.NOT_DIVERSE)) {
                notDiverse++;
            }
            if (engineer.previousIntern.equals(Intern.PREVIOUS_INTERN)) {
                intern++;
            } else if (engineer.previousIntern.equals(Intern.NOT_PREVIOUS_INTERN)) {
                notIntern++;
            }
        }

        //Set Values
        this.numberOfFemale = female;
        this.numberOfMale = male;
        this.numberOfPnta = pnta;
        this.numberOfDiverse = diverse;
        this.numberOfNotDiverse = notDiverse;
        this.numberOfPreviousIntern = intern;
        this.numberOfNotPreviousIntern = notIntern;

        this.percentFemale = Double.parseDouble(DF.format(((double) female / (double) podSize)*100));
        this.percentMale = Double.parseDouble(DF.format(((double) male / (double) podSize)*100));
        this.percentPnta = Double.parseDouble(DF.format(((double) pnta / (double) podSize)*100));
        this.percentDiverse = Double.parseDouble(DF.format(((double) diverse / (double) podSize)*100));
        this.percentNotDiverse = Double.parseDouble(DF.format(((double) notDiverse / (double) podSize)*100));
        this.percentPreviousIntern = Double.parseDouble(DF.format(((double) intern / (double) podSize)*100));
        this.percentNotPreviousIntern = Double.parseDouble(DF.format(((double) notIntern / (double) podSize)*100));
    }
}
