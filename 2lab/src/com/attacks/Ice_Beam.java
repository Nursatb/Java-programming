package com.attacks;

import ru.ifmo.se.pokemon.*;

public class Ice_Beam extends PhysicalMove {
	public Ice_Beam(){
		super(Type.ICE, 90, 1.0);
	}

	@Override
	protected void applySelfEffects(Pokemon a) {
        Effect i_beam = new Effect().chance(0.1).condition(Status.FREEZE);
        a.addEffect(i_beam);
    }
    /*public String describe(){
        return " замерзни";*/
}