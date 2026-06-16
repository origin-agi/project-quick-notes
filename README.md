# Project Quick Notes

Project Quick Notes is a small IntelliJ IDEA plugin that adds a project-local notes tool window.

Use it to keep short TODOs, review reminders, debugging context, or handoff notes inside the IDE without switching to another app.

## Features

- Adds a **Project Notes** tool window.
- Stores one short note per project using IDE project properties.
- Provides **Save Note** and **Clear** actions.

## Local Development

Run the plugin in a sandbox IDE:

```bash
JAVA_HOME="/Applications/IntelliJ IDEA.app/Contents/jbr/Contents/Home" ./gradlew runIde
```

Build a local ZIP:

```bash
JAVA_HOME="/Applications/IntelliJ IDEA.app/Contents/jbr/Contents/Home" ./gradlew buildPlugin
```

Sign the ZIP with the learning-only test certificate configured in `build.gradle.kts`:

```bash
JAVA_HOME="/Applications/IntelliJ IDEA.app/Contents/jbr/Contents/Home" ./gradlew signPlugin
```

## Marketplace Preparation

Before publishing a real plugin:

- Replace the learning-only signing certificate with a JetBrains-issued certificate.
- Move signing secrets and Marketplace tokens out of source code.
- Add Marketplace screenshots that show the **Project Notes** tool window.
- Run `verifyPlugin` and install the produced ZIP locally from disk.
