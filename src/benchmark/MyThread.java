package benchmark;

public class MyThread extends Thread {
	int[] array;

	public MyThread(int[] array) {
		this.array = array;
	}

	public void run() {
		if (this.getName().equals("bubble sort"))
			Algorithms.bubbleSort(array);

		if (this.getName().equals("selection sort"))
			Algorithms.selectionSort(array);

		if (this.getName().equals("insertion sort"))
			Algorithms.insertionSort(array);
		
		if (this.getName().equals("quick sort"))
			Algorithms.insertionSort(array);
	}

}
