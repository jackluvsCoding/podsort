package sort;

import enums.Diversity;
import enums.Gender;
import enums.Intern;
import object.Engineer;
import object.Pod;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class EvaluatePods {

    private final DecimalFormat DF = new DecimalFormat("###.#");

    public int getPodGenderCount(ArrayList<Pod> pods, int podNumber, Enum<Gender> genderEnum) {
        Pod pod = pods.get(podNumber);
        int count = 0;

        for (Engineer engineer : pod.getEngineers()) {
            if (engineer.gender.equals(genderEnum)) {
                count++;
            }
        }
        return count;
    }


    public int getPodDiversityCount(ArrayList<Pod> pods, int podNumber, Enum<Diversity> diversityEnum) {
        Pod pod = pods.get(podNumber);
        int count = 0;

        for (Engineer engineer : pod.getEngineers()) {
            if (engineer.diverse.equals(diversityEnum)) {
                count++;
            }
        }
        return count;
    }

    public int getPodPreviousInternCount(ArrayList<Pod> pods, int podNumber, Enum<Intern> internEnum) {
        Pod pod = pods.get(podNumber);
        int count = 0;

        for (Engineer engineer : pod.getEngineers()) {
            if (engineer.previousIntern.equals(internEnum)) {
                count++;
            }
        }
        return count;
    }

    public double getPodGenderPercentage(ArrayList<Pod> pods, int podNumber, Enum<Gender> genderEnum) {
        int podSize = pods.get(podNumber).getEngineers().size();
        return Double.parseDouble(
                DF.format(((double) getPodGenderCount(pods, podNumber, genderEnum) / (double) podSize) * 100));
    }

    public double getPodDiversityPercentage(ArrayList<Pod> pods, int podNumber, Enum<Diversity> diversityEnum) {
        int podSize = pods.get(podNumber).getEngineers().size();
        return Double.parseDouble(
                DF.format(((double) getPodDiversityCount(pods, podNumber, diversityEnum) / (double) podSize) * 100));
    }

    public double getPodPreviousInternPercentage(ArrayList<Pod> pods, int podNumber, Enum<Intern> internEnum) {
        int podSize = pods.get(podNumber).getEngineers().size();
        return Double.parseDouble(
                DF.format(((double) getPodPreviousInternCount(pods, podNumber, internEnum) / (double) podSize) * 100));
    }

    public void printPodStats(ArrayList<Pod> pods, int podNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        Pod pod = pods.get(podNumber);

        stringBuilder.append("------").append(pod.podName).append(" Stats------\n");
        stringBuilder.append("Pod Size: ").append(pod.getEngineers().size()).append("\n");
        stringBuilder.append("Female:\t\t")
                .append(getPodGenderPercentage(pods, podNumber, Gender.FEMALE))
                .append("%\t Total: ").append(getPodGenderCount(pods, podNumber, Gender.FEMALE)).append("\t\n");
        stringBuilder.append("Male:\t\t")
                .append(getPodGenderPercentage(pods, podNumber, Gender.MALE))
                .append("%\t Total: ").append(getPodGenderCount(pods, podNumber, Gender.MALE)).append("\t\n");
        stringBuilder.append("PNTA:\t\t")
                .append(getPodGenderPercentage(pods, podNumber, Gender.PNTA))
                .append("%\t Total: ").append(getPodGenderCount(pods, podNumber, Gender.PNTA)).append("\t\n");
        stringBuilder.append("Diverse:\t")
                .append(getPodDiversityPercentage(pods, podNumber, Diversity.DIVERSE))
                .append("%\t Total: ").append(getPodDiversityCount(pods, podNumber, Diversity.DIVERSE)).append("\t\n");
        stringBuilder.append("Intern:\t\t")
                .append(getPodPreviousInternPercentage(pods, podNumber, Intern.PREVIOUS_INTERN))
                .append("%\t Total: ").append(getPodPreviousInternCount(pods, podNumber, Intern.PREVIOUS_INTERN)).append("\t\n");
        System.out.println(stringBuilder);
    }

}
