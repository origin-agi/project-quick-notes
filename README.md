# Project Quick Notes

Project Quick Notes is a small IntelliJ IDEA plugin that adds a project-local notes tool window.

Use it to keep short TODOs, review reminders, debugging context, or handoff notes inside the IDE without switching to another app.

## What It Does

Project Quick Notes adds a **Project Notes** tool window to IntelliJ IDEA. The tool window provides a simple note area for the current project, so you can keep useful project context close to your code.

Each project has its own saved note. Notes from one project will not appear in another project.

Typical things to keep in Project Quick Notes:

- Project startup commands.
- Local service URLs.
- Test accounts or local-only credentials.
- Temporary TODOs.
- Debugging notes and investigation results.
- Code review reminders.
- Handoff notes for teammates or your future self.

## How To Use

1. Open any project in IntelliJ IDEA.
2. Open the **Project Notes** tool window from the left tool window bar.
3. Write your project note in the text area.
4. Click **Save Note** to save the note for the current project.
5. Reopen the same project later and the note will still be available.
6. Click **Clear** to remove the current project's note.

## Features

- Adds a **Project Notes** tool window.
- Stores one short note per project using IDE project properties.
- Provides **Save Note** and **Clear** actions.
- Works without external services, accounts, or network access.

## 中文说明

Project Quick Notes 是一个轻量级 IntelliJ IDEA 项目便签插件，用来在 IDE 里保存当前项目专属的简短笔记。

适合记录：

- 项目启动命令
- 本地接口地址
- 测试账号
- 临时 TODO
- 问题排查结论
- Code Review 提醒
- 项目交接说明

使用方式：

1. 在 IntelliJ IDEA 中打开项目。
2. 在左侧工具栏打开 **Project Notes**。
3. 输入当前项目的笔记。
4. 点击 **Save Note** 保存。
5. 下次打开同一个项目时，笔记仍然存在。
6. 点击 **Clear** 清空当前项目的笔记。

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
