package edu.iastate.cs228.hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
//import java.lang.NullPointerException;
import java.lang.NullPointerException;
/**
 * A class representing an ordering of characters that can be queried to know
 * the position of a given character.
 * 
 * @author Richa Patel
 */
public class Alphabet {
	/**
	 * A lookup table containing characters and their positions. Sorted by the
	 * character of each entry.
	 */
	private CharAndPos[] lookup;

	/**
	 * Constructs and initializes the ordering to have exactly the ordering of the
	 * elements in the given array.
	 * 
	 * @param ordering
	 *            the array containing the characters, in the ordering desired
	 * @throws NullPointerException
	 *             if {@code ordering} is {@code null}
	 */
	
	
	public Alphabet(char[] ordering) throws NullPointerException {
		// TODO
		
		if (ordering == null)
			throw new NullPointerException();
		
		this.lookup = new CharAndPos[ordering.length];
		for(int i = 0; i < ordering.length; i++){
			this.lookup[i] = new CharAndPos(ordering[i], i);
		}
		Arrays.sort(lookup, new CharAndPosComparator());
		//sortLookup();
		
		
	}
//
	//public static void main() throws NullPointerException, FileNotFoundException {
		
		//Alphabet a = new Alphabet("");
		//
	//}
	
	/**
	 * Constructs and initializes the ordering by reading from the indicated file.
	 * The file is expected to have a single character on each line, and the
	 * ordering in the file is the order that will be used.
	 * 
	 * @param filename
	 *            the name of the file to read
	 * @throws NullPointerException
	 *             if {@code filename} is {@code null}
	 * @throws FileNotFoundException
	 *             if the file cannot be found
	 */
	public Alphabet(String filename) throws NullPointerException, FileNotFoundException {
		// TODO
		if (filename == null)
			throw new NullPointerException();
			
		Scanner scan = new Scanner(new File(filename));
		
		String row;
		int counter = 0;
		while(scan.hasNextLine() == true){ //if read the line, then increment counter
			
			row = scan.nextLine();
			counter++;
		}
		scan.close();
		
		lookup = new CharAndPos[counter];
		
		scan = new Scanner(new File(filename));
		String str;
		int index = 0;
		while(scan.hasNext() == true){ //if read the line, then increment counter
			
				str = scan.nextLine();
				lookup[index]  = new CharAndPos(str.charAt(0), index);
				index++;
				
		}
		scan.close();
		//sortLookup();
	}

	/**
	 * Returns true if and only if the given character is present in the ordering.
	 * 
	 * @param c
	 *            the character to test
	 * @return true if and only if the given character is present in the ordering
	 */
	public boolean isValid(char c) {
		// TODO
		/*
		for(int j =0; j < lookup.length; j++) {
			if(lookup[j].character ==c) {
				return true;
			}
		}
		return false;
	}
	*/
		
		//sortLookup();
		int index = binarySearch(c);
		if (index >= 0) {
			return true;
		}
			
		
		return false;
}
	

	/**
	 * Returns the position of the given character in the ordering. Returns a
	 * negative value if the given character is not present in the ordering.
	 * 
	 * @param c
	 *            the character of which the position will be determined
	 * @return the position of the given character, or a negative value if the given
	 *         character is not present in the ordering
	 */
	public int getPosition(char c) {
		// TODO
		
		/*
		int i = lookup.length;
		int r = i -1;
		int l = 0;
		
		while ( l <= r) {
			int mid = (r + l) / 2;
			if(lookup[mid].character == c) {
				return mid;
			}
			if(lookup[mid].character < c) {
				l = mid + 1;
			}else {
				r = mid -1;
			}
		}
		return -1;
	}
		*/
		int index = binarySearch(c);
		if (index > 0)
			return lookup[index].position;
		
		return -1;
	}
	

	/**
	 * Returns the index of the entry containing the given character within the
	 * lookup table {@link #lookup}. Returns a negative value if the given character
	 * does not have an entry in the table.
	 * 
	 * @param toFind
	 *            the character for which to search
	 * @return the index of the entry containing the given character, or a negative
	 *         value if the given character does not have an entry in the table
	 */
	private int binarySearch(char toFind) {
		for(int i = 0; i < lookup.length; i++) {
			if(lookup[i].character == toFind) {
			return lookup[i].position;
			}
		}
		/*
		 * note: for testing, you can perform a simple search through the array instead
		 * of a binary search, allowing you to test other components with a working (but
		 * slower) implementation
		 */
		
		
/*
		int i = lookup.length;
		int r = i -1;
		int l = 0;
		
		while ( l <= r) {
			int mid = (r + l) / 2;
			if(lookup[mid].character == toFind) {
				return lookup[mid].position;
			}
			if(lookup[mid].character < toFind) {
				l = mid + 1;
			}else {
				r = mid -1;
			}
		}
		return -1;
	*/
		// TODO
		return -1;

	}
	
	private void sortLookup()
	{
		CharAndPos minimum = lookup[0];
		CharAndPos temp;
		int minLocation = 0;
		for(int i = 0; i< lookup.length; i++)
		{
			minLocation = i;
			minimum = lookup[i];
			for(int j = i+1; j<lookup.length; j++)
			{
				if(minimum.character>lookup[j].character)
				{
					minimum = lookup[j];
					minLocation = j;
				}
			}
			temp = lookup[i];
			lookup[i] = minimum;
			lookup[minLocation] = temp;
			
		}
		
		int b = 0;
	}

	/**
	 * A PODT class containing a character and a position. Used as the entry type
	 * within {@link Alphabet#lookup lookup}.
	 */
	/* already completed */
	private static class CharAndPos {
		/**
		 * The character of the entry.
		 */
		public char character;

		/**
		 * The position of the entry in the ordering.
		 */
		public int position;

		/**
		 * Constructs and initializes the entry with the given values.
		 * 
		 * @param character
		 *            the character of the entry
		 * @param position
		 *            the position of the entry
		 */
		public CharAndPos(char character, int position) {
			this.character = character;
			this.position = position;
		}
//CharAndPos(int i, CharAndPos lookup) {
		@Override
		public boolean equals(Object obj) {
			if (null == obj || this.getClass() != obj.getClass()) {
				return false;
			}

			CharAndPos o = (CharAndPos) obj;

			return this.character == o.character && this.position == o.position;
		}

		@Override
		public int hashCode() {
			return character ^ position;
		}

		@Override
		public String toString() {
			return "{" + character + ", " + position + "}";
		}
	}
	private class CharAndPosComparator implements Comparator<CharAndPos>
	{

		@Override
		public int compare(CharAndPos o1, CharAndPos o2) {
			// TODO Auto-generated method stub
			return o1.character - o2.character;
		}
		
	}
}


