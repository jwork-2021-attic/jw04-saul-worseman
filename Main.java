

import javax.swing.JFrame;

import Lambda.MyInterface;
import com.anish.monsters.World;
import com.anish.screen.Screen;
import com.anish.screen.WorldScreen;
import Lambda.MyInterface;
import asciiPanel.AsciiFont;
import asciiPanel.AsciiPanel;

import java.awt.event.KeyListener;

public class Main extends JFrame{

    private AsciiPanel terminal;
    private Screen screen;

    public Main() {
        super();
        terminal = new AsciiPanel(World.WIDTH, World.HEIGHT, AsciiFont.TALRYTH_15_15);
        add(terminal);
        pack();
        screen = new WorldScreen();
//        addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//                screen = screen.respondToUserInput(e);
//                repaint();
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//
//            }
//        });

//       inner class
//        addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                screen = screen.respondToUserInput(e);
//                repaint();
//            }
//        });

//      lambda 1
//        MyInterface myInterface = e->{
//            screen = screen.respondToUserInput(e);
//            repaint();
//        };
//        addKeyListener(myInterface);

        addMyInterface(e -> {
            screen = screen.respondToUserInput(e);
            repaint();
        });
        repaint();
    }

    public synchronized void addMyInterface(MyInterface l){
        addKeyListener(l);
    }
    @Override
    public void repaint() {
        terminal.clear();
        screen.displayOutput(terminal);
        super.repaint();
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

}
