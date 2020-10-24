package util;

import data.Engineers;
import object.Engineer;
import object.Pod;
import sort.BeginSort;


import java.util.ArrayList;

public class Run {

    private static final int CLASS_SIZE = 43;
    private static final int ENGINEERS_PER_POD = 4;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("Launching Sort");

        ArrayList<Engineer> engineers = new Engineers().getEngineers(CLASS_SIZE);

        ArrayList<Pod> pods = new BeginSort().getPods(engineers, ENGINEERS_PER_POD);

        StringBuffer result = new StringBuffer();
        for (Pod pod : pods) {
            result.append(pod.podName + ": ");
            for (Engineer engineer : pod.engineers) {
                result.append(engineer.score + ",");
            }
            result.append("\n");
        }
        System.out.println(result);

        System.out.println("Sort time to complete: " + (System.currentTimeMillis()-start) + "ms");
    }

}
