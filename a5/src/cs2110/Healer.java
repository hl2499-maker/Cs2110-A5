package cs2110;

/**
 * A type of Mage that can cast a healing spell to restore health to any player
 */
public class Healer extends Mage {

    /**
     * Constructs a new Healer with the inherited name and game engine.
     */
    public Healer(String name, GameEngine engine) {
        super(name, engine);
    }

    /**
     * Returns the name of this Mage's spell: "healing spell"
     */
    @Override
    protected String spellName() {
        return "healing spell";
    }

    /**
     * Executes the healing spell, prompting the user to select a player target and then restores a
     * random amount of health between 0 and the Healer's power level (inclusive) to that player.
     * The target's health cannot exceed their maximum starting health, however
     */
    @Override
    protected void useSpell() {
        Player target = engine.selectPlayerTarget();
        int healRoll = engine.diceRoll(0, power());
        target.heal(healRoll);
    }
}
