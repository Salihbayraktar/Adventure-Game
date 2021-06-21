package Locations.NormalLocations;

import Characters.Players.Player;
import Locations.Location;

public class SafeHouse extends Location {

    public SafeHouse(Player player) {

        System.out.println("There's no place like a safe house");

        player.setHealthPoint(player.getMaxHealthPoint());

        System.out.println(player.getName() + "'s health point filled");
    }

}
