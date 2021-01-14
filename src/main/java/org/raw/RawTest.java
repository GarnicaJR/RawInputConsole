package org.raw;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

public class RawTest {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        
        
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
        Terminal terminal = defaultTerminalFactory.createTerminal();
        
        while (true) {
           
            KeyStroke key = terminal.pollInput();
            if (key == null || key.getKeyType()== KeyType.Backspace) {
                continue;
            } 
            else if (key.getCharacter() != ' '  &&  key.getKeyType()!=KeyType.Enter) {
                terminal.putCharacter(key.getCharacter());
            } else {
                terminal.putCharacter('\n');
                break;
            }
            Thread.sleep(10);
        }
    }
}
