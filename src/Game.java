import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;

public class Game {
    private Terminal terminal;
    private boolean running;
    private State adventureState;

    public void run() {
        //init Terminal
        onInit();

        State currentState = adventureState;

        //Gameloop
        while(running){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Key key = terminal.readInput();
            if (key != null) {
                currentState.onInput(key);
            }
            currentState.onLoop();
            currentState.onDraw(terminal);
        }

        onExit();
    }

    private void onExit() {
        terminal.exitPrivateMode();
    }

    private void onInit() {
        terminal = TerminalFacade.createTerminal(System.in,
                System.out, Charset.forName("UTF-8"));
        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);

        running = true;

        adventureState = new AdventureState();
        adventureState.onInit();
    }
}
