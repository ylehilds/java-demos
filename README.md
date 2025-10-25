# java-demos
Collection of Java demos Apps

## Apps Folder Structure
- Java files: `apps/<AppName>/src/main/java/dev/lehi/<app_name>/<ClassName>`
- Java Build: `build/dev/lehi/<app_name>/<ClassName>`
- External Libraries: `apps/<AppName>/src/main/java/dev/lehi/<app_name>/lib`

## External Libraries
if you need external libraries simply cd into the lib folder and performa curl command like these, also add an ew file in lib folder to explain how to add these libraries name it importJavaLibraries.txt:
```
curl -L -o lib/javax.json-api-1.1.4.jar \
  https://repo1.maven.org/maven2/javax/json/javax.json-api/1.1.4/javax.json-api-1.1.4.jar

curl -L -o lib/javax.json-1.1.4.jar \
  https://repo1.maven.org/maven2/org/glassfish/javax.json/1.1.4/javax.json-1.1.4.jar

curl -L \
  "https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-annotations/2.18.2/jackson-annotations-2.18.2.jar" \
  -o jackson-annotations-2.18.2.jar

curl -L \
  "https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-core/2.18.2/jackson-core-2.18.2.jar" \
  -o jackson-core-2.18.2.jar

curl -L \
  "https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-databind/2.18.2/jackson-databind-2.18.2.jar" \
  -o jackson-databind-2.18.2.jar
```

## Compile & Run commands
1. Change directory into app folder: `cd apps/<AppName>`
2. Compile command: `javac -d ../../build src/main/java/dev/lehi/<app_name>/*.java` or if your app has references to external libraries: `javac -cp "src/main/java/dev/lehi/<app_name>/lib/*" -d ../../build src/main/java/dev/lehi/<app_name>/*.java`
3. Run command: `java -cp ../../build dev.lehi.<app_name>.<ClassName>` or this if your app has references to external libraries: `java -cp "../../build:src/main/java/dev/lehi/<app_name>/lib/*" dev.lehi.<app_name>.<ClassName>`
