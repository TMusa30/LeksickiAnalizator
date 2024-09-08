Leksička analiza je prvi korak u prevođenju programskih jezika. Ovdje je dan primjer jednog takvog leskičkog analizatora koji za dani ulaz pretvara tekst u identifikatore, ključne riječi, operatore i brojeve.

Ključne riječi: za, od, do, az.
Komentari: Jednolinijski komentari počinju s // i protežu se do kraja linije.
Identifikatori: Imena varijabli počinju slovom i mogu sadržavati slova i brojeve.
Operatori: Podržani su osnovni aritmetički operatori +, -, *, / te operator pridruživanja =


#INSTALACIJA:
  1. Preuzmite file "LeksickiAnalizator.java"
  2. Nakon što preuzmete kod, kompilirajte ga pomoću javac komande: "javac LeksickiAnalizator.java"
  3. Pokrenite program koristeći java komandu: "java LeksickiAnalizator"
  4. Ulazni podaci se mogu unijeti ručno putem konzole ili preusmjeriti iz tekstualne datoteke: "java LeksickiAnalizator < input.txt"


U drugom repozirotiju ću stavit i program koji uzima zadan program i datoteku s testovima i na temelju njih usporeduje je li dobar izlaz i javlja "correct" ako je dobro i "incorrect" ako nije.
S njim se brže testira jer omogućuje lakšu provjeru.
