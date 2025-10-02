package cs2110;

public class FireMage extends Mage {
    public FireMage(String name, GameEngine engine) {
        super(name, engine);
    }

    @Override
    protected String spellName() {
        return "fire spell";
    }

    @Override
    protected void useSpell() {
        Monster target = engine.selectMonsterTarget();
        int attackRoll = 2 * engine.diceRoll(1, power());
        target.defend(attackRoll);
        this.takeDamage((int)(attackRoll/4));
    }

}
