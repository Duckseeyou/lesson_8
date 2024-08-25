package kg.geeks.game.players;

public class Reaper extends Hero{

    int maxHp = this.getHealth();

    public Reaper(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.SOUL_BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (this.getHealth() < maxHp * 0.30){
            this.setDamage(this.getDamage() * 2);
        } else if (this.getHealth() < maxHp * 0.15) {
            this.setDamage(this.getDamage() * 3);
        }
    }
}
