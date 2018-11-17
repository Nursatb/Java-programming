package Fromlab4;

public enum State {

   PERPLEXITY(" в растерянности "), UNCOMFORTABLE(" не по себе "),GOT_ANGRY(" рассердиться "),GETUP(" проснуться "),SETTLE_DOWN(" образумиться ");

    private String description;

    State(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


}
