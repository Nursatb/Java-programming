package com.attacks;

import ru.ifmo.se.pokemon.*;

public class Energy_Ball extends SpecialMove {
	public Energy_Ball(){
		super(Type.GRASS, 90, 1.0);
	}

	@Override
	protected void applySelfEffects(Pokemon a) {  //  ??self or opp ? and a or p?
        Effect e_ball = new Effect().chance(0.1).stat(Stat.SPECIAL_DEFENSE, -1);
        a.addEffect(e_ball);
    }
    public String describe(){
        return " снижаю защиту";}
}