# MyAddon

A [Skript](https://github.com/SkriptLang/Skript) addon template.

This template includes:
 * Async stuff
 * Events registrations
 * Simple boilerplate

## Features

This boilerplate contains a lot of new cool things to use:

 * ``AsyncEffect``: Make an effect asynchronously or synchronously depending of user needs.
 * ``PackageLoader``: Load all classes from a package asynchronously.
 * ``MultiplePropertyExpression``: A ``SimplePropertyExpression`` but with more than 1 item.
 * ``migrations.yml``: A file to migrate your addon from a version to another whenever you do an update.
 * A clean files structure.

## Demo

If you want to try this addon by default, you can try this code:

```vb
command t:
    trigger:
        async my effect:
        broadcast "Executed after my async effect"
        set {_type} to new type
        set type name of {_type} to "hello"
        broadcast "Name of type: %type name of {_type}%"
        my effect
        add "world" to type contents of {_type}
        broadcast "Content of type: %type contents of {_type}%"
```

## Setup

By default, the project's group will be ``com.author.myaddon``. Simply rename ``author`` with your username, and ``myaddon`` with the name of your addon (lower case, without space or any specifc chars, only a-z chars).
Think to change ``com.author.myaddon.MyAddon.java`` to the name of your addon, e.g ``com.olyno.skent.Skent.java``. Same in the ``src/main/resources/plugin.yml`` file.

## Build

Simply run:
```
gradlew build
```
The build will be available in the directoy build/libs.

## License

Code released under GNU GPLv3 license.

Copyright ©, [Olyno](https://github.com/Olyno).