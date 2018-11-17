//package server;

import java.io.Serializable;

public class Jsonparseserver implements Serializable{

    Jsonparseserver Jsonser;
    String o;

    Jsonparseserver(String o){
        this.o = o;
    }


    public String getO() {
        return o;
    }

    public void setO(String o) {
        this.o = o;
    }
}
