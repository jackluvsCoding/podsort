package sort;

import enums.Diversity;
import enums.Gender;
import enums.Intern;
import object.Engineer;
import object.Pod;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class EvaluateCohort {

    private final DecimalFormat DF = new DecimalFormat("###.#");

    public int getCohortGenderCount(ArrayList<Engineer> engineers, Enum<Gender> genderEnum) {
        int count = 0;
        for (Engineer engineer : engineers) {
            if (engineer.gender.equals(genderEnum)) {
                count++;
            }
        }
        return count;
    }

    public int getCohortDiversityCount(ArrayList<Engineer> engineers, Enum<Diversity> diversityEnum) {
        int count = 0;
        for (Engineer engineer : engineers) {
            if (engineer.diverse.equals(diversityEnum)) {
                count++;
            }
        }
        return count;
    }

    public int getCohortPreviousInternCount(ArrayList<Engineer> engineers, Enum<Intern> internEnum) {
        int count = 0;
        for (Engineer engineer : engineers) {
            if (engineer.previousIntern.equals(internEnum)) {
                count++;
            }
        }
        return count;
    }

    public double getCohortGenderPercentage(ArrayList<Engineer> engineers, Enum<Gender> genderEnum) {
        return Double.parseDouble(
                DF.format(((double) getCohortGenderCount(engineers, genderEnum)/(double) engineers.size())*100));
    }

    public double getCohortDiversityPercentage(ArrayList<Engineer> engineers, Enum<Diversity> diversityEnum) {
        return Double.parseDouble(
                DF.format(((double) getCohortDiversityCount(engineers, diversityEnum)/(double) engineers.size())*100));
    }

    public double getCohortPreviousInternPercentage(ArrayList<Engineer> engineers, Enum<Intern> internEnum) {
        return Double.parseDouble(
                DF.format(((double) getCohortPreviousInternCount(engineers, internEnum)/(double) engineers.size())*100));
    }

    public void printCohortStats(ArrayList<Engineer> engineers) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("------Cohort Stats------\n");
        stringBuilder.append("Class Size: ").append(engineers.size()).append("\n");
        stringBuilder.append("Female:\t\t")
                .append(getCohortGenderPercentage(engineers, Gender.FEMALE))
                .append("%\t Total: ").append(getCohortGenderCount(engineers, Gender.FEMALE)).append("\t\n");
        stringBuilder.append("Male:\t\t")
                .append(getCohortGenderPercentage(engineers, Gender.MALE))
                .append("%\t Total: ").append(getCohortGenderCount(engineers, Gender.MALE)).append("\t\n");
        stringBuilder.append("PNTA:\t\t")
                .append(getCohortGenderPercentage(engineers, Gender.PNTA))
                .append("%\t Total: ").append(getCohortGenderCount(engineers, Gender.PNTA)).append("\t\n");
        stringBuilder.append("Diverse:\t")
                .append(getCohortDiversityPercentage(engineers, Diversity.DIVERSE))
                .append("%\t Total: ").append(getCohortDiversityCount(engineers, Diversity.DIVERSE)).append("\t\n");
        stringBuilder.append("Intern:\t\t")
                .append(getCohortPreviousInternPercentage(engineers, Intern.PREVIOUS_INTERN))
                .append("%\t Total: ").append(getCohortPreviousInternCount(engineers, Intern.PREVIOUS_INTERN)).append("\t\n");
        System.out.println(stringBuilder);
    }

}
