package com.soro.utils;

import java.util.Random;

/**
 * packageName : com.soro.utils
 * fileName    : SortUtil
 * author      : soromiso
 * date        : 7/24/25
 * description :
 * ===========================================================
 * DATE                 AUTHOR             NOTE
 * -----------------------------------------------------------
 * 7/24/25             soromiso             new
 */
public class SortUtil {

    /**
     * Generates an array of random integers.
     *
     * @param n    the number of elements in the array
     * @param min  the minimum value of the random integers (inclusive)
     * @param max  the maximum value of the random integers (inclusive)
     * @return     an array of random integers
     */
    public static int[] generateRandomArray(int n, int min, int max) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(max - min + 1) + min;
        }
        return arr;
    }

    /**
     * 배열이 오름차순으로 정렬되었는지 확인합니다.
     * @param arr 정렬된 배열
     * @return 정렬이 되었으면 true, 아니면 false
     */
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }


    // MARK: - 정렬 알고리즘 START
    /**
     * Sorts an array using the selection sort algorithm.
     *
     * @param arr  the array to be sorted
     */
    // Bubble Sort
    // 시간복잡도: O(n^2)
    // 최악의 경우: 이미 정렬된 배열에서 모든 원소를 비교해야
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Sorts an array using the selection sort algorithm.
     *
     * @param arr  the array to be sorted
     */
    // Selection Sort
    // 시간복잡도: O(n^2)
    // 최악의 경우: 이미 정렬된 배열에서 모든 원소를 비교해야
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * Sorts an array using the quicksort algorithm.
     *
     * @param arr  the array to be sorted
     * @param low  the starting index of the array
     * @param high the ending index of the array
     */
    // Quick Sort
    // 시간복잡도: O(n log n) 평균, O(n^2)
    // 최악의 경우: 이미 정렬된 배열에서 pivot이 항상 마지막 원소
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    /**
     * Partitions the array for the quicksort algorithm.
     *
     * @param arr  the array to be partitioned
     * @param low  the starting index of the array
     * @param high the ending index of the array
     * @return     the index of the pivot element
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }


    /**
     * Sorts an array using the merge sort algorithm.
     *
     * @param arr   the array to be sorted
     * @param left  the starting index of the array
     * @param right the ending index of the array
     */
    // Merge Sort
    // 시간복잡도: O(n log n)
    // 최악의 경우: 모든 원소를 비교해야
    // Merge Sort는 안정 정렬이므로, 동일한 값의 원소들의 상대 순서가 유지됩니다.
    // Merge Sort는 재귀적으로 배열을 분할하고, 분할된 배열을 병합하여 정렬합니다.
    // 이 과정에서 배열을 두 개의 부분으로 나누고, 각 부분을 재귀적으로 정렬한 후, 두 부분을 병합하여
    // 최종적으로 정렬된 배열을 만듭니다.
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    /**
     * Merges two sorted subarrays into one sorted array.
     *
     * @param arr   the array containing the subarrays
     * @param left  the starting index of the first subarray
     * @param mid   the ending index of the first subarray and starting index of the second subarray
     * @param right the ending index of the second subarray
     */
    // Merge function for merge sort
    // 시간복잡도: O(n)
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int i = 0; i < n2; i++) R[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    /**
     * Sorts an array using the heap sort algorithm.
     *
     * @param arr  the array to be sorted
     */
    // Heap Sort
    // 시간복잡도: O(n log n)
    // 최악의 경우: 모든 원소를 비교해야
    // Heap Sort는 안정 정렬이 아니므로, 동일한 값의 원소들의
    // 상대 순서가 유지되지 않습니다.
    // Heap Sort는 배열을 힙 구조로 변환한 후, 힙에서
    // 가장 큰 원소를 추출하여 정렬합니다.
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract elements
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    /**
     * Maintains the heap property for a subtree rooted at index i.
     *
     * @param arr  the array representing the heap
     * @param n    the size of the heap
     * @param i    the index of the root of the subtree
     */
    // Heapify function for heap sort
    // 시간복잡도: O(log n)
    // 힙 구조를 유지하기 위해서, 현재 노드와 자식 노드
    // 간의 관계를 비교하여, 자식 노드가 현재 노드보다 크면
    // 자식 노드와 현재 노드를 교환하고, 자식 노드
    // 에 대해서도 같은 작업을 반복합니다.
    // 이 과정을 통해 힙 구조를 유지하면서, 정렬된 배열을 만듭니다.
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
    // MARK: - 정렬 알고리즘 END

    /**
     * 정렬된 배열에서 이진 탐색으로 값을 찾습니다.
     * @param arr 정렬된 배열
     * @param target 찾을 값
     * @return 인덱스 (없으면 -1)
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }

    /**
     * Prints the elements of an integer array.
     *
     * @param arr  the array to be printed
     */
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
