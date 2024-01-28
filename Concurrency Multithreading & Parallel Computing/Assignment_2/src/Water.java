import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Water {

    float[][] height;
    int[][] wDepth;
    float[][] waterSurface;
    int dimy, dimx;
    BufferedImage image;
    Rectangle shape;

    BufferedImage getImage(){ return image;}

    void readData(String filename)
    {
        try
        {
            Height(filename);
            Scanner input = new Scanner(new File(filename));

            dimx = input.nextInt();
            dimy = input.nextInt();

            wDepth = new int[dimx][dimy];
            waterSurface = new float[dimx][dimy];

            for (int i = 0; i < dimy; i++)
            {
                for (int j = 0; j < dimx; j++)
                {
                    String[] temp = (input.next()).split("");
                    int size = temp.length;
                    wDepth[i][j] = Integer.parseInt(temp[size - 1]);
                }
            }

            // Generating the water surface
            for (int i = 0; i < dimy;i++)
            {
                for (int j = 0; j < dimx;j++)
                {
                    waterSurface[i][j] = (height[i][j] + wDepth[i][j]);
                }
            }
         //   printSurface();

        }
        catch (IOException e)
        {
            System.out.println("Unable to open input file "+ filename);
            e.printStackTrace();
        }

        catch (java.util.InputMismatchException e)
        {
            System.out.println("Malformed input file "+filename);
            e.printStackTrace();
        }
    }

    void Height(String filename)
    {
        try
        {
            Scanner key = new Scanner(new File(filename));

            int x = key.nextInt();
            int y = key.nextInt();

            height = new float[x][y];

            for (int i = 0; i < y; i++)
            {
                for (int j = 0; j < x; j++)
                {
                    height[i][j] = key.nextFloat();
                }
            }
            deriveImage(x,y);

        }
        catch (IOException e)
        {
            System.out.println("Unable to open file input "+filename);
            e.printStackTrace();
        }

        catch (java.util.InputMismatchException e)
        {
            System.out.println("Malformed input file "+filename);
            e.printStackTrace();
        }
    }

    void printSurface()
    {
        for (int k = 0; k < dimy;k++)
        {
            for (int j = 0; j < dimx;j++)
            {
                System.out.println(waterSurface[k][j]);
            }
        }
    }

    void deriveImage(int x,int y)
    {
        image = new BufferedImage(x,y,BufferedImage.TYPE_INT_ARGB);

    }

    void drawOnImage(int x, int y)
    {

        shape = new Rectangle();
        shape.setBounds(x,y,3,3);
        (new FlowPanel()).addRectangle(shape,Color.BLUE);
        (new FlowPanel()).repaint();
        shape = null;
    }
    
    void simualtion()
    {
        for (int i = 1; i < dimy - 1; i++) {
            for (int j = 1; j < waterSurface[i].length - 1; j++) {
                if (((waterSurface[i][j]) <= waterSurface[i - 1][j - 1] && ((i + 1) != waterSurface[i].length || (j + 1) != waterSurface[j].length))
                        && ((waterSurface[i][j]) <= waterSurface[i - 1][j] && ((i + 1) != waterSurface[i].length || (j + 1) != waterSurface[j].length))
                        && ((waterSurface[i][j]) <= waterSurface[i - 1][j + 1] && ((i + 1) != waterSurface[i].length || (j + 1) != waterSurface[j].length))
                        && ((waterSurface[i][j]) <= waterSurface[i][j + 1] && ((i + 1) != waterSurface[i].length || (j + 1) != waterSurface[j].length))
                        && ((waterSurface[i][j]) <= waterSurface[i + 1][j + 1] && ((i + 1) != waterSurface[i].length || (j + 1) != waterSurface[j].length))
                        && ((waterSurface[i][j]) <= waterSurface[i + 1][j] && ((i + 1) != waterSurface[i].length || (j + 1) != waterSurface[j].length))
                        && ((waterSurface[i][j]) <= waterSurface[i + 1][j - 1] && ((i + 1) != waterSurface[i].length || (j + 1) != waterSurface[j].length))
                        && ((waterSurface[i][j]) <= waterSurface[i][j - 1] && ((i + 1) != waterSurface[i].length || (j + 1) != waterSurface[j].length))
                ) {
                    drawOnImage(i,j);
                    (new FlowPanel()).repaint();


//                    numberOfBasins++;
//                    ans = i + " " + j +"\n";
//                    build.append(ans);
                    // System.out.println(i + " " + j ); please uncomment when entering large data
                }
            }
        }
    }


}
