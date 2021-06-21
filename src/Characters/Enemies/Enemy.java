package Characters.Enemies;

import Characters.Character;

public abstract class Enemy extends Character {

    boolean canDropItems;

    public Enemy(String name, int id, int damage, int healthPoint, int totalMoney, boolean canDropItems) {
        super(name, id, damage, healthPoint, totalMoney);
        this.canDropItems = canDropItems;
    }


    public boolean isCanDropItems() {
        return canDropItems;
    }

    public void setCanDropItems(boolean canDropItems) {
        this.canDropItems = canDropItems;
    }
}
