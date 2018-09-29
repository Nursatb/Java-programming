package com.pokemons;
import com.attacks.*;
import ru.ifmo.se.pokemon.*;

public class Nincada extends Pokemon {

    public Nincada(String name) {
        super(name, 50);
		setStats(31, 45, 90, 30, 30, 40);
		setType(Type.BUG, Type.GROUND);		
		setMove(new Facade(), new Rest(), new Double_team());
    }
}
