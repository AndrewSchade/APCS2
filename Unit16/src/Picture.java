
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void keepOnlyBlue()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray : pixels)
	  {
		  for(Pixel pixelObj : rowArray)
		  {
			  pixelObj.setGreen(0);
			  pixelObj.setRed(0);
		  }
	  }
  }
  
  public void keepOnlyRed()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray : pixels)
	  {
		  for(Pixel pixelObj : rowArray)
		  {
			  pixelObj.setGreen(0);
			  pixelObj.setBlue(0);
		  }
	  }
  }
  public void keepOnlyGreen(){
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray : pixels)
	  {
		  for(Pixel pixelObj : rowArray)
		  {
			  pixelObj.setBlue(0);
			  pixelObj.setRed(0);
		  }
	  }
  }
  
  public void negate()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray : pixels)
	  {
		  for(Pixel pixelObj : rowArray)
		  {
			  pixelObj.setBlue(255-pixelObj.getBlue());
			  pixelObj.setGreen(255-pixelObj.getGreen());
			  pixelObj.setRed(255-pixelObj.getRed());		  }
	  }
  }
  
  public void grayscale()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray : pixels)
	  {
		  for(Pixel pixelObj : rowArray)
		  {
			  int average = (int)pixelObj.getAverage();
			  pixelObj.setBlue(average);
			  pixelObj.setGreen(average);
			  pixelObj.setRed(average);		  }
	  }
  }
  
  public void fixUnderwater()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray : pixels)
	  {
		  for(Pixel pixelObj : rowArray)
		  {
			  if(!(pixelObj.getBlue() > 155 && pixelObj.getGreen() < 170 && pixelObj.getRed() < 25))
			  {
						  int average = (int)pixelObj.getAverage();
						  pixelObj.setBlue(average);
						  pixelObj.setGreen(average);
						  pixelObj.setRed(average);	  
			  }
			  }
	  }
  }
  
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println(count);
  }
  public void mirrorArms()
  {
    int mirrorPoint = 204;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    Pixel[][] pixelscopy = this.getPixels2D();
    
    // loop through the rows
    for (int row = 170; row < 191; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 102; col < 170; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
        Pixel set = pixels[row+40][mirrorPoint - col + mirrorPoint];
        set.setColor(leftPixel.getColor());
   
        count++;
      }
    }
    
    for (int row = 175; row < 194; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 292; col > 239; col--)
      {
        
        rightPixel = pixels[row][col];      
        leftPixel = pixels[row][mirrorPoint - col + mirrorPoint];
        Pixel set = pixels[row+40][mirrorPoint - col + mirrorPoint];
        set.setColor(rightPixel.getColor());
   
        count++;
      }
    }
    
    
    
    System.out.println(count);
  }
  
  public void mirrorGull()
  {
	  int mirrorPoint = 350;
	    Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    int count = 0;
	    Pixel[][] pixels = this.getPixels2D();
	    
	    // loop through the rows
	    for (int row = 220; row < 350; row++)
	    {
	      // loop from 13 to just before the mirror point
	      for (int col = 230; col < mirrorPoint; col++)
	      {
	        
	        leftPixel = pixels[row][col];      
	        rightPixel = pixels[row]                       
	                         [mirrorPoint - col + mirrorPoint];
	        rightPixel.setColor(leftPixel.getColor());
	        count++;
	      }
	    }
	    System.out.println(count);
	  
  }
  
  public void mirrorDiag(){
			Pixel origPixel = null;
			Pixel newPixel = null;
			Pixel[][] pixels = this.getPixels2D();

			for (int row = 0; row < pixels.length; row++) {
				for (int col = 0; col < pixels[0].length; col++) {
					if (col < pixels.length && row < pixels[0].length) {
						origPixel = pixels[col][row];
						newPixel = pixels[row][col];
						newPixel.setColor(origPixel.getColor());
					}
				}
			}
		
  }
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  public void blur(int x, int y, int w, int h)
  {
	  System.out.println("Andrew Schade" + "\n" + "Period 2" + "\n" + "4/24/2018");
	  Pixel[][] pixels = this.getPixels2D();
	  for(int col = x; col < x+w; col ++)
	  {
		  for(int row = y; row < y+h; row ++)
		  {
			  if(row>0 && col>0){
			  pixels[row][col].setGreen(
					   (pixels[row-1][col].getGreen() + pixels[row+1][col].getGreen()
					  + pixels[row][col+1].getGreen() + pixels[row][col-1].getGreen())/4);
			  pixels[row][col].setRed((pixels[row-1][col].getRed() + pixels[row+1][col].getRed()
					  + pixels[row][col+1].getRed() + pixels[row][col-1].getRed())/4);
			  pixels[row][col].setBlue((pixels[row-1][col].getBlue() + pixels[row+1][col].getBlue()
					  + pixels[row][col+1].getBlue() + pixels[row][col-1].getBlue())/4);
		  }
		  }  
	  }
  }
  public void encode(Picture messagePict)
  {
	  
	  Pixel[][] messagePixels = messagePict.getPixels2D();
	  Pixel[][] currPixels = this.getPixels2D();
	  Pixel currPixel = null;
	  Pixel messagePixel = null;
	  
	  
	 int count = 0;
//	 int msgRow = 0;
//	 int msgCol = 0;
//		  	for (int row = 0; row < this.getHeight(); row++)
//	  	{
//		  		if(!(msgRow < this.getHeight()))
//	  				break;
//	  		for (int col = 0; col < this.getWidth(); col++)
//	  		{
//	  			if(!(msgRow < this.getHeight()))
//	  				break;
//  			currPixel = currPixels[row][col];
//  		
//  		
//  			if (currPixel.getRed() % 2 == 1)
//  				 currPixel.setRed(currPixel.getRed() - 1);
//  			if(currPixel.getBlue() %2 == 1)
//  				currPixel.setBlue(currPixel.getBlue()-1);
//  			int distance = 0;
//  				
//  		  	if(msgRow > this.getHeight())
//  		  		currPixel.setBlue(currPixel.getBlue()+1);
//  		  		messagePixel = messagePixels[msgRow][msgCol];
//  		  		if (!(messagePixel.colorDistance(Color.BLACK) < 50) && msgCol < this.getHeight())
//		  			{
//		  				while(!(messagePixels[msgRow][msgCol].colorDistance(Color.BLACK)<50) && distance <256){
//		  					distance++;
//		  					msgCol++;
//		  					if(msgCol == this.getWidth()-1) {
//		  						msgCol = 0;
//		  						msgRow++;
//		  					}
//		  					
//		  				}
//		  				
//		  			}
//  		  		else if (messagePixel.colorDistance(Color.BLACK) < 50  && msgCol < this.getHeight())
//  		  			{
//  		  				
//  		  				currPixel.setRed(currPixel.getRed()+1);
//  		  			while((messagePixels[msgRow][msgCol].colorDistance(Color.BLACK)<50)&& distance < 256){
//	  					distance++;
//	  					msgCol++;
//	  					if(msgCol == this.getWidth()-1) {
//	  						msgCol = 0;
//	  						msgRow++;
//	  					}
//	  					
//	  				}
//  		  			}
//  		  		
//  		  		currPixel.setGreen(distance);
//  		  		System.out.println(distance);
//  		  		
//  		  		}
//  		  	}
	 
	 for (int col = 0; col < this.getWidth(); col++){
		 
	 
	 for (int row = 0; row < this.getHeight(); row++)
		  	{
		  		
	  				currPixel = currPixels[row][col];
	  				messagePixel = messagePixels[row][col];
	  				if(!((currPixel.getBlue()*currPixel.getGreen())%4==0)){
	  					if(currPixel.getBlue()%2==1)
	  						currPixel.setBlue(currPixel.getBlue()+1);
	  					if(currPixel.getGreen()%2==1)
	  						currPixel.setGreen(currPixel.getGreen()+1);
	  					}
	  				if(messagePixel.colorDistance(Color.black) < 50)
	  					if(Math.random()*2 == (double)1)
	  					currPixel.setBlue(currPixel.getBlue()-1);
	  					else
	  					currPixel.setGreen(currPixel.getGreen()-1);
	  				}
	  					
	  						
	  					
	  				}
	  				
	  				
	  			
		  		
		  		
  	
  System.out.println(count);
  	}
  
  public Picture decode()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  int height = this.getHeight();
	  int width = this.getWidth();
	  Pixel currPixel = null;
	  Pixel messagePixel = null;
	  Picture messagePicture = new Picture(height,width);
	  Pixel[][] messagePixels = messagePicture.getPixels2D();
	  int count = 0;
//	  int msgRow = 0;
//	  int msgCol = 0;
//	  for (int row = 0; row < height; row++)
//	  {
//		  if(msgRow == height-1) {
//				break;
//	  }
//		  for (int col = 0; col < width; col++)
//		  {
//			  if(msgRow == height-1) {
//					break;
//			  }
//	  		
//			  currPixel = pixels[row][col];
//			  if(currPixel.getBlue()%2 == 0){
//			  if(currPixel.getRed()%2 == 0 && msgCol < this.getHeight()) {
//			  for(int a = 0; a < currPixel.getGreen(); a++) {
//				  if(msgRow == this.getHeight()-1) {
//						break;
//			  }
//				  if(msgCol == 480)
//					  msgCol = 0;
//				  messagePixels[msgRow][msgCol].setColor(Color.white);
//				  if(msgCol < width)
//				  msgCol++;
//				  else
//				  {
//					  msgRow++;
//					  msgCol = 0;
//				  }  
//				  
//			  }
//			  }
//			  else if(currPixel.getRed()%2 == 1 && msgCol < this.getHeight()){
//				  for(int b = 0; b < currPixel.getGreen(); b++) {
//					  if(msgCol >= this.getWidth())
//			  				msgCol = 0;
//					  if(msgRow == this.getHeight()-1) 
//	  						break;
//			  		
//					  messagePixels[msgRow][msgCol].setColor(Color.black);
//					  if(msgCol < width)
//					  msgCol++;
//					  else
//					  {
//						  msgRow++;
//						  msgCol = 0;
//					  }
//					  
//				  
//			  }
//		  }
//			  }
//			  }
//	  }
	  
	  for (int row = 0; row < this.getHeight(); row++)
	  	{
		  for (int col = 0; col < this.getWidth(); col++)
		  {
			  currPixel = pixels[row][col];
			  messagePixel = messagePixels[row][col];
			  if ((currPixel.getBlue()*currPixel.getGreen())%4==0)
			  {
				messagePixel.setColor(Color.WHITE);
				  
			  }
			  else
				  messagePixel.setColor(Color.GREEN);
		  }
	  }
	  System.out.println(count);
	  return messagePicture;
  }
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
}// this } is the end of class Picture, put all new methods before this