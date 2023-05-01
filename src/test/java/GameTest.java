import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void GameWin1 () {
        Game game = new Game();

        Player player1 = new Player(1,"Pavel",1_000);
        Player player2 = new Player(2,"Vova",500);

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Pavel","Vova");

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void GameWin2() {
        Game game = new Game();

        Player player1 = new Player(1,"Pavel", 50);
        Player player2 = new Player(2,"Vova", 200);

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Pavel", "Vova");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void GameEquals () {
        Game game = new Game();

        Player player1 = new Player(1,"Pavel",100);
        Player player2 = new Player(2, "Vova", 100);

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Pavel","Vova");

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void NotRegister1 () {
        Game game = new Game();

        Player player1 = new Player(1,"Pavel",100);
        Player player2 = new Player(2,"Vova",50);

        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Pavel","Vova");
        });
    }

    @Test
    public void NotRegister2 (){
        Game game = new Game();

        Player player1 = new Player(1,"Pavel",100);
        Player player2 = new Player(2,"Vova",50);

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Pavel","Vova");
        });
    }

    @Test
    public void NotRegisterAll () {
        Game game = new Game();

        Player player1 = new Player(1,"pavel", 100);
        Player player2 = new Player(2,"Vova",50);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Pavel","vova");
        });
    }
}
