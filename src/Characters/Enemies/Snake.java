package Characters.Enemies;

import java.util.Random;

public class Snake extends Enemy{
    public Snake() {
        super("Snake", 4, new Random().nextInt(4)+3, 12, 0, true);
    }
}
