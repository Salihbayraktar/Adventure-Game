package Locations.NormalLocations;

import Characters.Players.Player;
import Equipment.Armor.Armor;
import Equipment.Armor.HeavyArmor;
import Equipment.Armor.LightArmor;
import Equipment.Armor.MediumArmor;
import Equipment.Weapon.Pistol;
import Equipment.Weapon.Rifle;
import Equipment.Weapon.Sword;
import Equipment.Weapon.Weapon;
import Locations.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Market extends Location {

    static List<Armor> armorList = new ArrayList<>();
    static List<Weapon> weaponList = new ArrayList<>();

    static {

        armorList.add(new LightArmor());
        armorList.add(new MediumArmor());
        armorList.add(new HeavyArmor());

        weaponList.add(new Pistol());
        weaponList.add(new Sword());
        weaponList.add(new Rifle());

    }

    public Market(Player player) {

        System.out.printf("%s welcome the market.\n", player.getName());
        System.out.printf("You have %d gold.\n", player.getTotalMoney());
        System.out.printf("Your current armor is %s \n", player.getInventory().getArmorName());
        System.out.printf("Your current weapon is %s \n", player.getInventory().getWeaponName());

        boolean stay = true;
        do {

            System.out.println("What do you want to buy? (1 Armors, 2 Weapons, 0 For exit)");
            Scanner scanner = new Scanner(System.in);
            int query = scanner.nextInt();
            switch (query) {
                case 1 -> {
                    System.out.println("Armors : ");
                    for (Armor armor : armorList) {
                        System.out.println(armor);
                    }
                    System.out.println("Enter the id of the armor you want to buy");
                    int armorId = scanner.nextInt() - 1;
                    int armorCost = armorList.get(armorId).getCost();
                    if (player.getTotalMoney() >= armorCost) {

                        player.getInventory().changeArmor(armorList.get(armorId));

                        player.withDraw(armorCost);

                        System.out.printf("You bought the %s and your current money is %d \n", player.getInventory().getArmorName(), player.getTotalMoney());

                    } else {

                        System.out.println("You don't have enough money");
                    }
                }
                case 2 -> {
                    System.out.println("Weapons : ");
                    for (Weapon weapon : weaponList) {
                        System.out.println(weapon);
                    }
                    System.out.println("Enter the id of the weapon you want to buy");
                    int weaponId = scanner.nextInt() - 1;
                    int weaponCost = weaponList.get(weaponId).getCost();
                    if (player.getTotalMoney() >= weaponCost) {

                        player.getInventory().changeWeapon(weaponList.get(weaponId));

                        player.withDraw(weaponCost);

                        System.out.printf("You bought the weapon %s and your current money is %d \n", player.getInventory().getWeaponName(), player.getTotalMoney());

                    } else {

                        System.out.println("You don't have enough money");
                    }
                }
                case 0 -> {
                    System.out.println("Leaving the market");
                    stay = false;
                }
                default -> {
                    System.out.println("Invalid Input");
                }
            }
        } while (stay);

    }

    public static List<Armor> getArmorList() {
        return armorList;
    }

    public static List<Weapon> getWeaponList() {
        return weaponList;
    }
}
