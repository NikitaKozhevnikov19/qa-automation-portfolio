# Проект по автоматическому тестированию сценариев для веб-сайта компании [naumen](https://www.naumen.ru/)
<img width="40%" title="Arcadia" src="media/logo/logo.png">
Naumen разрабатывает программные решения для автоматизации бизнес-процессов и управления ИТ-сервисами. Техническая экспертиза и опыт внедрения позволяют компании создавать надёжные и масштабируемые системы, отвечающие требованиям современного бизнеса. Naumen входит в число ведущих российских разработчиков корпоративного программного обеспечения.

## :scroll: Содержание:

- [Используемый стек](#computer-используемый-стек)
- [Запуск автотестов](#-запуск-автотестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Пример Allure Report](#-пример-allure-отчета)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testOps)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Уведомления в Telegram](#-уведомления-в-telegram)
- [Видео примера запуска тестов в Selenoid](#-видео-примера-запуска-теста-в-selenoid)

- ## :computer: Используемый стек

- <p align="center"> 
<a href="https://www.jetbrains.com/idea/"><img width="6%" title="IntelliJ IDEA" src="media/logo/Intelij_IDEA.svg"></a> 
<a href="https://www.java.com/"><img width="6%" title="Java" src="media/logo/Java.svg"></a>
<a href="https://selenide.org/"><img width="6%" title="Selenide" src="media/logo/Selenide.svg"></a>
<a href="https://aerokube.com/selenoid/"><img width="6%" title="Selenoid" src="media/logo/Selenoid.svg"></a>
<a href="https://github.com/allure-framework/allure2"><img width="6%" title="Allure Report" src="media/logo/Allure_Report.svg"></a>
<a href="https://qameta.io/"><img width="5%" title="Allure TestOps" src="media/logo/AllureTestOps.svg"></a>
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="media/logo/Gradle.svg"></a>
<a href="https://junit.org/junit5/"><img width="6%" title="JUnit5" src="media/logo/JUnit5.svg"></a>
<a href="https://github.com/"><img width="6%" title="GitHub" src="media/logo/GitHub.svg"></a>
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="media/logo/Jenkins.svg"></a>
<a href="https://web.telegram.org/"><img width="6%" title="Telegram" src="media/logo/Telegram.svg"></a>
<a href="https://www.atlassian.com/software/jira/"><img width="5%" title="Jira" src="media/logo/Jira.svg"></a>
</p>

#### Для работы с тестами в данном проекте используются: 
* язык - <code>Java</code>;
* фреймворк для тестирования - <code>Selenide</code>;
* сборщик - <code>Gradle</code>; 
* фреймворк модульного тестирования - <code>JUnit 5</code>;
* запуск браузеров с помошью <code>Selenoid</code>;
* джоба для удалённого запуска в - <code>Jenkins</code>;
* отчёт в <code>Allure Report</code>;
* отправка результатов при помощи бота в - <code>Telegram</code>;
* интеграция с - <code>Allure TestOps</code>;
* регистрация задач и дефектов в <code>Jira</code>.

#### Содержание Allure-отчёта:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

* ## <img width="4%" style="vertical-align:middle" title="Selenoid" src="media/logo/Selenoid.svg"> Запуск автотестов

## Команды для запуска из терминала
___
***Локальный запуск:***
```bash  
gradle clean naumen_test
```

***Удалённый запуск через Jenkins:***
```bash  
./gradlew clean naumen_test \
  -Dbrowser=${browser} \
  -DbrowserSize=${browserSize} \
  -DbrowserVersion=${browserVersion} \
  -Dremote=https://user1:1234@selenoid.autotests.cloud/wd/hub
```

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="media/logo/Jenkins.svg"> Сборка в Jenkins
[Ссылка на сборку в Jenkins](https://jenkins.autotests.cloud/job/Naumen_Automation_Tests/)

Для запуска сборки необходимо перейти в раздел <code>Собрать с параметрами</code>, выбрать значение для таких параметров как: ENVIRONMENT, COMMENT, TASK, browser, browserVersion, browserSize. Далее нажать кнопку <code>Собрать</code>.
<p align="center">
<img title="Jenkins Build" src="media/screens/Jenkins.png">
</p>
После выполнения сборки, в блоке <code>История сборок</code> напротив номера сборки появятся значки <code>Allure Report</code> и <code>Allure TestOps</code>, при клике на которые откроется страница с сформированным html-отчетом и тестовой документацией соответственно.


