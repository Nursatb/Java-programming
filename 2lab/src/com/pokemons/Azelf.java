package com.pokemons;
import com.attacks.*;
import ru.ifmo.se.pokemon.*;

public class Azelf extends Pokemon {

    public Azelf(String name) {
        super(name, 50);
        setType(Type.PSYCHIC);
        setStats(75, 125, 70, 125, 70, 115);
        setMove(new Scald(), new Bubble_Beam(), new Sand_Attack(), new Rest());
    }
}