package edu.iastate.cs228.hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Scanner;

/**
 * An class that compares various methods of sorting.
 * 
 * @author Richa Patel
 */
public class SorterFramework {
	/**
	 * Loads data necessary to run the sorter statistics output, and runs it. The
	 * only logic within this method should be that necessary to use the given file
	 * names to create the {@link AlphabetComparator}, {@link WordList}, and sorters
	 * to use, and then using them to run the sorter statistics output.
	 * 
	 * @param args
	 *            an array expected to contain two arguments: - the name of a file
	 *            containing the ordering to use to compare characters - the name of
	 *            a file containing words containing only characters in the other
	 *            file
	 */
	public static void main(String[] args) {
		
		
		if (args.length != 2) {
			System.out.println("not valid");
			return;
		}

		try {
			
			InsertionSorter in = new InsertionSorter();
			Alphabet a = new Alphabet("10.alphabet.txt");
			AlphabetComparator ac = new AlphabetComparator(a);
			WordList ww = new WordList("10.wordlist.txt");
			in.sort(ww, ac);
			
			
			
			// Sorter
			
			
			
			System.out.println("Enter the file part for WordList");
			Scanner input= new Scanner(System.in);
			String Word=input.next();
			System.out.println("Enter the file part for Alphabet");
			String alp=input.next();

			InsertionSorter insertion = new InsertionSorter();
			MergeSorter m = new MergeSorter();
			QuickSorter q = new QuickSorter();
			Sorter[] sorters = new Sorter[3];
			sorters[0] = insertion;
			sorters[1] = m;
			sorters[2] = q;
			
			Alphabet alphabet = new Alphabet(alp);
			AlphabetComparator alphabetComparator = new AlphabetComparator(alphabet);
			WordList wordList = new WordList(Word);
			SorterFramework sf = new SorterFramework(sorters, alphabetComparator, wordList, 1000000);
			sf.run();

			
			//
//			Alphabet alphabet = new Alphabet(args[0]);
//			AlphabetComparator alphabetComparator = new AlphabetComparator(alphabet);
//			WordList words = new WordList(args[1]); // bc file containing words containing only characters in the other
//			SorterFramework sf = new SorterFramework(sorters, alphabetComparator, words, words.length());
//			sf.run();
			
//			Alphabet alpha = new Alphabet(alp);
//			AlphabetComparator alphaC = new AlphabetComparator(alpha);
//			WordList word = new WordList(Word);
//			SorterFramework sorterFrame = new SorterFramework(sorters, alphaC, word, 1000);
//			sorterFrame.run();
			//
		}
		catch(Exception e)
		{
			
		}
	}


			
		
		
	
	
	
		

	
	/**
	 * The comparator to use for sorting.
	 */
	private Comparator<String> comparator;

	/**
	 * The words to sort.
	 */
	private WordList words;

	/**
	 * The array of sorters to use for sorting.
	 */
	private Sorter[] sorters;

	/**
	 * The total amount of words expected to be sorted by each sorter.
	 */
	private int totalToSort;

	/**
	 * Constructs and initializes the SorterFramework.
	 * 
	 * @param sorters
	 *            the array of sorters to use for sorting
	 * @param comparator
	 *            the comparator to use for sorting
	 * @param words
	 *            the words to sort
	 * @param totalToSort
	 *            the total amount of words expected to be sorted by each sorter
	 * @throws NullPointerException
	 *             if any of {@code sorters}, {@code comparator}, {@code words}, or
	 *             elements of {@code sorters} are {@code null}
	 * @throws IllegalArgumentException
	 *             if {@code totalToSort} is negative
	 */
	public SorterFramework(Sorter[] sorters, Comparator<String> comparator, WordList words, int totalToSort)
			throws NullPointerException, IllegalArgumentException {
		// TODO
		if (sorters == null || comparator == null || words == null) {
			throw new NullPointerException();
		}
		if (totalToSort < 0) {
			throw new IllegalArgumentException();
		}
		this.comparator = comparator;
		this.words = words;
		this.sorters = sorters;
		this.totalToSort = totalToSort;

		// sorters
		// * the array of sorters to use for sorting
		// * @param comparator
		// * the comparator to use for sorting
		//

	}

	/**
	 * Runs all sorters using
	 * {@link Sorter#sortWithStatistics(WordList, Comparator, int)
	 * sortWithStatistics()}, and then outputs the following information for each
	 * sorter: 
	 * - the name of the sorter 
	 * - the length of the word list sorted each time
	 * - the total number of words sorted 
	 * - the total time used to sort words 
	 * - the average time to sort the word list 
	 * - the number of elements sorted per  second
	 *  - the total number of comparisons performed
	 */
	public void run() {
		// TODO
		// go through all sorters
		
		
		for (int i = 0; i<sorters.length;i++) {
			sorters[i].sortWithStatistics(words, comparator, totalToSort);
			//sorters[i].sortWithStatistics(list[i], comparator, list[i].length());
			System.out.println(sorters[i].getClass().getSimpleName() + " The name of the sorter:");
			System.out.println(words.length() + " The length of the word list sorted each time:");
			System.out.println(sorters[i].getTotalWordsSorted() + " The total number of words sorted:");
			System.out.println(sorters[i].getTotalSortingTime() + " The total time used to sort words:");
			System.out.println(sorters[i].getTotalSortingTime() / sorters[i].getTotalWordsSorted() + " The average time to sort the word list:");
			System.out.println(sorters[i].getTotalWordsSorted() / sorters[i].getTotalSortingTime() + " The number of elements sorted per second:");
			System.out.println(sorters[i].getTotalComparisons() + " The total number of comparisons performed:");
		}
		//totalToSort a million
	
/*
		WordList[] list = { words.clone(), words.clone(), words.clone() };

		for (int i = 0; i < list.length; i++) {
			sorters[i].sortWithStatistics(list[i], comparator, list[i].length());
			System.out.println(sorters[i].getClass().getSimpleName() + "The name of the sorter:");
			System.out.println(list[i].length() + "The length of the word list sorted each time:");
			System.out.println(sorters[i].getTotalWordsSorted() + "The total number of words sorted");
			System.out.println(sorters[i].getTotalSortingTime() + "The total time used to sort words");
			System.out.println(sorters[i].getTotalSortingTime() / sorters[i].getTotalWordsSorted() + "The average time to sort the word list");
			System.out.println(sorters[i].getTotalWordsSorted() / sorters[i].getTotalSortingTime() + "The number of elements sorted per second");
			System.out.println(sorters[i].getTotalComparisons() + "The total number of comparisons performed");
			
		}
		*/

	}
}
	