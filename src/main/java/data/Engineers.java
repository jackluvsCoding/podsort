package data;

import enums.Diversity;
import enums.Gender;
import enums.Intern;
import object.Engineer;
import sort.EvaluatePods;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.round;

public class Engineers {

    private ArrayList<Engineer> engineers = new ArrayList<>();

    private static Random random = new Random();
    private EvaluatePods evaluate = new EvaluatePods();

    public ArrayList<Engineer> getEngineers(int classSize) {
        for (int i = 0; i < classSize; i++)
            engineers.add(new Engineer(
                    "Engineer " + (i+1),
                    getRandomGender(),
                    getDiverse(),
                    getPreviousIntern()));

        return engineers;
    }

    private static Enum<Gender> getRandomGender() {
        switch (random.nextInt(3)) {
            case 0:
                return Gender.MALE;
            case 1:
                return Gender.FEMALE;
            case 2:
                switch (random.nextInt(11)) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        return Gender.MALE;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        return Gender.FEMALE;
                    case 10: return Gender.PNTA;
                }
            default: return Gender.FEMALE;
        }
    }

    private static Enum<Diversity> getDiverse() {
        return random.nextInt(3) == 0 ? Diversity.DIVERSE : Diversity.NOT_DIVERSE;
    }

    private static Enum<Intern> getPreviousIntern() {
        return random.nextInt(3) == 0 ? Intern.PREVIOUS_INTERN : Intern.NOT_PREVIOUS_INTERN;
    }

}
