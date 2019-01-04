

public class RGBColorTester
{
  
    public static void main(String[] args)
    {
        // Create three color objects
        RGBColor color1 = new RGBColor(127,0,127);
        RGBColor color2 = new RGBColor(color1);
        RGBColor color3 = new RGBColor();
        
        // Print (test the get method)
        System.out.println("Welcome to RGB Color tester");
        System.out.println("1)color1 R:" + color1.getRed() + " G:" + color1.getGreen() + " B:" + color1.getBlue());
        System.out.println("2)color2 R:" + color2.getRed() + " G:" + color2.getGreen() + " B:" + color2.getBlue());
        System.out.println("3)color3 R:" + color3.getRed() + " G:" + color3.getGreen() + " B:" + color3.getBlue());
        
        // Test the set methods
        color1.setRed(100);
        color1.setGreen(100);
        color1.setBlue(100);
        System.out.println("4) The new color1 is:" + color1);
        
        // Test  mix
        color2.mix(color1);
        System.out.println("5) color1 mixed with color2:" + color2);
        
        // Test  invert
        color1.invert();
        System.out.println("6) color1 inverted:" + color1);
        
        // Test equal
        System.out.println("7) " + color1 + " equals " + color2 + " = " + color1.equals(color2));
        
        // Test convert to grayscale
        System.out.println("8) color1 in grayscale: " + color1.convertToGrayscale());
        System.out.println("Good luck!");
    }
}
