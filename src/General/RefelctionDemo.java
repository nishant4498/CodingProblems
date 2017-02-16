package General;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class RefelctionDemo {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws Exception{
		Test obj = new Test();
		
		Class cls = obj.getClass();
		System.out.println("Class Name:" + cls.getName());
		System.out.println("Constructor Name:" + cls.getConstructor().getName());
		
		Method[] methods = cls.getMethods();
		
		/**
		 * Also prints the methods inherited from its superclass Object like equals, toString()
		 * hashCode() etc.
		 */
		for(Method m : methods){
			System.out.println(m.getName());
		}
		
		Method methodCall = cls.getDeclaredMethod("method2", int.class);
		
		methodCall.invoke(obj, 10);		
		
		Field field = cls.getDeclaredField("s");
		field.setAccessible(true);// Make it public
		field.set(obj, "JAVA");
		
		Method mCall = cls.getMethod("method1");
		mCall.invoke(obj);
		
		Method mCall2 = cls.getMethod("method3");
		mCall2.setAccessible(true);
		mCall2.invoke(obj);
	}
}

class Test{
	private String s;
	
	public Test(){
		s = "Nishant";
	}
	
	public void method1(){
		System.out.println("Method1: " + s);
	}
	
	public void method2(int n){
		System.out.println("The number you eneterd is :" + n);
	}
	
	@SuppressWarnings("unused")
	private void method3(){
		System.out.println("Method2");
	}
}
