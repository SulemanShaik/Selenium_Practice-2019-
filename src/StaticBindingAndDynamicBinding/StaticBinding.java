package StaticBindingAndDynamicBinding;


/*In case of static binding type of object is determined at Compile time whereas
in Dynamic binding type of object is determined at runtime.*/
public class StaticBinding {
	
	public void car() {
		System.out.println("car speed is 60kmph");
	}
	
	public static void main(String[] args) {
		StaticBinding sd= new StaticBinding();
		sd.car();
	}

}
