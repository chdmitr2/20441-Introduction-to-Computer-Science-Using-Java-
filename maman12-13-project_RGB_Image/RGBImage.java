/**
 * This class represents a pixels of image.
 * In every pixel puts the color in the end we built the image.
 * @author Dmitriy Chudnovsky 
 * @version 01/05/16
 */
public class RGBImage {

	private RGBColor[][] _pixels;//this array store the pixels of the image
	
	 /**
	 * Construct a pixels with black color.
	 * @param rows the width of the new image.
     * @param cols the height of the new image.
	 */
	  public RGBImage(int rows, int cols){  
	      _pixels=new RGBColor[rows][cols];//define the limits of array
	      for(int i=0;i<rows;i++){//this loop put in each pixel black color
	          for(int j=0;j<cols;j++){
	              _pixels[i][j]=new RGBColor();//take black color from RGBcolor class
	           }//inner for 
	       }//for
	   }//end of constructor
	   
	 /**
	 * Construct a new RGBImage array of pixels.
	 * @param pixels is a part of the new image.
	 */
	   public RGBImage(RGBColor[][] pixels){
	       _pixels=pixels;
	       RGBColor[][] _pixels=new RGBColor[getHeight()][getWidth()];//define a new array
	       for(int i=0;i<getHeight();i++){//this loop put in each pixel color
	          for(int j=0;j<getWidth();j++){
	              pixels[i][j]=new RGBColor(pixels[i][j]);//take color from RGBColor class
	           }//inner for
	       }//for
	   }//end of constructor  
	   
	 /** 
	 * Construct a copy of RGBImage array  of pixels.
	 * @param other copy a pixel and put in copy array.
	 */
	    RGBImage(RGBImage other) {
        _pixels=other.toRGBColorArray();//make copy of pixel
     }
    
     /**
     * return  array of the pixels.  
     * @return array of the pixels. 
     */
     public RGBColor[][] toRGBColorArray(){
        RGBColor[][] copyPixels = new RGBColor[getHeight()][getWidth()];//define new array which to make copy
        for(int i=0;i<getHeight();i++){//this loop pass each pixel take from value and copy in copy array in the same place
            for(int j=0;j<getWidth();j++){
               copyPixels[i][j]=new RGBColor(_pixels[i][j]);
                  }//inner for
               } //for
               return copyPixels;
     }//toRGBColorArray
    
     /**
     * Gets the rows  of the array.
     * @return the rows of the array.
     */
	   public int getHeight(){
	       return _pixels.length;//rows of array
	   }
	   
	 /**
     * Gets the columns  of the array.
     * @return the columns of the array.
     */
	   public int getWidth(){
	       return _pixels[0].length;//columns of array
	   }
	   
	 /** 
     * Gets a values from the pixel located in spesific row and column that we enter.
     * @param rows in which pixel is located.
     * @param column in which pixel is located.
     * @return a pixel located with specific row and column. Return black color
     * if we enter row and column abroad of array.
     */
	   public RGBColor getPixel(int row,int col){
	       if(row>getHeight() || col>getWidth())//check if pixel enter in limits of array
	        return new RGBColor();//return black color if pixel is not in the limits of array
	      else
	      return new RGBColor(_pixels[row][col]);//return the pixel that we choose
	   }//getPixel
	   
	 /** 
     * Sets a values to pixel located in spesific row and column that we need.
     * @param rows in which pixel is to be set.
     * @param column in which pixel is to be set.
     * @param pixel with his address [row][column] in which we set values. 
     * @return to main if pixel is not in the limits of array.
     */
	   public void setPixel(int row,int col,RGBColor pixel){
	      if(row>getHeight() || col>getWidth())//check limits of array
	         return;//if out of limit back to main
	      else
	      _pixels[row][col]=new RGBColor(pixel);//set pixel that we define in main
	   }//setPixel
	   
	 /** 
     * Compared if two images equals.
     * @param other compared with pixel.
     * @return true if images equals and false if not.
     */
	   public boolean equals(RGBImage other){
	     if(!(getHeight()==other.getHeight())||!(getWidth()==other.getWidth())){//check if limits of array ot two images is same
	          return false;//if not same return false else continue
	          }//if
         for(int i=0 ; i<getHeight(); i++){ //the loop check each pixel if it same
            for(int j=0 ; j<getWidth(); j++){
                if ( !_pixels[i][j].equals(other._pixels[i][j]) ){//equals in RGBColor class
                    return false ; 
                    }//if
                   }//inner for
                    }//for
                  return true;
         }  //equals 
         
     /** 
     * Invert each pixel in array.
     */
	   public void invertColors(){
	       for(int i=0;i<getHeight();i++){//this loop pass each pixel in array and invert him
	          for(int j=0;j<getWidth();j++){
	              _pixels[i][j].invert();//invert in RGBColor class
	           }//inner for
	       }//for
	   }//invertColors
	   
	 /** 
     * Return grayscale of the image.
     * @return grayscale of the image.
     */
	   public double[][] toGrayscaleArray(){
	       double[][] gray=new double[getHeight()][getWidth()];//define new double array
	       for(int i=0;i<getHeight();i++){//this loop change each pixel to gray
	          for(int j=0;j<getWidth();j++){
	             gray[i][j]=_pixels[i][j].convertToGrayscale();//convert to grayscale in RGBColor class
	           }//inner for
	       }//for
	       return gray;
	   }//toGrayscaleArray()
	   
	 /**
	 * Flips the image on it's vertical axis.
	 * First row will be last and last row will be first
	 * Second row will be second before the end 
	 * and row second before end will be second row
	 * and so on
	 * Need only rows
	 */
	   public void flipVertical(){
	        int a=getHeight()/2,b=getHeight()%2;//a+b give us getHeight()
        for(int i=0;i<a;i++) {//this loop make vertical axis
            RGBColor vflip[] = _pixels[a-i-1];//take row of pixels and and change them position
            _pixels[a-i-1]=_pixels[a+i+b];//change his position(if first-put last...)
            _pixels[a+i+b] = vflip;//put values in pixel of our image
        }//for
	   }//flipVertical()
	   
	 /**
	 * Flips the image on it's horizontal axis.
	 * First column will be last and last column will be first.
	 * Second column will be second before the end 
	 * and column second before end will be second column
	 * and so on.
	 * Need rows and columns. 
	 */
	   public void  flipHorizontal(){
	    int a=getWidth()/2, b=getWidth()%2;//a+b give us getWidth()
        for(int i=0;i<getHeight();i++)//this loop make horizontal axis
            for(int j=0;j<a;j++) {//this loop take each pixel and change his position 
                RGBColor gflip = _pixels[i][a-j-1];//take each column and change his position each pixel
                _pixels[i][a-j-1] = _pixels[i][a+j+b];////change his position(if first-put last...)
                _pixels[i][a+j+b] = gflip;//put values in pixel of our image
            }//for
	   }//flipHorizontal()
	   
	 /** 
     * To move array right of left.
     * When value of offset larger when columns do nothing.
     * When value of offset greater or equal to columns shift right.
     * When value of offset less to columns shift left.
     * @param offset how many steps to make array left or right.
     * @return to main program.
     */
	   public void shiftCol(int offset){  
        if(offset>getWidth())//do nothing if value of offset equal or larger when columns
            return;//do nothing go to main
        
        if(offset>=0) {//when offset equal or larger when 0
            for(int i=0;i<getHeight();i++){//this loop shift right array
                for(int j=getWidth()-1;j>=offset;j--)
                    _pixels[i][j] = _pixels[i][j-offset];//shift right
                
                for(int j=0;j<offset&&j<getWidth();j++)//this loop change to black colors the new columns after shift
                    _pixels[i][j] = new RGBColor();//change in RGBColor class
            }//for
            return;//do nothing go to main
        }//if
        
        if(offset+getWidth()<0) //when offset less when 0
            offset = -getWidth();//when it happen in loop array stay on the same place
            
        for(int i = 0; i<getHeight();i++) {//this loop shift left array
            for(int j=0;j<=getWidth()+offset-1;j++)//if offset+getWidth()<0 donwt shift else shift left
                _pixels[i][j] = _pixels[i][j-offset];//shift right
            
            for(int j=getWidth()+offset;j<getWidth();j++)//this loop change to black colors the new columns after shift
                _pixels[i][j] = new RGBColor();//change in RGBColor class
        }//for
     }//shiftCol
    
     /** 
     * To move array up of down.
     * When value of offset larger when rows do nothing.
     * When value of offset greater or equal to rows - up.
     * When value of offset less to rows - down.
     * @param offset how many steps to make array up or down.
     * @return to main program.
     */
       public void shiftRow(int offset) {
        if(offset>getHeight()) //do nothing if value of offset equal or larger when rows
            return;//do nothing go to main
        
        if(offset>=0) {//when offset equal or larger when 0
            for(int i=getHeight()-1;i>=offset;i--)//this loop up array
                _pixels[i]=_pixels[i-offset];
        
            for(int i=0;i<offset&&i<getHeight();i++) {//this loop take rows and columns to change each pixel
                _pixels[i]=new RGBColor[getWidth()];//change in RGBColor class
                for(int j=0;j<getWidth();j++)//change to black colors each pixel after up
                    _pixels[i][j]=new RGBColor();//change in RGBColor class
            }
            return;//do nothing go to main
        }

        if(offset+getHeight()<0) //when offset less when 0
            offset = -getHeight();//when it happen in loop array stay on the same place
        
        for(int i=0;i<=getHeight()+offset-1;i++)//this loop down array
            _pixels[i]=_pixels[i-offset];
        
        for(int i=getHeight()+offset;i<getHeight();i++) {//this loop take rows and columns to change each pixel
            _pixels[i]=new RGBColor[getWidth()];//change in RGBColor class
            for(int j=0;j<getWidth();j++)////change to black colors each pixel after down
                _pixels[i][j]=new RGBColor();//change in RGBColor class
        }

     }
    
     /**
	 * Rotates the image 90 degrees to the right.
	 */
         public void rotateClockwise() {
        RGBColor[][] leftRotate = new RGBColor[getWidth()][getHeight()];//define new array
        for(int i=0;i<getHeight();i++)//this loop change paces of pixels
            for(int j=0;j<getWidth();j++)//rows=colums and columns=rows
               leftRotate[j][getHeight()-i-1] = _pixels[i][j];
               int clock1 = getWidth(); 
               int clock2 = getHeight();
               clock2 = clock1;
               _pixels = leftRotate;//pixels [][] take new array after clockwise/**
     }//rotateClockwise()

     /**
	 * Rotates the image 90 degrees to the left.
	 */
     public void rotateCounterClockwise() {
        rotateClockwise();//rotate 90 degrees right
        rotateClockwise();//rotate 90 degrees right
        rotateClockwise();//rotate 90 degrees right,after 3 times it's like 90 degrees left
     }//rotateCounterClockwise()
    
     /**
	 * Returns a string representation of pixel. 
	 * For example (0,0,0) 
	 * @return string representation of pixel.
	 */
	 public String toString() {
		String value = "";
		for (int i=0; i<getHeight();i++) {//this loop print each pixel
			for (int j=0; j<getWidth();j++) {
				if (j!= getWidth() - 1) {
					value += _pixels[i][j].toString() + " ";//print from RGBColor class
				} else {
					value += _pixels[i][j].toString() + "\n";

				}//if
			}//inner for

		}//for
		return value;
	 }//toString
}
