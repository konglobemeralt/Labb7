Att lösa labyrinter och visualisera i 3D
========================================

Denna lab är uppdelad i två delar, A och B. I del A ska ni skriva ett
program som hittar lösningar till labyrinter, och i del B visualiserar
ni sökningen av lösningen.

Magnus Myreen, september 2016.


Filer
-----

Denna lab kommer med många filer. Flera av filerna behöver ni inte
läsa. För del A bör ni bekanta er med följande:

 - `Labyrinth.java` är en interface för labyrint objekt
 - `LabSolver.java` *är filen där du ska skriva lösningen för del A*
 - `LabSolverTest.java` är ett testprogram som hjälper dig testa del A

För del B bör ni bekanta er med följande filer:

 - `LabList.java` ett verktyg i visualiseringen för del B
 - `LabAnimate.java` *är filen där du ska skriva lösningen för del B*
 - `Main.java` kör programmet som löser och visualiserar labyrinter, del B

Programmet kan köras från `LabSolver.java`, `LabSolverTest.java` och
`Main.java`. Hela helheten körs från `Main.java`


Deluppgift A
------------

Er uppgift är att skriva en rekursiv funktion som hittar en lösning
till en slumpmässigt skapad labyrint.  Labyrinterna skapas av den
givna koden i `Lab.java`.  Er kod, som hittar lösningen, bör skrivas i
`LabSolver.java` filen.  När det färdiga `LabSolver.java` programmet
körs bör utskriften vara ungefär:

    Created a random labyrinth:
    +--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
    |     |  |     |                    |  |  |                 |
    +  +--+  +  +  +  +--+--+--+  +--+--+  +  +--+  +--+--+--+--+
    |     |     |  |  |  |     |                                |
    +  +  +  +--+--+  +  +  +--+--+--+  +--+  +  +  +  +--+  +--+
    |  |                             |  |     |  |  |     |  |  |
    +  +--+  +  +--+--+  +  +--+--+--+--+  +--+  +--+  +  +  +  +
    |     |  |        |  |     |     |        |     |  |  |     |
    +--+  +  +--+--+  +--+  +  +  +--+--+  +--+--+--+--+  +--+--+
    |     |        |  |  |  |        |                 |        |
    +  +--+--+--+--+--+  +--+--+  +--+--+--+  +--+--+  +--+--+--+
    |                          |  |        |        |     |  |  |
    +--+  +--+  +  +--+--+  +--+--+  +--+--+  +--+--+--+--+  +  +
    |        |  |     |           |     |  |        |  |     |  |
    +  +--+--+  +  +  +--+  +--+--+  +--+  +  +--+  +  +--+  +  +
    |        |  |  |  |                    |  |                 |
    +  +--+  +--+--+--+  +  +--+--+  +  +  +--+  +  +--+--+--+  +
    |     |        |     |        |  |  |  |     |  |     |  |  |
    +  +--+--+--+--+  +--+  +  +--+  +  +  +  +  +--+  +--+  +--+
    |              |     |  |     |  |  |  |  |                 |
    +--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+

    Solution found:
    +--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
    |XX   |  |     |XX XX XX XX XX      |  |  |                 |
    +  +--+  +  +  +  +--+--+--+  +--+--+  +  +--+  +--+--+--+--+
    |XX XX|     |  |XX|  |     |XX XX XX XX XX                  |
    +  +  +  +--+--+  +  +  +--+--+--+  +--+  +  +  +  +--+  +--+
    |  |XX XX XX XX XX               |  |XX XX|  |  |     |  |  |
    +  +--+  +  +--+--+  +  +--+--+--+--+  +--+  +--+  +  +  +  +
    |     |  |        |  |     |     |   XX   |     |  |  |     |
    +--+  +  +--+--+  +--+  +  +  +--+--+  +--+--+--+--+  +--+--+
    |     |        |  |  |  |        |   XX XX         |        |
    +  +--+--+--+--+--+  +--+--+  +--+--+--+  +--+--+  +--+--+--+
    |                          |  |        |XX      |     |  |  |
    +--+  +--+  +  +--+--+  +--+--+  +--+--+  +--+--+--+--+  +  +
    |        |  |     |           |     |  |XX XX XX|  |     |  |
    +  +--+--+  +  +  +--+  +--+--+  +--+  +  +--+  +  +--+  +  +
    |        |  |  |  |                    |  |XX XX            |
    +  +--+  +--+--+--+  +  +--+--+  +  +  +--+  +  +--+--+--+  +
    |     |        |     |        |  |  |  |   XX|  |     |  |  |
    +  +--+--+--+--+  +--+  +  +--+  +  +  +  +  +--+  +--+  +--+
    |              |     |  |     |  |  |  |  |XX XX XX XX XX XX|
    +--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+

`Labyrinth.java` definierar ett gränssnitt för labyrinter. En labyrint
har koordinater i vanligt x-y koordinat system. Koordinaterna
(`0`,`0`) är det övre vänstra hörnet. Koorinaterna för det nedre högra
hörnet är (`lab.getWidth()-1`, `lab.getHeight()-1`).

Med `canMove` kan man fråga ett `Labyrinth`-objekt om det är möjligt
att ta ett steg i någon av riktiningarna `Labyrinth.Direction.RIGHT`,
`Labyrinth.Direction.LEFT`, `Labyrinth.Direction.UP`,
`Labyrinth.Direction.DOWN` från givna `x` och `y`. Man kan också spara
en `boolean` vid varje koordinat i labyrinten med `getMark` och
`setMark`.

Ni behöver inte förstå koden i `Lab.java`, men ni får gärna läsa
den. Koden har en konstruktor som skapar en slumpmässig labyrint med
den givna storleken. Labyrinten är skapad på ett sådant sätt att det
endast finns ett sätt att komma från en plats i labyrinten till en
annan plats.

Er uppgift är att skriva koden för `findPath(x0,y0,x1,y1,l)` metoden i
`LabSolver.java`. Idén med metoden `findPath` är att ändra på
tillståndet i det givna `Labyrinth`-objektet `l` så att
`l.getMark(x,y)` returnerar sant ifall (`x`,`y`) är på vägen från
(`x0`,`y0`) till (`x1`,`y1`). När man skriver ut `Labyrinth`-objektet
med `System.out.println(l)` då skriver den ut `XX` där
`l.getMark(x,y)` är sant.

Hur ska man tänka när man löser denna uppgift? Svar: försök hitta en
lösning rekursivt. Om (`x0`,`y0`) och (`x1`,`y1`) är samma koordinat,
då är vi färdiga. Ifall (`x0`,`y0`) och (`x1`,`y1`) koordinaterna inte
är samma, då markerar vi den nuvarande (`x0`,`y0`) koordinaten med
`setMark` och går i någon av riktningarna som är möjliga, och försöker
hitta en lösning från de nya koordinaterna. Exempel: ifall det är
möjligt att ta ett steg till höger, då försöker vi hitta en lösning
från koordinaten (`x0+1`,`y0`) till (`x1`,`y1`). Om det inte lyckas,
då måste vi gå tillbaka, dvs ta bort `setMark`.

Koden behöver inte vara lång. Min implementation av `findPath` är
endast 25 rader lång.

Tips. Innan ni skriver kod lönar det sig att fundera noggrant hur ni
tänker att koden skall fungera.

Obs. Det är osannolikt att er kod fungerar första gången den körs. Det
lönar sig att sätta flera `System.out.println(l)`-utskrifter i koden
så att ni kan se vad som händer och hur labyrinten ser ut.

Lös uppgiften med att ersätta kommentarerna `// ...` med er egen kod i
`LabSolver.java`.


Deluppgift B
------------

Den här delen av labben ber er animera sökningen efter
lösningen. Följande video visar hur det bör se ut när `Main.java` kör.

<https://www.youtube.com/watch?v=RL_NpShA9KY>

Följande rader från `Main.java` visar hur programmet skapar en
`Labyrinth` med `new Lab(w,h)` och sedan skapar ett `LabList`-objekt,
som sedan ges till `LabSolver` för att lösa. Den sista raden skapar
ett `LabAnimate`-objekt. Detta `LabAnimate`-objekt används av
`Main.java` för att visa labyrinten.

    Labyrinth l = new Lab(w,h);
    LabList ll = new LabList(l);
    LabSolver.findPath(0,0,w-1,h-1,ll);
    LabAnimate la = new LabAnimate(ll);

Din första uppgift är att läsa och förstå koden i `LabList.java`. Vad
gör `LabList` objekt. Tips: hela poängen är att den kan returnera en
`Iterator` med sin `iterator()` metod. Vad är en Iterator? Vad finns
inuti denna `Iterator`? (Tips: använd Google för att hitta
dokumentation kring `Iterator`, sök t.ex. "Java API Iterator".)

För att få programmet att bete sig som i videon ovan bör du editera
`LabAnimate.java`. Orginal versionen av `LabAnimate` klassen går
genast in och börjar snurra på labyrinten och dessutom visar den den
färdiga labyrinten.

Du bör använda dig av `LabList`-objektets `iterator()` metod och
implementera om `tick` så att varje labyrint på vägen till lösningen
visas innan rotationen startar. Rotationen ska starta så fort
labyrinten är löst, dvs. så fort man kommer till slutet av
iterationen genom sökningens alla mellanstadier.

Uppdateringen av `LabAnimate` behöver inte vara längre än cirka tio
rader, men det finns ju mycket att läsa och förstå om
`Iterator`-objekt innan man kommer fram till dessa cirka tio rader.
