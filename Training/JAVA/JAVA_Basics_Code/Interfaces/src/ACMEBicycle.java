
class ACMEBicycle implements MyInterface {


	  public void method1()
	  {
	      System.out.println("implementation of method1");
	  }
	  public void method2()
	  {
	      System.out.println("implementation of method2");
	  }
	  public static void main(String arg[])
	  {
		  MyInterface obj = new ACMEBicycle();
	      obj. method1();
	   //   x=20; //compile time error
	  }
	}