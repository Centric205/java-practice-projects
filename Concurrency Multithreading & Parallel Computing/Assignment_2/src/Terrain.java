import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Terrain {

    float [][] height;
    int dimx, dimy;
    BufferedImage image;

    public int dim(){ return dimx*dimy; }

    public int getDimX() {
        return dimx;
    }

    public int getDimY() {
        return dimy;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void deriveImage()
    {
        image = new BufferedImage(dimx,dimy, BufferedImage.TYPE_INT_ARGB);
        float maxh = -10000.0f, minh = 10000.0f;

        // determine range of heights
        for (int x = 0; x < dimx; x++)
            for (int y = 0; y < dimy; y++)
            {
                float h = height[x][y];
                if (h > maxh)
                    maxh = h;
                if (h < minh)
                    minh = h;
            }

        for (int x = 0; x < dimx; x++)
            for (int y = 0; y < dimy; y++)
            {
                // find normalized height value in range
                float val = (height[x][y] - minh) / (maxh - minh);
                Color col = new Color(val, val, val, 1.0f);
                image.setRGB(x, y, col.getRGB());
            }

    }

    public void readData(String fileName)
    {
        try {
            Scanner sc = new Scanner(new File(fileName));

            // read grid dimensions
            // x and y correspond to columns and rows, respectively.
            // Using image coordinate system where top left is (0, 0).
            dimx = sc.nextInt();
            dimy = sc.nextInt();

            // populate height grid
            height = new float[dimx][dimy];

            for (int y = 0; y < dimy; y++)
                for (int x = 0; x < dimx; x++)
                {
                    height[x][y] = sc.nextFloat();
                }
            sc.close();;

            // generate randomly permuted list of indices for traversal
            // genPermute();

            // generate greyscale heightfield image
            deriveImage();


        }
        catch (IOException e)
        {
            System.out.println("Unable to open input file "+ fileName);
            e.printStackTrace();
        }

        catch (java.util.InputMismatchException e)
        {
            System.out.println("Malformed input file "+fileName);
            e.printStackTrace();
        }

    }

    public void createEmptyImage()
    {
        image = new BufferedImage(dimx,dimy, BufferedImage.TYPE_INT_ARGB);
        float maxh = -10000.0f, minh = 10000.0f;

        // determine range of heights
        for (int x = 0; x < dimx; x++)
            for (int y = 0; y < dimy; y++)
            {
                float h = height[x][y];
                if (h > maxh)
                    maxh = h;
                if (h < minh)
                    minh = h;
            }

        for (int x = 0; x < dimx; x++)
            for (int y = 0; y < dimy; y++)
            {
                // find normalized height value in range
                float val = (height[x][y] - minh) / (maxh - minh);
                Color col = new Color(val, val, val, 1.0f);
                image.setRGB(x, y, col.getRGB());
            }
        Graphics2D gr2D = (Graphics2D) image.getGraphics();
        gr2D.drawImage(image, 0, 0, null);
    }
}
