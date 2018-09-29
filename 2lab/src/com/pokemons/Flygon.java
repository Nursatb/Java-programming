package com.pokemons;

import com.attacks.Confide;
import com.attacks.Energy_Ball;
import com.attacks.Rest;
import ru.ifmo.se.pokemon.Move;
import ru.ifmo.se.pokemon.Type;

public class Flygon
        extends Vibrava
{
    public Flygon(String paramString)
    {
        super(paramString);
        setStats(80.0D, 100.0D, 80.0D, 80.0D, 80.0D, 100.0D);
        setType(new Type[] { Type.GROUND, Type.DRAGON });
        setMove(new Move[] { new Confide(), new Rest(), new Energy_Ball(), new Confide() });
    }
}
//package com.pokemons;
//import com.attacks.*;
//import ru.ifmo.se.pokemon.*;
//
//public class Flygon extends Vibrava {
//
//    public Flygon(String name) {
//        super(name);
//		setStats(80, 100, 80, 80, 80, 100);
//		setType(Type.GROUND, Type.DRAGON);
//		setMove(new Confide(), new Rest(), new Energy_Ball(), new Confide());
//    }
//
//    protected Flygon(String name, int level){
//        super(name, level);
//    }
//}
