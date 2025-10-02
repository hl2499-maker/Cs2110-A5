package cs2110;

public class Healer extends Mage {

    public Healer(String name, GameEngine engine) {
        super(name, engine);
    }

    @Override
    protected String spellName() {
        return "healing spell";
    }

    @Override
    protected void useSpell() {
        Player target = engine.selectPlayerTarget();
        int healRoll = engine.diceRoll(0, power());
        target.heal(healRoll);
    }
}
