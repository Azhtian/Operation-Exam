# Obligatorisk innlevering 2

### Kort oppdatert rollefordeling:
* Daniel
    * Sjefsutvikler
* Marius
    * Testansvarlig
    * Logistikkansvarlig
* Stian
    * Nestleder
    * Grafisk designer
* Marita
    * Kundekontakt
    * Grafisk designer
* Sondre
    * Leder
    * Hovedansvar for debugging
    * Dokumentasjon og logg-ansvarlig


## Deloppgave 1

<ul>
<li>Hvordan fungerer rollene i teamet? Trenger dere å oppdatere hvem som er teamlead eller kundekontakt?</li>
  Trenger dere andre roller? Skriv ned noen linjer om hva de ulike rollene faktisk innebærer for dere.
  <ul>
    <li>
      Rollene har vi ikke vært så strenge med. Det har for eksempel vært lite behov for en leder, da gruppen tar beslutninger i fellesskap.
    </li>    
    <li> 
      Leder innebærer å ta beslutninger når man ikke kommer til enighet, eller sørge for at gruppen holder seg på rett spor. Dette har ikke vært særlig til problem, da vi, som sagt, diskuterer problemer som kommer opp. Er leder usikker samarbeider den med nestleder.
    </li>    
    <li>
      Stian og Marita tar på seg mer ansvar innen grafisk design, som innebærer utseende på spillobjekter og menyer.
    </li>
    <li>
      Sondre får ansvaret for dokumentering og møtereferat.
    </li>
    <li>
      Daniel er sjefsutvikler og dermed fikk han hovedansvaret for å restrukturere koden til et MVC-produkt. Han vil også ha hovedansvar for slike store refaktoreringer i fremtiden dersom det skulle bli relevant.
    </li>    
    <li>
      Marius har som logistikkansvarlig pådratt seg ansvaret for å planlegge og reservere grupperom til regelmessige møter med teamet.
    </li>  
  </ul>
</ul>

<ul>
  <li> 
    Er det noen erfaringer enten team-messig eller mtp prosjektmetodikk som er verdt å nevne?
  </li>
  <ul>
    <li>
      Kanban har fungert veldig bra for oss. Det har vært oversiktlig og lett å jobbe med, med god oversikt over alle oppgavene som må gjøres. Det har vært til stor hjelp å se hvor langt vi er kommet på vei og hvem som har jobbet med de forskjellige oppgavene. Det har vært motiverende å flytte oppgaver fra “doing” til “fullført”.
    </li>    
    <li> 
      Videre vil vi se på nytten av å bruke ideer fra scrum mer bevisst. Vi har jobbet litt med scrum ved å dele oppgaver i mindre biter og dele dem ut i løpet av gruppetimen. Vi prøver så å få oppgavene ferdige innen neste møte.
    </li>
  </ul>
</ul>


* Synes teamet at de valgene dere har tatt er gode? Hvis ikke, hva kan dere gjøre annerledes for å forbedre måten teamet fungerer på?
    * Vi synes teamet fungerer bra sammen, men vi burde ha fokusert mer på å skrive objektorientert kode og strukturere prosjektet ifølge MVC strukturen i starten av prosjektet. Det ville ført til mindre arbeid for oss nå, og gjort det lettere å skrive tester.
  


* Hvordan er gruppedynamikken? Er det uenigheter som bør løses?
    * Gruppen kommuniserer godt med hverandre, og har få uenigheter. De største uenighetene vi hadde var hvordan vi ønsket å implementere en MVC model, men det løste seg i løpet av en gruppetime.



* Hvordan fungerer kommunikasjonen for dere?
    * Kommunikasjonen har fungert veldig godt i gruppen. Dette fordi vi har hatt hyppig kommunikasjon gjennom discord, vi har hatt møter 2 ganger i uken og vi har jobbet sammen i gruppetimene. Det har vært lav terskel for å stille spørsmål om hjelp fra noen i teamet. Alle valg som vi har gjort har blitt diskutert grundig og alle sine meninger blir hørt.
    Vi har hatt en lett og munter tone i alle møter og gruppetimer. Vi har hatt god kultur for å fortelle vitser og spøke om oppgaven, eller vise frem morsomme bugs i koden.
    Alle har bidratt jevnt til kommunikasjon og deltatt på møter. Alle har hatt god responstid på discord og det har aldri vært noe uklarhet om hvor møter skal holdes, om folk blir sein eller om de deltar digitalt eller fysisk.



* Gjør et kort retrospektiv hvor dere vurderer hva dere har klart til nå, og hva som kan forbedres. Dette skal handle om prosjektstruktur, ikke kode. Dere kan selvsagt diskutere kode, men dette handler ikke om feilretting, men om hvordan man jobber og kommuniserer.
    * Vi har klart å få til ganske mange av MVP-kravene vi ønsket, og fått et mer objektorientert prosjekt totalt sett.
    * Vi har brukt Trello prosjekttavlen og fått mer oversikt over arbeidsoppgaver og status. I tillegg til å ha tegnet et kodediagram og fått klarere oversikt over hele prosjektet.
    * Likevel har vi forbedringspotensial når det kommer til antall tester i prosjektet.
    * Når prosjektet veldig ofte blir oppdatert med nye commits har det vært hjelpsomt at personen som er ansvarlig for den nye kodeendringen har brukt tid på å forklare endringene til resten av teamet. I tillegg har vi raskt funnet løsninger, ved å samarbeide i gruppetimene og "par programmert" hvis noen står fast eller vil ha innspill.
 


* Under vurdering vil det vektlegges at alle bidrar til kodebasen. Hvis det er stor forskjell i hvem som committer, må dere legge ved en kort forklaring for hvorfor det er sånn. Husk å committe alt. (Også designfiler)
    * Vi har så langt ikke brukt noen analyseverktøy eller lignende for å sjekke koden; det har vært hovedsakelig manuell testing og et par JUnit tester. Dette er noe vi kan forbedre til senere, både det å bruke et analyseverktøy, men også det å skrive flere tester.
    * Trello er et produkt vi har fått til og prosjekt tavlen har blitt hyppig brukt. Dette har fungert veldig godt. Vi har oppdatert den kontinuerlig og lagt til nye oppgaver underveis. Link til [project board](https://trello.com/b/233wC0Wh/project-board). En forbedring vi har tenkt til å utføre er å sette begrensninger på hvor mange elementer som kan være under de ulike postene på prosjekt tavlen
    * Vi har til nå jobbet mellom gruppemøter hvor alle velger en oppgave fra trello og kan fullføre den på neste møte. Oppgavene har vært litt i forskjellige størrelser, fra å fikse noe smått til å endre på hele kodestrukturen. Som en følge har noen oppgaver tatt litt lengre tid. Vi synes at det har fungert, men vi ser også at det finnes forbedringspotensiale. Vi kan blir bedre på å dele opp oppgaver i passelige biter til arbeidsintervallet vi har satt, og prøve å endre lengden på intervallet for å teste om det gir bedre produktivitet og mer jevn arbeidsfordeling. Dette vil samsvare mer med scrums sprinter.
    * Det viser seg at Sondre har mange flere commits enn mange andre i gruppen. Dette har mye med at han ofte fikser merge-conflicts, eller committer små feilrettinger. Dette gjør at han får mange flere commits på mindre størrelse, mens andre i gruppen ofte har større endringer i kodebasen.
    * Daniel, som er en av dem med færrest commits har restrukturert hele kodebasen, og har veldig ofte store endringer i kodestruktur.
    * Marita er også i samme kategori som Daniel, hvor hun har gjort store endringer når hun committer. Hun er ansvarlig for å ha laget hele `ScreenManager` systemet vi bruker.



* Referat fra møter siden forrige leveranse skal legges ved (mange av punktene over er typisk ting som havner i referat)
    * Referat ligger vedlagt i bunnen



* Bli enige om maks tre forbedringspunkter fra retrospektivet, som skal følges opp under neste sprint.
    * Vi burde ha større fokus på å skrive gode brukerhistorier og få på plass akseptansekrav til hver arbeidsoppgave før vi begynner på selve oppgaven.
    * Bruke Scrum-metodikken i større grad ved å dele opp arbeidsoppgaver i mindre deloppgaver som er gjennomførbare i det gitte sprint intervallet. Dermed kan vi sette strengere deadlines for oppgavene.
    * Ta i bruk analyseverktøy og verktøy for testing av koden. Samt utbedre test-prosessen og Dokumentasjon av manuelle tester.


## Deloppgave 2

* Bestem dere for én litt mer avansert ting som dere vil prøve å få til utover et vanlig single-player platform spill. Dette kan være f.eks.: multiplayer (på samme maskin eller over nett), å porte til en annen platform (Android eller Web, f.eks.), å bytte ut grafikk-frontenden, e.l.
  Dropp multiplayer fra MVP om dere velger noe annet her ;)

* Prioritér MVP og å få de enklere delene av spillet til å fungere – det er mye viktigere å ha et bra enspiller-spill for desktop med høy kodekvalitet, enn å ha noe som funker dårlig i med både én og flere spillere og på flere platformer.

* Det er likevel et poeng i å tenke på dette tidlig i prosessen, så man ikke låser seg i dårlige løsninger. (Forøvrig, godt design, bra skille mellom model / view / controller, og klare abstraksjoner gjør det mye enklere å oppnå «stretch»-forslagene over.)


### MVP

* Oppdater hvilke krav dere har prioritert, hvor langt dere har kommet og hva dere har gjort siden forrige gang. Er dere kommet forbi MVP? Forklar hvordan dere prioriterer ny funksjonalitet.
    * Vi har stort sett oppnådd all MVP kravene fra oppgaven. Vi valgte å gjennomføre forslaget med multiplayer som “stretch-goal”. Vi har implementert støtte for multiplayer lokalt på maskinen, og ønsker å utvide dette til flerspiller over lokalt nettverk.
    * Ny funksjonalitet prioriteres etter hvor mye vi tenker det forbedrer brukeropplevelse, og hvor viktig det er for å få spillet til å fungere. Dersom det er en funksjonalitet som krever noe restrukturering prioriteres dette, ettersom det bare blir mer arbeid dess lengre det utsettes.



* For hvert krav dere jobber med, må dere lage 1) ordentlige brukerhistorier, 2) akseptansekriterier og 3) arbeidsoppgaver. Husk at akseptansekriterier ofte skrives mer eller mindre som tester


* Dersom dere har oppgaver som dere skal til å starte med, hvor dere har oversikt over både brukerhistorie, akseptansekriterier og arbeidsoppgaver, kan dere ta med disse i innleveringen også.
  Forklar kort hvordan dere har prioritert oppgavene fremover


* Har dere gjort justeringer på kravene som er med i MVP? Forklar i så fall hvorfor. Hvis det er gjort endringer i rekkefølge utfra hva som er gitt fra kunde, hvorfor er dette gjort?
  Oppdater hvilke krav dere har prioritert, hvor langt dere har kommet og hva dere har gjort siden forrige gang.
  Husk å skrive hvilke bugs som finnes i de kravene dere har utført (dersom det finnes bugs).
  Kravlista er lang, men det er ikke nødvendig å levere på alle kravene hvis det ikke er realistisk. Det er viktigere at de oppgavene som er utført holder høy kvalitet. Utførte oppgaver skal være ferdige.
  
    * Vise spillbrett, spiller, og fiender på spillbrettet fungerer uten feil. Spillere og fiender har den størrelsen de fremstår som på spillbrettet.
    * Spiller kan interagere med terreng og kan bevege seg ved hjelp av piltastene. Dette fungerer også uten problem. Spiller kan også kun hoppe når spiller står på bakken.
    * Spiller interagerer også med poenggjenstander, og har en poengteller man kan lese av.
    * Fiender som kan interagere med spiller og terreng fungerer bra. Det er forskjellige typer fiender; noen søker spilleren ut aktivt, mens andre hopper når de kommer til en kant. Spilleren tar også skade ved å komme i kontakt med en fiende.
    * Spilleren kan dø ved å være borti en fiende for mange ganger.
    * Spillbrettet har et mål, som for øyeblikket er et sted. Å nå dette “stedet” gjør at du vinner banen.
    * Spillet gir deg et nytt brett når du er ferdige med det forrige, men for øyeblikket er bare ett kart implementert. Vi kommer til å jobbe med å få inn flere kart, men vi prioriterte funksjonalitet før vi designet kartene.
    * Spillet har en start-skjerm, en pause-skjerm, og både tap- og seiers-skjerm. Det er også flere undermenyer. Dersom man navigerer gjennom undermenyene og på en spesiell måte starter spillet hvor man taper eller vinner før spillet egentlig starter. Dette overkommes lett ved å trykke “New Game” igjen, men det er en kjent feil som jobbes med.
    * Spillet kan støtte 2 spillere, men det er for øyeblikket ikke noen måte å se forskjellen mellom dem. Dette er også noe som skal fikses.


## Deloppgave 3

* Utbedring av feil: hvis dere har rettet / forbedret noe som dere har fått trekk for tidligere, lag en liste med «Dette har vi fikset siden sist», så det er lett for gruppelederne å få oversikt.
  I README.md: Dere må dokumentere hvordan prosjektet bygger, testes og kjøres, slik at det er lett for gruppelederne å bygge, teste og kjøre koden deres. Under vurdering kommer koden også til å brukertestes.


* Prosjektet skal kunne bygge, testes og kjøres på Linux, Windows og OS X – dere kan f.eks. spørre de andre teamene på gruppen om dere ikke har tilgang til alle platformene. OBS! Den vanligste grunnen til inkompatibilitet med Linux er at filnavn er case sensitive, mens store/små bokstaver ikke spiller noen rolle på Windows og OS X. Det er viktig å sjekke at stiene til grafikk og lyd og slikt matcher eksakt. Det samme vil antakelig også gjelde når man kjører fra JAR-fil.
    * Prosjektet er compilert, pakket, og testet på Linux og Windows uten problemer. 
  


* Lag og lever et klassediagram. (Hvis det er veldig mange klasser, lager dere for de viktigste.) Det er ikke nødvendig å ta med alle metoder og feltvariabler med mindre dere anser dem som viktige for helheten. (Eclipse har forskjellige verktøy for dette.)
    * Vedlagt ligger et [klassediagram](https://git.app.uib.no/biosoft-productions/Operation-Exam/-/tree/master/Deliverables/classDiagramOblig2.png) som viser den generelle strukturen for programmet. Her er alle metodene med i diagrammet, da vi ikke hadde noe kontroll over hvilke metoder og lignende som ble tatt med av programmet.
 

* Kodekvalitet og testdekning vektlegges. Dersom dere ikke har automatiske tester for GUI-et, lager dere manuelle tester som gruppelederne kan kjøre basert på akseptansekriteriene.


* Statiske analyseverktøy som SpotBugs eller SonarQube kan hjelpe med å finne feil dere ikke tenker på. Hvis dere prøver det, skriv en kort oppsummering av hva dere fant / om det var nyttig.
    * Ved å bruke et slikt analyseverktøy så vi at vi hadde en del imports som ikke ble brukt, samt et par steder hvor kode var mer eller mindre duplisert. Dette er noe vi kommer til å jobbe med å redusere fremover.
    * Ved hjelp av `spotbugs` så vi også at det vare en del optimalisering vi kunne gjøre, samt noe kode som var "dodgy". Dette er igjen mer som kommer til å bli fokusert på.
  


* Automatiske tester skal dekke forretningslogikken i systemet (unit-tester). Coverage kan hjepe med å se hvor mye av koden som dekkes av testene – i Eclipse kan dette gjøres ved å installere EclEmma gjennom Eclipse Marketplace.

* Utførte oppgaver skal være ferdige. Slett filer/kode som ikke virker eller ikke er relevant (ennå) for prosjektet. (Så lenge dere har en egen git branch for innlevering, så er det ikke noe stress å fjerne ting fra / rydde den, selv om dere fortsetter utviklingen på en annen gren.


## Vedlegg Møtereferat


### Møtereferat 15.03.2022

Alle til stede (Marita over discord)

Finne ut hva vi vil gjøre med MVC Model view controller
Bruke MVC ved:
Main starter GameScreen som instansierer en controller og en model. User input sendes til controlleren, og controlleren styrer endringer på Model klassen

Andre bestemmelser:
Ha kort gjennomgang om hva som ble gjort i løpet av uken

Bestemmelser om ting som må fikses:
MVP
Handlingsreferat må skje hele tiden
Bestemme oss for et større prosjekt

Til neste gang:
Prøve å implementere Model, View, Controller
Se om flowchart kan lages
Code review


### Møtereferat 18.03.2022

Alle til stede (Marita discord)

Gjennomang av gjort oppgaver
Daniel begynner sin presentasjon av bevegelse til MVC kode.
Sondre viser UML diagrammet som er laget
Stian viser hvilke feil han har fikset

Videre arbeid:
Sondre - Enemy sprites  
Marita - Lyd / musikk  
Daniel - Enemies og player  
Stian - Level design  
Marius - Score items og merge til master - Begynner også å jobbe med to-spiller modus.


### Møtereferat 22.03.2022

Tilstede: Daniel, Marius, Sondre, Stian (Discord)

Daniel begynner med å presentere hva han har gjort
Marius forklarer hvordan vi kan bruke arbeidet hans
Sondre viste hvordan han hadde lagt til animasjoner på ene enemy classen.

Til neste gang:
Fullføre oblig 2


### Møtereferat 25.03.2022

Til stede: Sondre, Marius, Stian (Discord), Marita (Discord), Daniel (forsinket).

Daniel viser hva han har gjort med EnemyDecicionTree

Dagens gjøremål: Fullføre oblig 2. 