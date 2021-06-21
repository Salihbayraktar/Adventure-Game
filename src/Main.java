import Characters.Players.*;
import Locations.BattleLocations.*;
import Locations.NormalLocations.*;

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
            if("1".equals(query)){
                player = new Samurai();
                break;
            } else if ("2".equals(query)) {
                player = new Archer();
                break;
            } else if("3".equals(query)) {
                player = new Knight();
                break;
            } else {
                System.out.println("Invalid Fighter");
            }
        }while (true);

        System.out.printf("You choice %s. Your character traits are %s\n\n",player.getName(),player);

        player.setTotalMoney(999);

        do {
            System.out.println("Where do you wanna go? (1 Safe House, 2 Market, 3 Cave, 4 Forest, 5 River, 6 Mine, 0 Check Win)");
            String query = scanner.nextLine();
            if("1".equals(query)){

                new SafeHouse(player);

            } else if("2".equals(query)){

                new Market(player);

            } else if("3".equals(query)){

                new Cave(player);

            } else if("4".equals(query)){

                new Forest(player);

            } else if("5".equals(query)){

                new River(player);

            }else if("6".equals(query)){

                new Mine(player);

            } else if("0".equals(query)){

                System.out.printf("Welcome back %s. Your character traits are %s\n\n",player.getName(),player);

               for(Map.Entry<String,Boolean> entry : player.getInventory().getRequiredItems().entrySet()){
                   if(!entry.getValue()){
                       System.out.printf("You need %s for win. \n",entry.getKey());
                   }
               }

            }
        }while (!player.isGameEnd());

        System.out.println("Congratulations you have collected all the items and finished the game");


/*
        BattleLocation battleLocation = new Forest(player);
       // battleLocation.setPlayer(player);
        player.setHealthPoint(999);
        battleLocation.fight();

        battleLocation.fight();

        battleLocation = new Cave(player);
        battleLocation.fight();

        System.out.println("FORESETE TERAR GIRDI");
        battleLocation = new Forest(player);
        battleLocation.fight();*/
/*

        System.out.println(player.getHealthPoint());
        player.setHealthPoint(3);
        System.out.println(player.getHealthPoint());
        SafeHouse safeHouse = new SafeHouse(player);
        System.out.println(player.getHealthPoint());

        Market market = new Market(player);
        //Characters.Inventory inventory = new Characters.Inventory();
*/

    }
}
