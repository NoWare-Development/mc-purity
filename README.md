# Minecraft Purity
__Minecraft Purity__ is mod for Minecraft Beta 1.7.3

Supported Java version is 8.

## How to install?
__For MultiMC__:
1. Download __"purity.zip"__ from Releases
2. Open MultiMC
3. Click "Add instance"
4. Navigate to "Import"
5. Click "Browse"
6. Select __"purity.zip"__
7. Click "OK"
8. Done

__For Other Launchers__:
1. Download __"purity.jar"__ from Releases
2. Navigate to your __".minecraft"__ folder
3. Open __"versions"__ folder
4. Create __"purity"__ folder
5. Move __"purity.jar"__ into it
6. Download Beta 1.7.3 version in your launcher
7. Move file named __"b1.7.3.json"__ into __"purity"__ folder
8. Rename __"b1.7.3.json"__ in your folder to __"purity.json"__
9. Enjoy

## How to create server?
1. Download __"purity_server.jar"__ from Releases
2. Create __"start.bat"__/__"start.sh"__ file in the same folder which contains __"purity_server.jar"__
3. Open your terminal and enter this command: `chmod +x start.sh` (Only on Linux and macOS)
4. Edit __"start.bat"__/__"start.sh"__
5. Paste this into it:
   ``` sh
   java -Xmx2048m -Xms2048m -jar purity_server.jar nogui
   ```
6. Enjoy
