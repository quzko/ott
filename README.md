# ott
Задача_1 описать автоматическую проверку метода API https://www.onetwotrip.com/_hotels/api/suggestRequest(доступность, данные в ответе).

Для запуска проекта через IntelliJIdea в файле pom.xml указаны необходимые зависимости(selenium, rest-assured,testng,json,json-schema-validator) в качестве сборщика - Maven.
Сам тест: SuggestRequest.java. При запуске в консоли подключено логирование - отображаются используемые данные в запросе(данные выбираются случайно с помощью ParametersList.java, дабы исключить дублирование одних и тех же данных при запусках) и полученный ответ, который сравнивается с json схемой schema.json, которая имеет структуру через "anyOf" для разных типов в ответе: город, отель, туристическая зона, аэропорт (т.к. required поля отличаются в зависимости от типа). В схеме указано условие на "непустой ответ", дабы исключить успешное прохождение теста при отправке пустого или некорректного запроса.
Для проверки доступнось метода используется тест с получением кода 200.
Гибкость этой модели выражается в возможности расширения json схемы (добавление новых типов или полей). Так же возможно гибко расширять ParametersList.java для увеличения вероятных тестовых данных для запроса. 

Задача_2 реализовать автоматическую проверку редиректа. 

Решение реализовано средствами selenium в RedirectTest.java сравниванием двух урлов.