package Locations.BattleLocations;

import Characters.Enemies.Bear;
import Characters.Players.Player;

public class River extends BattleLocation{
    public River(Player player) {
        super("River", new Bear(), "Water", player);
    }


}
