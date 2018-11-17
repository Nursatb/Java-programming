package Fromlab4;

public interface Haction {
    void get_state(State state);
    void look_to(Human human,String n);
    void go(Speed state);
    void mutter();
    void clattering(Instrument inst);
    String carry(Product product);
    void say(Human n, Human m, Location a, Location b,
             Time time1, Time time2, Human.Cyborg cyborg, Product product, State state);
    String promise();
    String agree();
    String give(Object object);

}
