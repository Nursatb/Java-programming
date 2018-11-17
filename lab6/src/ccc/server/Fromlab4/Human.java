package Fromlab4;

import server.MyExeptions;

/**
 * Class server.Fromlab4.Human with subclass (@link server.Fromlab4.Human)
 *
 */
public class Human extends Being implements Haction {
    String name;
    public Human(String name){
        this.name = name;
        System.out.println("Создается человек по имени "+name );
    }
    public String getName() {
        return name;
    }

    /**
     * @see Human#go(Speed)
     */

    @Override
    public void go(Speed curState){
        System.out.println(name+ " передвигается "+ curState.getDescription());
    }
    @Override
    public void get_state(State state) {
        System.out.println(name+ state.getDescription());
    }
    @Override
    public void mutter(){
        if(name != "Emma")
            throw new IllegalArgumentException("Не тот бормочет!!!А должен "+name);
        else
            System.out.println(name + " бормочет ");

    }
    @Override
    public void clattering(Instrument inst){
        System.out.println(name + " постукивает " + inst.getInstname()); }


    /**
     * @see Human#carry(Product)
     * @return " принести "+product.getName_of_product()
     */
    @Override
    public String carry(Product product) {
        return (" принести "+product.getName_of_product());
    }

    /**
     * @see  Human#say(Human, Human, Location, Location, Time, Time, Cyborg, Product, State)
     */

    @Override
    public void say(Human n, Human m, Location a, Location b, Time time1, Time time2, Cyborg cyborg, Product product, State state) {
        class Dog extends Being {
            String name;
            Dog(String name){
                this.name=name;
            }
            public String getName() {
                return name;
            }

            @Override
            public String toString() {
                return name;
            }

            public void goesto(Location location) {
                System.out.println(" идет к "+location);
            }
            public String  sleep(Dog dog) {
                //System.out.println(name + "спит");
                return (dog.getName() + " спит");
            }
            public String getup(Dog dog) {
                return (dog.getName()+" проснулся ");
            }
        }

            /*(server.Fromlab4.Human human,server.Fromlab4.Human human2,Dog dog,server.Fromlab4.State state)->{
                System.out.println(human.getName()+":пусть только "+human2.getName()+state.getDescription()+" и "+human2.agree());
            };*/

        Dog bimbo = new Dog(" Бимбо ");
        System.out.println(n.getName()+":"+bimbo.getName()+" может провести "+time1.getTime() + " в "+
                b.getLocation() + "." + bimbo.sleep(bimbo) + " на "+a.getLocation()+".А "+time2.getTime()+" "+bimbo.getup(bimbo)+".\n"
                +cyborg.promise()+cyborg.carry(product)+".Пусть только"+m.getName()+state.getDescription()+","+m.agree()+m.give(bimbo)+".");

//          Пусть только Малыш образумится и согласится отправить к нему Бимбо.
//        ("%s :%s  может провести %s в %s.%s на %s.A %s %s.%s %s. %s",n.getName(),bimbo.getName(),time1.getTime(),b.getLocation(),
//         bimbo.sleep(bimbo),a.getLocation(),time2.getTime(),bimbo.getup(bimbo),cyborg.getName(),cyborg.carry(product),cyborg.promise())
        }

    @Override
    public String promise() {
        return (name+" обещает");
    }
    @Override
    public String agree() {
        try{if (name !=" Малыш ")
                throw new MyExeptions("не тот соглашается,а должен:_Малыш_");
        }
        catch (MyExeptions o){
            return o.getMessage();
        }
        return (name + " согласиться ");
    }
    @Override
    public String give(Object object) {
        try{
           if(object==null){
               throw  new Unchecked("werfgblkn");
           }
        }
        catch (NullPointerException error){
            return error.getMessage();
        }
        return (" дать "+object.toString());
    }
    @Override
    public void look_to(Human human,String n){
    }
    @Override
    public boolean equals(Object o) {
        Human other = (Human)o;
        if (o == null || o.getClass()!=Human.class)
        return false;
        if (other.name.equals(this.name))
            return true;
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result=0;
        result = name.hashCode();
        return result;
    }
        static public class Cyborg extends Human implements Haction{
            public Cyborg(String name){
                    super(name);
                System.out.println("который является киборгом");
            }
}
}
