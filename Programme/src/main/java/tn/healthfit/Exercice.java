package tn.healthfit;

public class Exercice {
    int idExercice ;
    String nameExercice;
    String descriptionExercice;
    int points;
    int duration;
    String imageUrl;

    public String getNameExercice() {
        return nameExercice;
    }

    public void setNameExercice(String nameExercice) {
        this.nameExercice = nameExercice;
    }

    public String getDescriptionExercice() {
        return descriptionExercice;
    }

    public void setDescriptionExercice(String descriptionExercice) {
        this.descriptionExercice = descriptionExercice;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
