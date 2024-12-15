<div align="center" >

<img src="https://noware-development.github.io/mc-purity/media/mc-purity-logo.png" ></img>

**Minecraft Purity** is mod for Minecraft Beta 1.7.3

</div>

Supported Java version : __8__

## How to install ?
For **MultiMC/PrismLauncher**:
1. Download __"purity.zip"__ from **Releases**
2. Open **MultiMC**
3. Click _"Add instance"_
4. Navigate to _"Import"_
5. Click _"Browse"_
6. Select __"purity.zip"__
7. Click _"OK"_
8. Done
   
**P.S.** : You may need some instance tinkering (__like changing java__).

__Other Launchers__ : **NOT SUPPORTED**

__Purity Launcher__: **in development**

## How do you create a server?
1. Download __"purity_server.jar"__ from **Releases**
2. Create __"start.bat"__/__"start.sh"__ file in the **same folder** which contains __"purity_server.jar"__
3. Open your terminal and enter this command: `chmod +x start.sh` (Only on Linux and macOS)
4. Edit __"start.bat"__/__"start.sh"__
5. Paste this into it:
   ``` sh
   java -Xmx2048m -Xms2048m -jar purity_server.jar nogui
   ```
6. _Enjoy_ 

<img src="https://noware-development.github.io/mc-purity/media/fig_lake.png" alt="screenshot" style="width: 900px; ">
