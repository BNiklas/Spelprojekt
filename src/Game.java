import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;

public class Game {
    public void run() {
        //init Terminal
        Terminal terminal = TerminalFacade.createTerminal(System.in,
                System.out, Charset.forName("UTF-8"));
        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);

        AdventureState as = new AdventureState();
        AdventureState currentState = as;

        as.onInit();
        //Gameloop
        while(true){
            as.onDraw(terminal);
        }


    }
}
