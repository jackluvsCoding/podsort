package sort;

import object.Cohort;
import object.Engineer;
import object.Pod;

import java.util.ArrayList;
import java.util.Random;

public class Optimize {

    private static final Random RANDOM = new Random();
    private static final int MAX_TRIES = 100;
    private final EvaluatePods evaluatePods = new EvaluatePods();
    private ArrayList<Pod> optimizedPods;
    private int numberOfTries = 0;
    private ArrayList<Integer> previousResults = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public ArrayList<Pod> runOptimization(Cohort cohort, ArrayList<Pod> pods, int podSize) {
        // Create a clone to work off of - return original if optimization fails
        ArrayList<Pod> podsClone = (ArrayList<Pod>) pods.clone();

        podsClone = optimize(podsClone, cohort, podSize);
        System.out.println("Number of tries: " + numberOfTries);
        return podsClone;
    }

    private ArrayList<Pod> optimize(ArrayList<Pod> pods, Cohort cohort, int podSize) {

        System.out.println("Attempt #: " + numberOfTries);
        // Obtain a list of all nonOptimalPods
        ArrayList<Pod> nonOptimalPods = evaluatePods.nonOptimalPods(pods, cohort);
        System.out.println("[1] Non Optimal Pods Returned: " + nonOptimalPods.size());

        // Resort nonOptimalPods
        ArrayList<Pod> resortedPods = randomResort(nonOptimalPods, podSize);

        // Replace the resorted nonOptimalPods into pods
        optimizedPods = replaceResortedPods(pods, resortedPods);

        // Record Results so we know when we're stuck
        previousResults.add(nonOptimalPods.size());

        System.out.println("End of Attempt #: " + numberOfTries + "\n\n");

        if (nonOptimalPods.size() <= 1) {
            numberOfTries = MAX_TRIES;
        } else if (numberOfTries == MAX_TRIES) {
            return optimizedPods;
        } else if (numberOfTries % 3 == 0) {
            if (doRandomResort(nonOptimalPods.size())) {
                randomResort(optimizedPods, podSize);
            }
            resortedPods.clear();
        } else {
            numberOfTries++;
            optimize(optimizedPods, cohort, podSize);
        }
        previousResults.clear();
        return optimizedPods;
    }

    private Boolean doRandomResort(int nonOptimalPods) {
        int previousResult = 0;
        boolean previousMatched = false;
        for (int i = 0; i < previousResults.size(); i++) {
            if (i == 0) {
                previousResult = previousResults.get(i);
            }
            if (previousResults.get(i) == previousResult) {
                previousMatched = true;
            }
        }
        return previousMatched;
    }

    private ArrayList<Pod> randomResort(ArrayList<Pod> pods, int podSize) {
        ArrayList<Engineer> engineers = getEngineersFromPods(pods);
        ArrayList<Pod> emptyPods = clearPods(pods);

        for (Pod pod : emptyPods) {
            int count = 0;
            while (count != podSize) {
                if (engineers.size() > 0) {
                    Engineer engineer = engineers.remove(RANDOM.nextInt(engineers.size()));
                    pod.getEngineers().add(engineer);
                }
                count++;
            }
        }
        return emptyPods;
    }

    private ArrayList<Engineer> getEngineersFromPods(ArrayList<Pod> pods) {
        ArrayList<Engineer> engineers = new ArrayList<>();
        for (Pod pod : pods) {
            int count;
            count = pod.getEngineers().size();
            for (int i = 0; i < count; i++) {
                engineers.add(pod.getEngineers().get(i));
            }
        }
        return engineers;
    }

    ArrayList<Pod> fullRandomSort(ArrayList<Engineer> engineers, int numberOfPods, int podSize) {
        ArrayList<Engineer> engineersClone = (ArrayList<Engineer>) engineers.clone();
        ArrayList<Pod> pods = new ArrayList<>();

        for (int i = 0; i < numberOfPods; i++) {
            ArrayList<Engineer> engineersInPod = new ArrayList<>();
            int count = 0;
            while (count != podSize) {
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

    private ArrayList<Pod> clearPods(ArrayList<Pod> pods) {
        for (Pod pod : pods) {
            pod.getEngineers().clear();
        }
        return pods;
    }

    public ArrayList<Pod> replaceResortedPods(ArrayList<Pod> pods, ArrayList<Pod> resortedPods) {
        pods.addAll(resortedPods);
        return pods;
    }

}
