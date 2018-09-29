import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import org.json.simple.parser.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException,MyExeptions,IOException{

        Human kid = new Human(" Малыш ");
        Human.Cyborg karl = new Human.Cyborg(" Карлсон "){
            @Override
            public void   look_to(Human human,String n){
                System.out.println(human.getName()+" смотрит на "+human.getName());
            }
        };
        karl.look_to(kid," Малыш ");
        kid.get_state(State.GOT_ANGRY);
        karl.say(karl,kid,Location.SOFA,Location.ROOF,Time.NIGHT
                ,Time.MORNING,karl,Product.FORCEMEAT,State.SETTLE_DOWN);

        TreeSetCompare mainTree = new TreeSetCompare();
        Json cmdParse = new Json();
        Scanner cmdIn = new Scanner(System.in);

        Thread mainThread = Thread.currentThread();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                mainTree.save();
                //System.out.println(11111111);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                mainThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

        Scanner path = new Scanner(System.getenv("PATH"));
        path.useDelimiter(":");

        String pathStr;
        String check = null;

        while(path.hasNext()){

            pathStr = path.next();

            if (pathStr.substring(pathStr.length()-4,pathStr.length()).equals("5lab"))
                check = pathStr;

        }
        path.close();

        mainTree.setPath(check);
        mainTree.readElements();
        mainTree.writeElements();



        while(true){
                System.out.println("Enter command:");

                String curCmd = cmdIn.next();

                if (Objects.equals(curCmd, "stop_app")){
                    //mainTree.save();
                    System.out.println("Application stopped...");
                    break;
                }
                else
                    cmdParse.nextCommand(curCmd,mainTree);
            }
        }



}


































//        Human emma = new Human("Emma");
//        Trolls mumi = new Trolls("Mumi");
//        Instrument broom = new Instrument("broom");
//        emma.go(Speed.FAST);
//        emma.mutter();
//        emma.clattering(broom);
//        emma.go(Speed.SLOW);
//        mumi.currstate(mumi,State.PERPLEXITY);
//        mumi.look(emma);
//        mumi.currstate(mumi,State.UNCOMFORTABLE);
//        mumi.forget();
//        System.out.println("Emma's hashcode is = " + emma.hashCode());
//        System.out.println("Emma's string is = " + emma.toString(emma));
//        System.out.println("Mumi's hashcode is = " + mumi.hashCode());
//        System.out.println("Mumi's string is = " + mumi.toString(mumi));
//        String result=" Карлсон : Бимбо  может провести  ночь  в  дом на крыше . Бимбо  спит на  диван .А  утром   Бимбо  проснулся .\n" +
//                " Карлсон  обещает принести фарш.Пусть только Малыш  образумиться , Малыш  согласиться  дать  Бимбо .";
//        {
//            try {
//                if(karl.say(karl, kid, Location.SOFA, Location.ROOF, Time.NIGHT, Time.MORNING, karl, Product.FORCEMEAT, State.SETTLE_DOWN) = result)
//                    return;
//            }
//            finally {
//                System.out.println(" Карлсон : Бимбо  может провести  ночь  в  дом на крыше . Бимбо  спит на  диван .А  утром   Бимбо  проснулся .\n" +
//                            " Карлсон  обещает принести фарш.Пусть только Малыш  образумиться , Малыш  согласиться  дать  Бимбо .");
//            }
//        }
//стоит попытаться Заключить фарш и собаку в разговоре навсегда т.к. это все говориться только в разговоре
        /*Карлсон поглядел на Малыша так, словно не верил своим ушам. Малыш всерьез рассердился. Тогда Карлсон сказал,
         что Бимбо может провести ночь в его домике на крыше. Ляжет на его диванчик, будет себе спать и тихо посапывать.
         А утром, когда Бимбо проснется, Карлсон принесет ему фарш, он обещает.Пусть только Малыш образумится и согласится отправить к нему Бимбо.*/