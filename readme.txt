buegeleisen/dhbw_14sea_projekt
JA.COM

Das Repository enthält mehrere Dateiordner. Zu den wichtigsten gehören folgende Ordner:

Consumer
Es handelt sich um ein Java-Projekt, welches die simulierten Daten der Taktstraße mithilfe eines Kafka-Consumers, eines Activemq-Consumers und eines ERP-Filereaders aufnimmt. Die Daten werden in eine Statemachine überführt und in die Datenbank (MongoDB) eingetragen. Auch Livezustände werden für das UI gesammelt. Den genauen Aufbau kann man dem Klassendiagramm entnehmen.

Diagramme
Hier befinden sich eine Abbildung, die in einer Zwischenpräsentation verwendet wurde, das Klassendiagramm und zwei Zustandsdiagramme. Eines der Zustandsdiagramme betrachtet nur die Räume zwischen den Lichtschranken als Zustände. Das andere Diagramm sieht auch Milling und Drilling sowie jeweils die Phasen kurz davor als Zustände.

Dockerfiles
Hier befinden sich die Files, mit denen Dockercontainer erstellt wurden.

Portfolio
Hier sind alle Zwischenpräsentationen und die Abschlusspräsentation als "Session3.pptx".

SparkProject
An dieser Stellen haben wir versucht ein Java-Projekt zu erstellen, welche Produkt-Objekte konsumiert, um darauf aufbauend Spark in die Pipeline zu integrieren.

Statemachine
Dieser Ordner war der erste Versuch eine Statemachine für die Pipeline zu erstellen. Letztlich wurde aber im Java-Projekt "Consumer" eine eigene Statemachine verwendet.

UI
An dieser Stelle befinden sich alle Dateien und Bilder, die für die Erstellung eines User Interfaces mit Meteor verwendet wurden.
