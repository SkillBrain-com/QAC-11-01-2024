package DianaLuca.Tema3;

public class WizardsAndWarriors {
    abstract class Fighter {

        boolean isVulnerable() {
            {
                return false;
            }
        }

        abstract int damagePoints(Fighter fighter);

    }

    class Warrior extends Fighter {

        @Override
        public String toString() {
            return "Fighter is a Warrior";
        }

        @Override
        int damagePoints(Fighter wizard) {
            return wizard.isVulnerable() ? 10 : 6;
        }
    }

    class Wizard extends Fighter {

        private boolean spellPrepared = false;

        public String toString() {
            return "Fighter is a Wizard";
        }

        @Override
        boolean isVulnerable() {
            return !spellPrepared;
        }

        @Override
        int damagePoints(Fighter warrior) {
            return spellPrepared ? 12 : 3;
        }

        void prepareSpell() {
            spellPrepared = true;
        }
    }
}
