<div align="center" >

<img src="https://noware-development.github.io/mc-purity/media/mc-purity-logo.png" ></img>

</div>

__Minecraft Purity__ is mod for Minecraft Beta 1.7.3

Supported Java version is 8.

## How to install?
__For MultiMC/PrismLauncher__:
1. Download __"purity.zip"__ from Releases
2. Open MultiMC
3. Click "Add instance"
4. Navigate to "Import"
5. Click "Browse"
6. Select __"purity.zip"__
7. Click "OK"
8. Done

__P.S.__: You may need some instance tinkering (like change java).

__For Other Launchers__: <ins>**NOT SUPPORTED!**</ins>

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
