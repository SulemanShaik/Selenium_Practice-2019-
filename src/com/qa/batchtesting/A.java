package com.qa.batchtesting;
	
	 class B{
		void m1() {
			System.out.println("a class");
		}
	
	}
	
	class c extends B{
		void m2() {
			System.out.println("b class");
		}
	
	}
	
	public class A {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			B b= new B();
			b.m1();
			c c = new c();
			c.m1();
			c.m2();

		}

}
