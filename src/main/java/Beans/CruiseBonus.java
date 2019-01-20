package Beans;

public class CruiseBonus {
    public Integer getCruiseId() {
        return cruiseId;
    }

    public void setCruiseId(Integer cruiseId) {
        this.cruiseId = cruiseId;
    }

    public Integer getBonusId() {
        return bonusId;
    }

    public void setBonusId(Integer bonusId) {
        this.bonusId = bonusId;
    }

    public CruiseBonus(Integer cruiseId, Integer bonusId) {
        this.cruiseId = cruiseId;
        this.bonusId = bonusId;
    }

    private Integer cruiseId;
    private Integer bonusId;



    public CruiseBonus() {
    }
}
