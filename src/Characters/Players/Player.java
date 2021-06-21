package Characters.Players;

import Characters.Character;
import Characters.Inventory;

public abstract class Player extends Character {

    private final int maxHealthPoint;
    Inventory inventory;

    public Player(String name, int id, int damage, int healthPoint, int totalMoney) {
        super(name, id, damage, healthPoint, totalMoney);
        this.maxHealthPoint = healthPoint;
        inventory = new Inventory("none","none",0,0);
    }

    public int getMaxHealthPoint() {
        return maxHealthPoint;
    }

    public Inventory getInventory() {
        return inventory;
    }


    @Override
    public String toString() {
        return  super.toString() +
                ", weaponDamage=" + inventory.getWeaponDamage() +
                ", armorDefence=" + inventory.getArmorDefence();
    }

    public boolean isGameEnd(){
        return !(this.getInventory().getRequiredItems().containsValue(false));
    }
}
