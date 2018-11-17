//package klient;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Scanner;

public class Commands {
//            { "name":"Nursat", "date":"28-05-2000", "age":18}

    JSONObject outmsg = null;


    public void nextCommand(String cmd) {
        if (cmd.equals("test")){
            Client client= new Client();
            client.test();
            return;
        }
        System.out.println("Введите JSON:");
        Scanner in = new Scanner(System.in);
        String jsonStringIN = in.nextLine();
        String exept = null;

        JSONParser parser = new JSONParser();
        JSONObject jsonCommand = null;
        boolean ch = false;

        switch (cmd) {
            case "remove_greater":
                //System.out.println(jsonCommand.get("name") + " " + jsonCommand.get("date") + " " + jsonCommand.get("age"));
                //tree.save();
                System.out.println("Elements successfully removed...");
                break;
            case "add_if_max":
                //System.out.println(jsonCommand.get("name") + " " + jsonCommand.get("date") + " " + jsonCommand.get("age"));
                //tree.save();
                break;
            case "add_if_min":
                //System.out.println(jsonCommand.get("name") + " " + jsonCommand.get("date") + " " + jsonCommand.get("age"));
                //tree.save();

                break;
            case "add":
                //System.out.println(jsonCommand.get("name") + " " + jsonCommand.get("date") + " " + jsonCommand.get("age"));
                //tree.save();
                break;
            default:
                System.out.println("Invalid command...");
                ch = false;
        }

        try {
            jsonCommand = (JSONObject) parser.parse(String.valueOf(jsonStringIN));
            if (jsonCommand.get("name") == null || jsonCommand.get("date")==null || jsonCommand.get("age")==null){
                System.out.println("что-то осталось пустым");
                outmsg = null;
                return;
            }
            exept = "прошел";
            System.out.println(jsonCommand.get("name") + " " + jsonCommand.get("date") + " " + jsonCommand.get("age"));
            outmsg = jsonCommand;

        } catch (ParseException e) {
            System.out.println("Incorrect JSON format...");
            return;

        }
        
        if (ch == false){return;}

            //System.out.println(exept);
//        if (exept == null){
//            if (jsonCommand.get("name") == null || jsonCommand.get("date")==null || jsonCommand.get("age")==null){
//                System.out.println("что-то осталось пустым");
//                return;
//            }
//        }






    }

    public JSONObject getOutmsg() {
        return outmsg;
    }
 }
