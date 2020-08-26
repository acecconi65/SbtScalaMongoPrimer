# SbtScalaMongoPrimer
Prima applicazione Scala che accede a MongoDB via MongoDB Scala driver
Target: sviluppare con Scala attraverso IDE IntelliJ IDEA, installata su Windows 10, applicazioni che fanno accesso a MongoDB dockerizzato disponibile su WSL 2 Ubuntu

**Step 1: Installazione JDK 8**
Prerequisito obbligato per I tool che sarà necessario installare su Windows è Java JDK 8, che si scarica da qui:
https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html
Le note che seguono da applicare nel caso che java non sia automaticamente nel PATH.
Da Esplora File, tasto destro sull’icona Questo PC (o Computer), selezionare la voce Proprietà dal menu che compare. Da Impostazioni di sistema avanzate dalla barra laterale di sinistra, tasto Variabili d’ambiente, quindi tasto Nuova: digitare “JAVA_JDK” nel campo Nome variabile, e il percorso di JDK (es. “C:\Program Files\Java\jdk-11.0.2”) nel campo Valore variabile: cliccare OK per salvare i cambiamenti.
Selezionare la variabile Path dall’elenco delle Variabili di sistema e cliccare sul tasto Modifica. Modificare il campo Valore variabile inserendo la stringa “%JAVA_JDK%\bin”, cliccare su OK per salvare i cambiamenti.

**Step 2: Installazione Docker Desktop su Windows**
Registrarsi su sito Docker e scaricare l’ultima versione di Docker Desktop per Windows:
https://www.docker.com/products/docker-desktop

**Step 3: Installazione WSL Ubuntu e di Docker e Docker Compose al suo interno**
Link di riferimento:
https://ubuntu.com/wsl
https://nickjanetakis.com/blog/setting-up-docker-for-windows-and-wsl-to-work-flawlessly
https://docs.microsoft.com/en-us/windows/wsl/tutorials/wsl-database
WSL1:
https://www.microsoft.com/en-us/p/ubuntu-1804-lts/9n9tngvndl3q?activetab=pivot:overviewtab
WSL 2:
https://www.microsoft.com/en-us/p/ubuntu/9nblggh4msv6?activetab=pivot:overviewtab
Per installare WSL 2 occorre aggiornare Windows alla versione Maggio 2020:
https://docs.microsoft.com/it-it/windows/wsl/install-win10?redirectedfrom=MSDN

**Step 4: Installazione container MongoDB 4.0.19 su WSL Ubuntu**
Nella WSL Ubuntu, creare la dir mongodb e, al suo interno, creare il file docker-compose.yml così valorizzato:
```
version: '3'
services:
  my-mongoDB:
    image: 'mongo:4.0.19'
    container_name: 'my-mongoDB-container'
    volumes:**
      - db-data:/data/db
      - mongo-config:/data/configdb
    ports:
      - '27017-27019:27017-27019'

volumes:
  db-data:
  mongo-config:
```
Lanciare il container MongoDB con il comando:
$ docker-compose up –d

Verificare che il container sia up:
$ docker ps
$ docker volume ls
$ docker inspect my-mongoDB-container

Tirare giù il container:
$ docker-compose down
oppure:
$ docker rm -f my-mongoDB-container

**Step 5: Installazione di un IDE MongoDB su Windows**
Si può scegliere se installare la IDE ufficiale MongoDB Compass (selezionare “on-premises”):
https://www.mongodb.com/try/download/compass
e/o il tool Robo 3T (scegliere Robo 3T, non Studio 3T)
https://robomongo.org/download
Le due IDE sono in qualche modo complementari: Compass facilità l’analisi e l’inspection delle query (anche di tipo Aggregation framework) e del database, Robo 3T è più semplice e usabile per letture e scritture.
E’ possibile connettersi a MongoDB, attivo in ambiente WSL Ubuntu, tramite le seguenti modalità di connessione:
MongoDB Compass:
•	connection string: 	mongodb://localhost:27017
Robo 3T:
•	Type: 			direct connection
•	Address: 		localhost:27017
Una volta fatto accesso a MongoDB, si può (a) creare il database “snam”, creare la collection “Documents”, inserire almeno un document su tale collection.

**Step 6: Installazione di IntelliJ IDEA e dei plugin per Scala**
Installare IntelliJ per Windows a partire da:
https://www.jetbrains.com/idea/download/#section=windows
e procedere con l’installazione del plugin Driver Scala 2.12.10 per IntelliJ seguendo il link:
https://www.jetbrains.com/help/idea/discover-intellij-idea-for-scala.html

**Step 7: Configurazione del MongoDB Scala driver per IntelliJ IDEA**
Fare riferimento al seguente link:
https://mongodb.github.io/mongo-scala-driver/
che consente di utilizzare il driver all’interno del progetto IntelliJ semplicemente creando una dependency nel file build.sbt:

name := "SbtScalaMongoPrimer"
version := "0.1"
scalaVersion := "2.13.3"
libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "2.9.0"

**Step 8: Esempio di applicazione Scala che legge i dati da una collection MongoDB** *(processo mongod su WSL Ubuntu)*
Con il driver MongoDB Scala correttamente riconosciuto all’interno di IntelliJ, sarà molto semplice scrivere la prima classe Scala che fa accesso a MongoDB ed esegue una query.
Un buon punto di partenza è il seguente:
http://mongodb.github.io/mongo-scala-driver/2.2/getting-started/quick-tour/
e
https://github.com/mongodb/mongo-scala-driver/tree/master/examples/src/test/scala/tour
Dopo aver creato, su IntelliJ, il project SbtMongoPrimer, e il package Tour, si creano le due classi Scala (di tipo Object) Helpers e QuickTour.

Il run sulla classe QuickTour esegue la connessione al db snam ed esegue una find() sulla collection documents ritornando i document in essa memorizzati.

