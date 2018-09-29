package com.attacks;

import ru.ifmo.se.pokemon.*;

public class Facade extends PhysicalMove {
    public Facade() {
        super(Type.NORMAL, 70, 1);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        Effect e = new Effect();
        if (e.condition() == Status.BURN || e.condition() == Status.PARALYZE || e.condition() == Status.POISON)
        {
         super.power *= 2;
        }
    }
    public String describe(){
        return " я в ярости и моя мощь удваивается";
    }
}
