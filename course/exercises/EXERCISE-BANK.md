# بانک جامع تمرین Java

این بانک از تمرین‌های کوتاه تا مسئله‌های پروژه‌ای چیده شده است. ترتیب پیشنهادی: ابتدا حل مستقل، سپس Test، سپس مقایسه با Solution.

## Fundamentals
1. Hello Java با سه خط خروجی.
2. تبدیل Celsius/Fahrenheit.
3. محاسبه تخفیف و مالیات.
4. تبدیل ثانیه به ساعت/دقیقه/ثانیه.
5. تشخیص زوج/فرد.
6. تعیین بزرگ‌ترین عدد از سه ورودی.
7. محاسبه BMI.
8. ماشین حساب با switch.
9. جدول ضرب.
10. مجموع اعداد 1 تا n.
11. مجموع اعداد زوج 1 تا n.
12. تشخیص عدد اول.
13. محاسبه Factorial.
14. تولید Fibonacci.
15. Reverse String.
16. Palindrome checker.
17. شمارش vowelها.
18. Frequency کاراکترها.
19. min/max آرایه.
20. average آرایه.
21. حذف duplicate از آرایه.
22. Bubble Sort بدون API آماده.
23. Linear Search.
24. Binary Search روی آرایه مرتب.
25. ماشین حساب متدی با validation.

## Beginner / OOP
26. کلاس Product با validation.
27. Customer با credit limit.
28. BankAccount با deposit/withdraw.
29. Custom InsufficientBalanceException.
30. Library با Book/Member.
31. سیستم Student/Course.
32. Invoice و InvoiceItem.
33. Cart با چند Product.
34. PaymentMethod interface و چند implementation.
35. Employee hierarchy و polymorphism.
36. Composition به جای inheritance در یک سناریو.
37. enum برای OrderStatus.
38. record برای Money.
39. LocalDate برای deadline.
40. Contact Book با HashMap.
41. حذف duplicate با HashSet.
42. مرتب‌سازی Product با Comparator.
43. Queue صف پشتیبانی.
44. Undo/Redo با Deque.
45. File Notes با NIO.
46. CSV reader ساده.
47. Serialization JSON مفهومی با DTO.
48. Repository in-memory generic.
49. Optional-based lookup.
50. Mini Project: Invoice Manager.

## Algorithms & Data Structures
51. Two Sum.
52. Valid Parentheses.
53. Frequency Map.
54. Merge دو آرایه مرتب.
55. Linked List traversal.
56. Reverse Linked List.
57. Detect cycle در Linked List.
58. Stack با Array.
59. Queue با دو Stack.
60. Binary Search Tree insert/search.
61. BST inorder traversal.
62. Tree height.
63. Level-order traversal.
64. Graph adjacency list.
65. BFS.
66. DFS.
67. Connected components.
68. Cycle detection در Graph.
69. Shortest path در Graph بدون وزن.
70. Merge Sort.
71. Quick Sort.
72. مقایسه Sortها با Big-O.
73. Climbing Stairs.
74. Fibonacci memoization/tabulation.
75. Coin Change.
76. Longest Common Subsequence.
77. 0/1 Knapsack.
78. Maximum Subarray.
79. Top-K با PriorityQueue.
80. LRU Cache.

## Advanced Java
81. Generic Pair<K,V>.
82. Generic Repository<T,ID>.
83. Wildcard با PECS.
84. Stream filter/map/reduce.
85. groupingBy گزارش فروش.
86. flatMap برای nested collections.
87. Primitive Stream benchmark.
88. CompletableFuture دو سرویس مستقل.
89. Producer/Consumer با BlockingQueue.
90. Race Condition و AtomicInteger.
91. Deadlock و رفع آن با lock ordering.
92. Virtual Threads برای workload blocking.
93. Thread-safe cache.
94. Reflection: لیست Methodها.
95. Annotation سفارشی validator.
96. Mini Test Runner با Reflection.
97. HTTP GET با timeout.
98. JSON mapping به record.
99. Retry محدود برای 503.
100. Rate limit response handling.
101. JDBC CRUD.
102. JDBC transaction انتقال وجه.
103. Batch insert.
104. SQL Injection fix با PreparedStatement.
105. Connection Pool design discussion.
106. JUnit boundary tests.
107. Mockito برای PaymentGateway.
108. Integration Test Repository.
109. Refactor برای Dependency Injection.
110. Mini Project: Student JDBC.

## Professional / Spring
111. Spring Bean با Constructor Injection.
112. Controller/Service/Repository separation.
113. ConfigurationProperties.
114. Profileهای local/test/prod.
115. Health endpoint.
116. Structured logging.
117. REST CRUD کامل.
118. DTO mapping.
119. Validation + Error Contract.
120. Pagination و Sorting.
121. Filtering امن.
122. PATCH semantics.
123. OpenAPI documentation.
124. Idempotency برای Checkout.
125. JPA Entity lifecycle analysis.
126. OneToMany/ManyToOne mapping.
127. N+1 reproduction/fix.
128. Projection query.
129. Optimistic locking.
130. Migration با Flyway/Liquibase.
131. Register با BCrypt.
132. Login flow.
133. JWT access token.
134. Role-based authorization.
135. Ownership check برای Order.
136. Expired token test.
137. Refresh token design.
138. Rate limiting login.
139. Security integration test.
140. Dockerize Spring Boot API.
141. Docker Compose با PostgreSQL.
142. CI pipeline با mvn verify.
143. Transactional checkout.
144. Inventory concurrency scenario.
145. PaymentGateway abstraction.
146. Fake adapter و test double.
147. Integration Test Checkout.
148. Production configuration checklist.
149. Mini Project: Learning REST API.
150. Capstone: Academy Store API.

## Career / Interview
151. توضیح JDK/JRE/JVM در 60 ثانیه.
152. equals/hashCode scenario.
153. ArrayList vs LinkedList trade-off.
154. HashMap collision explanation.
155. checked vs unchecked exception.
156. synchronized vs AtomicInteger.
157. Heap vs Stack debugging scenario.
158. SQL index trade-off.
159. Transaction isolation scenario.
160. JPA N+1 interview problem.
161. REST idempotency question.
162. JWT threat analysis.
163. Unit vs Integration Test decision.
164. SOLID refactoring exercise.
165. System design کوچک برای Course Enrollment.

## قانون ارزیابی
تمرین‌های 1–50 باید با ورودی‌های مختلف اجرا شوند؛ 51–110 علاوه بر صحت، تحلیل complexity/test می‌خواهند؛ 111–150 باید با تست خودکار و architecture rationale تحویل شوند؛ 151–165 برای آمادگی مصاحبه باید با پاسخ شفاهی/کتبی کوتاه و مثال فنی انجام شوند.
