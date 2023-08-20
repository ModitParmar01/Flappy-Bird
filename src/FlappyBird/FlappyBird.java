package FlappyBird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.ImageIcon;

public class FlappyBird implements ActionListener{

    public static FlappyBird flappyBird;
    public Renderer renderer;
    public Rectangle bird;

    public final int WIDHT=800, HEIGHT=800;

    public ArrayList<Rectangle> colomns;

    Timer timer = new Timer(20,this);

    public FlappyBird(){
        
        JFrame frame = new JFrame();
        renderer = new Renderer();
        bird = new Rectangle(WIDHT/2, HEIGHT/2, 20, 20);
        colomns = new ArrayList<Rectangle>();
        
        ImageIcon icon = null;
        try {
            icon = new ImageIcon("img\\pngegg.png");
        } catch (Exception e){
            e.printStackTrace();
        }

        frame.setTitle("Flappy Bird");
        frame.setIconImage(icon.getImage());
        frame.add(renderer);                                   //this will add renderer obj to the frame.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //this will stop the code on closing JFrame unless the code will keep running;
        frame.setSize(WIDHT, HEIGHT);                        //frame size set, not visible.
        frame.setVisible(true);                             //make frame visible.
        frame.setResizable(false);
                                                           //By default JFame is resizable, making it non resizeable.
        timer.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        renderer.repaint();
    }

    public void paintColomn(Graphics g, Rectangle colomn){
        g.setColor(Color.green.darker().darker());
        g.fillRect(colomn.x, colomn.y, colomn.width, colomn.height);

    }

    public void repaint(Graphics g){
        g.setColor(Color.cyan);
        g.fillRect(WIDHT-WIDHT, HEIGHT-HEIGHT, WIDHT, HEIGHT);

        g.setColor(Color.ORANGE);
        g.fillRect(WIDHT-WIDHT, HEIGHT-150, WIDHT, (HEIGHT/4)-50);

        g.setColor(Color.GREEN);
        g.fillRect(WIDHT-WIDHT, HEIGHT-175, WIDHT, (HEIGHT/8)-75);

        g.setColor(Color.RED);
        g.fillRect(bird.x-10, bird.y-10, bird.width, bird.height);
    }
    
    public static void main(String[] args) {
        flappyBird = new FlappyBird();
    }

}