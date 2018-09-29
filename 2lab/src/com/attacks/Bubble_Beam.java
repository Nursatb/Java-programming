package com.attacks;

import ru.ifmo.se.pokemon.*;

public class Bubble_Beam extends SpecialMove {
	public Bubble_Beam(){
		super(Type.WATER, 65, 1.0);
	}

	@Override
	protected void applySelfEffects(Pokemon a) {   //  ??self or opp 
        Effect b_beam = new Effect().turns(1).chance(0.1).stat(Stat.SPEED, -1);
        a.addEffect(b_beam);
    }
    public String describe(){
        return " ";}
}