# Minecraft Purity
__Version 1.0.0__

__Minecraft Purity__ is a mod for Minecraft Beta 1.7.3 which adds a lot of features and items.

## How to build?
You should download [RetroMCP-Java](https://github.com/MCPHackers/RetroMCP-Java) and run these commands:
``` sh
$ cd RetroMCP-Java
$ java -jar RetroMCP-Java-CLI/GUI.jar
# If you installed GUI version, ignore next commands
> setup
>> b1.7.3
> decompile
```

Next you should replace __"minecraft"__ and __"minecraft_server"__ folders with those you have downloaded from _this repository_.

Next run these commands:
``` sh
$ java -jar RetroMCP-Java-CLI/GUI.jar
# If you installed GUI version, ignore next commands
> recompile
# to start client and server:
> start
# to start only client:
> start client
# to start only server
> start server
```
