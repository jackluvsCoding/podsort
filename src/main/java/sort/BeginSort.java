package sort;

import object.Cohort;
import object.Engineer;
import object.Pod;

import java.util.ArrayList;
import java.util.Random;

public class BeginSort {

    private static final Random RANDOM = new Random();

    public ArrayList<Pod> getPods(ArrayList<Engineer> engineers, int engineersPerPod) {
        int numberOfPods = engineers.size() / engineersPerPod;
        int remainder = engineers.size() % engineersPerPod;
        numberOfPods = (remainder > 0) ? numberOfPods + 1 : numberOfPods;

        System.out.println("Number of Pods: " + numberOfPods);

        // First Sort to Create Cohort - Random
        ArrayList<Pod> pods = fullRandomSort(engineers, numberOfPods, engineersPerPod);
        Cohort cohort = new Cohort(engineers, pods);

        // Evaluate Sort
        /*
        - What is possible
            * based on female/male ratio
            * based on diversity ratio
            * based on previous intern ratio
        - Determine which pods are optimal
        - Determine which pods need modifications
         */
        EvaluatePods evaluatePods = new EvaluatePods();
        for (Pod pod : pods) {
            evaluatePods.printPodStats(pod);
        }

        EvaluateCohort evaluateCohort = new EvaluateCohort();
        evaluateCohort.printCohortStats(cohort);

        //Attempt to improve


        return pods;
    }

    /*
    Creates a brand new sort from the list of engineers
     */
    @SuppressWarnings("unchecked")
    private ArrayList<Pod> fullRandomSort(ArrayList<Engineer> engineers, int numberOfPods, int engineersPerPod) {
        ArrayList<Engineer> engineersClone = (ArrayList<Engineer>) engineers.clone();
        ArrayList<Pod> pods = new ArrayList<>();

        for (int i = 0; i < numberOfPods; i++) {
            ArrayList<Engineer> engineersInPod = new ArrayList<>();
            int count = 0;
            while (count != engineersPerPod) {
                if (engineersClone.size() > 0) {
                    Engineer engineer = engineersClone.remove(RANDOM.nextInt(engineersClone.size()));
                    engineersInPod.add(engineer);
                }
                count++;
            }
            Pod pod = new Pod("Pod " + i, engineersInPod);
            pods.add(pod);
        }
        return pods;
    }

}
