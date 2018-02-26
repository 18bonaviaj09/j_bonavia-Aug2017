
public class MakeShape {

	public static void main(String[] args) {
		ThreeDShape s1 = new RectangularPrism(5, 6, 10);     // V = 300, SA = 280
		ThreeDShape s2 = new RectangularPrism(5, 3, 10);     // V = 150, SA = 190

		ThreeDShape s3 = new TriangularPrism(6, 8, 10, 20);  // V = 480, SA = 528
		ThreeDShape s4 = new TriangularPrism(8, 8, 8*Math.sqrt(2), 10);  // V = 320, SA = 337.1
		
		ThreeDShape s5 = new Cylinder(5, 10);                // V = 785.4, SA = 471.2
		ThreeDShape s6 = new Cylinder(10, 20);               // V = 6283.2,  SA = 1885.0
		
		ThreeDShape s7 = new Sphere(4);						// V = 268.1, SA = 201.1
		ThreeDShape s8 = new Sphere(24);					// V = 57905.8, SA = 7238.2
		
		ThreeDShape s9 = new RectangularPyramid(5, 7, 12); // V = 140, SA = 183.3
		ThreeDShape s10 = new RectangularPyramid(27, 15, 39); // V = 5265, SA = 2096.4
		
		ThreeDShape s11 = new Cone(8, 13);					// V = 871.3, SA = 584.7
		ThreeDShape s12 = new Cone(32, 10);					// V = 10723.3, SA = 6587.4
		
		ThreeDShape[] shapes = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12};
		
		for (int i=0; i < shapes.length; i++) {
			System.out.println("The volume of s" + (i+1) +": " + shapes[i].getVolume());
			System.out.println("The surface area of s" + (i+1) +": " + shapes[i].getSA());
			System.out.println();
		}		
	
	}	
}
