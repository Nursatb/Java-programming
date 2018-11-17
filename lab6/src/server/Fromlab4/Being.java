package Fromlab4;


/**
 * This is abstract method server.Fromlab4.Being
 */
public abstract class Being {

    public String toString(Human h) {
        return h.name;
    }


    public String toString(Trolls t) {
        return t.name;
    }
}