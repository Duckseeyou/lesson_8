package kg.geeks.game.players;

public class Magic extends Hero {

    public Magic(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                hero.setDamage((int) (hero.getDamage() * 1.15));
            }
        }
        System.out.println("Magic " + this.getName() + " boosts every hero by 15%");
    }
}
