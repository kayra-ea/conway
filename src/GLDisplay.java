import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GLDisplay extends JPanel{
    GLModel world;
    int size = 400;
    Timer animator;
    Color pixelColor;

    public GLDisplay(){
        world = new GLModel();
        pixelColor = Color.red;

        this.addMouseListener(new ClickListener());
        this.addMouseMotionListener(new drawingMouseListener());

        //Create and setup the timer
        animator = new Timer(30, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                world.update();
                repaint();
            }
        });
        animator.stop();
    }

    @Override
    public void paintComponent(Graphics g){
        g.setColor(pixelColor);
        int cellSize = 400 /size;
        for(int x = 0; x < size; x++){
            for(int y = 0; y < size; y++){
                if(world.isAlive(x,y)){
                    g.fillRect(x*cellSize, y*cellSize, cellSize, cellSize);
                }
            }
        }
    }

    public void play(){
        animator.start();
    }

    public void stop(){
        animator.stop();
    }

    /*
     * Set Dimension(int)
     * Sets the size of the grid for the cells
     */
    public void setDimension(int size){
        this.size = size;
        world.setDimensions(size);
    }

    /* SetColor(Color)
     * Set the method to set the color of the cells
     */
    public void setColor(Color c){
        pixelColor = c;
        repaint();
    }

    private class ClickListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            int cellSize = 400 / size;
            System.out.println("Happened");
            int x = e.getX() / cellSize;    //Recalculating the coordinate to adjust for pixel size
            int y = e.getY() / cellSize;
            world.setAlive(x, y);
            repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private class drawingMouseListener implements MouseMotionListener{

        @Override
        public void mouseDragged(MouseEvent e) {
            int cellSize = 400 / size;
            int x = e.getX() / cellSize;    //Recalculating the coordinate to adjust for pixel size
            int y = e.getY() / cellSize;
            world.setAlive(x, y);
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }
}
