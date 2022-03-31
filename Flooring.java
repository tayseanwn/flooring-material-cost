package flooringMaterials;

public class Flooring {
	
	private String type;
	private String materialName;
	private double pricePerSqInch;
	
	
	public Flooring(String materialName, double pricePerSqInch) {
		this.type = "poured";
		this.materialName = materialName;
		this.pricePerSqInch = pricePerSqInch;
	}
//			Initialize each of the instance variables (material and pricePerSqInch) with the corresponding parameters
//			The default flooring is set to type “poured”
			
			
	public String getType() {
		return type;
	}
//			Returns the type
	
	
	public void setType(String type) {
		this.type = type;
	}
//			Sets the type
	
	
	public String getMaterial() {
		return materialName;
	}
//			Returns the material
	
	
	public double getPricePerSqInch() {
		return pricePerSqInch;
	}
//			Returns the pricePerSqInch
	
	
	public int amountOfMaterial(int l, int w) {
		
		return l*w;
	}
//			Takes a length and a width of the floor in inches
//			Returns the amount of material required to cover the floor which in this case is 
//	        calculated by the area of the floor in inches squared
	
	
	public int quoteCents(int l, int w, double mc) {
		
		double price = 0;
		
		int roundpriceincents = 0;
		
		price = this.amountOfMaterial(l, w) * this.getPricePerSqInch();
		
		/*
		 * 1. First we add 1 to markup commission e.g. 0.13 + 1 = 1.13
		 * 2. Second we multiply this by the price
		 * 3. Third we multiply by 100 to change from dollar to cents
		 * 4. Finally we convert it from a double to an integer
		 */
		
		roundpriceincents = (int)Math.ceil((price * (mc + 1)) * 100);
		
		return roundpriceincents;
	}
//			Takes a length and a width of the floor in inches and a markup commission 
//	        which is a factor of the total price of materials (10% for instance).
//			The calculation must factor in the amount of material needed, the price per 
//	        square inch, and the markup.
//			Use Math.ceil() to round up in the case that the quote calculation 
//	        includes a fraction of a cent.
//			Returns the cost of the flooring (in cents)
	
	
	public static String toFeet(int i) {
		
		int feet = 0;
		int inches = 0;
		
		if (i >= 12) {
			feet = i/12;
			inches = i - feet*12;
			if (inches == 0) {
				return feet + "'";
			}
			return feet + "'" + inches + "''";
		} 
		return i + "''";
		
		
		
	}
//			Takes the number of inches
//			Returns a String with the number feet followed by a ‘ and the 
//	        remaining number 
//	        of inches followed by ‘ ‘ (two single quotes)
	
	
	public int unusedMaterial(int l, int w) {

		return 0;
	}
//			Takes a length and a width of the floor in inches
//			Returns the amount of unused material which in 
//	        the case of a poured Flooring is simply 0.
	
	
	public double wasteRatio(int l, int w) {
		
//		double waste = this.unusedMaterial(l, w) / this.amountOfMaterial(l, w);
		
		/*
		 * cast one of the integers to a double
		 * if we divide two integers then we will get a whole number
		 * we are looking for a return that is a double with a remainder
		 * 
		 * initially I used the amountofMaterial method
		 * but instead I added the unusedMaterial to the l*w
		 */
		
		double waste =  (double) unusedMaterial(l, w) / amountOfMaterial(l, w);
		
		return waste;
	}
//			Takes a length and a width of the floor in inches
//			Returns the ratio of the amount of unused material over the total 
//	        of material used. Note: use the Flooring methods in this ratio.
	
	
	public String toString() {
		return "Flooring-" + this.getType() + " " + this.getMaterial() + " @" + this.getPricePerSqInch() + " sq. in";
	}
//			Returns a String representation of this Flooring 
//	        (see TestFlooring for details)
	
	


}
