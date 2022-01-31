package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
@Test
    void testGame(){
    Game game = new Game();
    game.readFile();
    System.out.println(game.getPlayers());
    System.out.println(game.getSolution());
    assertEquals(game.getPlayers().keySet().stream().toList().get(1),game.getWinner());
    }
}