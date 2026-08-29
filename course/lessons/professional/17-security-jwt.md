# فصل 17 — Security و JWT

## مفاهیم
Authentication مشخص می‌کند کاربر چه کسی است؛ Authorization مشخص می‌کند چه کاری مجاز است انجام دهد.

## جریان پیشنهادی
`Login → Verify Credentials → Issue Token → Client Sends Token → Validate → Authorize`

## قواعد
- Password خام ذخیره نکنید.
- Secret را داخل Git قرار ندهید.
- مجوزها را در سمت Server enforce کنید.
- ورودی‌ها را Validate کنید.

## تمرین
Roleهای ADMIN و STUDENT تعریف و دسترسی حذف Course را فقط برای ADMIN مجاز کنید.
