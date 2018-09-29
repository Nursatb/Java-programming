package com.attacks;
import ru.ifmo.se.pokemon.*;


public class Rest extends StatusMove {
    public Rest() {
        super(Type.PSYCHIC, 0, 1);
    }

    protected void applySelfEffects(Pokemon p) {
        Effect rest = new Effect().turns(2);
        p.restore();
        rest.sleep(p);
    }
    public String describe(){
        return " надо силы восстаносить";
    }
}