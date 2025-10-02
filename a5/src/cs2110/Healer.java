package cs2110;

public class Healer extends Mage {

    private String Spellname = "heal spell";

    public Healer(String name, GameEngine engine) {
        super(name, engine);
    }

    @Override
    protected void useSpell() {
        int healRoll = engine.diceRoll(0, power());
        heal(healRoll);
    }

}
