

 class A{
	 int i = 0;
 }
 
 class B  extends A{
	 int i = 1;
	 
	 public void hello() {
//		 int i =2;
		 System.out.println(i);
		 System.out.println(this.i);
		 System.out.println(super.i);
	 }
 }


public class Main {

	public static void main(String[] args) {
		new B().hello();
	}

}
