package cs2110;

public abstract class Mage extends Player {

    public Mage(String name, GameEngine engine) {
        super(name, engine);
    }

    public boolean chooseAction() {
        System.out.print("Would you like to cast a " + spellName() + " (yes/no)? ");
        String indicator = engine.getInputLine();
        if (indicator.equals("yes")) {
            useSpell();
            return false;
        }
        return true;
    }

    protected abstract String spellName();

    protected abstract void useSpell();
}
