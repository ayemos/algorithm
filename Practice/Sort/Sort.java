import java.util.Stack;

public class Sort {
    // O(n log n)
    public static void mergeSort(int[] arr, int begin, int end) {
        if(begin < 0 || end >= arr.length)
            return ; // or exception

        if(begin >= end) {
            return ;
        } else {
            int m = (begin + end) / 2;
            mergeSort(arr, begin, m);
            mergeSort(arr, m + 1, end);
            merge(arr, begin, m, end);
        }
    }

    private static void merge(int[] arr, int begin, int m, int end) {
        int p = begin;
        int q = m + 1;
        int c = 0;
        int[] tmp = new int[end - begin + 1];

        while(p <= m && q <= end) 
            if(arr[p] < arr[q])
                tmp[c++] = arr[p++];
            else
                tmp[c++] = arr[q++];

        while(p <= m)
            tmp[c++] = arr[p++];

        while(q <= end)
            tmp[c++] = arr[q++];

        for(int i = begin; i <= end; i++) {
            System.out.print(tmp[i - begin] + " ");
            arr[i] = tmp[i - begin];
        }
        System.out.println();
    }

    public static void qsort1(int[] arr, int l, int r) {
        if(l >= r)
            return;

        int t = arr[l];
        int m = l;
        for(int i = l + 1; i <= r; i++) {
            if(arr[i] <= t) {
                m++;
                swap(arr, i, m);
            }
        }
        swap(arr, l, m);

        qsort1(arr, l, m);
        qsort1(arr, m + 1, r);
    }

    public static void qsort2(int[] arr, int l, int r) {
        if(l >= r)
            return;
        int t = arr[l];
        int left = l + 1;
        int right = r;
        while(left > right) {
            while(left <= r && arr[left] < t)
                left++;
            while(arr[right] > t)
                right--;
            if(left > right)
                break;
            swap(arr, left, right);
            left++;
            right--;
        }
        swap(arr, l, right);
        qsort2(arr, l, right - 1);
        qsort2(arr, right + 1, r);
    }

    public static void quickSort(int[] arr, int l, int r) {
        System.out.println("l:r => " + l + ":" + r);
        for(int i = l; i <= r; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        if(l >= r) {
            return ;
        } else {
            int pivot = partition(arr, l, r);
            quickSort(arr, l, pivot - 1);
            quickSort(arr, pivot, r);
        }
    }

    private static int partition(int[] arr, int l, int r) {
        int start = l;
        int pivot = arr[l];
        while(l < r) {
            while(arr[l] < pivot)
                l++;
            while(arr[r] > pivot)
                r--;

            if(l < r) {
                System.out.println("swap(l, r) => " + arr[l] + ":" + arr[r]);
                swap(arr, l, r);
                l++;
                r--;
            }
        }

        return start == l ? l + 1 : l;
    }

    public static void quickSortNoSubRoutine(int[] arr, int l, int r) {
        if(l >= r) {
            return ;
        } else {
            int pivot = arr[l];
            int origL = l;
            int origR = r;
            while(l < r) {
                while(arr[l] < pivot)
                    l++;
                while(arr[r] > pivot)
                    r--;

                if(l < r) {
                    swap(arr, l, r);
                    l++;
                    r--;
                }
            }

            quickSortNoSubRoutine(arr, origL, l - 1);
            if(l > origL)
                quickSortNoSubRoutine(arr, l, origR);
            else
                quickSortNoSubRoutine(arr, l + 1, origR);
        }
    }

    public static void quickSortNoRecur(int[] arr, int l, int r) {
        if(l >= r) {
            return;
        } else {
            Stack<Integer> ls = new Stack<Integer>();
            Stack<Integer> rs = new Stack<Integer>();
            ls.push(l);
            rs.push(r);
            int pivot, tmpl, tmpr, origL, origR;

            while(!ls.isEmpty()) {
                tmpl = ls.pop();
                tmpr = rs.pop();
                if(tmpl >= tmpr)
                    continue;
                origL = tmpl;
                origR = tmpr;
                pivot = arr[tmpl];
                while(tmpl < tmpr) {
                    while(arr[tmpl] < pivot)
                        tmpl++;
                    while(arr[tmpr] > pivot)
                        tmpr--;
                    if(tmpl < tmpr) {
                        swap(arr, tmpl, tmpr);
                        tmpl++;
                        tmpr--;
                    }
                }

                ls.push(origL);
                rs.push(tmpl - 1);
                ls.push(tmpl == origL ? tmpl + 1 : tmpl);
                rs.push(origR);
            }
        }
    }

    public static void heapSort(int[] arr) {
        for(int i = 0; i < arr.length; i++)
            upheap(arr, i);

        for(int i = arr.length - 1; i >= 0; i--) 
            downheap(arr, i);
    }

    private static void upheap(int[] arr, int current) {
        int parent;
        while(current > 0) {
            parent = current / 2;
            if(arr[parent] < arr[current])
                swap(arr, parent, current);
            current = parent;
        }
    }

    private static int downheap(int[] arr, int current) {
        int ret = arr[0];
        swap(arr, 0, current);
        int p = 0;
        int child = p * 2 + 1;

        while(child < current) {
            if(child < current -1 && arr[child + 1] > arr[child])
                child++;

            if(arr[child] > arr[p])
                swap(arr, child, p);

            p = child;
            child = p * 2 + 1;
        }

        return ret;
    }


    // O(n ^ 2)
    public static void insertSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) 
            for(int j = i; j > 0 && arr[j - 1] > arr[j]; j--) 
                swap(arr, j - 1, j);
    }

    public static void bubbleSort(int[] arr) {
        boolean flg = true;
        for(int p = arr.length - 1; p >= 0; p--) {
            flg = false;
            for(int i = 0; i < p; i++) {
                if(arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    flg = true;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int min;
        int ind = 0;
        int n = arr.length;
        
        for(int i = 0; i < n; i++) {
            min = Integer.MAX_VALUE;
            for(int j = i; j < n; j++) {
                if(arr[j] < min) {
                    min = arr[j];
                    ind = j;
                }
            }
            swap(arr, i, ind);
        }
    }
    
    // Utils
    private static void swap(int[] arr, int a, int b) {
        if(a < 0 || a >= arr.length 
                || b < 0 || b >= arr.length) {
            return ;
        } else {
            int tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
        }
    }

    public static void main(String[] args) {
        /*
        int[] arr = {5, 1, 2, 4, 3, 3};
        quickSortNoSubRoutine(arr, 0, arr.length - 1);
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        */

        int[] arr2 = {7, 3, 5, 1, 2, 4, 9, 8};
        qsort2(arr2, 0, arr2.length - 1);
        for(int i = 0; i < arr2.length; i++)
            System.out.print(arr2[i] + " ");
        System.out.println();
    }
}
