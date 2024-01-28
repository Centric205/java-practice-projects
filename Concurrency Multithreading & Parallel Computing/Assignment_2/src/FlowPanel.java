import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FlowPanel extends JPanel implements Runnable {
 //   public static MyMouseListener MyMouseListener;
    Terrain land;
    private Rectangle shape;
    Point x,y;



    FlowPanel(){}

    FlowPanel(Terrain terrain)
    {
        land = terrain;

        MyMouseListener ml = new MyMouseListener();
        addMouseListener(ml);
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        // draw the landscape in greyscale as an image
        if (land.getImage() != null)
        {
            g.drawImage(land.getImage(), 0, 0, null);
            repaint();
        }

        // overlaying the water image
        if ((new Water()).getImage() != null)
        {
            g.drawImage((new Water()).getImage(),0,0,null);
            repaint();
        }

        if (shape != null)
        {
            Graphics2D gr2D = (Graphics2D) g;
            gr2D.draw(shape);
        }

        if ((new Water()).shape != null)
        {
            Graphics2D grd2 = (Graphics2D) g;
            grd2.draw((new Water()).shape);
        }

    }

    public void addRectangle(Rectangle rectangle, Color color)
    {
        // Draws the rectangle onto the BufferedImage

        Graphics2D gr2D = (Graphics2D) land.getImage().getGraphics();
        gr2D.setColor(Color.BLUE);
        gr2D.fill(rectangle);
        gr2D.draw(rectangle);
        repaint();
    }

    @Override
    public void paintImmediately(int x, int y, int w, int h) {
        super.paintImmediately(x, y, w, h);
    }

    @Override
    public void run() {
        // display loop here
        // to do: this should be controlled by the GUI
        // to allow stopping and starting
        repaint();
    }

    class MyMouseListener extends MouseAdapter
    {
        private Point gridPoint;

        @Override
        public void mouseClicked(MouseEvent e) {
            gridPoint = e.getPoint();
            shape = new Rectangle();


            shape.setBounds(gridPoint.x,gridPoint.y,10,10);
            addRectangle(shape, e.getComponent().getForeground());
            repaint();
            shape = null;
        }

    }
}
