package Equipment.Armor;

public abstract class Armor {

    private String name;
    private int id;
    private int blockedDamage;
    private int cost;

    public Armor(String name, int id, int blockedDamage, int cost) {
        this.name = name;
        this.id = id;
        this.blockedDamage = blockedDamage;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlockedDamage() {
        return blockedDamage;
    }

    public void setBlockedDamage(int blockedDamage) {
        this.blockedDamage = blockedDamage;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", blockedDamage=" + blockedDamage +
                ", cost=" + cost + "";
    }
}
