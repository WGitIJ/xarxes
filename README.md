## Xarxes – Introducció a la programació de xarxes en Java

Projecte de pràctiques de **Programació de Serveis i Processos (PSP)** centrat en la introducció a la programació de **xarxes en Java**.  
El projecte està estructurat en diversos exercicis (`exercise1`…`exercise5`) on es treballen clients i servidors TCP, intercanvi de missatges i tractament bàsic de dades.

### Estructura del projecte

- **`pom.xml`**: projecte Maven, Java **23**.
- **`src/main/java/com/paucasesnoves/xarxes/introduction/`**  
  - **`exercise1`**: client i servidor bàsic que intercanvien un missatge de text (el servidor retorna el text en majúscules).  
  - **`exercise2`**: exercici addicional de comunicació client-servidor (detalls al codi).  
  - **`exercise3`**: inclou la classe `Address` i exemples d’enviament/recepció d’informació estructurada.  
  - **`exercise4`** i **`exercise5`**: exercicis addicionals sobre sockets i tractament de missatges.

### Requisits previs

- **Java JDK 23** (o compatible amb la versió configurada al `pom.xml`).
- **Apache Maven** instal·lat i disponible al `PATH`.

Per comprovar versions:

```bash
java -version
mvn -version
```

### Com compilar el projecte

Situar-se a la carpeta arrel del projecte (`Xarxes`) i executar:

```bash
mvn clean compile
```

Això descarregarà les dependències (per exemple `jackson-databind`) i compilarà les classes a la carpeta `target/`.

### Com executar els exercicis

Normalment, cada exercici té un **servidor** (`Server`) i un **client** (`Client`).

#### Des d’un IDE (recomanat)

1. Importar el projecte com a projecte **Maven** (IntelliJ IDEA, Eclipse, VS Code, etc.).
2. Localitzar el `main` que es vol executar, per exemple:
   - `com.paucasesnoves.xarxes.introduction.exercise1.Server`
   - `com.paucasesnoves.xarxes.introduction.exercise1.Client`
3. Executar **primer el servidor** i, un cop inicialitzat, executar el client.

#### Des de línia de comandes amb Maven

Pots executar una classe amb `exec:java`. Exemple per a l’**exercise1**:

```bash
mvn -q -DskipTests exec:java -Dexec.mainClass="com.paucasesnoves.xarxes.introduction.exercise1.Server"
```

En una altra terminal:

```bash
mvn -q -DskipTests exec:java -Dexec.mainClass="com.paucasesnoves.xarxes.introduction.exercise1.Client"
```

Substitueix el nom de la classe `Server`/`Client` per als altres exercicis (`exercise2`, `exercise3`, etc.) segons convingui.

### Exemple de funcionament (exercise1)

1. Arrenca el servidor de l’`exercise1`. A la consola veuràs un missatge semblant a:
   - “Servidor inicialitzat. Esperant al client…”
2. Arrenca el client de l’`exercise1`. El client demanarà que escriguis un missatge.
3. Escriu un text i prem **Enter**.  
   - El servidor rep el missatge, el converteix a **majúscules** i el retorna al client.
   - El client mostra per pantalla el missatge retornat pel servidor.

### Notes i recomanacions

- Assegura’t que **el port** que utilitza cada servidor (per exemple, `2222` a `exercise1`) **no està ocupat** per un altre procés.
- Si treballes amb tallafocs o antivirus, permet les connexions locals (`localhost`).
- Pots utilitzar diverses terminals per provar diferents exercicis alhora (cada exercici hauria d’utilitzar el seu propi port).

### Autoria

Projecte creat per a pràctiques de xarxes en Java.  
Autor: **Wisdom** (`groupId: com.wisdom.java`, `artifactId: Xarxes`).


