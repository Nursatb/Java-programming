public enum Time {
    MORNING(" утром "),EVENING(" вечером "),NIGHT(" ночь ");
    String time;
    Time(String time) {
        this.time=time;
    }

    public String getTime() {
        return time;
    }
}