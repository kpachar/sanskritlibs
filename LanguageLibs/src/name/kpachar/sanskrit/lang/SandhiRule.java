package name.kpachar.sanskrit.lang;

public class SandhiRule {
	private int left;
	private int right;
	private int[] result;
	public SandhiRule(int left, int right, int[] result) {
		super();
		this.left = left;
		this.right = right;
		this.result = result;
	}

	public int[] apply(int left, int right){
		//System.out.println("Checking "+left+" against "+this.left+" and "+right+" against "+this.right);
		if(this.left==left && this.right==right)return this.result;
		return null;
	}
}
