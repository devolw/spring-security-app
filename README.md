Проект представляет собой веб-приложение, разработанное с использованием Java и Spring Security.

Веб-приложение включает в себя 4 представления:

1. Страница регистрации
2. Страница аутентификации
3. Тестовая страница для проверки аутентификации
4. Тестовая страница для проверки авторизации

Незарегистрированному пользователю доступны два представления: страница регистрации и страница аутентификации. После регистрации пользователя данные добавляются в БД, пароль передается в зашифрованном виде (BCrypt). По умолчанию пользователю назначается роль "ROLE_USER". Эта роль предоставляет ему возможность посещать тестовую страницу hello. Роль "ROLE_ADMIN" назначается вручную через запрос к БД. При наличии данной роли пользователь может посетить тестовую страницу admin и воспользоваться методом showUserInfo().

## Страница регистрации
<img width="1912" alt="registration" src="https://github.com/devolw/spring-security-app/assets/104515806/e6f2ee39-f6a9-454e-af57-90257981881d">

## Страница аутентификации
<img width="1912" alt="login" src="https://github.com/devolw/spring-security-app/assets/104515806/25b906ff-4c20-489e-a12b-83598b764c90">

## Тестовая страница hello (Для проверки аутентификации)
<img width="1912" alt="hello" src="https://github.com/devolw/spring-security-app/assets/104515806/c9a7ac7c-a4dc-40b9-ae41-e8a101937b0b">

## Тестовая страница admin (Для проверки авторизации)
<img width="1912" alt="admin" src="https://github.com/devolw/spring-security-app/assets/104515806/bfafbc9f-453c-4411-bb63-f9f181fee036">

## Метод showUserInfo() (Для проверки авторизации)
<img width="967" alt="showUserInfo()" src="https://github.com/devolw/spring-security-app/assets/104515806/187d0edf-7944-4538-b773-fc9210f389db">

## Таблица базы данных
<img width="823" alt="db" src="https://github.com/devolw/spring-security-app/assets/104515806/cceec357-2fff-4862-85ef-084bc0f16653">
