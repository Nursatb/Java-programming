public class Unchecked extends NullPointerException {
    String  massage;
    public Unchecked(String  error){
      this.massage=error;
    }

    public String getMassage() {
        return massage;
    }
}
