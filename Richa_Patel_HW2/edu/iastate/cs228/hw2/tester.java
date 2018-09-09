package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;

/*
 * @author Richa Patel
 */
public class tester {

	public static void main(String[] args) throws NullPointerException, FileNotFoundException {
		

		//WordList w1 = new WordList("10.wordlist.txt");
		Alphabet a1 = new Alphabet("10.alphabet.txt");
		AlphabetComparator alphC = new AlphabetComparator(a1);
		MergeSorter m1 = new MergeSorter();
		InsertionSorter inS = new InsertionSorter();
		//m1.sort(w1, alphC);
		//inS.sort(w1, alphC);
		System.out.println(a1.getPosition('w'));
	
	}

}
