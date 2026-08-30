# Recursion، Tree و Graph

## هدف
این درس سه مفهوم مهم الگوریتمی را از سطح تعریف به سطح حل مسئله می‌برد: Recursion، ساختارهای درختی و Graph Traversal.

## Recursion
Recursion یعنی یک تابع مسئله را به نمونه کوچک‌تری از همان مسئله تبدیل کند. هر الگوریتم بازگشتی صحیح حداقل دو بخش دارد:

- Base Case برای توقف.
- Recursive Case برای کوچک‌کردن مسئله.

```java
static long factorial(int n) {
    if (n < 0) throw new IllegalArgumentException("n must be non-negative");
    if (n <= 1) return 1;
    return n * factorial(n - 1);
}
```

## Call Stack
هر فراخوانی متد Frame مخصوص خود را روی Stack ایجاد می‌کند. Recursion بسیار عمیق می‌تواند `StackOverflowError` ایجاد کند. Java برخلاف بعضی زبان‌ها Tail Call Optimization تضمین‌شده ندارد؛ بنابراین برای ورودی‌های بسیار بزرگ Iteration ممکن است انتخاب امن‌تری باشد.

## مثال: Binary Search بازگشتی

```java
static int binarySearch(int[] values, int target, int low, int high) {
    if (low > high) return -1;
    int mid = low + (high - low) / 2;
    if (values[mid] == target) return mid;
    if (target < values[mid]) return binarySearch(values, target, low, mid - 1);
    return binarySearch(values, target, mid + 1, high);
}
```

پیچیدگی زمانی: O(log n). شرط: داده باید مرتب باشد.

## Tree
Tree یک Graph متصل بدون Cycle است. اصطلاحات پایه:

- Root: ریشه.
- Parent/Child: رابطه Nodeها.
- Leaf: Node بدون فرزند.
- Depth: فاصله از Root.
- Height: طول بلندترین مسیر تا Leaf.

## Binary Search Tree
در BST استاندارد، مقادیر کوچک‌تر سمت چپ و بزرگ‌تر سمت راست قرار می‌گیرند. اگر Tree متوازن باشد Search تقریباً O(log n) است؛ اگر کاملاً skewed شود ممکن است به O(n) برسد.

```java
class Node {
    int value;
    Node left;
    Node right;
    Node(int value) { this.value = value; }
}

static boolean contains(Node node, int target) {
    if (node == null) return false;
    if (node.value == target) return true;
    return target < node.value
            ? contains(node.left, target)
            : contains(node.right, target);
}
```

## Tree Traversal
- Preorder: Root → Left → Right.
- Inorder: Left → Root → Right؛ در BST خروجی مرتب می‌دهد.
- Postorder: Left → Right → Root.
- Level-order: پیمایش سطحی با Queue.

## Graph
Graph شامل Vertex و Edge است و می‌تواند Directed/Undirected و Weighted/Unweighted باشد.

نمایش Adjacency List:

```java
Map<String, List<String>> graph = Map.of(
    "A", List.of("B", "C"),
    "B", List.of("D"),
    "C", List.of("D"),
    "D", List.of()
);
```

## BFS
BFS با Queue حرکت می‌کند و در Graph بدون وزن برای کوتاه‌ترین مسیر بر حسب تعداد Edge مناسب است.

```java
static void bfs(Map<String, List<String>> graph, String start) {
    Queue<String> queue = new ArrayDeque<>();
    Set<String> visited = new HashSet<>();
    queue.offer(start);
    visited.add(start);

    while (!queue.isEmpty()) {
        String current = queue.poll();
        System.out.println(current);
        for (String next : graph.getOrDefault(current, List.of())) {
            if (visited.add(next)) queue.offer(next);
        }
    }
}
```

## DFS
DFS را می‌توان Recursive یا با Stack پیاده کرد. برای Graph حتماً `visited` لازم است تا Cycle باعث حلقه بی‌نهایت نشود.

```java
static void dfs(Map<String, List<String>> graph, String node, Set<String> visited) {
    if (!visited.add(node)) return;
    System.out.println(node);
    for (String next : graph.getOrDefault(node, List.of())) {
        dfs(graph, next, visited);
    }
}
```

پیچیدگی BFS و DFS با Adjacency List برابر O(V + E) است.

## چه زمانی BFS یا DFS؟
BFS برای shortest path بدون وزن، فاصله سطحی و nearest match مناسب است. DFS برای traversal عمیق، cycle detection، connected components و بسیاری از مسائل backtracking مفید است.

## خطاهای رایج
- نداشتن Base Case.
- تغییر نکردن ورودی Recursive Case.
- فراموش‌کردن visited در Graph.
- فرض اینکه BST همیشه O(log n) است.
- استفاده از Recursion عمیق بدون توجه به Stack.

## تمرین
1. مجموع عناصر Array را Recursive محاسبه کنید.
2. Tree Traversalهای Preorder/Inorder/Postorder را پیاده کنید.
3. BFS و DFS را روی یک Graph مشترک اجرا و ترتیب بازدید را مقایسه کنید.
4. Cycle را در یک Graph تشخیص دهید.
5. کوتاه‌ترین فاصله بین دو Node در Graph بدون وزن را با BFS محاسبه کنید.

## پروژه کوچک
سیستم مسیرهای آموزشی Academy را Graph فرض کنید؛ Lessonها Vertex و prerequisiteها Edge هستند. بررسی کنید آیا Dependency Cycle وجود دارد و یک ترتیب یادگیری معتبر تولید کنید.
