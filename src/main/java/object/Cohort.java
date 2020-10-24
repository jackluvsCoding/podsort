package object;

import enums.Diversity;
import enums.Gender;
import enums.Intern;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Cohort {

    public ArrayList<Engineer> engineers;
    public ArrayList<Pod> pods;
    public int classSize, female, male, pnta, diverse, intern;
    public double percentFemale, percentMale, percentPnta, percentDiverse, percentPreviousIntern;

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

    public int getIntern() {
        return intern;
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

    public double getPercentPreviousIntern() {
        return percentPreviousIntern;
    }

    public void setAll() {
        DecimalFormat df = new DecimalFormat("###.#");
        int male = 0;
        int female = 0;
        int pnta = 0;
        int diverse = 0;
        int intern = 0;

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
            }
            if (engineer.previousIntern.equals(Intern.PREVIOUS_INTERN)) {
                intern++;
            }
        }

        //Set Values
        this.classSize = engineers.size();
        this.male = male;
        this.female = female;
        this.pnta = pnta;
        this.diverse = diverse;
        this.intern = intern;

        this.percentFemale = Double.parseDouble(df.format(((double) female / (double) classSize)*100));
        this.percentMale = Double.parseDouble(df.format(((double) male / (double) classSize)*100));
        this.percentPnta = Double.parseDouble(df.format(((double) pnta / (double) classSize)*100));
        this.percentDiverse = Double.parseDouble(df.format(((double) diverse / (double) classSize)*100));
        this.percentPreviousIntern = Double.parseDouble(df.format(((double) intern / (double) classSize)*100));
    }
}
