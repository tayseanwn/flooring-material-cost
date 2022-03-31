package flooringMaterials;

public class Roll extends Flooring {
	
	private int rollWidthInch;
	private double rollPricePerInch;
	
	public Roll (String name, int rollWidthInch, double rollPricePerInch) {
		
		super (name, rollPricePerInch/rollWidthInch);
		//because it not per square inch, we divide by the roll width
		
		this.rollWidthInch = rollWidthInch;
		this.rollPricePerInch = rollPricePerInch;
		this.setType("roll");
		
	}
	
	
	
//			Takes the material name, the width in inches of the roll, 
//			and a price per inch of the roll (be aware: this is not per square inch)
//			This type of flooring must be set as “roll”
	
	@Override
	public int amountOfMaterial(int length1, int length2)  {
	
		
		/*
		 * int divided by int
		 * will return an int. so the decimals are not considered
		 * 
		 * 1. so we cast one of the int to a double so we can keep the decimal
		 * 2. then we round up to the highest
		 * 3. finally we cast it back to an integer
		 */
		int numindirec1 = (int) Math.ceil((double)length1 / rollWidthInch);
		int numindirec2 = (int) Math.ceil((double)length2 / rollWidthInch);
		/*
		 * numindirec1 tells me how many rolls I will user
		 * rollWidthInch is width of a single roll
		 * when i multiply the two then i get the total width
		 * I have to multiple to the total width by the length
		 */
		
		int area1 = (numindirec1 * rollWidthInch) * length2;
		
		int area2 = (numindirec2 * rollWidthInch) * length1;
		
		//System.out.print("area1 " + area1);
		//System.out.print("area2"+ area2);
		
		if (area1 > area2) {
			return area2;
		} else {
			return area1;
		}
		
		
		
	}
//			Takes a length and a width of the floor in inches
//			If the floor cannot be rolled out in a single strip, 
//	        then an integer number of strips must be used. The resulting 
//	        rolled floor will have at most one direction of seams. The roll 
//	        can be parallel with the length or the width whichever uses the 
//	        least amount of material.
	
//			Hint: think about rolling the material lengthwise vs. widthwise 
//	        and how much material would be needed for each.
	
//			Hint: the Math.ceil() method can help in these calculations
//			Returns the amount of material required to cover the floor
	
	@Override
	public int unusedMaterial(int l, int w) {
		
		int area = l*w;
		
		return this.amountOfMaterial(l, w) - area;
	}
//			Takes a length and a width of the floor in inches
//			Returns the difference between the amount of rolled 
//	        material needed and the size of the floor (hint: what is 
//	        super.amountOfMaterial()?)
		
	@Override
	public String toString() {
		return "Flooring-" + this.getType() + " " + this.getMaterial() + " @" + rollPricePerInch + " per inch of a " + (int)Math.sqrt(rollWidthInch) + "' roll";
//		print: Flooring-roll linoleum @3.29 per inch of a 12' roll
	}
//			Returns a String representation of a Roll (see TestFlooring for details)
//			Hint: use the toFeet() method to format the width properly



}
