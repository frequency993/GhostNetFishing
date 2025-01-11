# GhostNetFishing

Respository für eine Fallstudie an der Internationalen Hochschule IU.
Wird offline genommen, sobald die Benotung erfolgte.

Repository for a Case Study at the International University IU.
Will be taken offline, as soon as grading has been completed.

---

## Testsetup

Im Folgenden wird das verwendete Testsetup beschrieben. Bei etwaigen Problemen mit der Ausführung empfiehlt es sich zunächst zu prüfen, ob alle verwendeten Software-Komponenten (Versionen etc.) mit den hier genannten übereinstimmen.

### 1. Hardware / Betriebssystem
Die gesamte Webanwendung wurde auf einem Notebook mit folgender Konfiguration gehostet und auch getestet:
- **Betriebssystem**: Windows 11 Pro / Version 10.0.26100, Build 26100
- **Hardware**: 64 GB Arbeitsspeicher / Intel(R) Core(TM) i9-14900HX Prozessor

### 2. Verwendete Software
Hier wird nur Software aufgeführt, welche nicht durch Maven verwaltet wird. Durch Maven verwaltete Pakete und Abhängikeiten können der  pom.xml entnommen werden.

**IDE**  
   - Eclipse IDE for Enterprise Java and Web Developers Version: 2024-12 (4.34.0) <br>
   [Eclipse Installer herunterladen](https://www.eclipse.org/downloads/packages/) ➡️ Bei der Installation "Eclipe IDE for Enterprise Java Web Developers" auswählen ➡️ JRE 21.0.5 auswählen ➡️ installieren

**Java Runtime Environment (JRE)**
   - JRE Version 21.0.5 (mitgeliefert in o.g. Eclipse-Version)<br> 
   :arrow_right: Die Fehlermeldungen in Eclipse bezüglich Java 11 und Java 21 haben für hiesige Anwendung keine Auswirkungen und können ignoriert werden. 

**Datenbankumgebung**
   - XAMPP für Windows 8.2.12 / PHP 8.2.12<br>
   ➡️ [XAMPP 8.2.12 / PHP 8.2.12 herunterladen](https://www.apachefriends.org/de/download.html) ➡️ installieren

### 3. Installation & Setup

#### 1. **Herunterladen des Projekts**
 
Zunächst muss das Projekt von GitHub heruntergeladen werden. Dies kann durch Klonen über git mittels: 
```shell
   git clone https://github.com/frequency993/GhostNetFishing.git
```

geschehen, oder durch herunterladen des Projekts als ZIP und anschließendes Entpacken: <br>

*Navigieren sie auf der Seite des Repository zu <>Code :arrow_right: Download ZIP*

#### 2. Öffnen in Eclipse als Maven Projekt
Um zu gewährleisten, dass Eclipse das Projekt als Maven-Projekt erkennt und alle Abhängigkeiten aus der *pom.xml* korrekt lädt, muss es wie folgt in Eclipse geöffnet werden:<br>

*File :arrow_right: Import... :arrow_right: Maven ➡️ Existing Maven Projects* ➡️ Ornder von GhostNetFishing auswählen ➡️ finish


#### 3. Installation eines Webservers
Für das Testsetup wurde ein **Apache Tomcat Server in der Version 10.0 verwendet, mit neueren Versionen kam es zu diversen Fehlern**:<br>

*Servers :arrow_right: No server are [...] :arrow_right: Apache :arrow_right: Tomcat v10.0 Server :arrow_right: Next :arrow_right: Projekt auswählen und mittels Add hinzufügen :arrow_right: Finish*

#### 4. Installation und Einrichtung der Datenbankumgebung
Die von der Webanwendung genutzten Einstellungen für die Verbindung zur Datenbank sind der *persistence.xml* zu entnehmen. Wenn die Installation wie hier beschrieben durchgeführt wird, sind keine Anpassungen notwendig. Auf Ausnahmen wird an den entsprechenden Stellen hingewiesen.

1. Nach der Installation von XAMPP, das Programm starten und sowohl den Apache, als auch den MySQL-Server starten. <br>
Es ist zu beachten, dass standardmäßig die Ports 80, 443 und 3306 verwendet werden. Sind diese Ports anderweitig in Verwendung, können die Ports über den entsprechenden Eintrag in der Config-Datei (Konfig-Button) geändert werden. **Die Änderung des Ports 3306 des MySQL-Moduls muss in der *persistence.xml* eingetragen werden:**

``` <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/ghostnet-db"/>```

2. Im Anschluss über den Admin-Button des MySQL-Moduls die Seite phpMyAdmin aufrufen. Und dort eine neue Datenbank mit dem Namen **ghostnet-db** anlegen. Als Kollation wurde im Testaufbau **utf8_general_ci** verwendet. <br> Sollte eine andere Datenbankbezeichnung verwendet werden, ist diese ebenfalls in der *persistence.xml* (siehe oben) anzugeben.  

#### 5. (Optional) Importieren des Testdatensatzes
Wenn gewünscht kann die *hostnet-db.sql* aus dem Ordner *Testdaten* vor der ersten Ausführung der Webanwendung in die Datenbank importiert werden. Die SQL-Datei legt die gewünschte Datenbankstruktur mitsamt elf Geisternetzen und ihren meldenden Personen an. So entfällt die Notwendigkeit eigene Geisternetze anzulegen, bevor mit diesen gearbeitet werden kann.<br>

*phpMyAdmin über XAMPP aufrufen (siehe Abschnitt 4. Punkt 2.) :arrow_right: ghostnet-db :arrow_right: Importieren :arrow_right: Datei auswählen :arrow_right: Importieren*

### 4. Ausführen der Webanwendung

Nach dem einmaligen Einrichten der Testumgebung nach o.g. Anleitung bestehen die Schritte zum Ausführen nur noch aus den Folgenden:
- Apache und MySQL über XAMPP starten *(bei erstmaliger Einrichtung nach o.g. Anleitung bereits gestartet)*.
- Projekt über Webserver in Eclipse starten: <br>
*index.xhtml im Project Explorer auswählen :arrow_right: Rechtsklick auf den installierten Server :arrow_right: start*
Sollte die index.xhtml nicht automatisch geöffnet werden, öffne einen Browser und navigiere zu *http://localhost:8080/GhostNetFishing/index.xhtml*

Im Anschluss kann die Webanwendung getestet werden.
