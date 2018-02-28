import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public void run() {
        //init Terminal
        Terminal terminal = TerminalFacade.createTerminal(System.in,
                System.out, Charset.forName("UTF-8"));
        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);

        //setup player
        List<GameObject> gameObjects = new ArrayList<>();
        Player player = new Player(0,0,'P');
        gameObjects.add(player);

        //Gameloop
        while(true){
            for (GameObject gameObject : gameObjects) {
                terminal.moveCursor(gameObject.getX(),gameObject.getY());
                terminal.putCharacter(gameObject.getLook());
            }
        }


    }
}
