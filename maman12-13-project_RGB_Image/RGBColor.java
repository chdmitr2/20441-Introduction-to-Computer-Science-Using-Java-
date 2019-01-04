/**
 * This class represents a color, defined by its red, green and blue components. 
 * @author Dmitriy Chudnovsky 
 * @version 10/04/16
 */
public class RGBColor{
    private int _red;
    private int _green;
    private int _blue;
    
    
    /**
	 * Construct a black RGBColor (red = green = blue = 0).
	 */
    public RGBColor() {
        this._red = 0;
        this._green =0;
        this._blue = 0;
    }
    
    /**
	 * Construct a new RGBColor with the given color component values.
	 * If one (or more) of the given values is illegal (not in the range 0-255), 
	 * it constructs a black RGBColor object. 
	 * @param red - The red color component value.
	 * @param green - The green color component value.
	 * @param blue - The blue color component value.
	 */
	 
    public RGBColor(int red, int green, int blue) {
        if((red<0 )|| (red>255)||(green<0 )|| (green>255)||(blue<0 )||(blue>255)){
        this._red = 0;
        this._green = 0;
        this._blue = 0;
    }
    else{
        this._red = red;
        this._green = green;
        this._blue = blue;
    }
}

    /**
	 * Construct a new RGBColor which is a copy of the given color.
	 * Assumes the given color is not null.
	 * @param other - The RGBColor to copy.
	 */
	
    public RGBColor(RGBColor other){
        this._red = other._red;
        this._green = other._green;
        this._blue = other._blue; 
    }
    
    /** 
     * Returns the red color component value of this RGBColor. 
     * @return The red color component value of this RGBColor.
     */ 
	  public int getRed(){
		return this._red;
	}
	
	/** 
	 * Returns the green color component value of this RGBColor.  
	 * @return The green color component value of this RGBColor.
	 */
	  public int getGreen(){
		return this._green;
	}
	
	/** 
	 * Returns the blue color component value of this RGBColor.  
	 * @return The blue color component value of this RGBColor.
	 */ 
	  public int getBlue(){
		return this._blue;
	}
	
	/** 
	 * Sets the red color component value of this RGBColor. 
	 * If the given value is not legal (in the range 0-255) the color remains unchanged. 
	 * @param redToSet - The red color component value to set.
	 */
	  public void setRed(int redToSet){
	      if((redToSet<0 )|| (redToSet>255))
	      this._red = this._red ;
	      else
		this._red = redToSet;
	}
	
	/** 
	 * Sets the green color component value of this RGBColor. 
	 * If the given value is not legal (in the range 0-255) the color remains unchanged. 
	 * @param greenToSet - The green color component value to set.
	 */
	  public void setGreen(int greenToSet){
		if((greenToSet<0 )|| (greenToSet>255))
	      this._green= this._green ;
	      else
		this._green= greenToSet;
	}
	
	/** 
	 * Sets the blue color component value of this RGBColor. 
	 * If the given value is not legal (in the range 0-255) the color remains unchanged. 
	 * @param blueToSet - The blue color component value to set.
	 */
	  public void  setBlue(int blueToSet){
		if((blueToSet<0 )|| (blueToSet>255))
	      this._blue= this._blue ;
	      else
		this._blue= blueToSet;
	}
	
	/**
	* Returns a string representation of this RGB triplet. 
	* For example (255,127,0) 
	* @return string representation of this RGB triplet.
	*/
	public String toString() {
		return "("+this._red+"," + this._green + "," +this._blue+")";
	}
	
	         
    /** 
     *  Compares this and other color. 
     *  Returns true if this and other are the same RGBcolor, i.e. have the same red, green amd blue components.
     *  Assumes the given bulb is not null. 
     *  @param other - The color to compare this color to. 
     *  @return true if the RGBColors are equal, otherwise false.
     */
    public boolean equals(RGBColor other){

        if (_red<other._red || (_red==other._red && _green<other._green) || (_red==other._red && _green==other._green && _blue<other._blue))
            return true;
        return false;
    }
    
    /**
	 * Changes this color to be a mix of this and other RGBColors. 
	 * The mixed color is simply the average (over the red, green and blue components) of this and other colors. 
	 * In case the average is fractional (e.g. 113.5) you should take only the integer part as the new value (e.g. 113).
	 * For examle if this color is red - (255,0,0) and other color is green - (0,255,0) after mix operation this color will be yellow = (127,127,0).
	 * Assumes the given color is not null. 
	 * @param other - The other color.
	 */
    public void mix (RGBColor other){
       _red=(int)((_red+other._red)/2);
       _green=(int)((_green+other._green)/2);
       _blue=(int)((_blue+other._blue)/2);
    }
    
    /**
	 * Returns the grayscale value of this RGBColor. 
	 * The grayscale value is defined as 30% the red value + 59% of the green value and 11% of the blue value. 
	 * @return true if the RGBColors are equal, otherwise false.
	 */
    public double convertToGrayscale(){
        return (double)(_red*0.3+_green*0.59+_blue*0.11);
    }
    
    /**
	 * Inverts the color of this RGBColor, by replacing each component value with its complement relative to 255. 
	 * For example, RGB values of (0,1,2) would be changed to (255,254,253). 
	 */
    public void invert(){
        _red=255-_red;
        _green=255-_green;
        _blue=255-_blue;
    }
    
}