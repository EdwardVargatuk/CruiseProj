package Beans;

public class Bonus extends Entity {
    private String bonusName;

    public Bonus() {
    }

    public Bonus(int id, String bonusName) {
        super(id);
        this.bonusName = bonusName;
    }

    public String getBonusName() {
        return bonusName;
    }

    public void setBonusName(String bonusName) {
        this.bonusName = bonusName;
    }

    @Override
    public String toString() {
        return "Bonus{" +
                "bonusName='" + bonusName + '\'' +
                '}';
    }
}
