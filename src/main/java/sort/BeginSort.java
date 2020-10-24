package sort;

import object.Cohort;
import object.Engineer;
import object.Pod;

import java.util.ArrayList;
import java.util.Random;

public class BeginSort {

    private static final Random RANDOM = new Random();

    public ArrayList<Pod> getPods(ArrayList<Engineer> engineers, int engineersPerPod) {
        int numberOfPods = engineers.size()/engineersPerPod;
        int remainder = engineers.size()%engineersPerPod;
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
        for (int i = 0; i < pods.size(); i++) {
            evaluatePods.printPodStats(pods, i);
        }

        EvaluateCohort evaluateCohort = new EvaluateCohort();
        evaluateCohort.printCohortStats(engineers);


        return new ArrayList<Pod>();
    }

    /*
    Creates a brand new sort from the list of engineers
     */
    private ArrayList<Pod> fullRandomSort(ArrayList<Engineer> engineers, int numberOfPods, int engineersPerPod) {
        ArrayList<Engineer> engineersClone = (ArrayList<Engineer>) engineers.clone();
        ArrayList<Pod> pods = new ArrayList<>();
        for (int i = 0; i < numberOfPods; i++) {
            int count= 0;
            Pod pod = new Pod("Pod " + (i), new ArrayList<Engineer>());
            while (count != 4) {
                if (engineersClone.size() > 0) {
                    Engineer engineer = engineersClone.remove(RANDOM.nextInt(engineersClone.size()));
                    pod.getEngineers().add(engineer);
                }
                count++;
            }
            pods.add(pod);
        }
        return pods;
    }

}
