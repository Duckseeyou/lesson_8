package kg.geeks.game.players;

import java.util.Random;

public class King extends Hero{
    public King(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.ONEPUNCH);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        Random random = new Random();
        boolean isSaitamaSummoned = random.nextInt(10) == 0;
        if (isSaitamaSummoned) {
            System.out.println("Bald Cape is summoned");
            System.out.println("Bald cape does damage: " + boss.getHealth());
            boss.setHealth(0);
        }
    }
}
