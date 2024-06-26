package com.ryb.algorithm;

/**
 * 堆排序
 */
public class Demo6 {
    public static void main(String[] args) {
        int[] arr = {2,4,2,15,3,1};
        heapSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void heapSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) { //O(N)
            heapInsert(arr, i); // O(logN)
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) { //O(N)
            heapify(arr, 0, heapSize); // O(logN)
            swap(arr, 0, --heapSize);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ?
                    left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if(largest == index) {
                return;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
