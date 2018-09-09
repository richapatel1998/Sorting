package edu.iastate.cs228.hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * A simple list of Strings.
 * 
 * @author Richa Patel
 */
public class WordList implements Cloneable {
	/**
	 * The array holding all of the elements of the list.
	 */
	private String[] words; 

	/**
	 * Constructs and initializes the list to have exactly the same contents as the
	 * given array.
	 * 
	 * @param contents
	 *            the array with the contents of the new list
	 * @throws NullPointerException
	 *             if {@code contents} is {@code null}
	 */
	public WordList(String[] contents) throws NullPointerException {
		// TODO
		if (contents == null)
			throw new NullPointerException();
		
		words = new String[contents.length];
		
		for (int i = 0; i < contents.length; i++) {
			words[i] = contents[i];
		}
		
	}

	/**
	 * Constructs and initializes the list by reading from the indicated file. The
	 * file is read assuming that each line contains a word. The ordering in the
	 * file is the order that will be used by the list.
	 * 
	 * @param filename
	 *            the name of the file to read
	 * @throws NullPointerException
	 *             if {@code filename} is {@code null}
	 * @throws FileNotFoundException
	 *             if the file cannot be found
	 */
	public WordList(String filename) throws NullPointerException, FileNotFoundException {
		// TODO
		//Scanner scan = new Scanner(new File(filename));
		File file = new File(filename);
		Scanner scan = new Scanner(file);
		
		int tmp;
		String w;
		int counter = 0;
		while(scan.hasNextLine() == true){ //if read the line, then increment counter
			
			
				w = scan.nextLine();
				counter++;
		}
		scan.close();
		words = new String[counter];
		Scanner scan1 = new Scanner(new File(filename));
		for(int i = 0; i<words.length; i++)
		{
			words[i] = scan1.nextLine();
		}
		scan1.close();
		// fill the array from file by assigning each line to words[index]
		
		
	}

	/**
	 * Returns the number of elements in the list.
	 * 
	 * @return the number of elements in the list
	 */
	public int length() {
		// TODO
		if (words == null)
			return 0;
		
		return words.length;
	}

	/**
	 * Returns the element of the list at the indicated index.
	 * 
	 * @param idx
	 *            the index of the element to retrieve
	 * @return the element at the indicated index
	 * @throws IndexOutOfBoundsException
	 *             if {@code idx} is negative or greater than or equal to the length
	 *             of the list
	 */
	public String get(int idx) throws IndexOutOfBoundsException {
		// TODO
		if (idx < 0 || idx >= words.length)
			throw new IndexOutOfBoundsException();
		
		if (words != null)
			return words[idx];

		return null;
	}

	/**
	 * Sets the element of the list at the indicated index to the given value.
	 * 
	 * @param idx
	 *            the index of the element to set
	 * @param newValue
	 *            the new value of the element
	 * @throws IndexOutOfBoundsException
	 *             if {@code idx} is negative or greater than or equal to the length
	 *             of the list
	 */
	public void set(int idx, String newValue) throws IndexOutOfBoundsException {
		// TODO
		if (idx < 0 || idx >= words.length)
			throw new IndexOutOfBoundsException();
		
		if (words != null)
			words[idx] = newValue;

	}

	/**
	 * Swaps the indicated elements in the list.
	 * 
	 * @param idxA
	 *            the index of one of the elements to swap
	 * @param idxB
	 *            the index of the other element to swap
	 * @throws IndexOutOfBoundsException
	 *             if either of {@code idxA} or {@code idxB} is negative or greater
	 *             than or equal to the length of the list
	 */
	public void swap(int idxA, int idxB) throws IndexOutOfBoundsException {
		// TODO
		//create temp var and get value of string location in
		String tmp;
		
		tmp = words[idxA];
		words[idxA] = words[idxB];
		words[idxB] = tmp;
		

		}
	

	/**
	 * Returns the array used by the list to store its elements.
	 * 
	 * @return the array used by the list to store its elements
	 */
	public String[] getArray() {
		// TODO

		return words;
	}

	/**
	 * Performs a deep copy of the list.
	 */
	@Override
	public WordList clone() {
		/*
		 * note: since Strings are immutable, you don't need to clone them
		 */
		
		//create new wordlist and copy from the original wordlist and return new wordlist
		
		WordList newlist = new WordList(words);
		
		return newlist;
	}
}