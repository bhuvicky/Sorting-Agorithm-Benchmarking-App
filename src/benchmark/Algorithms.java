package benchmark;

import java.util.Scanner;

public class Algorithms {
	private static long startTime;
	private static long endTime;
	static MyThread threadBubble, threadSelection, threadInsertion, threadQuick;

	public static int getUserInput() {
		Scanner input = new Scanner(System.in);
		while (true) {
			try {
				return Integer.parseInt(input.nextLine());
			} catch (NumberFormatException ex) {
				System.out.println(ex);
				continue;
			}
		}
	}

	public static int complexityList() {
		System.out.println("\t\t\t Choose Complexity from below list" + "\n\t\t\t *********************************"
				+ "\n\t\t\t 	1.Best    Case" + "\n\t\t\t 	2.Average Case" + "\n\t\t\t 	3.Worst   Case"
				+ "\n\t\t\t *********************************");
		return getUserInput();
	}

	public static int AlgorithmList() {
		System.out.println("\t\t\t Choose Algorithms from below list" + "\n\t\t\t *********************************"
				+ "\n\t\t\t 	1.Bubble    Sort" + "\n\t\t\t 	2.Selection Sort" + "\n\t\t\t 	3.Insertion Sort"
				+ "\n\t\t\t 	4.Quick     Sort" + "\n\t\t\t 	5.BenchMark All" + "\n\t\t\t 	6.Start over"
				+ "\n\t\t\t 	7.Exit" + "\n\t\t\t *********************************");
		return getUserInput();
	}

	public static void selectAlg(int[] clonedArray, int selectAlg) {
		startTime = 0;
		endTime = 0;
		switch (selectAlg) {
		case 1:
			startTime = System.currentTimeMillis();
			bubbleSort(clonedArray);
			endTime = System.currentTimeMillis();
			System.out.println("Bubble Sort completed at " + (endTime - startTime) + " milli seconds");
			break;
		case 2:
			startTime = System.currentTimeMillis();
			selectionSort(clonedArray);
			endTime = System.currentTimeMillis();
			System.out.println("Selection Sort completed at " + (endTime - startTime) + " milli seconds");
			break;
		case 3:
			startTime = System.currentTimeMillis();
			insertionSort(clonedArray);
			endTime = System.currentTimeMillis();
			System.out.println("Insertion Sort completed at " + (endTime - startTime) + " milli seconds");
			break;
		case 4:
			startTime = System.currentTimeMillis();
			quickSort(clonedArray, 0, clonedArray.length - 1);
			endTime = System.currentTimeMillis();
			System.out.println("Quick Sort completed at " + (endTime - startTime) + " milli seconds");
			break;
		case 5:
			startTime = System.currentTimeMillis();

			threadBubble    = new MyThread(clonedArray);
			threadSelection = new MyThread(clonedArray);
			threadInsertion = new MyThread(clonedArray);
			threadQuick     = new MyThread(clonedArray);
			threadBubble.setName("bubble sort");
			threadSelection.setName("selection sort");
			threadInsertion.setName("insertion sort");
			threadQuick.setName("quick sort");
			threadBubble.start();
			threadSelection.start();
			threadInsertion.start();
			threadQuick.start();
			while (threadBubble.isAlive() || threadSelection.isAlive() || threadInsertion.isAlive() || threadQuick.isAlive());

			endTime = System.currentTimeMillis();
			System.out.println("BenchMarking All completed at " + (endTime - startTime) + " milli seconds");
			break;
		default:
			System.out.println("Invalid input. Give correct input no from the list.");
			selectAlg = Algorithms.AlgorithmList();
			selectAlg(clonedArray, selectAlg);
		}
	}

	public static void swap(int[] array, int index1, int index2) {
		int temp = 0;
		temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1; j++)
				if (array[j] > array[j + 1])
					swap(array, j, j + 1);
		}
	}

	public static void selectionSort(int[] array) {
		int min = 0;
		for (int i = 0; i < array.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < array.length; j++)
				if (array[min] > array[j])
					min = j;
			if (i != min)
				swap(array, i, min);
		}
	}

	public static void insertionSort(int[] array) {
		int value = 0, hole = 0, flag = 0, j = 0;
		for (int i = 1; i < array.length; i++) {
			value = array[i];
			hole = i;
			flag = 1;
			j = i;
			while (j > 0 && array[j - 1] > value) {
				array[hole--] = array[--j];
				flag = 0;
			}
			if (flag == 0)
				array[j] = value;
		}
	}

	public static int partition(int[] array, int start, int end) {
		int pivot = array[end];
		int pIndex = start, temp = 0;
		for (int i = start; i <= end; i++) {
			if (array[i] <= pivot) {
				swap(array, i, pIndex);
				/*
				 * temp = a[i]; a[i] = a[pIndex]; a[pIndex] = temp;
				 */
				pIndex++;
			}
		}
		return pIndex - 1;
	}

	public static void quickSort(int[] array, int start, int end) {
		if (start < end) {
			int pIndex = partition(array, start, end);
			quickSort(array, start, pIndex - 1);
			quickSort(array, pIndex + 1, end);
		}
	}

}
