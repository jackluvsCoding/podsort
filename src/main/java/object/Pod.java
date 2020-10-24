package object;

import java.util.ArrayList;

public class Pod {

    public String podName;
    public ArrayList<Engineer> engineers;

    public Pod(String podName, ArrayList<Engineer> engineers) {
        this.podName = podName;
        this.engineers = engineers;
    }

    public String getPodName() {
        return podName;
    }

    public void setPodName(String podName) {
        this.podName = podName;
    }

    public ArrayList<Engineer> getEngineers() {
        return engineers;
    }

    public void setEngineers(ArrayList<Engineer> engineers) {
        this.engineers = engineers;
    }

    @Override
    public String toString() {
        StringBuilder podToString = new StringBuilder();
        podToString.append(podName).append("\n");
        for (Engineer engineer : engineers)
            podToString.append(engineer.toString()).append("\n");

        return podToString + "\n";
    }
}
