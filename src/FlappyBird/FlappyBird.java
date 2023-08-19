package FlappyBird;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class FlappyBird implements ActionListener{

    public static FlappyBird flappyBird;
    public Renderer renderer;
    public final int WIDHT=800, HEIGHT=800;

    Timer timer = new Timer(20,this);

    public FlappyBird(){
        
        JFrame frame = new JFrame();
        renderer = new Renderer();

        frame.add(renderer);                                   //this will add renderer obj to the frame.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //this will stop the code on closing JFrame unless the code will keep running;
        frame.setSize(WIDHT, HEIGHT);                        //frame size set, not visible.
        frame.setVisible(true);                           //make frame visible.
        frame.setResizable(false);
                                                           //By default JFame is resizable, making it non resizeable.
        timer.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        renderer.repaint();
    }

    public void repaint(Graphics g){
        System.out.println("hehe");
    }
    
    public static void main(String[] args) {
        flappyBird = new FlappyBird();
    }

}