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
		//System.out.println("Checking "+new String(Character.toChars(left))+" against "+new String(Character.toChars(this.left))+" and "+new String(Character.toChars(right))+" against "+new String(Character.toChars(this.right))+" to give "+new String(result, 0, result.length));
		if(this.left==left && this.right==right)return this.result;
		return null;
	}
}
