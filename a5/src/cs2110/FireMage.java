package cs2110;

public class FireMage extends Mage {
    private String spellname="Fireball";
    public FireMage(String name, GameEngine engine) {
        super(name, engine);
    }

    @Override
    protected void attack(Actor target) {
        int attackRoll = engine.diceRoll(1, power());
        target.defend(2*attackRoll);
        this.takeDamage((int)(attackRoll/4));
    }

}
