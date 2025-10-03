package cs2110;

/**
 * A type of Mage that specializes in a fire spell that deals 2x the base roll to a monster at the
 * cost of potentially causing a quarter of the damage to the caster Mage themselves
 */
public class FireMage extends Mage {

    /**
     * Constructs a new FireMage with the inherited name and game engine.
     */
    public FireMage(String name, GameEngine engine) {
        super(name, engine);
    }

    /**
     * Returns the name of this Mage's spell: "fire spell"
     */
    @Override
    protected String spellName() {
        return "fire spell";
    }

    /**
     * Executes the fire spell, prompting the user to select a monster target, then attacks it with
     * a fireball that has a doubled the base attack roll, which is a random integer between 1 and
     * the FireMage's power, inclusive. If the attack was successful, the FireMage then takes recoil
     * damage equal to one-quarter of the total attack roll (rounded down).
     */
    @Override
    protected void useSpell() {
        Monster target = engine.selectMonsterTarget();
        int attackRoll = 2 * engine.diceRoll(1, power());
        target.defend(attackRoll);
        this.takeDamage(attackRoll / 4);
    }
}
