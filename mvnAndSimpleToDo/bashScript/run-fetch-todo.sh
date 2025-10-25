#!/usr/bin/env bash
set -e

# Create a lib folder for jars
mkdir -p lib

echo "📥 Downloading javax.json jars..."
curl -L -o lib/javax.json-api-1.1.4.jar \
  https://repo1.maven.org/maven2/javax/json/javax.json-api/1.1.4/javax.json-api-1.1.4.jar

curl -L -o lib/javax.json-1.1.4.jar \
  https://repo1.maven.org/maven2/org/glassfish/javax.json/1.1.4/javax.json-1.1.4.jar

echo "✅ Download complete"

echo "📦 Compiling FetchTodo.java..."
javac -cp "lib/*" FetchTodo.java

echo "🚀 Running FetchTodo..."
java -cp ".:lib/*" FetchTodo
