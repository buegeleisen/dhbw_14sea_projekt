buegeleisen/dhbw_14sea_projekt
JA.COM

Das Repository enth�lt mehrere Dateiordner. Zu den wichtigsten geh�ren folgende Ordner:

Consumer
Es handelt sich um ein Java-Projekt, welches die simulierten Daten der Taktstra�e mithilfe eines Kafka-Consumers, eines Activemq-Consumers und eines ERP-Filereaders aufnimmt. Die Daten werden in eine Statemachine �berf�hrt und in die Datenbank (MongoDB) eingetragen. Auch Livezust�nde werden f�r das UI gesammelt. Den genauen Aufbau kann man dem Klassendiagramm entnehmen.

Diagramme
Hier befinden sich eine Abbildung, die in einer Zwischenpr�sentation verwendet wurde, das Klassendiagramm und zwei Zustandsdiagramme. Eines der Zustandsdiagramme betrachtet nur die R�ume zwischen den Lichtschranken als Zust�nde. Das andere Diagramm sieht auch Milling und Drilling sowie jeweils die Phasen kurz davor als Zust�nde.

Dockerfiles
Hier befinden sich die Files, mit denen Dockercontainer erstellt wurden.

Portfolio
Hier sind alle Zwischenpr�sentationen und die Abschlusspr�sentation als "Session3.pptx".

SparkProject
An dieser Stellen haben wir versucht ein Java-Projekt zu erstellen, welche Produkt-Objekte konsumiert, um darauf aufbauend Spark in die Pipeline zu integrieren.

Statemachine
Dieser Ordner war der erste Versuch eine Statemachine f�r die Pipeline zu erstellen. Letztlich wurde aber im Java-Projekt "Consumer" eine eigene Statemachine verwendet.

UI
An dieser Stelle befinden sich alle Dateien und Bilder, die f�r die Erstellung eines User Interfaces verwendet wurden.