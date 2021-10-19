package Lambda;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public interface MyInterface extends KeyListener {
    default  public void keyTyped(KeyEvent e) {

    };

    default public void keyReleased(KeyEvent e){

    };

    public void keyPressed(KeyEvent e);

}
