package sort;

import object.Cohort;
import object.Engineer;
import object.Pod;

import java.util.ArrayList;

public class BeginSort {

    private final Optimize optimize = new Optimize();

    public ArrayList<Pod> getPods(ArrayList<Engineer> engineers, int podSize) {
        int numberOfPods = getNumberOfPods(engineers.size(), podSize);
        System.out.println("Number of Pods: " + numberOfPods);

        // First Sort to Create Cohort - Random
        ArrayList<Pod> pods = optimize.fullRandomSort(engineers, numberOfPods, podSize);
        Cohort cohort = new Cohort(engineers, pods);

        // Evaluate Sort
        EvaluatePods evaluatePods = new EvaluatePods();
        for (Pod pod : pods) {
            evaluatePods.printPodStats(pod);
        }

        EvaluateCohort evaluateCohort = new EvaluateCohort();
        evaluateCohort.printCohortStats(cohort);

        // Attempt to Optimize the sort
        ArrayList<Pod> optimizedPods = optimize.runOptimization(cohort, pods, podSize);

        System.out.println("\u2022Optimized Pods Size: " + optimizedPods.size());
        return optimizedPods;
    }

    private int getNumberOfPods(int classSize, int podSize) {
        int numberOfPods = classSize / podSize;
        int remainder = classSize % podSize;
        return (remainder > 0) ? numberOfPods + 1 : numberOfPods;
    }

}
