package benchmark;

public class BenchMarkIt {

	public static void main(String[] args) {
		int[] array;
		int arraySize;

		System.out.println("\t\t\t **********************************");
		System.out.println("\t\t\t Sorting Algorithm BenchMarking App");
		System.out.println("\t\t\t **********************************");

		while (true) {
			System.out.println("Enter the Array Size");
			arraySize = Algorithms.getUserInput();
			array = new int[arraySize];

			while (true) {
				int algNo = 0;
				int complexity = Algorithms.complexityList();
				switch (complexity) {
				case 1:
					for (int i = 0; i < arraySize; i++)
						array[i] = i + 1;
					System.out.println("Array of size " + arraySize + " created for Best Case");
					break;
				case 2:
					for (int i = 0; i < arraySize; i++)
						array[i] = (int) (Math.random() * 1000);
					System.out.println("Array of size " + arraySize + " created for Average Case");
					break;
				case 3:
					int temp = arraySize;
					for (int i = 0; i < arraySize; i++)
						array[i] = temp--;
					System.out.println("Array of size " + arraySize + " created for Worst Case");
					break;
				default:
					System.out.println("Invalid input. Give correct input no from the list.");
					continue;
				}
				while (true) {
					algNo = Algorithms.AlgorithmList();
					if (algNo == 6)
						break;
					else if (algNo == 7)
						System.exit(0);
					int[] cloneArr = array.clone();
					Algorithms.selectAlg(cloneArr, algNo);
				}
				if (algNo == 6)
					break;
			}
		}
	}

}
