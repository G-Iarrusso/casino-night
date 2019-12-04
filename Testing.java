package cp317;
public class Testing {
	
	public enum Face {
		TWO(2, 0), THREE(3, 0), FOUR(4, 0), FIVE(5, 0);

		private int value;
		private int num;

		Face(final int value, final int num) {
		    this.value = value;
		    this.num = num;
		}
	}
	
	public static void main(String args[]) {
		System.out.print(Face.TWO.value + "\n" + Face.TWO.num);
		
	}	
}
