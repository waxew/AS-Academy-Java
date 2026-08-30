# ساختمان داده در Java

## هدف
ساختمان داده را بر اساس access pattern و complexity انتخاب کنید، نه صرفاً عادت.

## مسیر
Array → Dynamic Array → Linked List → Stack/Queue → Hash Table → Tree → Heap → Graph.

## مقایسه تقریبی
| ساختار | دسترسی | جست‌وجو | درج/حذف رایج |
|---|---:|---:|---:|
| Array/ArrayList | O(1) | O(n) | انتها amortized O(1)، وسط O(n) |
| LinkedList | O(n) | O(n) | با node معلوم O(1) |
| HashMap | - | average O(1) | average O(1) |
| TreeMap | - | O(log n) | O(log n) |
| PriorityQueue | head O(1) | O(n) | O(log n) |

## ArrayList و LinkedList
ArrayList برای اکثر list workloadها انتخاب پیش‌فرض مناسب‌تری است چون locality و random access خوبی دارد. LinkedList فقط در patternهای خاص مزیت دارد و نباید صرفاً به دلیل O(1) درج نظری انتخاب شود.

## Stack و Queue
در Java معمولاً `ArrayDeque` را به `Stack` قدیمی ترجیح دهید.

```java
Deque<String> stack = new ArrayDeque<>();
stack.push("lesson-1");
stack.push("lesson-2");
System.out.println(stack.pop());

Queue<String> jobs = new ArrayDeque<>();
jobs.offer("compile");
jobs.offer("test");
System.out.println(jobs.poll());
```

## HashMap
HashMap بر `hashCode()` و `equals()` درست تکیه دارد. Key mutable می‌تواند lookup را خراب کند اگر state مؤثر در hash بعد از insertion تغییر کند.

```java
Map<String, Integer> scoreByUser = new HashMap<>();
scoreByUser.put("ali", 90);
scoreByUser.merge("ali", 5, Integer::sum);
```

## TreeMap و TreeSet
وقتی ordering و عملیات range مهم است، ساختار tree-based می‌تواند مناسب باشد. هزینه عملیات اصلی معمولاً O(log n) است.

## Heap / PriorityQueue
برای Top-K، scheduler و انتخاب سریع کمینه/بیشینه کاربرد دارد.

```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
minHeap.offer(30);
minHeap.offer(10);
minHeap.offer(20);
System.out.println(minHeap.poll()); // 10
```

## Graph
Graph را می‌توان با adjacency list نمایش داد.

```java
Map<String, List<String>> graph = new HashMap<>();
graph.put("Java", List.of("Spring", "Android"));
graph.put("Spring", List.of("REST", "JPA"));
```

Sparse graph معمولاً با adjacency list حافظه مناسب‌تری نسبت به matrix دارد.

## انتخاب ساختار
سؤال‌ها:
1. آیا ordering لازم است؟
2. lookup بر اساس key مهم است؟
3. duplicate مجاز است؟
4. Top-K یا priority لازم است؟
5. insertion/removal کجا رخ می‌دهد؟
6. حجم داده و memory overhead چقدر است؟

## خطاهای رایج
- استفاده از LinkedList بدون benchmark.
- استفاده از List برای lookup مکرر به‌جای Map/Set.
- mutable key در HashMap.
- Comparator ناسازگار با equality در سناریوهای حساس.
- فرض اینکه Big-O تنها معیار performance است.

## تمرین
1. Undo/Redo با دو Deque.
2. Frequency counter با HashMap.
3. Top-10 score با PriorityQueue.
4. Phone book با Map و Set.
5. Graph مسیر یادگیری و adjacency list.
6. برای پنج workload مختلف ساختار مناسب انتخاب و دلیل complexity بنویسید.

## چالش
LRU Cache با ظرفیت محدود طراحی کنید و complexity عملیات get/put را توضیح دهید.

## معیار تسلط
دانشجو باید بتواند انتخاب ساختمان داده را با complexity، memory، ordering و access pattern توجیه کند.
