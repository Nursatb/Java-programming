package Fromlab4;

public enum Speed {
    FAST(" быстро "), SLOW(" медленно ");

    private String description;

    Speed(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
