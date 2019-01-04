/**
 * class LightBulb , consists of a color and state which defines if the bulb is switched on or off. 
 * 
 * @author Dmitriy Chudnovsky 
 * @version 10/04/16
 */
public class LightBulb {
    private RGBColor _color;
    private boolean _switchedOn;
    
    /**
     * Construct a new LightBulb with the given color component values. The switch is initialized to false.
     * If one (or more) of the given values is illegal (not in the range 0-255), it constructs a black RGBColor object. 
     * @param red - The red color component value.
     * @param green - The green color component value.
     * @param blue - The blue color component value.
     */
    public LightBulb(int red, int green,int blue){
        _switchedOn=false;
		if ((red < 0)||(red > 255)||(green < 0)||(green > 255)||(blue < 0)
				||(blue > 255)){
			_color = new RGBColor();
		}
		else {
			_color = new RGBColor(red, green, blue);
		}
	
    }
    
    /**
     * Construct a new LightBulb with a given color.
     * The switch is initialized to false. Assumes the given color is not null. 
     * @param color - The RGBColor to use for this LightBulb.
     */
  public LightBulb(RGBColor color){
       _color = new RGBColor(color);
    }
    
    
    /**
     * Construct a new LightBulb which is a copy of the given bulb.
     * Assumes the given bulb is not null.
     * @param other - The LightBulb to copy.
     */
    public LightBulb(LightBulb other){
       _color = new RGBColor(other._color);
    }
    
    /**
     * Returns the color component of this bulb. 
     * @return The color component of this bulb.
     */
    public RGBColor getColor(){
        return this._color;
    } 
    
    /**
     * Sets the color component of this LightBulb. 
     * @param color - The color component to set.
     */
    public void setColor(RGBColor color){
        this._color = new RGBColor(color);
    }
    
    /**
     *Returns true if this bulb is switched on.
     *Otherwise, returns false.
     *@return true if the bulb is switched on.
     */
    public boolean isSwitchedOn(){
       return _switchedOn;
    }
    
    /**
     *  Changes the switch situation from true to false and vice versa. 
     */
    public void switchLight(){
         _switchedOn = !_switchedOn;
    }
    
    /**
     *Returns a string representation of this LightBulb.
     *For example (255,127,0) On 
     *@return A string representation of this LightBulb.
     */
    public String toString()
    {
        if(_switchedOn)
            return _color + " On";
        else
            return _color + " Off";
    }
}