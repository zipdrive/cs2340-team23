package edu.gatech.oad.antlab.person;

/**
 *  A simple class for person 2
 *  returns their name and a
 *  modified string 
 *
 * @author Bob
 * @version 1.1
 */
public class Person2 {
    /** Holds the persons real name */
    private String name;
	 	/**
	 * The constructor, takes in the persons
	 * name
	 * @param pname the person's real name
	 */
	 public Person2(String pname) {
	   name = pname;
	 }
	/**
	 * This method should take the string
	 * input and return its characters in
	 * random order.
	 * given "gtg123b" it should return
	 * something like "g3tb1g2".
	 *
	 * @param input the string to be modified
	 * @return the modified string
	 */
	private String calc(String input) {
	  String temp = input;
	  String answer = "";
	  while (temp.length() > 0) {
		  int index = (int)Math.floor(Math.random() * temp.length());
		  answer += temp.charAt(index);
		  temp = temp.substring(0, index)+temp.substring(index+1);
	  String[] components = new String[input.length()];
	  for (int i = 0; i < input.length(); i++) {
	  	components[i] = input.substring(i, i + 1);
	  }
	  while (answer.length() < input.length()) {
	  	int index = (int)(Math.random() * input.length());
	  	if(components[index] != null) {
	  		answer += components[index];
	  		components[index] = null;
	  	}
	  }
	  return answer;
	}
	/**
	 * Return a string rep of this object
	 * that varies with an input string
	 *
	 * @param input the varying string
	 * @return the string representing the 
	 *         object
	 */
	public String toString(String input) {
	  return name + calc(input);
	}
}
