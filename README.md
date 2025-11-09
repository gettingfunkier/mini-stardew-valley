# Mini Stardew Valley!
> A terminal-based, cosy farming sim **inspired by Stardew Valley!**
> Written in Java as a practice/passion project <3


## Inspiration

After getting involved in playing **ConcernedApe**'s **Stardew Valley**, I felt compelled to develop a mini fan version for myself.
Integrated concepts:
- OOP design


## Directory

```bash
mini-stardew-valley/
├ src/
├── main.java/
├──── inputs/ # CONTAINS ALL INPUT CLASSES
├── Calendar
├── Crop
├── CropCatalogue
├── Farm
├── Game # Main Class
├── GameState
├── Item
├── Player
└ .gitignore
```


## Setup

1. Clone this repo: (or upload the src classes into a java project)
   ```bash
   git clone https://github.com/gettingfunkier/mini-stardew-valley.git
   cd mini-stardew-valley/src
2. Run with Java:
   ```bash
   javac Game.java
   java Game.java
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
Terminal-based, indexed interface:

#### Starting the game
```bash
Enter name: Jimi
Name your farm: Bahia
```

#### Main Menu
```bash
--- [ Day 4 of Winter ] ---------
Jimi: 5178 coins

Options:
1. Check plots
2. Advance day
3. Water
4. Plant
5. Harvest
6. Sell
7. List inventory
8. Crop catalogue
0. Exit
>
```

#### Checking plots
```bash
Bahia Farm:
Plot 1 has Amaranth (2/5 days)
Plot 2 has Pumpkin (4/11 days)
Plot 3 is empty.
Plot 4 has Cranberry (5/5 days)
Plot 5 is empty.
```

#### Water
```bash
Choose a plot:
Plot 1 has Kale (1/4 days)
Plot 4 has Parsnip (2/3 days)
> 4
Parsnip has been watered!
```

#### Plant
```bash
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
```bash
Choose a plot:
Plot 2 has Radish (3/3 days)
> 2
Radish harvested!
```

#### Sell (& List Inventory)
```bash
Inventory:
1x Parsnip
3x Melon
5x Cranberry

Item: Melon
Quantity: 2
Sold 2 Melon for 162 coins!
```

#### Crop catalogue
```bash
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
- Adding save files
- Store with items/seeds

## Credits
- Game concept & assets: [**Stardew Valley, ConcernedApe** ↗](https://www.stardewvalley.net/)
- Code: [**gettingfunkier** ↗](https://github.com/gettingfunkier)
- Made with ❤ in Java, during Y2 of Software Engineering, 2025
  
---

*to be continued...*
