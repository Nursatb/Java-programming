//package klient;

import java.io.Serializable;

public class Jsonparse  implements Serializable{

    Jsonparseserver Jsonser;
    String o;

    Jsonparse(String o){
        this.o = o;
    }


    public String getO() {
        return o;
    }

    public void setO(String o) {
        this.o = o;
    }
}
