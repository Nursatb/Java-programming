package com.attacks;

import ru.ifmo.se.pokemon.*;

public class Scald extends SpecialMove {

    public Scald() {
        super(Type.WATER,80,1.0);
    }

    protected void applySelfEffects(Pokemon a) {
        Effect scld = new Effect().chance(0.3).condition(Status.BURN);
        a.addEffect(scld);
    }
    
}