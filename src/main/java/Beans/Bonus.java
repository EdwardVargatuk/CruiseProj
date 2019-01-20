package Beans;

public class Bonus extends Entity {
    private String bonuseName;

    public Bonus() {
    }

    public Bonus(int id, String bonuseName) {
        super(id);
        this.bonuseName = bonuseName;
    }

    public String getBonuseName() {
        return bonuseName;
    }

    public void setBonuseName(String bonuseName) {
        this.bonuseName = bonuseName;
    }

    @Override
    public String toString() {
        return "Bonus{" +
                "bonuseName='" + bonuseName + '\'' +
                '}';
    }
}
