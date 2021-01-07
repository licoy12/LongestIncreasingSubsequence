package longestincreasingsubsequence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class App {

	public static void main(String[] args) {

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		ArrayList<Integer> maxList = new ArrayList<Integer>();
		ArrayList<Integer> currentList = new ArrayList<Integer>();
		ArrayList<List<Integer>> candidate = new ArrayList<List<Integer>>();

		for (int i = 0; i < 100; i++) {
			numbers.add((int) ((Math.random() * 100))+1);
			System.out.println(numbers.get(i));
		}
		// loop thru all of the numbers
		for (int i = 1; i < numbers.size() - 1; i++) {
			// check if number behind is greater than or equal to number in front
			if (numbers.get(i - 1) >= numbers.get(i)) {
				currentList.add(numbers.get(i - 1));
				// check if the current length of our sequence is greater than the current
				// longest sequence
				if (currentList.size() > maxList.size()) {
					// if current sequence is higher then replace the current longest sequence with
					// currentList
					maxList = (ArrayList<Integer>) currentList.clone();
					candidate.clear();
					candidate.add(maxList);
				}
				// check if current sequence is equal to the current max sequence; if so add the
				// current sequence as a candidate to be included in longest sequence
				else if (currentList.size() == maxList.size()) {
					maxList = (ArrayList<Integer>) currentList.clone();
					candidate.add(maxList);
				}

				// printing all the combination long or short
				System.out.println("LIS: " + currentList + " at length :" + currentList.size());
				currentList.clear();
			}
			// goes here if the number behind numbers(i-1) is less than the number in front
			// numbers(i)
			else {
				currentList.add(numbers.get(i - 1));
				if (currentList.size() > maxList.size()) {
					maxList = (ArrayList<Integer>) currentList.clone();
					candidate.clear();
					candidate.add(maxList);
				}
			}
			// handle the last element to be compared, without this it will not include the
			// last element
			if (numbers.get(i) > maxList.get(maxList.size() - 1) && i == numbers.size() - 2) {
				maxList.add(numbers.get(i + 1));
				if (currentList.size() > maxList.size()) {
					maxList = (ArrayList<Integer>) currentList.clone();
					candidate.clear();
					candidate.add(maxList);
				} else if (currentList.size() == maxList.size()) {
					candidate.add(maxList);
				}
			}
		}
		//prints the values of candidate, prints all the combination if more than one and show the length of the combination
		System.out.println("FINAL LIS: " + candidate + " " + candidate.size()+ " combination" + " at length :" + candidate.get(0).size());

	}

}
