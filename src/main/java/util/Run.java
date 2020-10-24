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

        System.out.println("Sort time to complete: " + (System.currentTimeMillis()-start) + "ms");
    }

}
