package cs2110;

public abstract class Mage extends Player {

    private String Spellname;
//    private boolean willcast;

    public Mage(String name, GameEngine engine) {
        super(name, engine);

    }

    public boolean chooseAction() {
        System.out.print("Would you like to cast a" + this.Spellname + " ");
        String indicator = engine.getInputLine();
        if (indicator.equals("yes")) {
            return true;
        }
        return false;
    }

    protected abstract void useSpell();
}
