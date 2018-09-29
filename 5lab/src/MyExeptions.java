public class MyExeptions extends IllegalAccessException {

    private String message;

    public MyExeptions(String e){
        super(e);
        //this.initCause(e);
        message = e;

    }

    @Override
    public String getMessage() {
        return message;
    }


    //    public String exep(MyExeptions e){
//        if (e !=" Малыш ")
//            throw new IllegalArgumentException("не тот соглашается,а должен:_Малыш_");
//        else
//            return (e+" согласиться ");
//        System.out.println("");
//    }
}
