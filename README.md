# Operation Exam


## Bygge, kjøre, teste

Prosjektet kan enkelt bygges, testes, og kjøres gjennom en IDE som IntelliJ IDEA eller Eclipse, så lenge maven er installert.
Maven brukes da av editorene til å installere `LibGDX`, som er den eneste dependencien til prosjektet.

Man kan også bruke maven manuelt til å kunne kjøre og bygge programmet. For å installere dependencies kan man kjøre
`mvn install`, og for å bygge programmet kan man kjøre `mvn package`. Package funksjonen vil gi oss en `.JAR` fil som kan kjøres, dersom `javac` peker til rett java versjon (17).