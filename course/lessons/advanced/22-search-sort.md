# جست‌وجو و مرتب‌سازی

## مباحث
Linear Search، Binary Search، Bubble Sort، Selection Sort، Insertion Sort، Merge Sort و Quick Sort.

```java
static int binarySearch(int[] values, int target) {
    int low = 0;
    int high = values.length - 1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (values[mid] == target) return mid;
        if (values[mid] < target) low = mid + 1;
        else high = mid - 1;
    }
    return -1;
}
```

## نکته
Binary Search به داده مرتب‌شده نیاز دارد و O(log n) است.
