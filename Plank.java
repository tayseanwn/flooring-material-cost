package flooringMaterials;

public class Plank extends Flooring{
	
	
	private int plankLengthInch;
	private int plankWidthInch;
	private double plankPrice;
	
	
	public Plank(String name, int lI, int wI, double p) {
		
		super(name, p/(lI*wI));
		//we divide by the area to get the price over the entire
		// we multiply by the area in amountOfMaterial so we divide the area by the price
		// to maintain the correct pricing
		plankLengthInch = lI;
		plankWidthInch = wI;
		plankPrice = p;
		this.setType("plank");
		
		
	}
//			Takes the material name, the length in inches of the plank, 
//			the width in inches of the plank, and the price per plank (be 
//			aware: this is not per square inch)
//			This type of flooring must be set as “plank”
			
		
	@Override
	public int amountOfMaterial(int length, int width) {
		
		/*
		 * Method A
		 * 
		 * determine the long side from the short side
		 * the long side will be used in this method
		 * if the case that the short side was not a factor of the length
		 * then we would of needed to consider additional
		 * unused space
		 */

//		int longSide = 0; int shortSide = 0;
//		if (plankWidthInch > plankLengthInch) {longSide = plankWidthInch; shortSide=plankLengthInch;}
//		else {longSide = plankLengthInch; shortSide = plankWidthInch;}
//		
//		int numindirec1 = (int) Math.ceil((double)length1 / longSide);
//		int numindirec2 = (int) Math.ceil((double)length2 / longSide);
//		
//		int area1 = (numindirec1 * longSide) * length2;
//		int area2 = (numindirec2 * longSide) * length1;
//		
//		if (longSide == shortSide) {
//			if (area1 > area2 ) {
//				return area1;
//			} else {
//				return area2;
//			}
//		}
//		else if (area1 > area2 ) {
//			return area2;
//		} else {
//			return area1;
//		}
		
		
		/*
		 * Method B
		 */
		
		// what is the difference in the case of two directions
		// how many planks would I need when considering my length
		// how many full planks can we fit and then we multiply by that amount
		int lenIndirec1 = (int) Math.ceil((double)length / plankLengthInch) * plankLengthInch;
		int lenIndirec2 = (int) Math.ceil((double)width / plankLengthInch) * plankLengthInch;
		
		// what is the difference in the case of two directions
		// how many planks would I need when considering my width
		// how many full planks can we fit and then we multiply by that amount
		int widIndirec1 = (int) Math.ceil((double)length / plankWidthInch) * plankWidthInch;
		int widIndirec2 = (int) Math.ceil((double)width / plankWidthInch) * plankWidthInch;

		// compare
		// only the case of two will work since we are comparing only length and width
		int area1 = (lenIndirec1 * widIndirec2);
		int area2 = (lenIndirec2 * widIndirec1);
		
		
		if (area1 > area2) {
			return area2;
		} else {
			return area1;
		}

	}
//			Takes a length and a width of the floor in inches
//			All the planks must go in the same direction, whichever uses 
//			the least material. As with the discussion in the introduction, an 
//			integer number of planks widths and planks lengths will be used to 
//			determine the amount of material required. 
//			Returns the amount of material required to cover the floor
			
	@Override	
	public int unusedMaterial(int l, int w) {
		
		/*
		 * We continued to compare the short side and long side
		 */
		
		int material = this.amountOfMaterial(l, w) - super.amountOfMaterial(l, w);
		
		return material;
	}
//			Takes a length and a width of the floor in inches
//			Returns the difference between the amount of plank material 
//			needed and the size of the floor (hint: what is super.amountOfMaterial()?)
			
	@Override		
	public String toString() {
		
		/*
		 * !!!! Check with TA/Prof. about this method
		 * plankLengthInch/12
		 */
		if (plankLengthInch == plankWidthInch) {
			return "Flooring-" + this.getType() + " " + this.getMaterial() + " @" + plankPrice + " per " + plankLengthInch/12 + "' by " + plankWidthInch/12 + "'";
		} else {
		return "Flooring-" + this.getType() + " " + this.getMaterial() + " @" + plankPrice + " per " + plankLengthInch/12 + "' by " + plankWidthInch + "''";
		}
	}
//			Flooring-plank oak @21.02 per 8' by 5''
//			Returns a String representation of a Plank (see TestFlooring for details)



}
