package object;

import enums.Diversity;
import enums.DiversityScore;
import enums.Gender;
import enums.Intern;

public class Engineer {

    public String name;
    public Enum<Gender> gender;
    public Enum<Diversity> diverse;
    public Enum<Intern> previousIntern;
    public Enum<DiversityScore> score;

    public Engineer(String name, Enum<Gender> gender, Enum<Diversity> diverse, Enum<Intern> previousIntern) {
        this.name = name;
        this.gender = gender;
        this.diverse = diverse;
        this.previousIntern = previousIntern;
        this.score = setScore(gender, diverse, previousIntern);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enum<Gender> getGender() {
        return gender;
    }

    public void setGender(Enum<Gender> gender) {
        this.gender = gender;
    }

    public Enum<Diversity> getDiverse() {
        return diverse;
    }

    public void setDiverse(Enum<Diversity> diverse) {
        this.diverse = diverse;
    }

    public Enum<Intern> getPreviousIntern() {
        return previousIntern;
    }

    public void setPreviousIntern(Enum<Intern> previousIntern) {
        this.previousIntern = previousIntern;
    }

    public Enum<DiversityScore> getScore() {
        return score;
    }

    public Enum<DiversityScore> setScore(Enum<Gender> gender, Enum<Diversity> diverse, Enum<Intern> previousIntern) {
        boolean isDiverse = diverse.equals(Diversity.DIVERSE);
        boolean isPreviousIntern = previousIntern.equals(Intern.PREVIOUS_INTERN);

        if (gender.equals(Gender.MALE)) {
            if (isDiverse && isPreviousIntern) {
                return DiversityScore.MDP;
            } else if (!isDiverse && !isPreviousIntern) {
                return DiversityScore.M;
            } else if (!isDiverse) {
                return DiversityScore.MP;
            } else {
                return DiversityScore.MD;
            }
        } else if (gender.equals(Gender.FEMALE)) {
            if (isDiverse && isPreviousIntern) {
                return DiversityScore.FDP;
            } else if (!isDiverse && !isPreviousIntern) {
                return DiversityScore.F;
            } else if (!isDiverse) {
                return DiversityScore.FP;
            } else {
                return DiversityScore.FD;
            }
        } else if (gender.equals(Gender.PNTA)) {
            if (isDiverse && isPreviousIntern) {
                return DiversityScore.PDP;
            } else if (!isDiverse && !isPreviousIntern) {
                return DiversityScore.P;
            } else if (!isDiverse) {
                return DiversityScore.PP;
            } else {
                return DiversityScore.PD;
            }
        } else {
            return DiversityScore.UNKNOWN;
        }
    }

    @Override
    public String toString() {
        return "Engineer{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", diverse=" + diverse +
                ", previousIntern=" + previousIntern +
                ", score=" + score +
                '}';
    }
}
