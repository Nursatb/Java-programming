package com.attacks;

import ru.ifmo.se.pokemon.*;

public class Double_team extends StatusMove {

    public Double_team() {
        super(Type.NORMAL,0,1);
    }

    protected void applySelfEffects(Pokemon p) {
        Effect dTeam = new Effect().stat(Stat.EVASION,1);
        p.addEffect(dTeam);
    }
    public String describe(){
        return " уклоняюсь как никогда";
    }

}
