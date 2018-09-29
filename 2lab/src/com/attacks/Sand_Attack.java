package com.attacks;

import ru.ifmo.se.pokemon.*;

public class Sand_Attack extends SpecialMove {
	public Sand_Attack(){
		super(Type.GROUND, 0, 1.0);
	}

	@Override
	protected void applySelfEffects(Pokemon a) {  //  ??self or opp ? and a or p?
        Effect s_att = new Effect().turns(1).chance(1).stat(Stat.ACCURACY, -1);
        a.addEffect(s_att);
    }
    public String describe(){
        return " промахивайся";}
}