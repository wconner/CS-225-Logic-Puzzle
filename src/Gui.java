//Fred Dolan
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JFrame implements MouseListener {

    //three arrays to hold the colors of the cell contents
    private Color[][] arraya = new Color[4][4];
    private Color[][] arrayb = new Color[4][4];
    private Color[][] arrayc = new Color[4][4];
    private int s = 1;
    //scales the size
    private int b = 100;
    private Game game;
    public Gui() {
        game = new Game();
        int indone = 0;
        //filling the color arrays
        while(indone<4)
        {
            int indtwo=0;
            while(indtwo<4)
            {
                arraya[indone][indtwo] = Color.BLUE;
                indtwo++;
            }
            indone++;
        }
        while(indone<4)
        {
            int indtwo=0;
            while(indtwo<4)
            {
                arrayb[indone][indtwo] = Color.BLUE;
                indtwo++;
            }
            indone++;
        }
        while(indone<4)
        {
            int indtwo=0;
            while(indtwo<4)
            {
                arrayc[indone][indtwo] = Color.BLUE;
                indtwo++;
            }
            indone++;
        }
        setSize(200*s+2*b,200*s+2*b);
        addMouseListener(this); 
        setVisible(true);
    }
    //sets a new color for the item, a is array 1 2 or 3, c is either 0(white), 1(red), or 2(green)
    public void recolor(int a, int c, int row, int col)
    {
        //array a
        if(a==1){
            System.out.println("called on a "+ row + col);
            if (c==0)
            {
                arraya[row][col] = Color.BLUE;
            }
            else if (c==1)
            {
                arraya[row][col] = Color.RED;
            }
            else if (c==2)
            {
                arraya[row][col] = Color.GREEN;
            }
        }
        //array b
        if(a==2){
            System.out.println("called on b "+ row + col);
            if (c==0)
            {
                arrayb[row][col] = Color.BLUE;
            }
            else if (c==1)
            {
                arrayb[row][col] = Color.RED;
            }
            else if (c==2)
            {
                arrayb[row][col] = Color.GREEN;
            }
        }
        //array c
        if(a==3){
            System.out.println("called on c "+ row + col);
            if (c==0)
            {
                arrayc[row][col] = Color.BLUE;
            }
            else if (c==1)
            {
                arrayc[row][col] = Color.RED;
            }
            else if (c==2)
            {
                arrayc[row][col] = Color.GREEN;
            }
        }
    }

    // paint is called automatically when program begins, when window is
    //   refreshed and  when repaint() is invoked 
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        //vertical lines
        g.drawLine(0*s+b, 0*s+b, 0*s+b, 200*s+b);
        g.drawLine(25*s+b, 0*s+b, 25*s+b, 200*s+b);
        g.drawLine(50*s+b, 0*s+b, 50*s+b, 200*s+b);
        g.drawLine(75*s+b, 0*s+b, 75*s+b, 200*s+b);
        g.drawLine(100*s+b, 0*s+b, 100*s+b, 200*s+b);

        g.drawLine(125*s+b, 0*s+b, 125*s+b, 100*s+b);
        g.drawLine(150*s+b, 0*s+b, 150*s+b, 100*s+b);
        g.drawLine(175*s+b, 0*s+b, 175*s+b, 100*s+b);
        g.drawLine(200*s+b, 0*s+b, 200*s+b, 100*s+b);

        //horizontal lines
        g.drawLine(0*s+b, 0*s+b, 200*s+b, 0*s+b);
        g.drawLine(0*s+b, 25*s+b, 200*s+b, 25*s+b);
        g.drawLine(0*s+b, 50*s+b, 200*s+b, 50*s+b);
        g.drawLine(0*s+b, 75*s+b, 200*s+b, 75*s+b);
        g.drawLine(0*s+b, 100*s+b, 200*s+b, 100*s+b);

        g.drawLine(0*s+b, 125*s+b, 100*s+b, 125*s+b);
        g.drawLine(0*s+b, 150*s+b, 100*s+b, 150*s+b);
        g.drawLine(0*s+b, 175*s+b, 100*s+b, 175*s+b);
        g.drawLine(0*s+b, 200*s+b, 100*s+b, 200*s+b);

        //creates shapes for arraya
        g.setColor(Color.BLUE);
        int indonea = 0;
        int ypos=b+100*s;
        while(indonea<4)
        {
            int indtwoa=0;
            int xpos=b;
            while(indtwoa<4)
            {
                g.setColor(arraya[indonea][indtwoa]);
                g.fillOval(xpos, ypos, 25*s, 25*s);
                xpos+=25*s;
                indtwoa++;
                g.setColor(Color.BLUE);
            }
            ypos+=25*s;
            indonea++;
        }

        //creates shapes for arrayb
        int indoneb = 0;
        ypos=b;
        while(indoneb<4)
        {
            int indtwob=0;
            int xpos=b;
            while(indtwob<4)
            {
                g.setColor(arrayb[indoneb][indtwob]);
                g.fillOval(xpos, ypos, 25*s, 25*s);
                xpos+=25*s;
                indtwob++;
                g.setColor(Color.BLUE);
            }
            ypos+=25*s;
            indoneb++;
        }

        //creates shapes for arrayc
        int indonec = 0;
        ypos=b;
        while(indonec<4)
        {
            int indtwoc=0;
            int xpos=b+100*s;
            while(indtwoc<4)
            {
                g.setColor(arrayc[indonec][indtwoc]);
                g.fillOval(xpos, ypos, 25*s, 25*s);
                xpos+=25*s;
                indtwoc++;
                g.setColor(Color.BLUE);
            }
            ypos+=25*s;
            indonec++;
        }
        g.setColor(Color.BLACK);
        //button for check errors
        g.drawRect(b+10*s,b+210*s, 100*s, 25*s);
        g.drawString("Check Errors", b + 20 * s, b + 230 * s);
        //button for reset
        g.drawRect(b+150*s,b+210*s, 100*s, 25*s);
        g.drawString("Reset", b+182*s, b+230*s);
        //big victory sign

        if(game.getVictory())
        {
            g.setFont(new Font("Dialog",0 ,48));
            g.drawString("VICTORY", b, b);
            g.setFont(new Font("Dialog",0 ,12));
        }
    }

    // The next 4 methods must be defined, but you won't use them.
    public void mouseReleased(MouseEvent e ) { }

    public void mouseEntered(MouseEvent e)   { }

    public void mouseExited(MouseEvent e)    { }

    public void mousePressed(MouseEvent e)   { }

    public void mouseClicked(MouseEvent e) {
        System.out.println("clicked " + e.getX() + " , " + e.getY());

        //calls the appropriate button clicked and recolor buttons based on the mouse's x and y positions

        //first row in matrix b
        if (e.getX() > (0 + 0) * s + b && e.getX() < (25 + 0) * s + b && e.getY() > (0 + 0) * s + b && e.getY() < (25 + 0) * s + b) {
            game.buttonClicked(2, 0, 0);
        } else if (e.getX() > (25 + 0) * s + b && e.getX() < (50 + 0) * s + b && e.getY() > (0 + 0) * s + b && e.getY() < (25 + 0) * s + b) {
            game.buttonClicked(2, 0, 1);
        } else if (e.getX() > (50 + 0) * s + b && e.getX() < (75 + 0) * s + b && e.getY() > (0 + 0) * s + b && e.getY() < (25 + 0) * s + b) {
            game.buttonClicked(2, 0, 2);
        } else if (e.getX() > (75 + 0) * s + b && e.getX() < (100 + 0) * s + b && e.getY() > (0 + 0) * s + b && e.getY() < (25 + 0) * s + b) {
            game.buttonClicked(2, 0, 3);
        }
        //second row
        else if (e.getX() > (0 + 0) * s + b && e.getX() < (25 + 0) * s + b && e.getY() > (0 + 25) * s + b && e.getY() < (25 + 25) * s + b) {
            game.buttonClicked(2, 1, 0);
        } else if (e.getX() > (25 + 0) * s + b && e.getX() < (50 + 0) * s + b && e.getY() > (0 + 25) * s + b && e.getY() < (25 + 25) * s + b) {
            game.buttonClicked(2, 1, 1);
        } else if (e.getX() > (50 + 0) * s + b && e.getX() < (75 + 0) * s + b && e.getY() > (0 + 25) * s + b && e.getY() < (25 + 25) * s + b) {
            game.buttonClicked(2, 1, 2);
        } else if (e.getX() > (75 + 0) * s + b && e.getX() < (100 + 0) * s + b && e.getY() > (0 + 25) * s + b && e.getY() < (25 + 25) * s + b) {
            game.buttonClicked(2, 1, 3);
        }
        //third row
        else if (e.getX() > (0 + 0) * s + b && e.getX() < (25 + 0) * s + b && e.getY() > (0 + 50) * s + b && e.getY() < (25 + 50) * s + b) {
            game.buttonClicked(2, 2, 0);
        } else if (e.getX() > (25 + 0) * s + b && e.getX() < (50 + 0) * s + b && e.getY() > (0 + 50) * s + b && e.getY() < (25 + 50) * s + b) {
            game.buttonClicked(2, 2, 1);
        } else if (e.getX() > (50 + 0) * s + b && e.getX() < (75 + 0) * s + b && e.getY() > (0 + 50) * s + b && e.getY() < (25 + 50) * s + b) {
            game.buttonClicked(2, 2, 2);
        } else if (e.getX() > (75 + 0) * s + b && e.getX() < (100 + 0) * s + b && e.getY() > (0 + 50) * s + b && e.getY() < (25 + 50) * s + b) {
            game.buttonClicked(2, 2, 3);
        }
        //fourth row
        else if (e.getX() > (0 + 0) * s + b && e.getX() < (25 + 0) * s + b && e.getY() > (0 + 75) * s + b && e.getY() < (25 + 75) * s + b) {
            game.buttonClicked(2, 3, 0);
        } else if (e.getX() > (25 + 0) * s + b && e.getX() < (50 + 0) * s + b && e.getY() > (0 + 75) * s + b && e.getY() < (25 + 75) * s + b) {
            game.buttonClicked(2, 3, 1);
        } else if (e.getX() > (50 + 0) * s + b && e.getX() < (75 + 0) * s + b && e.getY() > (0 + 75) * s + b && e.getY() < (25 + 75) * s + b) {
            game.buttonClicked(2, 3, 2);
        } else if (e.getX() > (75 + 0) * s + b && e.getX() < (100 + 0) * s + b && e.getY() > (0 + 75) * s + b && e.getY() < (25 + 75) * s + b) {
            game.buttonClicked(2, 3, 3);
        }
        //next matric
        //first row in matrix c
        else if (e.getX() > (100 + 0 + 0) * s + b && e.getX() < (100 + 25 + 0) * s + b && e.getY() > (0 + 0) * s + b && e.getY() < (25 + 0) * s + b) {
            game.buttonClicked(3, 0, 0);
        } else if (e.getX() > (100 + 25 + 0) * s + b && e.getX() < (100 + 50 + 0) * s + b && e.getY() > (0 + 0) * s + b && e.getY() < (25 + 0) * s + b) {
            game.buttonClicked(3, 0, 1);
        } else if (e.getX() > (100 + 50 + 0) * s + b && e.getX() < (100 + 75 + 0) * s + b && e.getY() > (0 + 0) * s + b && e.getY() < (25 + 0) * s + b) {
            game.buttonClicked(3, 0, 2);
        } else if (e.getX() > (100 + 75 + 0) * s + b && e.getX() < (100 + 100 + 0) * s + b && e.getY() > (0 + 0) * s + b && e.getY() < (25 + 0) * s + b) {
            game.buttonClicked(3, 0, 3);
        }
        //second row
        else if (e.getX() > (100 + 0 + 0) * s + b && e.getX() < (100 + 25 + 0) * s + b && e.getY() > (0 + 25) * s + b && e.getY() < (25 + 25) * s + b) {
            game.buttonClicked(3, 1, 0);
        } else if (e.getX() > (100 + 25 + 0) * s + b && e.getX() < (100 + 50 + 0) * s + b && e.getY() > (0 + 25) * s + b && e.getY() < (25 + 25) * s + b) {
            game.buttonClicked(3, 1, 1);
        } else if (e.getX() > (100 + 50 + 0) * s + b && e.getX() < (100 + 75 + 0) * s + b && e.getY() > (0 + 25) * s + b && e.getY() < (25 + 25) * s + b) {
            game.buttonClicked(3, 1, 2);
        } else if (e.getX() > (100 + 75 + 0) * s + b && e.getX() < (100 + 100 + 0) * s + b && e.getY() > (0 + 25) * s + b && e.getY() < (25 + 25) * s + b) {
            game.buttonClicked(3, 1, 3);
        }
        //third row
        else if (e.getX() > (100 + 0 + 0) * s + b && e.getX() < (100 + 25 + 0) * s + b && e.getY() > (0 + 50) * s + b && e.getY() < (25 + 50) * s + b) {
            game.buttonClicked(3, 2, 0);
        } else if (e.getX() > (100 + 25 + 0) * s + b && e.getX() < (100 + 50 + 0) * s + b && e.getY() > (0 + 50) * s + b && e.getY() < (25 + 50) * s + b) {
            game.buttonClicked(3, 2, 1);
        } else if (e.getX() > (100 + 50 + 0) * s + b && e.getX() < (100 + 75 + 0) * s + b && e.getY() > (0 + 50) * s + b && e.getY() < (25 + 50) * s + b) {
            game.buttonClicked(3, 2, 2);
        } else if (e.getX() > (100 + 75 + 0) * s + b && e.getX() < (100 + 100 + 0) * s + b && e.getY() > (0 + 50) * s + b && e.getY() < (25 + 50) * s + b) {
            game.buttonClicked(3, 2, 3);
        }
        //fourth row
        else if (e.getX() > (100 + 0 + 0) * s + b && e.getX() < (100 + 25 + 0) * s + b && e.getY() > (0 + 75) * s + b && e.getY() < (25 + 75) * s + b) {
            game.buttonClicked(3, 3, 0);
        } else if (e.getX() > (100 + 25 + 0) * s + b && e.getX() < (100 + 50 + 0) * s + b && e.getY() > (0 + 75) * s + b && e.getY() < (25 + 75) * s + b) {
            game.buttonClicked(3, 3, 1);
        } else if (e.getX() > (100 + 50 + 0) * s + b && e.getX() < (100 + 75 + 0) * s + b && e.getY() > (0 + 75) * s + b && e.getY() < (25 + 75) * s + b) {
            game.buttonClicked(3, 3, 2);
        } else if (e.getX() > (100 + 75 + 0) * s + b && e.getX() < (100 + 100 + 0) * s + b && e.getY() > (0 + 75) * s + b && e.getY() < (25 + 75) * s + b) {
            game.buttonClicked(3, 3, 3);
        }
        //next matrix
        //first row in matrix a
        else if (e.getX() > (0 + 0) * s + b && e.getX() < (25 + 0) * s + b && e.getY() > (100 + 0 + 0) * s + b && e.getY() < (100 + 25 + 0) * s + b) {
            game.buttonClicked(1, 0, 0);
        } else if (e.getX() > (25 + 0) * s + b && e.getX() < (50 + 0) * s + b && e.getY() > (100 + 0 + 0) * s + b && e.getY() < (100 + 25 + 0) * s + b) {
            game.buttonClicked(1, 0, 1);
        } else if (e.getX() > (50 + 0) * s + b && e.getX() < (75 + 0) * s + b && e.getY() > (100 + 0 + 0) * s + b && e.getY() < (100 + 25 + 0) * s + b) {
            game.buttonClicked(1, 0, 2);
        } else if (e.getX() > (75 + 0) * s + b && e.getX() < (100 + 0) * s + b && e.getY() > (100 + 0 + 0) * s + b && e.getY() < (100 + 25 + 0) * s + b) {
            game.buttonClicked(1, 0, 3);
        }
        //second row
        else if (e.getX() > (0 + 0) * s + b && e.getX() < (25 + 0) * s + b && e.getY() > (100 + 0 + 25) * s + b && e.getY() < (100 + 25 + 25) * s + b) {
            game.buttonClicked(1, 1, 0);
        } else if (e.getX() > (25 + 0) * s + b && e.getX() < (50 + 0) * s + b && e.getY() > (100 + 0 + 25) * s + b && e.getY() < (100 + 25 + 25) * s + b) {
            game.buttonClicked(1, 1, 1);
        } else if (e.getX() > (50 + 0) * s + b && e.getX() < (75 + 0) * s + b && e.getY() > (100 + 0 + 25) * s + b && e.getY() < (100 + 25 + 25) * s + b) {
            game.buttonClicked(1, 1, 2);
        } else if (e.getX() > (75 + 0) * s + b && e.getX() < (100 + 0) * s + b && e.getY() > (100 + 0 + 25) * s + b && e.getY() < (100 + 25 + 25) * s + b) {
            game.buttonClicked(1, 1, 3);
        }
        //third row
        else if (e.getX() > (0 + 0) * s + b && e.getX() < (25 + 0) * s + b && e.getY() > (100 + 0 + 50) * s + b && e.getY() < (100 + 25 + 50) * s + b) {
            game.buttonClicked(1, 2, 0);
        } else if (e.getX() > (25 + 0) * s + b && e.getX() < (50 + 0) * s + b && e.getY() > (100 + 0 + 50) * s + b && e.getY() < (100 + 25 + 50) * s + b) {
            game.buttonClicked(1, 2, 1);
        } else if (e.getX() > (50 + 0) * s + b && e.getX() < (75 + 0) * s + b && e.getY() > (100 + 0 + 50) * s + b && e.getY() < (100 + 25 + 50) * s + b) {
            game.buttonClicked(1, 2, 2);
        } else if (e.getX() > (75 + 0) * s + b && e.getX() < (100 + 0) * s + b && e.getY() > (100 + 0 + 50) * s + b && e.getY() < (100 + 25 + 50) * s + b) {
            game.buttonClicked(1, 2, 3);
        }
        //fourth row
        else if (e.getX() > (0 + 0) * s + b && e.getX() < (25 + 0) * s + b && e.getY() > (100 + 0 + 75) * s + b && e.getY() < (100 + 25 + 75) * s + b) {
            game.buttonClicked(1, 3, 0);
        } else if (e.getX() > (25 + 0) * s + b && e.getX() < (50 + 0) * s + b && e.getY() > (100 + 0 + 75) * s + b && e.getY() < (100 + 25 + 75) * s + b) {
            game.buttonClicked(1, 3, 1);
        } else if (e.getX() > (50 + 0) * s + b && e.getX() < (75 + 0) * s + b && e.getY() > (100 + 0 + 75) * s + b && e.getY() < (100 + 25 + 75) * s + b) {
            game.buttonClicked(1, 3, 2);
        } else if (e.getX() > (75 + 0) * s + b && e.getX() < (100 + 0) * s + b && e.getY() > (100 + 0 + 75) * s + b && e.getY() < (100 + 25 + 75) * s + b) {
            game.buttonClicked(1, 3, 3);
        }

        //button for check errors
        else if (e.getX() > (10) * s + b && e.getX() < (110) * s + b && e.getY() > (210) * s + b && e.getY() < (235) * s + b) {
            game.checkState();
        }

        //button for reset
        else if (e.getX() > (150) * s + b && e.getX() < (250) * s + b && e.getY() > (210) * s + b && e.getY() < (235) * s + b) {
            game.reset();
        }


            //loops through all the cells and sets them to their current color
            Cell[][] Arraya = game.getMatrixa();
            int indexa = 0;
            while (indexa < 4) {
                int index2 = 0;
                while (index2 < 4) {
                    recolor(1, (Arraya[indexa][index2].getCellColor()), indexa, index2);
                    index2++;
                }
                indexa++;
            }
            Cell[][] Arrayb = game.getMatrixb();
            int indexb = 0;
            while (indexb < 4) {
                int index2 = 0;
                while (index2 < 4) {
                    recolor(2, (Arrayb[indexb][index2].getCellColor()), indexb, index2);
                    index2++;
                }
                indexb++;
            }
            Cell[][] Arrayc = game.getMatrixc();
            int indexc = 0;
            while (indexc < 4) {
                int index2 = 0;
                while (index2 < 4) {
                    recolor(3, (Arrayc[indexc][index2].getCellColor()), indexc, index2);
                    index2++;
                }
                indexc++;
            }

            repaint();    //calls paint()
        }

    public static void main(String argv[]) {
        Gui c = new Gui();
    }
}