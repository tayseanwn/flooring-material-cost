package flooringMaterials;
public class Tile extends Plank{
	//This class is a subclass of Plank with the key difference that the tiles are square.  
	
	
	public Tile(String name, int tI, double p)  {
		
		/*
		 * since tile is a subclass of plank than we can use the 
		 * constructor without creating new instance variables
		 */
		super(name, tI, tI, p);
		this.setType("tile");
	}
	
	public String toString() {
		
		/*
		 * I created a conditional print statement in Plank
		 * this additional statement prevented me from 
		 * using Override and writing a new print statement here
		 */
		
		String print = super.toString();
		
		return print;
		
		//Flooring-tile ceramic @3.5 per 1' by 1'
		
		}
//	Takes the material name, a side length of the tile in inches, and the price per tile (be aware: this is not per square inch)
//	This type of flooring must be set as “tile”
//	Note: the toString() does not need to be overridden (what does that imply about the toString() of Plank?)


}
