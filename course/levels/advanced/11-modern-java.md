# 11 — Java مدرن

- Generics
- Lambda
- Functional Interface
- Method Reference
- Stream API
- Optional
- Record
- Sealed Classes
- Pattern Matching
- Text Blocks

```java
var activeNames = users.stream()
    .filter(User::active)
    .map(User::name)
    .sorted()
    .toList();
```
