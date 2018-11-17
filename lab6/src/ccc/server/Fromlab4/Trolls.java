package Fromlab4;//package server;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Trolls extends Being implements Taction, Serializable, Comparable<Trolls> {

    public String name;
    String date;
    int age;
    Date born;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public Trolls() {}

    public Trolls(String name, String date, String age)
    {
       // super(name);
        this.name = name;
        this.date = date;
        this.age = Integer.parseInt(age);
        System.out.println("Cоздается троль с именем " + name );
    }


//    public void parsedate(String date){
//        try{
//            born = dateFormat.parse(date);
//            System.out.println(born);
//        }catch (ParseException e){
//            System.out.println("ошибка парс даты");
//        }
//    }



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
    public boolean equals(server.Fromlab4.Trolls obj) {
        return false;
    }*/

    @Override
    public int hashCode() {
        int result = 0;
        result = name.hashCode();
        return result;
    }

    public void setName(String name){this.name = name;}

    public void setdate(String date){this.date=date;}

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
    public String getdate() {
//        try{
//            born = date;
////            System.out.println(born);
//        }catch (ParseException e){
//            System.out.println("ошибка парс даты");
//        }
        return String.valueOf(date);
    }

    @Override
    public int compareTo(Trolls o) {
        return 0;
    }
}
