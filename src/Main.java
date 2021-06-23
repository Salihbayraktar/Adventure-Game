import Characters.Players.Archer;
import Characters.Players.Knight;
import Characters.Players.Player;
import Characters.Players.Samurai;
import Locations.BattleLocations.Cave;
import Locations.BattleLocations.Forest;
import Locations.BattleLocations.Mine;
import Locations.BattleLocations.River;
import Locations.NormalLocations.Market;
import Locations.NormalLocations.SafeHouse;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Player player;
        System.out.println("Welcome the adventure game.");
        System.out.println("Firstly choose your fighter (1 Samurai, 2 Archer, 3 Knight)");
        do {
            String query = scanner.nextLine();
            if ("1".equals(query)) {
                player = new Samurai();
                break;
            } else if ("2".equals(query)) {
                player = new Archer();
                break;
            } else if ("3".equals(query)) {
                player = new Knight();
                break;
            } else {
                System.out.println("Invalid Fighter");
            }
        } while (true);

        System.out.printf("You choice %s. Your character traits are %s\n\n", player.getName(), player);


        while (!player.isGameEnd()) {
            System.out.println("Where do you wanna go? (1 Safe House, 2 Market, 3 Cave, 4 Forest, 5 River, 6 Mine, 0 Check Win)");
            String query = scanner.nextLine();
            switch (query) {
                case "1" -> new SafeHouse(player);
                case "2" -> new Market(player);
                case "3" -> new Cave(player);
                case "4" -> new Forest(player);
                case "5" -> new River(player);
                case "6" -> new Mine(player);
                case "0" -> {
                    System.out.printf("Welcome back %s. Your character traits are %s\n\n", player.getName(), player);
                    for (Map.Entry<String, Boolean> entry : player.getInventory().getRequiredItems().entrySet()) {
                        if (!entry.getValue()) {
                            System.out.printf("You need %s for win. \n", entry.getKey());
                        }
                    }
                }
            }
        }
        System.out.println("Congratulations you have collected all the items and finished the game");

    }
}
