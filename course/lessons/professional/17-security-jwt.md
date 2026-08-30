# Spring Security، Authentication و JWT

## هدف
Security را به‌عنوان مجموعه‌ای از کنترل‌ها بفهمید: identity، credential، authorization، token lifecycle، password storage و attack surface.

## Authentication و Authorization
Authentication می‌گوید کاربر چه کسی است. Authorization مشخص می‌کند این identity روی resource مشخص چه عملی مجاز است انجام دهد.

## Password Storage
Password خام یا reversible encryption مناسب نیست. از password hashing مقاوم مانند BCrypt/Argon2 با تنظیم مناسب استفاده کنید.

```java
@Bean
PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
```

## JWT Flow
`Login → Verify Credentials → Issue Signed Token → Client Sends Bearer Token → Verify Signature/Claims → Build Authentication → Authorize`

JWT معمولاً سه بخش header.payload.signature دارد. Payload رمزنگاری‌شده نیست؛ اطلاعات حساس را داخل claim قرار ندهید.

## Claimهای مهم
- `sub`: subject/user identity.
- `iat`: issued at.
- `exp`: expiration.
- `iss`: issuer.
- `aud`: audience در سیستم‌های نیازمند آن.
- role/scope: authorization metadata با طراحی کنترل‌شده.

## Secret و Key Management
Signing secret/private key را داخل Git قرار ندهید. Production باید از environment/secret manager دریافت کند. Key rotation باید از ابتدا قابل طراحی باشد.

## Stateless Security
در JWT API معمولاً session server-side غیرفعال می‌شود و هر request credential خود را حمل می‌کند. Stateless بودن به معنی نداشتن state در کل سیستم نیست؛ revocation، refresh token و account status همچنان state می‌خواهند.

## Security Filter Chain
Filter توکن را استخراج و validate می‌کند و `SecurityContext` را فقط برای token معتبر پر می‌کند. Filter نباید token نامعتبر را silently authenticated کند.

## Authorization

```java
.requestMatchers("/api/admin/**").hasRole("ADMIN")
.requestMatchers("/api/auth/**").permitAll()
.anyRequest().authenticated()
```

Endpoint-level rule کافی نیست اگر ownership مهم باشد. کاربر authenticated نباید بتواند Order کاربر دیگر را فقط با تغییر ID ببیند.

## 401 در برابر 403
401 یعنی credential معتبر برای authentication نداریم. 403 یعنی identity مشخص است ولی permission کافی ندارد.

## Access و Refresh Token
Access token کوتاه‌عمر attack window را کاهش می‌دهد. Refresh token باید lifecycle، rotation، storage و revocation مشخص داشته باشد؛ صرفاً access token بسیار طولانی نسازید.

## Logout و Revocation
JWT self-contained به‌طور طبیعی تا expiration معتبر می‌ماند. برای logout فوری می‌توان refresh token را revoke کرد یا در سناریوهای خاص denylist/version strategy داشت.

## CSRF و CORS
CORS یک browser policy است، نه authorization. CSRF risk به نحوه حمل credential بستگی دارد. اگر token در cookie ارسال شود، CSRF design باید جدی بررسی شود.

## حملات رایج
- Broken access control / IDOR.
- credential stuffing و brute force.
- token leakage در log/local storage.
- secret ضعیف.
- expiration نامحدود.
- اعتماد به claim بدون signature validation.
- user enumeration در login/register response.

## Rate Limiting
Login، password reset و endpointهای پرهزینه باید rate limit و monitoring داشته باشند.

## تمرین
1. Roleهای ADMIN و CUSTOMER تعریف کنید.
2. حذف Product را فقط برای ADMIN مجاز کنید.
3. Order endpoint را علاوه بر role بر اساس ownership امن کنید.
4. expiration token را تست کنید.
5. طراحی access/refresh token با rotation و revocation بنویسید.
6. بررسی کنید چه داده‌هایی نباید داخل JWT قرار گیرند.

## پروژه امنیتی
Academy Store API را با register/login، password hashing، JWT کوتاه‌عمر، authorization role-based، ownership check، security integration test و secret خارجی کامل کنید.

## معیار تسلط
باید بتوانید threat را به control مناسب نگاشت کنید و بدانید JWT خودِ Security Architecture نیست؛ فقط یکی از credential/token mechanismهاست.
