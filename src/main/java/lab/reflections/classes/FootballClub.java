package lab.reflections.classes;

public class FootballClub {

    private String clubName;
    private Integer year;
    private String textDescription;
    private Boolean isChampion;
    private Double ptsPerGame;

    public FootballClub() {
        clubName = "Lech";
        year = 1922;
        textDescription = "KKS Lech Poznan";
        isChampion = true;
        ptsPerGame = 2.6;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public Boolean getIsChampion() {
        return isChampion;
    }

    public void setIsChampion(Boolean champion) {
        isChampion = champion;
    }

    public Double getPtsPerGame() {
        return ptsPerGame;
    }

    public void setPtsPerGame(Double ptsPerGame) {
        this.ptsPerGame = ptsPerGame;
    }

    @Override
    public String toString() {
        return "FootballClub{" +
                "\nclubName='" + clubName + '\'' +
                ", \nyear=" + year +
                ", \ntextDescription='" + textDescription + '\'' +
                ", \nisChampion=" + isChampion +
                ", \nptsPerGame=" + ptsPerGame +
                '}';
    }
}
