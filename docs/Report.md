# Progetto Minsky Ingegneria del software a.a. 21/22
# Report
## Indice
1. Introduzione
2. Modello di dominio
3. Requisiti specifici:
   - Requisiti funzionali
   - Requisiti non funzionali
4. OO Design



# 1. Introduzione

Il progetto riguarda le realizzazione del famoso gioco Wordle, gioco in cui bisogna indovinare in sei tentativi una parola segreta di cinque lettere. 
Lo svolgimento del lavoro è stato diviso in tre fasi principali dette Sprint, che si ponevano degli obbiettivi:

- Sprint 0: dimostrare familiarità con GitHub e il processo agile.
- Sprint 1: giocare in modo basico.

Il tempo di realizzazione dello Sprint 0 è stato dal 28 Marzo 2022 al 19 Aprile 2022, per quanto riguarda lo Sprint 1 è stato dal 6 Maggio 2022 al 20 Maggio 2022.
Il lavoro è stato suddiviso equamente tra tutti i contributori del progetto:
Proscia Vito, Quagliarella Vincenzo, Romanazzi Raffaello, Tancrini Stefano, Venezia Mario.

# 2. Modello di dominio
(inserire immagine del modello di dominio)
# 3. Requisisti specifici
## 3.1 Requisiti funzionali
Lista dei requisiti funzionali
## 3.2 Requisisti non funzionali
Requisito non funzionale 1 : 

il container docker dell’app deve essere eseguito da terminali che supportano Unicode con encoding UTF-8 o UTF-16.
Elenco di terminali supportati:
<p>Linux:

- terminal

Mac OS:

- terminal

Windows:

- Powershell

- Git Bash (in questo caso il comando Docker ha come prefisso winpty; es: winpty docker -it ....)

**Comando per l’esecuzione del container**
Dopo aver eseguito il comando docker pull copiandolo da GitHub Packages, Il comando Docker da usare per eseguire il container contenente l’applicazione è:

>docker run --rm -it ghcr.io/softeng2122-inf-uniba/wordle-minsky2122:latest

