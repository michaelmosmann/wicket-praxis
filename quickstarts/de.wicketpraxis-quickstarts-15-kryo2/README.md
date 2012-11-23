# Wicket Page Serializer und Performanceoptimierung

Wicket bildet den Zustand einer Anwendung, einer Webseite nicht wie andere Frameworks über Parameter in der Url ab. Wicket-Komponenten können viel mehr ihren eigenen Zustand über normale Java-Sprachmittel abbilden. Eine Komponente kann auf diese Weise die komplexesten Informationen halten, die möglicherweise sehr schwer über Url-Parameter abgebildet werden könnten. Das hat Vorteile, aber eben auch Nachteile. Der vermutlich größte Nachteil ist der Speicherbedarf, denn die Komponenten müssen für jeden Nutzer getrennt erzeugt und verwaltet werden. Anwendungen, die den Zustand einer Nutzerinteraktion immer über Url-Parameter abbilden, können nach dem ausliefern der Seite alle temporär erzeugten Daten verwerfen.

Wicket arbeitet anders. In Wicket ist eine Seite eine Sammlung verschiedenster Komponenten und Zustände in beliebigen Objekten. Wenn der Nutzer eine Aktion auf der Seite auslöst, wird die passende Komponente in diesem Komponentenbaum gesucht und die entsprechende Methode aufgerufen. Jede Interaktion erzeugt einen neuen Zustand und Wicket erzeugt eine neue Version der Seite für den Fall, dass der Nutzer z.B. mit dem Browser-Back-Buttom auf eine ältere Seite mit einem anderen Zustand zurück navigiert. Da der Arbeitsspeicher meist ein knappes Gut ist, werden die älteren Versionen einer Seite als Objektgraph mit all den Zuständen serialisiert und auf einem Datenträger abgelegt. Und hier wird es nun spannend.

Je mehr Zustand die Komponenten halten, je mehr Daten dafür notwendig sind, desto größer ist natürlich der Speicherbedarf zu Laufzeit aber auch der Platzbedarf auf dem Datenträger. Um nicht unnötig den Speicher und die Festplatte mit temporären Daten zu belasten, wird nach dem Ausliefern der Ergebnisseite für alle Komponenten die detach()-Methode aufgerufen, die sich darum kümmern muss, alles was für den Zustand der Komponente irrelevant ist, aufzuräumen.

## Überraschung vorraus

Nun hat man seine Wicket-Komponenten geschrieben und vermutet, dass man alles richtig gemacht hat oder hat einfach akzeptiert, dass z.B. der Speicherbedarf so hoch sein muss wie er eben gerade ist. Wenn man genügend Speicher hat, muss man ja nichts verändern, aber das ist vermutlich selten der Fall. Zum Glück bietet die Vorgehensweise, die Wicket an den Tag legt sehr interessante Möglichkeiten, um verschiedeneste Optimierungen vorzunehmen.

Wenn die Menge der Daten, die auf Festplatte geschrieben werden sehr hoch ist und die die CPU's im Rechner eher langweilen, kann man recht günstig Plattenplatz und Rechnengeschwindigkeit eintauschen (typische Kompression 70%, Mehrbelastung der CPU vermutlich 1-5%). Dafür benutzt man statt dem Standard-Serializer einfach die DeflatedJavaSerializer-Implementierung. **Vorsicht: die Daten, die mit dem Standard-Serializer auf die Festplatte geschrieben wurden, können nicht zurückgelesen werden.**

Besser wäre es natürlich, gleich von Anfang an weniger Temporärdaten zu erzeugen. 
