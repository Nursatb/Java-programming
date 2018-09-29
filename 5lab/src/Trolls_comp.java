import java.util.Comparator;

class Trolls_name_comp implements  Comparator<Trolls>{
    @Override
     public int compare(Trolls n1, Trolls n2)
    {return  n1.getname().compareTo(n2.getname());}

}

class Trolls_detachment_comp implements Comparator<Trolls> {
    @Override
    public  int compare(Trolls det1,Trolls det2)
    {return det1.getdetachment().compareTo(det2.getdetachment());}

}

class Trolls_age_comp implements Comparator<Trolls> {
    @Override
    public  int compare(Trolls a1,Trolls a2){
        if (a1.getage()>a2.getage()) {return 1;}
        else if (a1.getage()<a2.getage()){ return -1; }
        else {return 0;}

    }
}
