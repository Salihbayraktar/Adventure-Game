package Locations.BattleLocations;

import Characters.Enemies.Snake;
import Characters.Players.Player;

public class Mine extends BattleLocation{
    public Mine(Player player) {
        super("Mine", new Snake(), "null", player);
    }
}
