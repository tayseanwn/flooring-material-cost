package flooringMaterials;

public class QuoteTable {
	
	
	private Flooring[] option;
	private int lengthInch;
	private int widthInch;
	private double markup;
	
	public QuoteTable(Flooring[] flooring, int l, int w, double mc) {
		option = flooring;
		lengthInch = l;
		widthInch = w;
		markup = mc;
		
	}
//			Takes an array of Flooring, the length of the floor in inches, the
//			width of the floor in inches, and the contractors’ markup/commission.
			
			
	public void setOptions(Flooring[] floor) {
		option = floor;
	}
//			A setter method for option.
			
			
	public void setLength(int l) {
		lengthInch = l;
	}
//			A setter method for lengthInch.
			
			
	public void setWidth(int w) {
		widthInch = w;
	}
//			A setter method for widthInch.
			
			
	public void setMarkup(double mc) {
		markup = mc;
	}
//			A setter method for markup
			
			
	/*
	 * Simple method
	 * We will use the quoteCents from Flooring method to get the quote in cents
	 * We then use a for loop to check each quotecents in the array to get the cheapest
	 */
	
	public int getCheapestValue() {
				
		int cheapest = option[0].quoteCents(lengthInch, widthInch, markup);
		int ind = 0;
		
		int printind = 0;
		int printcheap = 0;
		
		for (int i = 0; option.length > i; i++) {
			ind = option[i].quoteCents(lengthInch, widthInch, markup);

			if (ind < cheapest) {
				cheapest = ind;
			}
			
		}
		
		return cheapest;
		
	}
//			Determines and returns the price in cents of the cheapest option
			
	/*
	 * same as the cheapest method instead we compare the wasteratio method
	 */
			
	public double getCleanestValue() {
		
		double cheapest = option[0].wasteRatio(lengthInch, widthInch);
		double ind = 0;
		
		for (int i = 0; option.length > i; i++) {
			ind = option[i].wasteRatio(lengthInch, widthInch);

			if (ind < cheapest) {
				cheapest = ind;
			}
			
		}
		
		return cheapest;
			
	}
//			Determines and returns the waste ratio of the cleanest option (in terms of waste)



	private static String displayHundredths(int hundredths) {
		return hundredths / 100 + "." + (hundredths / 10 % 10) + "" + hundredths % 10;
	}

	public String display() {
		String out = "For a floor " + Flooring.toFeet(lengthInch) + " by " + Flooring.toFeet(widthInch) + "\n\n";
        
        int cheapestValue = getCheapestValue();
        double cleanestValue = getCleanestValue();
		
		out += "Material\tWaste\tCost\n";
		out += "--------\t-----\t----\n";
		for (int i = 0; i < option.length; i++) {
			double waste = option[i].wasteRatio(lengthInch, widthInch);
			int cost = option[i].quoteCents(lengthInch, widthInch, markup);

			out += option[i].getType() + "-";
			out += option[i].getMaterial() + "\t";
			out += displayHundredths((int) (10000 * waste)) + "%\t";
			out += "$" + displayHundredths(cost);
			if (waste == cleanestValue)
				out += " Eco";
			if (cost == cheapestValue)
				out += " $$";
			out += "\n";
		}
		return out;
	}
}
