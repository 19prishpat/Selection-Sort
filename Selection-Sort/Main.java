    class Main {
        public static void main(String[] args) {
            int[] arr = genRanList(7); // Generates an array of random numbers
            System.out.println("Original Array:");
            printArray(arr); // Prints the unsorted array

            System.out.println("\nSelection Sort:");
            int[] selectionSortedArray = selectionSort(arr.clone()); // Sorts the array using selection sort
            printArray(selectionSortedArray); // Prints the selection sorted array

            System.out.println("\nBubble Sort:");
            int[] bubbleSortedArray = bubbleSort(arr.clone()); // Sorts the array using bubble sort
            printArray(bubbleSortedArray); // Prints the bubble sorted array

            System.out.println("\nInsertion Sort:");
            int[] insertionSortedArray = insertionSort(arr.clone()); // Sorts the array using insertion sort
            printArray(insertionSortedArray); // Prints the insertion sorted array
        }

        /**
         * Generates an array of random integers.
         * @param size Size of the array to generate.
         * @return A randomly generated array.
         */
        public static int[] genRanList(int size) {
            int[] arr = new int[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) (Math.random() * 50) + 1;
            }
            return arr;
        }

        /**
         * Prints the elements of the array.
         * @param arr The array to print.
         */
        public static void printArray(int[] arr) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        /**
         * Sorts an array using the selection sort algorithm.
         * @param list The array to be sorted.
         * @return The sorted array.
         */
        public static int[] selectionSort(int[] list) {
            int n = list.length;
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (list[j] < list[minIndex]) {
                        minIndex = j;
                    }
                }
                // Swap the minimum element with the current element
                int temp = list[minIndex];
                list[minIndex] = list[i];
                list[i] = temp;
            }
            return list;
        }

        /**
         * Sorts an array using the bubble sort algorithm.
         * @param list The array to be sorted.
         * @return The sorted array.
         */
        public static int[] bubbleSort(int[] list) {
            int n = list.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (list[j] > list[j + 1]) {
                        // Swap adjacent elements if they are in the wrong order
                        int temp = list[j];
                        list[j] = list[j + 1];
                        list[j + 1] = temp;
                    }
                }
            }
            return list;
        }

        /**
         * Sorts an array using the insertion sort algorithm.
         * @param list The array to be sorted.
         * @return The sorted array.
         */
        public static int[] insertionSort(int[] list) {
            int n = list.length;
            for (int i = 1; i < n; i++) {
                int key = list[i];
                int j = i - 1;

                // Move elements of list[0..i-1], that are greater than key,
                // to one position ahead of their current position
                while (j >= 0 && list[j] > key) {
                    list[j + 1] = list[j];
                    j = j - 1;
                }
                list[j + 1] = key;
            }
            return list;
        }
    }
