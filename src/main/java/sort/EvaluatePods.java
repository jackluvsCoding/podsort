package sort;

import object.Cohort;
import object.Engineer;
import object.Pod;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class EvaluatePods {

    private final DecimalFormat DF = new DecimalFormat("###.#");

    public ArrayList<Pod> nonOptimalPods(ArrayList<Pod> pods, Cohort cohort) {
        ArrayList<Pod> nonOptimalPods = new ArrayList<>();

        int minimumNumberFemale = cohort.getFemale() / pods.size();
        int minimumNumberDiverse = cohort.getDiverse() / pods.size();
        int minimumNumberPreviousIntern = cohort.getIntern() / pods.size();

        //System.out.println("-------Non Optimal Pods-------");
        for(int i = 0; i < pods.size(); i++) {
            Pod pod = pods.get(i);
            if (pod.getNumberOfFemale() < minimumNumberFemale
                    || pod.getNumberOfDiverse() < minimumNumberDiverse
                    || pod.getNumberOfPreviousIntern() < minimumNumberPreviousIntern) {
                nonOptimalPods.add(pods.remove(i));
                //System.out.println(pod.toString());
            }
        }
        return nonOptimalPods;
    }

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
