package Locations.BattleLocations;

import Characters.Enemies.Zombie;
import Characters.Players.Player;

public class Cave extends BattleLocation {

    public Cave(Player player) {
        super("Cave", new Zombie(), "Food", player);
    }

}
