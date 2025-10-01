package cs2110;

public class Fighter extends Player {
    private Weapon equipped;

    public Fighter(String name, GameEngine engine) {
        super(name, engine);
        this.equipped = null;
    }

    @Override
    public int power() {
        int weapon_power = 0;
        if (equipped != null) {
            weapon_power += equipped.power();
        }
        return weapon_power + super.power();
    }

    @Override
    public int toughness() {
        int weapon_toughness = 0;
        if (equipped != null) {
            weapon_toughness += equipped.toughness();
        }
        return weapon_toughness + super.toughness();
    }

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

    @Override
    protected void processDeath() {
        if (equipped != null) {
            equipped.unequip();
            equipped = null;
        }
        super.processDeath();
    }
}

