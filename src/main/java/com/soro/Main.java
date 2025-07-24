package com.soro;

import com.soro.utils.SortUtil;

import java.util.Arrays;

/**
 * packageName : com.soro
 * fileName    : Main
 * author      : soromiso
 * date        : 7/24/25
 * description :
 * ===========================================================
 * DATE                 AUTHOR             NOTE
 * -----------------------------------------------------------
 * 7/24/25             soromiso             new
 */

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        int size = 10000;
        int[] original = SortUtil.generateRandomArray(size, 0, 100000);

        int[] bubbleArr = original.clone();
        int[] selectionArr = original.clone();
        int[] quickArr = original.clone();

        int[] mergeArr = original.clone();
        int[] heapArr = original.clone();

        System.out.println("▶ 정렬 성능 비교 (데이터 개수: " + size + ")\n");

        // Bubble Sort
        long start = System.currentTimeMillis();
        SortUtil.bubbleSort(bubbleArr);
        long end = System.currentTimeMillis();
        System.out.println("------------------------------------------------------");
        System.out.println("Bubble Sort 시간: " + (end - start) + "ms");

        // Selection Sort
        start = System.currentTimeMillis();
        SortUtil.selectionSort(selectionArr);
        end = System.currentTimeMillis();
        System.out.println("------------------------------------------------------");
        System.out.println("Selection Sort 시간: " + (end - start) + "ms");

        // Quick Sort
        start = System.currentTimeMillis();
        SortUtil.quickSort(quickArr, 0, quickArr.length - 1);
        end = System.currentTimeMillis();
        System.out.println("------------------------------------------------------");
        System.out.println("Quick Sort 시간: " + (end - start) + "ms");

        // Java 기본 정렬
        int[] javaArr = original.clone();
        start = System.currentTimeMillis();
        Arrays.sort(javaArr);
        end = System.currentTimeMillis();
        System.out.println("------------------------------------------------------");
        System.out.println("Java Arrays.sort 시간: " + (end - start) + "ms");

        // Merge Sort
        start = System.currentTimeMillis();
        SortUtil.mergeSort(mergeArr, 0, mergeArr.length - 1);
        end = System.currentTimeMillis();
        System.out.println("------------------------------------------------------");
        System.out.println("Merge Sort 시간: " + (end - start) + "ms");

        // Heap Sort
        start = System.currentTimeMillis();
        SortUtil.heapSort(heapArr);
        end = System.currentTimeMillis();
        System.out.println("------------------------------------------------------");
        System.out.println("Heap Sort 시간: " + (end - start) + "ms");

        // 정렬 정확성 검증 출력 추가
        System.out.println("======================================================");
        System.out.println("정렬 정확성 검증 결과:");
        System.out.println("------------------------------------------------------");
        System.out.println("Bubble Sort 정확성: " + SortUtil.isSorted(bubbleArr));
        System.out.println("Selection Sort 정확성: " + SortUtil.isSorted(selectionArr));
        System.out.println("Quick Sort 정확성: " + SortUtil.isSorted(quickArr));
        System.out.println("Java Arrays.sort 정확성: " + SortUtil.isSorted(javaArr));
        System.out.println("Merge Sort 정확성: " + SortUtil.isSorted(mergeArr));
        System.out.println("Heap Sort 정확성: " + SortUtil.isSorted(heapArr));
        System.out.println("======================================================");

        // Binary Search
        int target = mergeArr[mergeArr.length / 2]; // 중간 값 하나 뽑아서 검색
        int foundIndex = SortUtil.binarySearch(mergeArr, target);
        System.out.println("------------------------------------------------------");
        System.out.println("\n▶ Binary Search 테스트");
        System.out.println("찾는 값: " + target + ", 위치: " + foundIndex);
        System.out.println("검증: " + (mergeArr[foundIndex] == target));
    }
}