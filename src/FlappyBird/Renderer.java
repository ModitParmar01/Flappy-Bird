//this class implements double buffering.

package FlappyBird;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Renderer extends JPanel {
    private static final long serialVersionUID = 1L;
    
    @Override
    public void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponents(g);

        FlappyBird.flappyBird.repaint(g);
    }

}
