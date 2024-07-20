class CircleArea{
	final float PI=3.14f;
	int radius;

	public static void main(String args[]){
		CircleArea ca1= new CircleArea();
		ca1.radius = 8; 
		ca1.radius = 10; 
		System.out.println(calculateArea(ca1.radius,ca1.PI));
	}
	
	public static float calculateArea
	(final int radius, float PI){
		float result = PI*radius*radius;
		return result;
	}

}