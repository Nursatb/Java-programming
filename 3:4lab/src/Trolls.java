public class Trolls extends Being implements Taction {

    String name;

    Trolls(String name)
    {
       // super(name);
        this.name = name;
        System.out.println("Cоздается тролли видов " + name );
    }


    @Override
    public void look(Human m) {
        System.out.println(name + " смотрят на " + m.getName());
    }

    @Override
    public void forget() {
        System.out.println(name + " забывают");
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public void currstate(Trolls n,State state){
        System.out.println(n.name + state.getDescription());
    }
/*
    @Override
    public boolean equals(Trolls obj) {
        return false;
    }*/

    @Override
    public int hashCode() {
        int result = 0;
        result = name.hashCode();
        return result;
    }
}
