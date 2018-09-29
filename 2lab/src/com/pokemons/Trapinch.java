package com.pokemons;
import com.attacks.*;
import ru.ifmo.se.pokemon.*;

public class Trapinch extends Pokemon {

    public Trapinch(String name) {
        super(name, 50);
		setStats(45, 100,45, 45, 45, 10);
		setType(Type.GROUND);		
		setMove(new Confide(), new Rest());
    }
    protected Trapinch(String name, int level){
        super(name,level);
    }
}
