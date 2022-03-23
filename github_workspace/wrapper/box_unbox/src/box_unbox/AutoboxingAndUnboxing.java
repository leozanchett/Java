package box_unbox;

public class AutoboxingAndUnboxing {

	public static int acceptWrapperObj(Integer intVal) {
		System.out.println("Value of Integer wrapper object: " + intVal.toString());
		int toReturn = intVal;
		return toReturn;
	}

	public static Double acceptPrimitiveDouble(double doubleVal) {
		System.out.println("Value of primitive double: " + doubleVal);
		Double toReturn = Double.valueOf(doubleVal);
		return toReturn;
	}

	public static void main(String[] args) {
		int testInt = 5;
		int resultInt = acceptWrapperObj(testInt); // autobox the primitive value

		Double testDoubleObj = Double.valueOf(3.14);
		Double resultDouble = acceptPrimitiveDouble(testDoubleObj); // unbox the wrapper object
	}
}
