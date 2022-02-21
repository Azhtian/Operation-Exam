# Prosjektplan
# Deloppgave 1 (uke 6): Organiser teamet
## Team Details 
### Kartlegging av teamet:
**Daniel** har tidligere erfaring med å lage spill, inkludert side-scrollere, så han bringer mye til bordet med sin kunnskap. Hans kompetanse gjør at han får rolle som sjefsutvikler, og vil kunne komme med gode bidrag til teamet når det er steder vi er usikre på hvordan vi skal fortsette. 

**Stian** har også laget spill før, og har også god kompetanse på game-logic. Han vil ha kontroll på verktøy vi bruker, og sørge for at alle bruker samme versjon av både java og pakker som brukes i programmet. Stian vil også ha hovedkontrollen for skrivingen av log, der det trengs. Han vil også fungere som nestleder for prosjektet, og overta som leder dersom det skulle være behov for dette.

**Marius** har utviklet spill før, men føler ikke hans styrke ligger i grafisk design. Gjennom hans egne prosjekter, og gjennom studiets løp, har han derimot vært eksponert mye for Git. Han har derfor et større ansvar for Git, og vil være den teamet går til dersom det er konflikter med merger eller lignende. Han liker struktur og orden, og dette setter ham opp som testansvarlig. 

**Marita** er den med minst erfaring på laget, men det betyr ikke hun kommer svakere ut. Hun har kodeerfaring med Python, og mindre kjennskap til Java og objektorientert programmering. Hun ønsker å være kundekontakten, bindeleddet mellom teamet og faget. En rolle som gir henne ansvar utover ren programmering gjør at hun lettere kan sette seg inn i de områdene hun ikke er helt kjent med enda, og jobbe stødig med de hun har kontroll på. 

**Sondre** har noe erfaring med spillprogrammering, men det er ikke det han har jobbet mest med. Han har noe ledererfaring fra før, som gjør at han passer godt inn i rollen som leder. Fra egne prosjekter har han jobbet mye med forskjellige prosjekter med feil på forskjellige ledd av programmet, som gjør at han er godt kjent med debugging. Han får derfor også hovedansvaret for debugging, dersom det skulle være et problem gruppen ikke klarer å løse. 

#### Kort oppsummert rollefordeling:
- Daniel
	- Sjefsutvikler
- Marius
	- Git ansvarlig
	- Testansvarlig
- Stian
	- Nestleder
	- Dokumentasjon og logg-ansvarlig
- Marita
	- Kundekontakt
- Sondre
	- Leder
	- Hovedansvar for debugging

# Deloppgave 2 (uke 6): Velg og tilpass en prosess for laget
## Prosess og prosjektmetodikk
Byggesystem - Maven

Prosjektmetoden vil være en agile tilnærming og en blanding av Scrum og Kanban, der vi skal prøve oss litt frem for å se hvilken strategi som fungerer best for teamet, ettersom vi ønsker å få oversikt over styrker og svakheter til de forskjellige metodene. Samtidig ønsker vi en konkret struktur som gjør at uenigheter og konflikter kommer sjeldnere og er lettere å fikse når de oppstår. En konkret struktur vil også sørge for en bedre kodekvalitet, som vi ønsker skal gjøre bugs lettere både å finne og å fikse. 

### Møter og hyppighet av dem
Vi har planlagt å ha to møter i uken hvor vi går gjennom hva vi har jobbet med så langt og hva vi skal jobbe med videre. Vi vil også benytte møtene til å jobbe med prosjektet. Møtene finner sted hver Tirsdag kl 10:15 - 12:00 og Fredag kl 12:15 - 14:00. Hver fredag blir det booket grupperom hvor alle kan arbeide i fellesskap. Tid og sted vil bli kommunisert gjennom discord.

### Kommunikasjon mellom møter
All kommunikasjon innad i teamet vil foregå på discord. Vi har laget egen discord-server som alle har tilgang til. Her er det viktig å melde ifra dersom man ikke skulle ha mulighet til å komme på de ukentlige møtene. Det er også viktig at gruppemedlemmer sier ifra dersom de ikke har mulighet til å arbeide med de oppgavene de har fått tildelt slik at dette kan delegeres til de andre gruppemedlemmene. 

### Arbeidsfordeling
Arbeidsfordeling vil bli utført regelmessig på de ukentlige møtene. Det vil være lederens ansvar å delegere arbeidsoppgavene på en anstendig og fornuftig måte. Alle gruppemedlemmer vil få mulighet til å komme med preferanser på arbeidsoppgaver, men det er lederen som har det siste ordet.

### Oppfølging av arbeid
All oppfølging vil bli utført under de ukentlige møtene. Planen er å gjøre en kort “Stand-up” i begynnelsen av hvert møte hvor alle presenterer hva de har jobbet på og hvor lang de har kommet. Vi holder også orden på oppgaver på Trello.

### Deling og oppbevaring av felles dokumenter, diagram og kodebase
Alle gruppemedlemmer har tilgang til alle dokumenter og verktøy som vi har benyttet.
Prosjektplan har blitt utviklet i et google docs dokument. 
Vi har benyttet et privat GitLab repository for oppbevaring av all koden. Alle gruppemedlemmer har full eiertigang, for å gjøre det raskt og enkelt å gjøre nødvendige endringer.
Kode diagram blir laget i Lucidchart som er et enkelt verktøy for å lage ER-diagram.
Vi har brukt Trello til å sette opp en prosjekt tavle hvor vi enkelt kan se arbeidsoppgaver

# Deloppgave 3 (uke 6–7): Få oversikt over forventet produkt
## Oversikt over forventet produkt 

Dette programmeringsprosjektet handler om å lage et 2D-spill der du beveger deg rundt ved å gå eller hoppe og samler ting mens du passer deg for fiender for å komme i mål (innen gitt tidsramme). Vi har bestemt at plottet til spillet skal ta utgangspunkt i Kurt-Mario eksempelet:

>_«Kurt-Mario er i trøbbel igjen! Han er sent ute til eksamen, han har ikke lest nok – og hvor er egentlig eksamenslokalet? Hjelp Kurt-Mario å hoppe fra etasje til etasje på Høyteknologisenteret, plukke opp viktig kunnskap (og snacks!) på veien og nå frem til eksamen i tide. Men pass opp for de skumle professorene – vi har ikke tid til å høre om flere teoremer nå!»_

Det overordnede målet for applikasjonen er altså å lage et spill, hvor Kurt Mario skal komme fram til eksamen i tide mens han møter på fiender.


### Viktige aspekter
- Spillfigur som kan styres – gå til høyre/venstre, hoppe oppover 
- Todimensjonal verden:
- Plattform – horisontal flate spilleren kan stå eller gå på (inkludert «bakken»)
- Vegg – vertikal flate som spilleren ikke kan gå gjennom
- Spilleren beveger seg oppover ved å hoppe, og nedover ved å falle
- Fiender som beveger seg og er skadelige ved berøring
- Spilleren kan samle poeng ved å plukke opp ting
- Utfordringen i spillet er gjerne en eller flere av: å bevege seg gjennom terrenget uten å falle utfor, å samle nok poeng, å bekjempe fiendene, å nå frem til og bekjempe en «big boss»


### Brukerhistorier/MVP
1. Vise et spillebrett
	1. Arbeidsoppgave: For å vise et spillbrett må man starte spillet.
	2. Brukerhistorie: Som programmerer trenger jeg et spillbrett for å kunne gjøre endringer og se om alt fungerer.
	3. Brukerhistorie: Som spiller trenger jeg å se et spillbrett slik at jeg vet hva mine muligheter er, og hvordan banen ser ut.
	4. Akseptansekrav: Når en programmerer/spiller starter spillet skal et vindu vises med grafikk av spillbrettet.
2. Vise spiller på spillebrett
	1. For å vise en spiller på brettet må man startet spillet.
	2. Som spiller trenger jeg å se spillfiguren for å vite hvor jeg er.
	3. Som fiende trenger jeg å se spillfiguren for å vite når jeg kan angripe.
	4. Det skal være mulig å se en spillbrikke på spillbrettet på skjermen. 
3. Flytte spiller (vha. taster e.l.)
	1. For å flytte en brikke må man trykke på en piltast.
	2. Som spiller trenger jeg å kunne flytte spillfiguren for å kunne bevege meg og interagere med spillverdenen.
	3. Når en av piltastene blir trykket på skal spillfiguren flytte seg på brettet. 
	4. Når man trykker piltasten for høyre skal brikken bevege seg i den retningen og x-verdien øker med en fastsatt verdi.
	5. Når man trykker piltasten venstre skal brikken bevege seg i den retningen og x-verdien synke med en fastsatt verdi.
	6. Når man trykker piltasten opp skal brikken “hoppe” dersom det er mulig.
	7. Når man trykker piltasten ned skal brikken bevege gjennom plattformen den står på, dersom mulig.
4. Spiller interagerer med terreng
	1. For å interagerer med terreng må man starte spillet og bruke piltastene til å bevege seg rundt på brettet. Terrenget må bestå av flere overflater som man ikke kan trenge gjennom med mindre man kommer fra riktig side. 
	2. Som spiller trenger jeg å kunne kollidere med terreng for å ikke falle gjennom bakken og holde meg innenfor spillets områder.
	3. Når spiller interagerer med terrenget skal spillbrikken stoppe bevegelsen i den retningen terrenget befinner seg i.
	4. Spilleren skal stoppe å falle dersom terrenget befinner seg under spilleren.
	5. Spilleren skal stoppe sidelengs bevegelse dersom terrenget er en vegg som spiller løper inn i. 
5. Spiller har poeng og interagerer med poenggjenstander
	1. For at spiller skal interagere med poenggjenstander må de være plassert rundt på brettet, og de må være mulige å plukke opp. 
	2. Som spiller trenger jeg å interagere med poenggjenstander for å samle poeng
	3. Som spill(et) trenger jeg poenggjenstander slik at jeg kan rangere spillere etter hvor bra de gjorde det
	4. Når spilleren plukker opp en poenggjenstand skal spillet gi mer poeng til spilleren på en synlig måte ved hjelp av en poengteller i hjørnet i spillet. 
6. Vise fiender/monstre; de skal interagere med terreng og spiller 
	1. For at fiender interagerer med terreng og spiller må de komme opp på spillebrettet når spillet starter.
	2. Som fiende trenger jeg å interagere med terreng og spiller for å stoppe spillfiguren.
	3. Som spiller trenger jeg å vite hvor fiender er slik at jeg kan unngå dem
	4. Når en fiende treffer en spiller skal spilleren ta skade
	5. Når en fiende kommer opp på spillbrettet skal den være synlig
7. Spiller kan dø (ved kontakt med fiender, eller ved å falle utenfor skjermen)
	1. For at en spiller kan dø må man starte spillet og bevege seg på spillbrettet vha. piltastene. Deretter kan en spiller dø ved å bevege seg mot en fiende, mot kanten av skjermen eller bunnen av etasjen.
	2. Som spiller er det viktig at jeg kan se når jeg jeg dør slik at jeg vet at spillet er ferdig.
	3. Når en spiller dør skal liv-counten minke. 
8. Mål for spillbrett (enten et sted, en mengde poeng, drepe alle fiender e.l.)
	1. Som spiller trenger jeg et mål slik at jeg kan ha noe å jobbe mot
	2. DVS at jeg må nå eksamen for å ikke stryke
9. Nytt spillbrett når forrige er ferdig
	1. For at et nytt spillbrett skal være tilgjengelig må det være flere spillbrett å velge mellom
	2. Som spiller trenger jeg nytt spillbrett når forrige er ferdig så jeg kan spille en gang til.
	3. Når spillet er ferdig får spiller valget om å fortsette å spille. Dersom spiller ønsker å fortsette vil spiller få et nytt spillbrett å spille på. 
10. Start-skjerm ved oppstart / game over
	1. Som spiller trenger jeg en start-skjerm og en game over skjerm slik at jeg enkelt vet hvilken tilstand spillet er i og på den måten kan avgjøre hvordan jeg kommer meg videre.
11. Støtte flere spillere (enten på samme maskin eller over nettverk)
	1. Som spiller trenger jeg støtte for flere spillere slik at jeg kan spille sammen med vennene mine.
	2. Som spiller trenger jeg å kunne skille mellom min karakter og vennen(e) mine sin(e) karakter(er)


## Idemyldring
«Kurt-Mario er i trøbbel igjen! Han er sent ute til eksamen, han har ikke lest nok – og hvor er egentlig eksamenslokalet? Hjelp Kurt-Mario å hoppe fra etasje til etasje på Høyteknologisenteret, plukke opp viktig kunnskap (og snacks!) på veien og nå frem til eksamen i tide. Men pass opp for de skumle professorene – vi har ikke tid til å høre om flere teoremer nå!»
Å lage et 2D-spill der du beveger deg rundt ved å gå eller hoppe og samler ting mens du passer deg for fiender for å komme i mål (innen gitt tidsramme). 
- Ide for fiender:
	- Professorer
		- Går frem og tilbake, treffer man dem får man en straff
- Ide for siste boss:
	- Rektor
	- kaster bøker?
- Ideer for poengobjekter:
	- Notater
	- Fagbøker
	- Eple/mat
	- Blyant
- Ide for tap:
	- Tid for tap -> teller til eksamensstart? Countdown siste sekunder
	- 3 liv?
	- Får karakterskala alt etter hvor fort man kommer frem (og hvor mange poenggjenstander man har plukket opp A++ feks.).
	- Mister liv når man møter fiender og/eller går tom for tid.
- Ide for bakgrunn:
	- Pikslerte bilder fra høytek
	- Parallakse
	- "No food or drink in this area" plakat

# Deloppgave 5: Oppsummering
Prosjektet hadde en god start, hvor vi raskt og effektivt fikk delt de viktigste rollene mellom oss. Vi kom raskt frem til hvordan vi ville organisere oss, både med tanke på kommunikasjon og planlegging. Vi opplevde å ha litt knapp tid rett før innlevering pga. sykdom blant medlemmer av teamet. Det førte til at vi ikke fikk møttes i henhold til planen og kommunikasjon rundt prosjektet ikke ble optimal. I tillegg brukte vi litt tid på å lære oss nødvendige/ekstra programmer og biblioteker som Tiled og libgdx. I løpet av neste obligatoriske oppgave må vi forbedre kommunikasjon og ta hensyn til at ikke alle i teamet kan være til stede på alle møtene. I løpet av videre arbeid i prosjektet tenkte vi å prøve ut XP og pair programming på noen av møtene. Vi har ikke kommet så langt med koden som vi hadde ønsket. Til neste gang tenker vi å levere et minimum viable product (MVP kravene 1-12). I tillegg til å forbedre kodekvaliteten til de påbegynte MVP kravene 1-3, og implementere tester og god dokumentasjon. 
