package ot;

import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*; 
import javax.swing.SwingUtilities.*;


public class Board extends JFrame implements ActionListener{ 
	imagen ima = new imagen();
	 
	static  Clip clip2;
	static  Clip audio1;
	
	// Audio
 
	   
	// Point 
	private int pblack = 0;
    private int pwhite = 0;
     
    // Button
    private JButton pass1;
    private JButton pass2;
    private JButton retry = new JButton();
    private JButton back = new JButton();
    private JButton give1;
    private JButton give2;
    
    private JFrame frame = new JFrame("Othello"); 
    private JFrame frame1;
    private JPanel panel = new JPanel(); 
    private JPanel panel1; 
    private JLabel B = new  JLabel(String.valueOf(pblack));
    private JLabel W = new  JLabel(String.valueOf(pwhite));
    private JLabel turn1 =  new  JLabel("You");
    private JLabel turn2 =  new  JLabel("Wait");
    private JLabel pic1;
    private JLabel pic2;
    private JLabel picwin;
    private JLabel picwin1;
    private JTextField gameset = new JTextField();
    private JTextField tb = new JTextField("BLACK");
    private JTextField tw = new JTextField("WHITE");
    private  Color c  ;
    private int count =4;
    
    // Button 8*8 for othello field
    public Piece[][] pButton;
    
    public Board(int co, int a, int d){ 
    	
     	
    	 try {
             AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(".\\sound\\Kirby.mid").getAbsoluteFile());

             clip2 = AudioSystem.getClip();
             clip2.open(audioInputStream);
             clip2.loop(1);
         } catch(Exception ex) {
             System.out.println("Error with playing sound.");
             ex.printStackTrace();
         }
    	
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(880,700); 
        frame.setLocationRelativeTo(null);
        panel.setLayout(null); 
        panel.setBackground(Color.PINK);         
        
         
        pButton = new Piece[8][8]; 
        
        
        
        
        
        
        
        pass1 = new JButton("pass");
        pass1.setBounds(10,390,80,80);
        pass1.setBackground(new Color(255,255,153));
        pass1.setHorizontalAlignment(JLabel.CENTER);
        pass1.addActionListener(this);
        panel.add(pass1);
        
        pass2 = new JButton("pass");
        pass2.setBounds(770,390,80,80);
        pass2.setBackground(new Color(255,255,153));
        pass2.setHorizontalAlignment(JLabel.CENTER);
        pass2.addActionListener(this);
        panel.add(pass2);
        
        give1 = new JButton("give up");
        give1.setBounds(10,480,80,80);
        give1.setBackground(new Color(255,255,153));
        give1.setHorizontalAlignment(JLabel.CENTER);
        give1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	
        	    gameset.setText("Game set 2p Win");
        	    picwin1.setBounds(5, 0, 80, 150);
        	   
        	    panel1.add(picwin1);
        	   frame1.setVisible(true);
           	   
           	   
              }});
        panel.add(give1);
        
        
        give2 = new JButton("give up");
        give2.setBounds(770,480,80,80);
        give2.setBackground(new Color(255,255,153));
        give2.setHorizontalAlignment(JLabel.CENTER);
        give2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
               
        	  gameset.setText("Game set 1p Win");
        	  picwin.setBounds(5, 0, 80, 150);
        	  panel1.add(picwin);
        	  frame1.setVisible(true);
        }});
        
        panel.add(give2);
        
        turn1.setBounds(10, 300, 80, 80);
        turn1.setBackground(Color.darkGray);
        turn1.setHorizontalAlignment(JLabel.CENTER);
        turn1.setForeground(Color.orange);
        turn1.setFont(new Font("Msgosic", Font.PLAIN, 30)); 
        turn1.setOpaque(true);
        panel.add(turn1);
        
        turn2.setBounds(770, 300, 80, 80);
        turn2.setBackground(Color.darkGray);
        turn2.setHorizontalAlignment(JLabel.CENTER);
        turn2.setForeground(Color.orange);
        turn2.setFont(new Font("Msgosic", Font.PLAIN, 30)); 
        turn2.setOpaque(true);
        panel.add(turn2);
        
        tb.setBackground(Color.BLACK);
        tb.setForeground(Color.GREEN);
        tb.setHorizontalAlignment(JLabel.CENTER);
        tb.setBounds(10,210,80,80);
        panel.add(tb);
        tw.setBackground(Color.WHITE);
        tw.setForeground(Color.GREEN);
        tw.setHorizontalAlignment(JLabel.CENTER);
        tw.setBounds(770,210,80,80);
        panel.add(tw);
        
        
        B.setBounds(10,570,80,80);
        B.setBackground(new Color(255,255,153));
        B.setOpaque(true);
        B.setHorizontalAlignment(JLabel.CENTER);
        B.setVerticalAlignment(JLabel.CENTER);
        B.setFont(new Font("Msgosic", Font.PLAIN, 60)); 
        panel.add(B); 
        W.setBounds(770,570,80,80);
        W.setBackground(new Color(255,255,153));
        W.setOpaque(true);
        W.setHorizontalAlignment(JLabel.CENTER);
        W.setVerticalAlignment(JLabel.CENTER);
        W.setFont(new Font("Msgosic", Font.PLAIN, 60)); 
        panel.add(W);
         
        // Set Character
        if(a==0) {
        pic1 = new JLabel(ima.icon);
        picwin = new JLabel(ima.icon4);
        }
        else if(a==1) {
        pic1 = new JLabel(ima.icon1); 	
        picwin = new JLabel(ima.icon3);
        }
        else {
        pic1 = new JLabel(ima.icon2);
        picwin = new JLabel(ima.icon5);
        }
	        	
        pic1.setBounds(10,10,80,150);
        panel.add( pic1); 
      
        if(d==1) {
        pic2 = new JLabel(ima.icon1);
        picwin1 = new JLabel(ima.icon3);
        }
        else if(d==0) {
        pic2 = new JLabel(ima.icon);
        picwin1 = new JLabel(ima.icon4);
        }
        else {
        pic2 = new JLabel(ima.icon2);
        picwin1 = new JLabel(ima.icon5);
        
        }
        pic2.setBounds(770,10,80,150);
        panel.add( pic2); 
         
        frame1 = new JFrame("Game set");
   	    frame1.setBounds( 100, 30, 220, 220);
   	    frame1.setLocationRelativeTo(null);
  	    panel1 = new JPanel();
  	    panel1.setLayout(null);
  	   
  	   
  	   
  	   
  	    retry.setBounds(0, 130, 100, 60);
  	    retry.setText("Retry");
  	    retry.setBackground(Color.orange);
  	    retry.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
               clip2.stop();
          	   frame.setVisible(false);
          	 
          	   game game = new game(co,a,d);
          	   frame1.setVisible(false);
          	   
         }});
  	    panel1.add(retry);
  	   
  	   
  	    back.setBounds(110, 130, 100, 60);
	  	back.setText("back");
	  	back.setBackground(Color.orange);
	  	back.addActionListener(new ActionListener() {
	           public void actionPerformed(ActionEvent e) {
	              // ac.stop();
	        	   clip2.stop();
	        	   frame.setVisible(false);
	        	   frame1.setVisible(false);
	        	   Startmenu s = new Startmenu();
	        	   s.setVisible(true);
	           }});
		panel1.add(back);
	   

	  	gameset = new JTextField();
	  	gameset.setBounds(90,20,100,80);
	  	panel1.add(gameset);  
	  	frame1.getContentPane().add(panel1);
	  	frame1.setVisible(false);
         
        // Set board color
        switch(co) {
        case 0:
    	c = new Color(255, 128, 128);
        break;
        case 1:
    	c = new Color(51,153,102);
        break;
        case 2:
    	c = new Color(0,102,204);
        break;
        case 3:
    	c = new Color(192,192,192);
        break;
        }
       
        // Setup 64 button of othello board
        for(int i=0; i<64; i++) 
        { 
            int x = i/8; 
            int y = i%8; 
             
            pButton[x][y] = new Piece(); 
            pButton[x][y].setSize(80,80); 
            pButton[x][y].setBounds(x*80+110, y*80+10, 80, 80); 
            pButton[x][y].setMargin(new Insets(0,0,0,0)); 
            pButton[x][y].setBackground(c); 
            pButton[x][y].setFont(new Font("Msgosic", Font.PLAIN, 60)); 
            pButton[x][y].setActionCommand(String.valueOf(i));            
            pButton[x][y].addActionListener(this); 
            panel.add(pButton[x][y]); 
        } 
        
        give2.setEnabled(false);
        pass2.setEnabled(false);
        give1.setEnabled(true);
        pass1.setEnabled(true);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        
    } 
     
    
    // Process any action of button
    public void actionPerformed(ActionEvent e) { 
    	
    	Thread t = new Thread(new Runnable(){
	        public void run(){
		        pblack = 0;
		        pwhite = 0;
		          
		        if(e.getSource() == pass1 || e.getSource()== pass2) {
		        	turn();
		        }else {
			        String str = e.getActionCommand();       
			        System.out.println(str); 
			        int data = Integer.parseInt(str); 
			        int x = data/8; 
			        int y = data%8; 
			        int a= -1;
			        int b= -1;
			        int cput=0;
			        for(int i=0; i<9; i++) {
			        	int sa = x+1+a;
			            int sb = y+1+b;
			        	while(Piece.p[sa][sb]==Piece.unturn) {
			        		sa += a;
			        		sb += b;
			        		if(Piece.p[sa][sb]==Piece.turn) {
			        			cput =1;
			        		}	
			        	}
		        	
			        	if(i%3==2 && i !=0) {
			        		a = a+1;
			        		b = -1;
			        	}else {
			        		b +=1;
			        	}
			        }
			
		
			        if(Piece.p[x+1][y+1] == 0 && cput==1 && Piece.p[x+1][y+1] !=Piece.turn) 
			        {             
			            Piece.p[x+1][y+1] = Piece.turn; 
			            Piece.doRev(x+1,y+1); 
			            putPiece(); 
			         
			            turn();
			            count++;
			        } 
			        if(count==64) {
			    	    if(pblack>pwhite) {
			    	    	gameset.setText("Game set 1P Win");
			    	    	 picwin.setBounds(5, 0, 80, 150);
			         	     panel1.add(picwin);
			    	    	
			    	    }
			    	    else if(pwhite>pblack) {
			    	    	gameset.setText("Game set 2P Win");
			    	    	picwin1.setBounds(5, 0, 80, 150);
			         	    panel1.add(picwin1);
			    	    }
			    	    else {
			    	    	ImageIcon icon6 = new ImageIcon(".\\src\\ot\\draw.gif");
			    	    	 JLabel picdraw = new JLabel(icon6);
			    	    	 picdraw.setBounds(5, 0, 80, 150);
			    	    	 panel1.add(picdraw);
			    	    	gameset.setText("Game set draw");
			    	    }
			    	    frame1.setVisible(true);
			        }
		    
		        } 
	        }
        });
    	t.start();
    }

    public void putPiece(){ 
         
        for(int i=0; i<100; i++) 
        { 
            int x = i/10; 
            int y = i%10; 
            
            if(Piece.p[x][y] == Piece.BLACK) 
            { 
                pButton[x-1][y-1].setText("●");
                pblack++;
                B.setText(String.valueOf(pblack));
            
                
            } 
            else if(Piece.p[x][y] == Piece.WHITE) 
            { 
                pButton[x-1][y-1].setText("○");
                pwhite++;
                W.setText(String.valueOf(pwhite));
           
            } 
            
            
            
        } 
         
    } 
    private void playsound(String str) {
    	 try {
             AudioInputStream audioInputStream1 = AudioSystem.getAudioInputStream(new File(str).getAbsoluteFile());
             audio1 = AudioSystem.getClip();
             audio1.open(audioInputStream1);
             audio1.start();
         } catch(Exception ex) {
             System.out.println("Error with playing sound.");
             ex.printStackTrace();
         }
    	
    }

    public void turn() {
    	
    	if(Piece.turn == Piece.BLACK){ 
    		Piece.turn = Piece.WHITE; 
            Piece.unturn = Piece.BLACK;
            turn1.setText("Wait");
          	turn2.setText("You");
            give2.setEnabled(true);
            pass2.setEnabled(true);
            give1.setEnabled(false);
            pass1.setEnabled(false);
            playsound(".//sound//v1.wav");
        }else{ 
        	Piece.turn = Piece.BLACK; 
            Piece.unturn = Piece.WHITE;
            turn1.setText("You");
          	turn2.setText("wait");
            give2.setEnabled(false);
            pass2.setEnabled(false);
            give1.setEnabled(true);
            pass1.setEnabled(true);
            playsound(".//sound//v2.wav");
        } 
    	
    	
    }
    
    
    
} 

