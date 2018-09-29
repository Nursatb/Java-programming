package com.pokemons;

import com.attacks.*;
import ru.ifmo.se.pokemon.*;

public class Ninjask extends Nincada {

    public Ninjask(String name) {
        super(name);
		setStats(31, 45, 90, 30, 30, 40);
		setType(Type.BUG,Type.FLYING);		
		setMove(new Facade(), new Rest(), new Double_team(), new Ice_Beam());

    }
/*    protected Ninjask(String name, int level){
        super(name, level);
    }*/
}
