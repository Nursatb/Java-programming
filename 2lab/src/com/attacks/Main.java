package com.attacks;
import com.pokemons.*;
import ru.ifmo.se.pokemon.*;

public class Main {

    public static void main(String[] args) {

        Battle battle = new Battle();
        battle.addAlly(new Azelf("Straik"));
        battle.addAlly(new Nincada("Kirilloid"));
        battle.addFoe(new Ninjask("ISERVERI"));
        battle.go();

        //System.err.println("-----------------------------------");

        Battle battle2 = new Battle();
        battle2.addAlly(new Trapinch ("LeBwa_2")    );
        //battle2.addAlly(new Marill  ("Kirilloid_2"));
        battle2.addFoe (new Vibrava ("Near_You_2") );
        battle2.addFoe (new Flygon("Neskwi_2")   );
        battle2.go();
    }
}
//компиляция javac -d bin -sourcepath src -classpath lib/Pokemon.jar src/com/attacks/Main.java
//запуск java -classpath bin:lib/Pokemon.jar com.attacks.Main
