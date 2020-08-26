# SbtScalaMongoPrimer
Prima applicazione Scala che accede a MongoDB via MongoDB Scala driver
Target: sviluppare con Scala attraverso IDE IntelliJ IDEA, installata su Windows 10, applicazioni che fanno accesso a MongoDB dockerizzato disponibile su WSL 2 Ubuntu

Step 1: Installazione JDK 8
Prerequisito obbligato per I tool che sarà necessario installare su Windows è Java JDK 8, che si scarica da qui:
https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html
Le note che seguono da applicare nel caso che java non sia automaticamente nel PATH.
Da Esplora File, tasto destro sull’icona Questo PC (o Computer), selezionare la voce Proprietà dal menu che compare. Da Impostazioni di sistema avanzate dalla barra laterale di sinistra, tasto Variabili d’ambiente, quindi tasto Nuova: digitare “JAVA_JDK” nel campo Nome variabile, e il percorso di JDK (es. “C:\Program Files\Java\jdk-11.0.2”) nel campo Valore variabile: cliccare OK per salvare i cambiamenti.
Selezionare la variabile Path dall’elenco delle Variabili di sistema e cliccare sul tasto Modifica. Modificare il campo Valore variabile inserendo la stringa “%JAVA_JDK%\bin”, cliccare su OK per salvare i cambiamenti.

Step 2: Installazione Docker Desktop su Windows
Registrarsi su sito Docker e scaricare l’ultima versione di Docker Desktop per Windows:
https://www.docker.com/products/docker-desktop

Step 3: Installazione WSL Ubuntu e di Docker e Docker Compose al suo interno
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

Step 4: Installazione container MongoDB 4.0.19 su WSL Ubuntu
Nella WSL Ubuntu, creare la dir mongodb e, al suo interno, creare il file docker-compose.yml così valorizzato:
   
Lanciare il container MongoDB: 
$ docker-compose up –d

Verificare che il container sia up:
$ docker ps
$ docker volume ls
$ docker inspect my-mongoDB-container
Tirare giù il container:
$ docker-compose down
oppure:
$ docker rm -f my-mongoDB-container
Lanciare il processo mongod per rendere il servizio MongoDB disponibile e raggiungibile da Windows su porta standard 27017.
