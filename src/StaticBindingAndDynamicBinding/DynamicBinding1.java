package StaticBindingAndDynamicBinding;

/*In case of static binding type of object is determined at Compile time whereas
in Dynamic binding type of object is determined at runtime.*/

public class DynamicBinding1 extends DynamicBinding {
	
	public void car1() {
		System.out.println("car speed is 60kmph");
	
	}
	
	public static void main(String[] args) {
		DynamicBinding db1= new DynamicBinding1();
		db1.car1();
		
	}

}
