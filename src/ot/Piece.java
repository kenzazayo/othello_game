package ot;
import javax.swing.JButton; 

public class Piece extends JButton{ 
     
    public static int[][] p = new int[10][10]; 
    public static final int OFFMAP =-1;         
    public static final int NULL = 0;              
    public static final int BLACK = 1; 
    public static final int WHITE = 2; 

     
   public static int turn = BLACK; 
   public static int unturn = WHITE; 
    
    public void pieceSetting(){ 
         
        for(int i=0; i<100; i++) 
        { 
            int x = i%10; 
            int y = i/10; 
             
            if(x==0 || x== 9 || y==0 || y==9) 
            { 
                p[x][y] = OFFMAP; 
            } 
            else 
            { 
                p[x][y] = NULL; 
            } 
        } 
         
        p[4][4] = BLACK; 
        p[5][5] = BLACK; 
        p[4][5] = WHITE; 
        p[5][4] = WHITE;        
         
    } 
     
    public static void doRev(int sx, int sy){ 
         
        int saveX = sx; 
        int saveY = sy; 
         
        int mx = -1; 
        int my = -2;            
         
                 
        for(int i=0; i<8; i++) 
        { 
            sx = saveX; 
            sy = saveY; 
            int revX = saveX; 
            int revY = saveY; 
             
            if(mx == 0 && my == -1) 
            { 
                my = my + 2; 
            } 
            else if(my != 1) 
            { 
                my++; 
            } 
            else 
            { 
                mx++; 
                my = -1; 
            } 
             
            while(p[sx+mx][sy+my] != turn && p[sx+mx][sy+my] > 0) 
            { 
                sx = sx+mx; 
                sy = sy+my; 

            } 
             
            if(p[sx+mx][sy+my] == turn){ 
                 
                while(p[revX+mx][revY+my] != turn && p[revX+mx][revY+my] > 0) 
                { 
                    p[revX+mx][revY+my] = turn; 
                    revX = revX+mx; 
                    revY = revY+my; 
                } 
            } 
             
        } 
         
         
    }


}