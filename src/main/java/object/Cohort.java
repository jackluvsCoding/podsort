package object;

import enums.Diversity;
import enums.Gender;
import enums.Intern;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Cohort {
    private final DecimalFormat DF = new DecimalFormat("###.#");

    public ArrayList<Engineer> engineers;
    public ArrayList<Pod> pods;
    public int classSize, female, male, pnta, diverse, notDiverse, intern, notIntern;
    public double percentFemale, percentMale, percentPnta, percentDiverse, percentNotDiverse, percentPreviousIntern, percentNotPreviousIntern;

    public Cohort(ArrayList<Engineer> engineers, ArrayList<Pod> pods) {
        this.engineers = engineers;
        this.pods = pods;
        setAll();
    }

    public ArrayList<Engineer> getEngineers() {
        return engineers;
    }

    public ArrayList<Pod> getPods() {
        return pods;
    }

    public int getClassSize() {
        return classSize;
    }

    public int getFemale() {
        return female;
    }

    public int getMale() {
        return male;
    }

    public int getPnta() {
        return pnta;
    }

    public int getDiverse() {
        return diverse;
    }

    public int getNotDiverse() {
        return notDiverse;
    }

    public int getIntern() {
        return intern;
    }

    public int getNotIntern() {
        return notIntern;
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

    public void setAll() {
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
        this.classSize = engineers.size();
        this.male = male;
        this.female = female;
        this.pnta = pnta;
        this.diverse = diverse;
        this.notDiverse = notDiverse;
        this.intern = intern;
        this.notIntern = notIntern;

        this.percentFemale = Double.parseDouble(DF.format(((double) female / (double) classSize)*100));
        this.percentMale = Double.parseDouble(DF.format(((double) male / (double) classSize)*100));
        this.percentPnta = Double.parseDouble(DF.format(((double) pnta / (double) classSize)*100));
        this.percentDiverse = Double.parseDouble(DF.format(((double) diverse / (double) classSize)*100));
        this.percentNotDiverse = Double.parseDouble(DF.format(((double) notDiverse / (double) classSize)*100));
        this.percentPreviousIntern = Double.parseDouble(DF.format(((double) intern / (double) classSize)*100));
        this.percentNotPreviousIntern = Double.parseDouble(DF.format(((double) notIntern / (double) classSize)*100));
    }
}
