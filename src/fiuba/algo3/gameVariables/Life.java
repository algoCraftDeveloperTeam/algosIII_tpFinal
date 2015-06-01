package fiuba.algo3.gameVariables;

/**
 * Created by mporto on 30/05/15.
 */
public class Life {
    int vitality, shield, maxShieldValue;

    public Life(int vitality, int shield) {
        this.vitality = vitality;
        this.shield = shield;
        this.maxShieldValue = shield;
    }

    public int getVitality() {
        return vitality;
    }

    public int getShield() {
        return shield;
    }

    public void receiveAttack(int attack) {
        if (attack > shield) {
            attack -= shield;
            shield = 0;
            vitality -= attack;
        } else {
            shield -= attack;
        }
    }

    public void regenerateShield() {
        int regenerationRate = 10;
        if(shield != 0) {
            if(shield + regenerationRate > maxShieldValue) {
                shield = maxShieldValue;
            }
            else{
                shield += regenerationRate;
            }
        }
    }
}
