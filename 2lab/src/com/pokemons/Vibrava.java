package com.pokemons;

import com.attacks.Confide;
import com.attacks.Energy_Ball;
import com.attacks.Rest;
import ru.ifmo.se.pokemon.Move;
import ru.ifmo.se.pokemon.Type;

public class Vibrava
        extends Trapinch
{
    public Vibrava(String paramString)
    {
        super(paramString, 50);
        setStats(50.0D, 70.0D, 50.0D, 50.0D, 50.0D, 70.0D);
        setType(new Type[] { Type.GROUND, Type.DRAGON });
        setMove(new Move[] { new Confide(), new Rest(), new Energy_Ball() });
    }
}
//package com.pokemons;
//
//import com.attacks.*;
//import ru.ifmo.se.pokemon.*;
//
//public class Vibrava extends Trapinch {
//
//    public Vibrava(String name) {
//        super(name,level);
//		setStats(50, 70, 50, 50, 50, 70);
//		setType(Type.GROUND, Type.DRAGON);
//		setMove(new Confide(), new Rest(), new Energy_Ball());
//    }
//}
