package Locations.BattleLocations;

import Characters.Enemies.Vampire;
import Characters.Players.Player;

public class Forest extends BattleLocation {

    public Forest(Player player) {
        super("Forest", new Vampire(), "Firewood", player);
    }


}
