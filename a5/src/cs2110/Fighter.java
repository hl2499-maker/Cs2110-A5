package cs2110;

/**
 * A type of Player, that can equip Weapons to increase both their power and toughness stats
 */
public class Fighter extends Player {

    /**
     * The weapon currently equipped by this Fighter. Is `null` if no weapon is equipped.
     */
    private Weapon equipped;

    /**
     * Constructs a new Fighter with the given name and game engine.
     */
    public Fighter(String name, GameEngine engine) {
        super(name, engine);
        this.equipped = null;
    }

    /**
     * Returns the total power of this Fighter, which is the sum of their base power and the power
     * of their equipped weapon (if any)
     */
    @Override
    public int power() {
        int weapon_power = 0;
        if (equipped != null) {
            weapon_power += equipped.power();
        }
        return weapon_power + super.power();
    }

    /**
     * Returns the total toughness of this Fighter, which is the sum of their base toughness and the
     * toughness of their equipped weapon (if any)
     */
    @Override
    public int toughness() {
        int weapon_toughness = 0;
        if (equipped != null) {
            weapon_toughness += equipped.toughness();
        }
        return weapon_toughness + super.toughness();
    }

    /**
     * Prompts the user to decide whether to change their equipped weapon. If they choose to, this
     * method unequips the current one (if any), and/or equips a new weapon. This action is always
     * followed by attack phase. Return true, to indicate the turn should proceed to an attack
     * phase
     */
    @Override
    public boolean chooseAction() {
        System.out.print("Would you like to change your current equipment (yes/no)? ");
        String input = engine.getInputLine();

        if (input.equals("yes")) {
            Weapon chosen = engine.selectWeapon();
            if (chosen == null) {
                if (equipped != null) {
                    equipped.unequip();
                    equipped = null;
                }
            } else {
                if (equipped != null) {
                    equipped.unequip();
                }
                chosen.equip();
                equipped = chosen;
            }
        }
        return true;
    }

    /**
     * Processes the death of this Fighter. The Fighter will "drop" their equipped weapon, making it
     * available to other players, before the standard death process is completed.
     */
    @Override
    protected void processDeath() {
        if (equipped != null) {
            equipped.unequip();
            equipped = null;
        }
        super.processDeath();
    }
}

