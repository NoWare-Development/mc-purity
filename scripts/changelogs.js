class ChangelogEntry {
  constructor(version, changes) {
    this.version = version;
    this.changeList = changes;
  }

  format() {
    const header = `
      <h1 class="container__subheader">${this.version}:</h1>
    `;

    var changes = "<ul>";

    this.changeList.forEach(change => {
        changes += `<li>${change}</li>`;
      }
    )

    changes += "</ul>";

    return header + changes;
  }
}

class Changelogs extends HTMLElement {
  connectedCallback() {
    var content = "";

    allChanges.forEach(change => {
        content += change.format();
      }
    )

    this.innerHTML = content;
  }
}
customElements.define("purity-changes", Changelogs);

const change_1_0_0 = new ChangelogEntry("1.0.0",
  [
    "First release",
  ]
);

const change_1_0_1 = new ChangelogEntry("1.0.1",
  [
    "Added Dead Miner",
    "Fixed crosshair's position being affected by \"Vertical gap\" option",
    "Sheeps now heal their fleece after being shearing",
    "Servers are now runnable",
  ]
);

const change_1_0_1_01 = new ChangelogEntry("1.0.1_01",
  [
    "Fixed server sometimes fail to load chunks because of error in NBT tag related to Dead Miners",
    "Removed NBT tag saving for Dead Miners",
    "Added \"/spawn\" command which spawns mob in 3 blocks away from you by X coordinate",
    "Fixed diamond, emerald, and ruby ore generation",
    "Fixed unsynced Dead Miner's pickaxe in hand in multiplayer",
    "Now Dead Miner will not die immediately on sunlight",
  ]
);

const change_1_0_1_02 = new ChangelogEntry("1.0.1_02",
  [
    "Optimizations",
    "Now fence's collision is more like modern Minecraft",
    "Fixed grass blocks were not turn into dirt when there's a block at the top of them",
  ]
);

const change_1_0_2 = new ChangelogEntry("1.0.2",
  [
    "Now stairs and slabs can be placed upside down",
    "Small fixes",
  ]
);

const change_1_0_2_01 = new ChangelogEntry("1.0.2_01",
  [
    "Fixed some issues with slabs",
    "Added new colored server name labels:",
    "Not logged in - <span id=\"dgreen\">Dark Green</span>",
    "Player - <span id=\"white\">White</span>",
    "Operator - <span id=\"gold\">Gold</span>",
    "Mod developer - <span id=\"red\">Red</span>",
    "Mojang employee - <span id=\"dred\">Dark Red</span>",
    "Notch (lol) - <span id=\"yellow\">Yellow</span>",
  ]
);

const change_1_1_0 = new ChangelogEntry("1.1.0",
  [
    "Fixed more issues with slabs",
    "Added quiver",
    "Updated bows",
    "Fixed \"eternal furnace\" bug",
    "Added iron mace",
    "Recolored item stats",
    "Shorten attack length for hostile mobs",
    "Added ruins",
    "Added cherry trees and cherries",
    "Updated dungeons",
    "Several GUI improvements",
    "Now server encrypts player's password in SHA512",
    "Updated boats",
    "Fixed void fog issues",
    "Added void fog particles",
    "Added block of sticks",
    "Added fireflies",
    "Added sandstorm",
    "Fixed server behavior",
    "Updated \"/spawn\" command",
    "Don't look at the void",
  ]
);

const change_1_1_1 = new ChangelogEntry("1.1.1",
  [
    "Fixed bow recipe on server-side",
    "Updated \"/list\" command",
    "Now you can't call \"/spawn\" command from the server console",
    "Rebalanced dungeon's loot",
    "Rebalanced dungeons spawn",
    "Server-side fixes",
    "Fixed skeletons behavior",
    "Now fireflies can spawn with the inverted texture",
    "Now you can go through grape leaves",
    "Corrected grape leaves behavior",
    "Fixed torch placement on slabs",
    "Optimizations",
    "Added \"them\"",
  ]
);

const change_1_1_1_01 = new ChangelogEntry("1.1.1_01",
  [
    "Several GUI fixes",
    "Added new option in GUI settings",
  ]
);

const change_1_1_1_02 = new ChangelogEntry("1.1.1_02",
  [
    "Added flexible option to control target FPS",
    "All item entities are 3D when fancy graphis is ON",
  ]
);

const change_1_2_0 = new ChangelogEntry("1.2.0",
  [
    "Optimizations",
    "Small fixes",
    "Reworked armor system",
    "Changed dungeons spawnrate",
    "Chat is now accessible in singleplayer mode",
    "Changed cherry tree leaves texture",
    "Added colored redstone lamps",
    "Changed TNT behavior on break",
    "Increased creeper's health up to 25",
    "Decreased spider's health down to 15",
    "Changed behavior of glowstone blocks on break",
    "Added magma blocks, magma pieces, hot gold, hotrod, and hot gold pickaxe",
    "Replaced diamond pickaxe with hot gold pickaxe",
    "Added nether furnace",
    "Added option \"Advanced lighting\" in video settings",
    "Updated brews' textures",
    "Spears can be thrown now",
    "Added item buoyancy",
    "Dead Miners can be saved to NBT on world save",
    "Updated void fog",
  ]
);

const change_1_2_1 = new ChangelogEntry("1.2.1",
  [
    "Rebalanced dungeon loot table",
  ]
);

const change_1_2_1_01 = new ChangelogEntry("1.2.1_01",
  [
    "Fixed crash when generating dungeons.",
  ]
);

const allChanges = [
  change_1_2_1_01,
  change_1_2_1,
  change_1_2_0,
  change_1_1_1_02,
  change_1_1_1_01,
  change_1_1_1,
  change_1_1_0,
  change_1_0_2_01,
  change_1_0_2,
  change_1_0_1_02,
  change_1_0_1_01,
  change_1_0_1,
  change_1_0_0,
];
