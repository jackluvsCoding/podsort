package sort;

import object.Pod;

public class EvaluatePods {

    public void printPodStats(Pod pod) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("------").append(pod.podName).append(" Stats------\n");
        stringBuilder.append("Pod Size: ").append(pod.getEngineers().size()).append("\n");
        stringBuilder.append("Female:\t\t\t")
                .append(pod.getPercentFemale())
                .append("%\t Total: ").append(pod.getNumberOfFemale()).append("\t\n");
        stringBuilder.append("Male:\t\t\t")
                .append(pod.getPercentMale())
                .append("%\t Total: ").append(pod.getNumberOfMale()).append("\t\n");
        stringBuilder.append("PNTA:\t\t\t")
                .append(pod.getPercentPnta())
                .append("%\t Total: ").append(pod.getNumberOfPnta()).append("\t\n");
        stringBuilder.append("Diverse:\t\t")
                .append(pod.getPercentDiverse())
                .append("%\t Total: ").append(pod.getNumberOfDiverse()).append("\t\n");
        stringBuilder.append("Not Diverse:\t")
                .append(pod.getPercentNotDiverse())
                .append("%\t Total: ").append(pod.getNumberOfNotDiverse()).append("\t\n");
        stringBuilder.append("Intern:\t\t\t")
                .append(pod.getPercentPreviousIntern())
                .append("%\t Total: ").append(pod.getNumberOfPreviousIntern()).append("\t\n");
        stringBuilder.append("Not Intern:\t\t")
                .append(pod.getPercentNotPreviousIntern())
                .append("%\t Total: ").append(pod.getNumberOfNotPreviousIntern()).append("\t\n");
        System.out.println(stringBuilder);
    }

}
