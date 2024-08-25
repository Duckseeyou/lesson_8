package kg.geeks.game.logic;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();
    private static int roundNumber;

    public static void startGame() {
        Boss boss = new Boss("Vurdalak", 1300, 60);
        Warrior warrior1 = new Warrior("Volt", 290, 10);
        Warrior warrior2 = new Warrior("Darius", 280, 15);
        Magic magic = new Magic("Terran", 270, 20);
        Berserk berserk = new Berserk("Viking", 240, 10);
        Medic doc = new Medic("Enstein", 200, 5, 15);
        Medic assistant = new Medic("Green", 300, 5, 5);
        Gambler gambler = new Gambler("Hakari", 250, 5);
        King king = new King("King", 300, 0);
        Reaper reaper = new Reaper("Bob", 300, 10);

        Hero[] heroes = {warrior1, doc, warrior2, magic, berserk, assistant, gambler, king, reaper};

        printStatistics(boss, heroes);
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
            return true;
        }
        return false;
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0
                    && hero.getAbility() != boss.getDefence()) {
                hero.attack(boss);
                hero.applySuperPower(boss, heroes);
            }
        }
        System.out.println();
        printStatistics(boss, heroes);
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " ---------------");
        System.out.println(boss);
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
        System.out.println();
    }
}
