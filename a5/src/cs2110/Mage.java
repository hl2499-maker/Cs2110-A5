package cs2110;

/**
 * An abstract base class for Players who can cast spells, defining the general turn structure for a
 * mage but reserves the specific spell implementation to its subclasses.
 */
public abstract class Mage extends Player {

    /**
     * Constructs a new Mage with the given name and game engine.
     */
    public Mage(String name, GameEngine engine) {
        super(name, engine);
    }

    /**
     * Prompts user to decide whether to cast this Mage's specific spell. If the user agrees, the
     * spell is cast and the Mage's turn ends, returning false. Otherwise, the user's turn proceeds
     * to be a normal attack phase, returning true.
     */
    public boolean chooseAction() {
        System.out.print("Would you like to cast a " + spellName() + " (yes/no)? ");
        String indicator = engine.getInputLine();
        if (indicator.equals("yes")) {
            useSpell();
            return false;
        }
        return true;
    }

    /**
     * Returns the name of the spell that this type of Mage can cast. Subclasses must implement this
     * method themselves to return their own spell name.
     */
    protected abstract String spellName();

    /**
     * Executes the actions associated with this Mage's unique spell. Subclasses must implement this
     * method themselves to define their own spell's behaviour
     */
    protected abstract void useSpell();
}
