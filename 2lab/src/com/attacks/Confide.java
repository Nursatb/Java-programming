package com.attacks;

import ru.ifmo.se.pokemon.*;

public class Confide extends StatusMove {

    public Confide() {
        super(Type.NORMAL,0,1);
    }

    @Override
    protected void applyOppEffects(Pokemon a) {
        Effect confide = new Effect().stat(Stat.ATTACK, -1);
        a.addEffect(confide);
    }

}
