package Characters;

import Equipment.Armor.Armor;
import Equipment.Weapon.Weapon;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

        String weaponName;
        String armorName;
        int weaponDamage;
        int armorDefence;
        Map<String,Boolean> requiredItems = new HashMap<>();

        public Inventory(String weaponName, String armorName, int weaponDamage, int armorDefence) {
                requiredItems.put("Water",false);
                requiredItems.put("Food",false);
                requiredItems.put("Firewood",false);
                requiredItems.put("null",true);

                this.weaponName = weaponName;
                this.armorName = armorName;
                this.weaponDamage = weaponDamage;
                this.armorDefence = armorDefence;
        }

        public void changeArmor(Armor armor){
                this.armorName = armor.getName();
                this.armorDefence = armor.getBlockedDamage();
        }

        public void changeWeapon(Weapon weapon){
                this.weaponName = weapon.getName();
                this.weaponDamage = weapon.getDamage();
        }

        public Map<String, Boolean> getRequiredItems() {
                return requiredItems;
        }


        public void setRequiredItems(Map<String, Boolean> requiredItems) {
                this.requiredItems = requiredItems;
        }

        public void changeRequiredItemValue(String itemName,boolean value){
                requiredItems.replace(itemName,value);
        }

        public String getWeaponName() {
                return weaponName;
        }

        public void setWeaponName(String weaponName) {
                this.weaponName = weaponName;
        }

        public String getArmorName() {
                return armorName;
        }

        public void setArmorName(String armorName) {
                this.armorName = armorName;
        }

        public int getWeaponDamage() {
                return weaponDamage;
        }

        public void setWeaponDamage(int weaponDamage) {
                this.weaponDamage = weaponDamage;
        }

        public int getArmorDefence() {
                return armorDefence;
        }

        public void setArmorDefence(int armorDefence) {
                this.armorDefence = armorDefence;
        }
}
