# تست در Spring Boot

## Unit Test
Service را بدون Web Server و Database واقعی تست کنید.

## Slice Test
`@WebMvcTest` برای Controller و `@DataJpaTest` برای Persistence.

## Integration Test
جریان کامل چند لایه را بررسی می‌کند.

```java
@Test
void discountShouldBeApplied() {
    DiscountCalculator calculator = new DiscountCalculator();
    assertEquals(900, calculator.calculate(1000, 10));
}
```

## تمرین
برای Create Product تست ورودی معتبر، قیمت منفی و نام خالی بنویسید.
