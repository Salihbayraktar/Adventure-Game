package Characters;


public abstract class Character {

    private String name;
    private int id;
    private int damage;
    private int healthPoint;
    private int totalMoney;


    public Character(String name, int id, int damage, int healthPoint, int totalMoney) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.healthPoint = healthPoint;
        this.totalMoney = totalMoney;
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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void withDraw(int amount){
        this.totalMoney -= amount;
    }

    public void addMoney(int amount){
        totalMoney += amount;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", id=" + id +
                ", damage=" + damage +
                ", healthPoint=" + healthPoint +
                ", totalMoney=" + totalMoney;
    }
}
