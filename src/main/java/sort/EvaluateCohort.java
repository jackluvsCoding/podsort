package sort;

import object.Cohort;

public class EvaluateCohort {

    public void printCohortStats(Cohort cohort) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("------Cohort Stats------\n");
        stringBuilder.append("Class Size: ").append(cohort.getClassSize()).append("\n");
        stringBuilder.append("Female:\t\t\t")
                .append(cohort.getPercentFemale())
                .append("%\t Total: ").append(cohort.getFemale()).append("\t\n");
        stringBuilder.append("Male:\t\t\t")
                .append(cohort.getPercentMale())
                .append("%\t Total: ").append(cohort.getMale()).append("\t\n");
        stringBuilder.append("PNTA:\t\t\t")
                .append(cohort.getPercentPnta())
                .append("%\t Total: ").append(cohort.getPnta()).append("\t\n");
        stringBuilder.append("Diverse:\t\t")
                .append(cohort.getPercentDiverse())
                .append("%\t Total: ").append(cohort.getDiverse()).append("\t\n");
        stringBuilder.append("Not Diverse:\t")
                .append(cohort.getPercentNotDiverse())
                .append("%\t Total: ").append(cohort.getNotDiverse()).append("\t\n");
        stringBuilder.append("Intern:\t\t\t")
                .append(cohort.getPercentPreviousIntern())
                .append("%\t Total: ").append(cohort.getIntern()).append("\t\n");
        stringBuilder.append("Not Intern:\t\t")
                .append(cohort.getPercentNotPreviousIntern())
                .append("%\t Total: ").append(cohort.getNotIntern()).append("\t\n");
        System.out.println(stringBuilder);
    }

}
