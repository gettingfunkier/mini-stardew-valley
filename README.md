# Mini Stardew Valley!
#### A terminal-based, cosy farming sim, written in Java as a practice/passion project <3

> A friend convinced me to play ConcernedApe's **Stardew Valley**, and I loved it so much I felt compelled to develop a mini fan version for myself.

## Directory

```bash
mini-stardew-valley/
│
├ src/
├── main.java/
│
├────── catalogues/     # CONTAINS ALL CATALOGUE CLASSES
├────── enums/          # CONTAINS ALL ENUM LISTS
├────── inputs/         # CONTAINS ALL INPUT CLASSES
├────── items/          # CONTAINS ALL ITEM CLASSES
├────── menus/          # CONTAINS ALL MENU CLASSES
├────── previews/       # CONTAINS ALL PREVIEW CLASSES
├────── runtime/        # CONTAINS ALL RUNTIME CLASSES
├────── states/         # CONTAINS ALL GAME STATE CLASSES
├────── writers/        # CONTAINS ALL READ/WRITE CLASSES
│
├──── Game           # Main Class
│
├ saves/
│
├── SAVE_FILE_1/  # slot 1 (expanded to exemplify structure)
├──── calendar.sdv   # calendar data
├──── farm.sdv       # farm data (incomplete)
├──── player.sdv     # player data
├──── shop.sdv       # shop data (NOT IMPLEMENTED YET!!)
│
├── SAVE_FILE_2/  # slot 2
├── SAVE_FILE_3/  # slot 3
├── SAVE_FILE_3/  # slot 4
│
├ .gitignore
└ README.md
```


## Setup

1. Clone this repo: (or upload the src classes into a java project)
   ```bash
   git clone https://github.com/gettingfunkier/mini-stardew-valley.git
   cd mini-stardew-valley/
2. Run with Java:
   ```bash
   javac -d out $(find src/main/java -name "*.java")
   java src/main/java/Game.java
   ```

## How to play

#### Actions
- Plant crops in empty plots
- Water them every day to grow
- Once ready, harvest them
- Sell them for coins

#### Caveats
- Crops are season locked
- When the season changes, all plots reset
- Each crop takes a specific number of days to grow

## UI & Stats

#### Starting the game
```angular2html
 █▄ ▄█ █ █▄ █ █   ▄▀▀ ▀█▀ ▄▀▄ █▀▄ █▀▄ ██▀ █   █   █ █ ▄▀▄ █   █   ██▀ ▀▄▀
 █ ▀ █ █ █ ▀█ █   ▄██  █  █▀█ █▀▄ █▄▀ █▄▄ ▀▄▀▄▀   ▀▄▀ █▀█ █▄▄ █▄▄ █▄▄  █ 
 ----- - ---- -   --- --- --- --- --- --- -----   --- --- --- --- --- ---
                                      > Code by gettingfunkier in 2025 <3

 ⎯⎯⎯  1. START GAME
 ⎯⎯⎯  2. Load Save 

> 
```

```angular2html
Choose a slot:
  ├── Save 1: Jimi
  ├── Save 2: Lily
  ├── Save 3: 
  └── Save 4: Rita

> 
```

```
Enter name: Lanzio
Name your farm: Bahia
```

#### Main Menu
```
--- [ Day 4 of Winter ] ---------
Lanzio: 5178 coins / Level 10 (404/514)

1. Farming
2. Trading
 | 
3. List Inventory
4. Crop Catalogue
 | 
5. Advance Day
0. Exit

>
```
```
    // input 1

Farming:
  ├── 1. Inspect
  ├── 2. Water
  ├── 3. Plant
  └── 4. Harvest

0. Return
> 

    // input 2

Trading:
  ├── 1. Sell
  └── 2. Shop

0. Return
> 
```

#### Checking plots
```
Bahia Farm:
#1 - Watered Amaranth (2/5 days)
#2 - Dry Pumpkin (4/11 days)
#3 - Empty
#4 - Watered Cranberry (5/5 days)
#5 - Empty
```

#### Water
```
Choose a plot:
#1 - Dry Kale (1/4 days)
#4 - Dry Parsnip (2/3 days)
> 4
Parsnip has been watered!
```

#### Plant
```
Available Crops:
1. Parsnip (3 days)
2. Kale (4 days)
3. Cauliflower (7 days)

Available Plots:
Plot 2
Plot 3
Plot 4
Plot 5

Crop: 3
Plot: 5
Planted Cauliflower on plot 5
```

#### Harvest
```
#2 - Radish ready to harvest!

Choose a plot:
> 2

Radish harvested!
```

#### Sell (& List Inventory)
```
Inventory:
1x Parsnip
3x Melon
5x Cranberry

Item: Melon
Quantity: 2
Sold 2 Melon for 162 coins!
```

#### Shop
```
Shop Catalogue:
⤷ Rug for 40 coins
⤷ Latte for 255 coins
⤷ Wristwatch for 1790 coins

('r' to return to menu)
> Latte
Latte bought for 255 coins
```

#### Crop catalogue
```
Available Crops:
Parsnip - Plant in the Spring, takes 3 days to grow
Kale - Plant in the Spring, takes 4 days to grow
Cauliflower - Plant in the Spring, takes 7 days to grow
Strawberry - Plant in the Summer, takes 5 days to grow
Melon - Plant in the Summer, takes 8 days to grow
Radish - Plant in the Summer, takes 3 days to grow
Tomato - Plant in the Summer, takes 5 days to grow
Wheat - Plant in the Summer, takes 1 days to grow
Cranberry - Plant in the Fall, takes 5 days to grow
Eggplant - Plant in the Fall, takes 6 days to grow
Pumpkin - Plant in the Fall, takes 11 days to grow
Amaranth - Plant in the Fall, takes 5 days to grow
Snowfruit - Plant in the Winter, takes 24 days to grow
```

## Roadmap
- When in submenu, stay in submenu
- Adding save files (ONGOING)
- Fishing minigame (somehow)
- Fixing player/farm name to allow strings with multiple words
- Implementing exponential reward system
- Turn GUI into some sort of interactable (props [@zF4ke](https://github.com/zF4ke))

## Credits
- Game concept & assets: [**Stardew Valley, ConcernedApe** ↗](https://www.stardewvalley.net/)
- Code: [**gettingfunkier** ↗](https://github.com/gettingfunkier)
- Made with ❤ in Java, during Y2 of Software Engineering, 2025
  
---

*to be continued...*
