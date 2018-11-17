//package server;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Json {


    public void nextCommand(String cmd, TreeSetCompare tree, String jsonstr) throws IOException {

        //Scanner in = new Scanner(System.in);
        //String jsonStringIN = in.nextLine();


        JSONParser parser = new JSONParser();
        JSONObject jsonCommand = null;

        try {
            jsonCommand = (JSONObject) parser.parse(String.valueOf(jsonstr));
        } catch (ParseException e) {
            System.out.println("Incorrect JSON format...");
        }

        switch (cmd) {
            case "remove_greater":
                tree.remove_greater(jsonCommand);
                tree.save();//------------------------------------------------------------
                System.out.println("Elements successfully removed...");
                break;
            case "add_if_max":
                tree.add_if_max(jsonCommand);
                tree.save();//------------------------------------------------------------
                break;
            case "add_if_min":
                tree.add_if_min(jsonCommand);
                tree.save();//------------------------------------------------------------

                break;
            case "add":
                tree.add_element(jsonCommand);
                tree.save();//------------------------------------------------------------
                break;
            default:
                System.out.println("Invalid command...");
                break;
        }
    }

}
