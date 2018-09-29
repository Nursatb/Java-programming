public class Main {
    public static void main(String[] args) {
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
        String result = " Карлсон : Бимбо  может провести  ночь  в  дом на крыше . Бимбо  спит на  диван .А  утром   Бимбо  проснулся .\n" +
                " Карлсон  обещает принести фарш.Пусть только Малыш  образумиться , Малыш  согласиться  дать  Бимбо .";
        String message;
        Human kid = new Human(" Малыш ");
        Human.Cyborg karl = new Human.Cyborg(" Карлсон ") {
            @Override
            public void look_to(Human human, String n) {
                System.out.println(human.getName() + " смотрит на " + human.getName());
            }
        };
        karl.look_to(kid, " Малыш ");
        kid.get_state(State.GOT_ANGRY);
        karl.say(karl, kid, Location.SOFA, Location.ROOF, Time.NIGHT
                , Time.MORNING, karl, Product.FORCEMEAT, State.SETTLE_DOWN);
        Tags rofl = new Tags();
        //rofl.setmessage("Hello world!!");
//        {
//            try {
//                karl.say(karl, kid, Location.SOFA, Location.ROOF, Time.NIGHT, Time.MORNING, karl, Product.FORCEMEAT, State.SETTLE_DOWN);
//                    return;
//            } finally {
//                System.out.println(" Карлсон : Бимбо  может провести  ночь  в  дом на крыше . Бимбо  спит на  диван .А  утром   Бимбо  проснулся .\n" +
//                        " Карлсон  обещает принести фарш.Пусть только Малыш  образумиться , Малыш  согласиться  дать  Бимбо .");
//            }
//
//        }
        //стоит попытаться Заключить фарш и собаку в разговоре навсегда т.к. это все говориться только в разговоре
        /*Карлсон поглядел на Малыша так, словно не верил своим ушам. Малыш всерьез рассердился. Тогда Карлсон сказал,
         что Бимбо может провести ночь в его домике на крыше. Ляжет на его диванчик, будет себе спать и тихо посапывать.
         А утром, когда Бимбо проснется, Карлсон принесет ему фарш, он обещает.Пусть только Малыш образумится и согласится отправить к нему Бимбо.*/
    }
}