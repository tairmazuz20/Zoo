package utilities;

/**
 * A set of Logging functions to be used in appropriate classes
 * 
 * @author baroh
 *
 */
public class MessageUtility {

	/**
	 * Logs Boolean function calls.
	 * 
	 * @param name
	 *            - Name of the Animal
	 * @param funcName
	 *            - Calling Function Name
	 * @param value
	 *            - Given Value
	 * @param isSuccess
	 *            - Result of boolean function
	 */
	public static void logBooleanFunction(String name, String funcName, Object value, boolean isSuccess) {
		String str = "[b]" + name + ":  \t" + funcName + "(" + value + ") => " + isSuccess;
		if (isSuccess) {
			System.out.println(str);
		} else {
			System.err.println(str);
		}
	}

	/**
	 * Logs Constructor calls
	 * 
	 * @param className
	 *            - use Implicit name or
	 *            <code>this.getClass().getSimpleName()</code>
	 * @param name
	 *            - Name of the Animal
	 */
	public static void logConstractor(String className, String name) {
		String str = "[+]new " + className + "\tname: " + name;
		System.out.println(str);
	}

	/**
	 * @param name
	 *            - Name of the Animal
	 * @param funcName
	 *            - Calling Getter Name
	 * @param value
	 *            - Returned value
	 */
	public static void logGetter(String name, String funcName, Object value) {
		String str = "[g]" + name + ":  \t" + funcName + "() => " + value;
		System.out.println(str);
	}

	/**
	 * @param name
	 *            - Name of the Animal
	 * @param funcName
	 *            - Calling Setter Name
	 * @param value
	 *            - Returned value
	 * @param isSuccess
	 *            - Did the assignment take place
	 */
	public static void logSetter(String name, String funcName, Object value, boolean isSuccess) {
		String str = "[s]" + name + ":  \t" + funcName + "(" + value + ") => " + isSuccess;
		if (isSuccess) {
			System.out.println(str);
		} else {
			System.err.println(str);
		}

	}

	public static void logSound(String name, String message) {
		String str = "[!]" + name + ":  \t" + message;
		System.out.println(str);
	}
}
