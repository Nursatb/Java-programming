import java.util.Scanner;

public class Trolls extends Being implements Taction {

    String name;
    String detachment;
    int age;

    public Trolls() {}

    Trolls(String name,String detachment,String age)
    {
       // super(name);
        this.name = name;
        this.detachment = detachment;
        this.age = Integer.parseInt(age);
        System.out.println("Cоздается троль с именем " + name );
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

    public void setName(String name){this.name = name;}

    public void setDetachment(String detachment){this.detachment=detachment;}

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int getage() {
        return age;
    }

    @Override
    public String getname() {
        return name;
    }

    @Override
    public String getdetachment() {
        return detachment;
    }

}
