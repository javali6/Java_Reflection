package lab.reflections.classes;

public class FootballClub {

    private String clubName;
    private Integer year;
    private String textDescription;
    private Boolean isChampion;
    private Double ptsPerGame;

    public FootballClub(String clubName, Integer year, String textDescription, Boolean isChampion, Double ptsPerGame) {
        this.clubName = clubName;
        this.year = year;
        this.textDescription = textDescription;
        this.isChampion = isChampion;
        this.ptsPerGame = ptsPerGame;
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

    public Boolean getChampion() {
        return isChampion;
    }

    public void setChampion(Boolean champion) {
        isChampion = champion;
    }

    public Double getPtsPerGame() {
        return ptsPerGame;
    }

    public void setPtsPerGame(Double ptsPerGame) {
        this.ptsPerGame = ptsPerGame;
    }
}
