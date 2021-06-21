package Locations.BattleLocations;

import Characters.Enemies.Enemy;
import Characters.Players.Player;
import Equipment.Armor.Armor;
import Equipment.Weapon.Weapon;
import Locations.Location;
import Locations.NormalLocations.Market;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class BattleLocation extends Location {

    int numberOfEnemy;
    String locationName;
    Enemy enemy;
    String itemName;
    boolean isItemInLocation = true;
    Player player;

    public BattleLocation(String locationName, Enemy enemy, String itemName, Player player) {
        this.numberOfEnemy = new Random().nextInt(3) + 1;
        this.locationName = locationName;
        this.enemy = enemy;
        this.itemName = itemName;
        this.player = player;

        fight();
    }

    public void fight() {
        Scanner scanner = new Scanner(System.in);

        if (!"null".equals(itemName)) {
            if (player.getInventory().getRequiredItems().get(itemName)) {
                System.out.printf("You already cleaned %s and got the %s \n", locationName, itemName);
                System.out.println("Do you still wanna go inside for gold? (1 Yes : 0 No)");
                if ("1".equals(scanner.nextLine())) {
                    System.out.println("Be careful!");
                } else {
                    return;
                }
            }
        }
        System.out.printf("Hello %s you are in %s and there are %d enemies here. \n\n", player.getName(), locationName, numberOfEnemy);
        System.out.printf("Your Stats : %s \n", player);
        System.out.printf("Enemy Stats : %s \n\n", enemy);

        int enemyMaxHealth = enemy.getHealthPoint();


        while (numberOfEnemy != 0) {

            System.out.println("What do you wanna do (1 Fight : 0 Run)");
            if ("1".equals(scanner.nextLine())) {

                if (new Random().nextBoolean()) {
                    enemyHit();
                    playerHit();
                } else {
                    playerHit();
                    enemyHit();
                }

                if (enemy.getHealthPoint() <= 0) {
                    System.out.printf("You killed the %s", enemy.getName());
                    if (enemy.isCanDropItems()) {
                        checkDropItems();
                    } else {
                        System.out.printf(" and gain %d gold.\n", enemy.getTotalMoney());
                    }

                    player.addMoney(enemy.getTotalMoney());

                    numberOfEnemy--;

                    if (numberOfEnemy != 0) {
                        System.out.printf("There are still %d %s in the %s \n", numberOfEnemy, enemy.getName(), locationName);
                    } else {
                        System.out.printf("Congratulations you cleaned the %s \n", locationName);

                        if (!"null".equals(itemName) && !player.getInventory().getRequiredItems().get(itemName)) {

                            player.getInventory().getRequiredItems().replace(itemName, true);

                            System.out.printf("You got the %s \n", itemName);
                        }
                    }

                    enemy.setHealthPoint(enemyMaxHealth);

                }

            } else {
                System.out.println("RUN FOREST RUN");
                break;
            }

        }

    }


    public void checkDropItems() {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        float rnd = new Random().nextFloat();
        if (rnd < 0.45f) {   // Unlucky
            System.out.printf("The %s does not have any item \n", enemy.getName());
        } else if (rnd < 0.7f) { // Money
            rnd = new Random().nextFloat();
            if (rnd < 0.5f) {
                System.out.printf("You gained 1 gold from %s \n", enemy.getName());
                player.addMoney(1);
            } else if (rnd < 0.8f) {
                System.out.printf("You gained 5 gold from %s \n", enemy.getName());
                player.addMoney(5);
            } else {
                System.out.printf("You gained 10 gold from %s \n", enemy.getName());
                player.addMoney(10);
            }
        } else if (rnd < 0.85f) {    // Armor
            rnd = new Random().nextFloat();
            List<Armor> armorList = Market.getArmorList();
            Armor droppedArmor;
            if (rnd < 0.5f) {
                droppedArmor = armorList.get(0);
            } else if (rnd < 0.8f) {
                droppedArmor = armorList.get(1);
            } else {
                droppedArmor = armorList.get(2);
            }
            System.out.printf("Your current armor is Name : %s - Blocked Damage %d : \n", player.getInventory().getArmorName(), player.getInventory().getArmorDefence());
            System.out.printf("You gained %s from the %s. Do you want to use it? (Blocked Damage : %d) \n", droppedArmor.getName(), enemy.getName(), droppedArmor.getBlockedDamage());
            System.out.println("1 Use, 0 Don't Use \n");
            if ("1".equals(scanner.nextLine())) {
                player.getInventory().changeArmor(droppedArmor);
            }
        } else {  // Weapon
            rnd = new Random().nextFloat();
            List<Weapon> weaponList = Market.getWeaponList();
            Weapon droppedWeapon;
            if (rnd < 0.5f) {
                droppedWeapon = weaponList.get(0);
            } else if (rnd < 0.8f) {
                droppedWeapon = weaponList.get(1);
            } else {
                droppedWeapon = weaponList.get(2);
            }
            System.out.printf("Your current weapon is Name : %s - Damage %d : \n", player.getInventory().getWeaponName(), player.getInventory().getWeaponDamage());
            System.out.printf("You gained %s from the %s. Do you want to use it? (Damage : %d) \n", droppedWeapon.getName(), enemy.getName(), droppedWeapon.getDamage());
            System.out.println("1 Use, 0 Don't Use \n");
            if ("1".equals(scanner.nextLine())) {
                player.getInventory().changeWeapon(droppedWeapon);
            }
        }
    }

    public void enemyHit() {
        player.setHealthPoint(player.getHealthPoint() - Math.max(0, (enemy.getDamage() - player.getInventory().getArmorDefence())));

        if (player.getHealthPoint() <= 0) {
            System.out.printf("You died from %s's attack. GAME OVER!!!", enemy.getName());
            System.exit(0);
        }

        System.out.printf("%s hit you, your current health is %d \n", enemy.getName(), player.getHealthPoint());

    }

    public void playerHit() {
        enemy.setHealthPoint(enemy.getHealthPoint() - (player.getDamage() + player.getInventory().getWeaponDamage()));

        if (enemy.getHealthPoint() > 0) {
            System.out.printf("You hit the %s, enemy's current health is %d \n", enemy.getName(), enemy.getHealthPoint());
        }
    }

    public String getLocationName() {
        return locationName;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isItemInLocation() {
        return isItemInLocation;
    }

    public void setItemInLocation(boolean itemInLocation) {
        isItemInLocation = itemInLocation;
    }
}
