Es gibt zwei Änderungen, die sich von dem Code im Buch unterscheiden.

1. In der Datei src/main/resources/de/wicketpraxis/persistence/persistence.xml wurde
die Datenquelle angepasst.

2. In der Datei pom.xml wurde der Eintrag für "dbconfig-test" verändert.

Beide Anpassungen sind nötig, damit die Webanwendung ohne vorhandene mysql-Anwendung funktioniert.
Wenn man diese Anpassungen zurücknimmt, dann wird wieder die konfigurierte mysql-Datenbank eingebunden.

