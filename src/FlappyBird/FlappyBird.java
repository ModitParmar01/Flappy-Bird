package FlappyBird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.ImageIcon;

public class FlappyBird implements ActionListener{

    public static FlappyBird flappyBird;
    public Renderer renderer;
    public Rectangle bird;
    public Random random;

    public final int WIDTH=800, HEIGHT=800;
    public int ticks, yMotion;

    public ArrayList<Rectangle> columns;

    Timer timer = new Timer(20,this);

    public FlappyBird(){
        
        JFrame frame = new JFrame();
        renderer = new Renderer();
        bird = new Rectangle(WIDTH/2, HEIGHT/2, 20, 20);
        columns = new ArrayList<Rectangle>();
        random = new Random();
        
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
        frame.setSize(WIDTH, HEIGHT);                        //frame size set, not visible.
        frame.setVisible(true);                             //make frame visible.
        frame.setResizable(false);
                                                           //By default JFame is resizable, making it non resizeable.
        timer.start();

        addCol(true);
        addCol(true);
        addCol(true);
        addCol(true);
        addCol(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int speed =10;
        ticks++;

        for(int i=0; i<columns.size(); i++){
            Rectangle col = columns.get(i);
            col.x -= speed;
        }

        if(ticks%2==0 && yMotion<15) {
            yMotion += 2;
        }
        bird.y += yMotion;

        renderer.repaint();
    }

    public void addCol(boolean start) {
        int spacing = 300;
        int width = 100;
        int height = 50 + random.nextInt(300);
        if(start) {
        columns.add(new Rectangle(WIDTH+width+columns.size()*300, HEIGHT - height - 120, width, height));
        //columns.size()*300 calculates x-coordinates for new columns.
        columns.add(new Rectangle(WIDTH+width+(columns.size()-1)*300, 0, width, HEIGHT - height - spacing));
        }
        else {
            columns.add(new Rectangle(columns.get(columns.size()-1).x + 600, HEIGHT - height - 120, width, height));
            columns.add(new Rectangle(columns.get(columns.size()-1).x, 0, width, HEIGHT - height - spacing));
        }
        
    }

    public void paintColomn(Graphics g, Rectangle column) {
        g.setColor(Color.green.darker());
        g.fillRect(column.x, column.y, column.width, column.height);

    }

    public void repaint(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect(WIDTH-WIDTH, HEIGHT-HEIGHT, WIDTH, HEIGHT);

        g.setColor(Color.ORANGE);
        g.fillRect(WIDTH-WIDTH, HEIGHT-150, WIDTH, (HEIGHT/4)-50);

        g.setColor(Color.GREEN);
        g.fillRect(WIDTH-WIDTH, HEIGHT-175, WIDTH, (HEIGHT/8)-75);

        g.setColor(Color.RED);
        g.fillRect(bird.x-10, bird.y-10, bird.width, bird.height);

        for(Rectangle column: columns) {
            paintColomn(g, column);
        }
    }
    
    public static void main(String[] args) {
        flappyBird = new FlappyBird();
    }
}