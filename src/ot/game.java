package ot;

import java.applet.AudioClip;

import ot.Board;
import ot.Piece;

public class game extends Board {
	     
      public game(int co, int a, int d) {
    	     super(co, a, d); 
    	     Piece p = new Piece();
     	     Piece.turn = Piece.BLACK; 
             Piece.unturn = Piece.WHITE;
             p.pieceSetting();
        	 putPiece();
    	  
      }
      
      public void putPiece(){
    	  //System.out.println(".");
    	  super.putPiece();
    	  
      }
      
     
      
      
      
}
