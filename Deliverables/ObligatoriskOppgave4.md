# Oblig 4 - Operation Exam

* Team: *Biosoft productions* (Gruppe 2, Team 3) *Marius Lokøen Hatland, Stian Adrian Rykkje, Marita Aakre, Daniel Beadle, Sondre Nordmoen*

### Innhold

[Deloppgave 1](#deloppgave-1)  
[Større retrospektiv for oblig 4](#større-retrospektiv-for-oblig-4)  
[Deloppgave 2](#deloppgave-2)  
[Deloppgave 3](#deloppgave-3)  
[MVP](#mvp)  
[Møtereferat](#vedlegg-møtereferat)  
[Brukerhistorier og akseptansekriterier](#brukerhistorier-og-akseptansekriterier)  


###  Rollefordeling:

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

[Top](#oblig-4-operation-exam)  

* Hvordan fungerer rollene i teamet? Trenger dere å oppdatere hvem som er teamlead eller kundekontakt?
Trenger dere andre roller? Skriv ned noen linjer om hva de ulike rollene faktisk innebærer for dere.
  * Rollene har fungert bra. Vi har beholdt rollene fra forrige gang, da disse har fungert bra på de to forrige obligene. 
  * Leder innebærer å ta beslutninger når man ikke kommer til enighet, eller sørge for at gruppen holder seg på rett spor. Dette har ikke vært særlig til problem, diskuterer problemer som kommer opp. Er leder usikker samarbeider den med nestleder.
  * Sondre har ansvaret for dokumentering og møtereferat.
  * Stian og Marita har som grafiske designere, hatt ansvar for utseende på spillobjekter, level-derign og menyer.
  * Daniel er sjefsutvikler og dermed fikk han hovedansvaret for å restrukturere koden til et MVC-produkt. Han vil også ha hovedansvar for slike store refaktoreringer i fremtiden dersom det skulle bli relevant.
  * Marius har som logistikkansvarlig ansvar for å planlegge og reservere grupperom til regelmessige møter med teamet. Som testansvarlig har han ansvar for å teste spille, både ved bruk av enhetstester og manuelle tester.


* Er det noen erfaringer enten team-messig eller mtp prosjektmetodikk som er verdt å nevne?  
  * Kanban har fungert veldig bra for oss. Det har vært oversiktlig og lett å jobbe med, med god oversikt over alle oppgavene som må gjøres. Det har vært til stor hjelp å se hvor langt vi er kommet på vei og hvem som har jobbet med de forskjellige oppgavene. Det har vært motiverende å flytte oppgaver fra “doing” til “fullført”.
I siste innlevering har vi brukt elementer fra scrum med stor suksess. På starten av innleveringen gikk vi gjennom alle tingene som vi hadde lyst å gjøre med prosjektet før siste innlevering. Detter var alt fra bug-fixes og tester til implementering av en boss-fiende. Vi fant fort ut at vi ikke hadde tid til alt vi ville gjøre. Da bestemte vi oss for hva som var viktig, og hva vi kunne droppe. Så fordelte vi oppgavene mellom oss, og jobbet med det hver for oss den neste uken. Vi hadde fortsatt gruppemøter der vi snakket om hva vi hadde gjort og kunne hjelpe hverandre om vi trengte det.

* Synes teamet at de valgene dere har tatt er gode? Hvis ikke, hva kan dere gjøre annerledes for å forbedre måten teamet fungerer på?
  * Vi synes teamet fungerer bra sammen, men vi burde ha fokusert mer på å skrive objektorientert kode og strukturere prosjektet ifølge MVC strukturen i starten av prosjektet. Det ville ført til mindre arbeid for oss nå, og gjort det lettere å skrive tester.

* Hvordan er gruppedynamikken? Er det uenigheter som bør løses?
  * Gruppen kommuniserer godt med hverandre, og har få uenigheter. De største uenighetene vi hadde var hvordan vi ønsket å implementere en MVC model, men det løste seg i løpet av en gruppetime.


* Hvordan fungerer kommunikasjonen for dere?
  * Kommunikasjonen har fungert veldig godt i gruppen. Dette fordi vi har hatt hyppig kommunikasjon gjennom discord, vi har hatt møter 2 ganger i uken og vi har jobbet sammen i gruppetimene. Det har vært lav terskel for å stille spørsmål om hjelp fra noen i teamet. Alle valg som vi har gjort har blitt diskutert grundig og alle sine meninger blir hørt.
  * Vi har hatt en lett og munter tone i alle møter og gruppetimer. Vi har hatt god kultur for å fortelle vitser og spøke om oppgaven, eller vise frem morsomme bugs i koden.
Alle har bidratt jevnt til kommunikasjon og deltatt på møter. Alle har hatt god responstid på discord og det har aldri vært noe uklarhet om hvor møter skal holdes, om folk blir seine eller om de deltar digitalt eller fysisk.
* Under vurdering vil det vektlegges at alle bidrar til kodebasen. Hvis det er stor forskjell i hvem som committer, må dere legge ved en kort forklaring for hvorfor det er sånn. Husk å committe alt. (Også designfiler)
  * Antall commits er ikke representativt for hvor mye noen bidrar til teamet.
    * Det viser seg at Sondre har mange flere commits enn mange andre i gruppen. Dette har mye med at han ofte fikser merge-conflicts, eller committer små feilrettinger. Dette gjør at han får mange flere commits på mindre størrelse, mens andre i gruppen ofte har større endringer i kodebasen.
    * Ved å gjøre svarene om til markdown format får man lett mange commits, da det er mange småting å endre på hele tiden. Dette har også gjort at Sondre har flere commits.
    * Daniel, som er en av dem med færrest commits har restrukturert hele kodebasen, og har veldig ofte store endringer i kodestruktur.
    * Marita er også i samme kategori som Daniel, hvor hun har gjort store endringer når hun committer. Hun er ansvarlig for å ha laget hele `ScreenManager` systemet vi bruker.


* Referat fra møter siden forrige leveranse skal legges ved (mange av punktene over er typisk ting som havner i referat)
  * [Referat](#vedlegg-møtereferat) ligger vedlagt i bunnen

* Bli enige om maks tre forbedringspunkter fra retrospektivet, som skal følges opp under neste sprint.

  * Bruke Scrum-metodikken i større grad ved å dele opp arbeidsoppgaver i mindre deloppgaver som er gjennomførbare i det gitte sprint intervallet. Dermed kan vi sette strengere deadlines for oppgavene.
    * Vi har lyst å bruke scrum-metodikken i større grad. Vi tenker det er mer passende til oblig 4 siden vi da har litt større oppgaver som må på plass, spesielt stretch goalet.
  * Vi har lyst å lage et ferdigstilt produkt. Til nå har vi hatt en del uferdige funksjonaliteter som vi har latt bli i prosjektet. Siden neste innlevering er den siste, har vi lyst å passe på at alt fungerer på en god måte til slutt.
  * Det siste vi ønsker å forbedre er test-coverage. Flere tester, automatiske tester og bedre tester generelt. Mange av testene våre har til nå vært manuelle tester.

### Større retrospektiv for oblig 4
* Gjør et retrospektiv hvor dere vurderer prosjektet har gått. Hva har dere gjort bra, hva hadde dere gjort annerledes hvis dere begynte på nytt? 
  * Gruppetimene og arbeid i gruppetimene er noe av det som har fungert veldig bra. Vi har hatt en strategi hvor vi i starten av hver gruppetime har hatt en gjennomgang av hovedessensen av det hver av oss har gjort, slik at vi alle vet hva som er endret og hvordan det er endret. Vi diskuterer så hva som er det viktigste å ordne til neste gang, og blir enige om hvordan vi skal fordele oppgavene rundt dette. Vi jobber så gruppevis hvor de som jobber med samme del av oppgaven gjerne jobber sammen, og diskuterer seg imellom. Dette er en strategi som har vist seg å være svært effektiv for oss. Dersom vi skulle begynt med prosjektet i dag er dette trolig noe vi ville hatt mer fokus på fra starten av.  
  * Kanban er utviklingsstrategien vi har brukt i all hovedsak, litt i sammenheng med scrum. Når det gjelder Kanban har tavlen (Vi har brukt trello) vært veldig nyttig til å få en tydelig oversikt over hva som må gjøres, og hva som er gjort. Det har også vært lett å prioritere ting ved hjelp av tavlen. Dette var noe vi startet tidlig med, men vi ble bedre på å bruke tavlen mer effektivt utover i prosjektet. Dersom vi startet prosjektet på ny med den kunnskapen vi nå har hadde det vært en stor fordel i å effektivisere startfasen av prosjektet, men ettersom det er noe vi allerede brukte fra starten er det bare et effektiviseringsspørsmål.
  * Når det kommer til scrum, som er den andre utviklingsstrategien vi brukte, var det litt vanskeligere. Scrum fungerer veldig godt sammen med kanban, men ettersom vi i starten ikke helt visste når de forskjellige innleveringsfristene var, ble det vanskelig å sette opp en såkalt “sprint”. Dette ble lettere når obligatoriske innlevering 2 ble lagt ut, da den kom med innleveringsfristene til alle de resterende innleveringene. Dersom vi startet på nytt burde vi diskutert en fast “sprint” lengde som vi kunne brukt mer uavhengig av når innleveringsoppgavene kom. Vi kunne trolig vært mer effektive dersom vi kom i gang med dette med en gang, men det kunne muligens gitt redusert effekt da vi allerede jobbet effektivt. Det scrum kunne ha hjulpet med var å sette konkrete mål innen visse datoer, for selv om vi jobbet effektivt ble noen oppgaver utsatt eller gjort senere enn vi hadde planlagt. Dette var ikke et stort problem da oppgaver som regel ble gjort på tiden, men det kunne fanget opp en og annen oppgave.
  * Arbeidsrollene er noe som har endret seg i liten grad utover prosjektet. De har likevel endret seg, og dersom vi begynte på nytt, ville hadde vi vært mer konkrete i hva som var forventet av de forskjellige oppgavene og hvilke ansvarsområder de sto for. Vi hadde også begynt med de arbeidsoppgavene vi nå avslutter med, da denne fordelingen har fungert godt for vårt team.
  * Kommunikasjonen har også utviklet seg gjennom prosjektet. Gruppen har aldri hatt dårlig kommunikasjon, men den har stadig forbedret seg. I starten var vi kanskje litt redde for å gi våre egne meninger eller si ifra dersom vi var uenige, men etter hvert ble vi bedre på dette. Dersom vi begynte på ny og kjente hverandre slik vi nå gjør ville vi kunne mer effektivt kommet til enighet. Dette har ikke vært et veldig stort problem, ettersom vi aldri hadde dårlig kommunikasjon, men det kunne hjulpet i starten på å få en god kodebase med en struktur vi alle var enige om.
  * Kodestruktur er viktig, og er noe vi hadde satt et mye større fokus på i starten dersom vi hadde den kunnskapen vi har nå. Model-view-controller var ikke et begrep vi var veldig kjent med i starten, så det gjorde at den ene uken gikk bort til refaktorering av kodestrukturen. Dersom vi hadde hatt kjennskap til MVC kunne vi begynt med programmeringen med denne strukturen i bunn. 

## Deloppgave 2

[Top](#oblig-4-operation-exam)  

* Bestem dere for én litt mer avansert ting som dere vil prøve å få til utover et vanlig single-player platform spill. Dette kan være f.eks.: multiplayer (på samme maskin eller over nett), å porte til en annen platform (Android eller Web, f.eks.), å bytte ut grafikk-frontenden, e.l.
Som stretch-goal til oblig 4 har vi laget et bosslevel. Dette gir en god avsluttning på spillet. Det var ikke et så veldig stort stretch goal, noe som passet bra siden vi hadde mange andre ting å få unnagjort før siste innlevering. Vi er likevel godt fornøyd med resultatet.

## MVP
[Brukerhistorier](#brukerhistorier-og-akseptansekriterier) ligger på bunn av filen
* Oppdater hvilke krav dere har prioritert, hvor langt dere har kommet og hva dere har gjort siden forrige gang. Er dere kommet forbi MVP? Forklar hvordan dere prioriterer ny funksjonalitet.
  * Vi har oppnådd MVP, og jobber nå hovedsakelig med å ferdigstille det produktet vi allerede har. Ny funksjonalitet havner derfor lengre bak i køen, og bug-fixing og forbedringer av brukeropplevelsen prioriteres.

* For hvert krav dere jobber med, må dere lage 1) ordentlige brukerhistorier, 2) akseptansekriterier og 3) arbeidsoppgaver. Husk at akseptansekriterier ofte skrives mer eller mindre som tester

  * Fullførte krav fra MVP liste \([Original MVP-liste](./ObligatoriskOppgave1.md#brukerhistoriermvp)\) \([Brukerhistorier fra Oblig 3](./ObligatoriskOppgave3.md#brukerhistorier-og-akseptansekriterier)\)
    * Vise spillbrett, spiller, og fiender på spillbrettet fungerer uten feil. Spillere og fiender har den størrelsen de fremstår som på spillbrettet.
    * Spiller kan interagere med terreng og kan bevege seg ved hjelp av piltastene. Dette fungerer også uten problem. Spiller kan også kun hoppe når spiller står på bakken.
    * Spiller interagerer også med poenggjenstander, og har en poengteller man kan lese av.
    * Fiender som kan interagere med spiller og terreng fungerer bra. Det er forskjellige typer fiender; noen søker spilleren ut aktivt, mens andre hopper når de kommer til en kant. Spilleren tar også skade ved å komme i kontakt med en fiende.
    * Spilleren kan dø ved å være borti en fiende for mange ganger.
    * Spillbrettet har et mål, som for øyeblikket er et sted. Å nå dette “stedet” gjør at du vinner banen.
    * Spillet gir deg et nytt brett når du er ferdige med det forrige, og flere baner begynner å bli implementert.
    * Spillet har en start-skjerm, en pause-skjerm, og både tap- og seiers-skjerm. Det er også flere undermenyer. Dersom man navigerte gjennom undermenyene på en spesiell måte startet spillet hvor man tapte eller vant før spillet egentlig startet. Dette skal være fikset.
    * Spillet kan nå støtte 2 spillere.


## Deloppgave 3

[Top](#oblig-4-operation-exam)  

* Utbedring av feil: hvis dere har rettet / forbedret noe som dere har fått trekk for tidligere, lag en liste med «Dette har vi fikset siden sist», så det er lett for gruppelederne å få oversikt.
  * Vi har gjort utbedringer de elemente vi fikk tilbakemelding på av gruppeleder.
  * Vi har skrevet en mer stegvis forklaring i readme på hvordan man kjører spillet og testene.
   * Vi har gjort en code inspection og ryddet opp i mesteparten av feilene der. (mange av feilene er bare rettskrivingsfeil fordi vi skriver på norsk)
  * Vi har vært tydligere på de akseptansekravene vi har skrevet
 
* Prosjektet skal kunne bygge, testes og kjøres på Linux, Windows og OS X – dere kan f.eks. spørre de andre teamene på gruppen om dere ikke har tilgang til alle platformene. OBS! Den vanligste grunnen til inkompatibilitet med Linux er at filnavn er case sensitive, mens store/små bokstaver ikke spiller noen rolle på Windows og OS X. Det er viktig å sjekke at stiene til grafikk og lyd og slikt matcher eksakt. Det samme vil antakelig også gjelde når man kjører fra JAR-fil.
  * Prosjektet er testet på Windows, Linux og Mac. Se README.md for hvordan bygge og kjøre proskjetet.  
 
* Lag og lever et klassediagram. (Hvis det er veldig mange klasser, lager dere for de viktigste.) Det er ikke nødvendig å ta med alle metoder og feltvariabler med mindre dere anser dem som viktige for helheten. (Eclipse har forskjellige verktøy for dette.)
  * Vedlagt ligger et [klassediagram](https://git.app.uib.no/biosoft-productions/Operation-Exam/-/tree/master/Deliverables/classDiagramOblig4.png) \([full størrelse](https://git.app.uib.no/biosoft-productions/Operation-Exam/-/raw/master/Deliverables/classDiagramOblig4.png)\) som viser den generelle strukturen for programmet. Her er alle metodene med i diagrammet, da vi ikke hadde noe kontroll over hvilke metoder og lignende som ble tatt med av programmet.  
 

* Kodekvalitet og testdekning vektlegges. Dersom dere ikke har automatiske tester for GUI-et, lager dere manuelle tester som gruppelederne kan kjøre basert på akseptansekriteriene.
  * Manuelle tester vi har gjort:
    * Sensor rektanglene til enemy er testet ved å printe rektangelet og rektangelet til selve enemyen ved siden av hverandre og sammenligne mens de beveger seg rundt i verdenen. Sensor boolean er testet ved å printe true/false verdien mens enemy beveger seg rundt.
    * Runner sin chase logikk er testet ved å observere hvordan den oppfører seg når en spiller er i nærheten. (snur den seg, øker den farten, ignorerer den at den kommer til å falle?)
    * Menysystemet er testet ved å trykke seg gjennom de ulike menyene. Starter spillet på nytt når det skal uansett hvordan man kommer inn i level select, og uansett om man velger bane 1 eller 2? Blir det riktig antall spillere når man velger det i hovedmenyen? Fungerer det å gå tilbake til hovedmenyen og velge antall spillere på nytt?
    * Level progresjon har blitt testet ved å spille gjennom spillet og se at man kommer videre til neste level ved oppnådd mål for gjeldende level. Game finished har blitt testet ved å fullføre det siste levelet og se at vi blir tatt med til game finished screen.

* Statiske analyseverktøy som SpotBugs eller SonarQube kan hjelpe med å finne feil dere ikke tenker på. Hvis dere prøver det, skriv en kort oppsummering av hva dere fant / om det var nyttig.
  * Ved å bruke et slikt analyseverktøy så vi at vi hadde en del imports som ikke ble brukt, samt et par steder hvor kode var mer eller mindre duplisert. Dette er noe vi kommer til å jobbe med å redusere fremover.
  * Ved hjelp av `spotbugs` så vi også at det var en del optimalisering vi kunne gjøre, samt noe kode som ble klassifisert som “dodgy”. Dette er noe vi vil arbeide med å fikse.


# Vedlegg Møtereferat

[Top](#oblig-4-operation-exam)

## Møtereferat 19.04.2022

Til stede: Marius, Sondre, Marita (Discord), Stian (Discord), Daniel (Discord)

Gikk gjennom trello for å sette prioritetsliste.  
 - Fullføre allerede påbegynte oppgaver  
 - Tester  
 - Stretch-goal  
 - Nye funksjonaliteter  

Alle som ikke har lagd en level til neste gang lager en level til fredag.


## Møtereferat 26.04.2022

Til stede: Sondre, Marius, Daniel, Stian, Marita (Discord)


Ender opp med å lage en boss-level
- Hva vi vil ha:  
  - "Super mario spøkelse"  
  - Går gjennom vegger -> Sjekker ikke vegg-collisions  
  - Går sakte rett mot deg  


Hva som mangler:  
- Antall leveler i readme  
- Fix level 2  
- Tutorial  
  - Readme?  
- Bugs og kodekvalitet  
  - Analysere prosjektet, refaktorere  
  - "Kan ikke reise seg opp når player er under en platform" -> Daniel fikser  
  - "Helikopter runner" når man står rett over eller rett under. -> Sondre fikser  
  - Enemies kolliderer i tynne platformer - Quick fix -> Stian  
- Klokken?  
  - Merger inn  
- Forbedre stegvis hvordan bygge prosjekt i readme  




# Brukerhistorier og akseptansekriterier

[Top](#oblig-4-operation-exam)  
[Original MVP-liste](./ObligatoriskOppgave1.md#brukerhistoriermvp)  
[Brukerhistorier fra Oblig 3](./ObligatoriskOppgave3.md#brukerhistorier-og-akseptansekriterier)


## Brukerhistorier:

### Klokke
Som spiller trenger jeg en klokke som sier hvor lang tid jeg har brukt på hvert level slik at jeg vet hvor rask jeg er og hvor lang tid jeg har igjen til eksamen starter.
### Tutorial-level
Som spiller trenger jeg en opplæringsbane slik at jeg vet hvordan man spiller spillet, og jeg har all kunnskapen jeg trenger for å fullføre spillet
### Score-board
Som spiller trenger jeg en endelig score når jeg er ferdig med spillet, slik at jeg vet hvor flink jeg var og eventuelt hva jeg må gjøre bedre for å få en bedre score neste gang.
### Boss Fight
Som spiller trenger jeg en utfordrign på slutten av spillet som jeg må overkomme for å slå spillet. 


## Akseptansekriterier:
### Klokke
Klokken skal begynne å telle i det man starter spillet. Klokken skal ikke begynne på nytt etter hvert level, men skal hele tiden fortsette å telle. Den skal heller ikke begynne på nytt hvis spilleren dør. Den skal kun telle videre og vises når man er i spillet, ikke når man er i menyene.
### Tutorial-level
Tutorial level skal inneholde instrukser for alle bevegelser spilleren kan gjøre og forklaring på at man skal unngå fiendene og at man kan plukke opp bøker.
### Score-Board 
Score skal beregnes ut fra hvor mange bøker spilleren plukker opp og hvor lang tid spilleren bruker på å fullføre spillet. Denne scoren skal vises som en karakter fra A-F når man er ferdig med hele spillet. 
### Boss
Bossen skal være en utfordrende fiende som preger hele levelet. Vi har bestemt oss for en stor fiende som følger etter deg hele veien. Den skal bevege seg direkte mot spilleren med en konstant fart. Treffer den spilleren, skal spilleren miste et liv. Den skal ikke kolidere med terrenget. Det må være mulig å fullføre boss-banen.
