package kg.geeks.game.players;

import java.util.Random;

public class Gambler extends Hero{

    public Gambler(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.GAMBLING);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        Random random = new Random();
        int d1 = random.nextInt(6) + 1;
        int d2 = random.nextInt(6) + 1;
        if (d1 == d2){
            boss.setHealth(boss.getHealth() - d1 * d2);
            System.out.println("Gambler " + this.getName() + " gets Jackpot and hits: " + (d1 * d2));
        } else {
            int indexOfLooser = random.nextInt(heroes.length);
            heroes[indexOfLooser].setHealth(heroes[indexOfLooser].getHealth() - (d1 + d2));
            System.out.println("Gambler " + this.getName() + " looses and " + heroes[indexOfLooser].getName() + " gets damage: " + (d1 + d2)) ;
        }
    }
}
