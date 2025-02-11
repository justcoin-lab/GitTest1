package awt;

public class GuGuDan {
	
	int dan;
	
	GuGuDan(){
		dan = (int)(Math.random()*9 + 1);
	}
	
	public void print() {
		if(dan == 1) {
			dan = (int)(Math.random()*9 + 1);
		}
		for(int i=1; i<=9; i++) {
			System.out.println(dan + " * " + i + " = " + (dan*i));
		}
	}
}
