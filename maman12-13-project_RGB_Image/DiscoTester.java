/**
 * User: EA
 * Date: 13/09/12
 * Time: 19:07
 */
public class DiscoTester {
    public static void main(String[] args) {
        System.out.println("Welcome to Disco tester");
        LightBulb lightBulb1 = new LightBulb(new RGBColor());
        LightBulb lightBulb2 = new LightBulb(new RGBColor(255, 255, 255));
        LightBulb lightBulb3 = new LightBulb(127, 127, 0);
        LightBulb lightBulb4 = new LightBulb(lightBulb3.getColor());

        Disco disco = new Disco(lightBulb1, lightBulb2, lightBulb3, lightBulb4);
        
        LightBulb l1 = disco.getFirstBulb();
        LightBulb l2 = disco.getSecondBulb();
        LightBulb l3 = disco.getThirdBulb();
        LightBulb l4 = disco.getFourthBulb();
        
        System.out.println("1) Are all on? "+disco.areAllOn());
        System.out.println("2) Are all off? "+disco.areAllOff());

        disco.turnAllOn();
        System.out.println("3) Are all on after turning all on? "+disco.areAllOn());
        System.out.println("4) Are all off after turning all on? "+disco.areAllOff());
        disco.switchBulb(1);
        System.out.println("5) Are all on after turning all on and switching  bulb 1? "+disco.areAllOn());
        System.out.println("6) Are all off after turning all on and switching  bulb 1? "+disco.areAllOff());
        disco.turnAllOff();

        System.out.println("7) Are all same color? "+disco.allSameColor());
        System.out.println("Good luck!");

    }
}
