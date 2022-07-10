import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class TerminalWrapper {

    private DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
    private Terminal terminal;

    public TerminalWrapper() throws IOException {
    defaultTerminalFactory.setInitialTerminalSize(new TerminalSize(200, 200));
    terminal = defaultTerminalFactory.createTerminal();
    }

    public void drawString(String string) throws IOException {
        for (int i = 0; i < string.length(); i++) {
            terminal.putCharacter(string.charAt(i));
        }
        terminal.putCharacter('\n');
        terminal.flush();
    }

}
