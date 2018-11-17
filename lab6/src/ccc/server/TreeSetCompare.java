//package server;

import Fromlab4.Trolls;
import org.json.simple.JSONObject;

import java.io.*;
import java.net.UnknownHostException;
import java.util.*;


public class TreeSetCompare {
    //add
    //{ "name":"Nursat", "date":"28-05-2000", "age":18}

    Comparator<Trolls> Trollcomp = new Trolls_name_comp().thenComparing(new Trolls_date_comp()).thenComparing(new Trolls_age_comp());
    TreeSet<Trolls> types = new TreeSet<>(Trollcomp);


    Set<Trolls> synch = Collections.synchronizedSet(types);
    Connection connection = new Connection();

    FileInputStream fr;
    String filemsg;

    {
        try {
            fr = new FileInputStream("/home/s242096/str.csv");///Users/nursat/workspace/lab6/src/str.csv
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    Scanner in = null;
    static FileOutputStream out = null;
    Scanner dataScanner = null;
    String path = "";

    public void setPath(String path) throws FileNotFoundException {

        this.path = path;

        in = new Scanner(new File("/home/s242096/str.csv"));//path + "/str.csv"
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
        try {
            connection.connect();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }



    public void readElements() {

        int index = 0;
        while (in.hasNextLine()) {

            dataScanner = new Scanner(in.nextLine());
            dataScanner.useDelimiter(",");
            Trolls curTroll = new Trolls();

            while (dataScanner.hasNext()) {
                String data = dataScanner.next();

                if (index == 0) {
                    curTroll.setName(data);
                } else if (index == 1) {
                    curTroll.setdate(String.valueOf(data));
                } else if (index == 2) {
                    curTroll.setAge(Integer.valueOf(data));
                }

                index++;
            }

            index = 0;

            types.add(curTroll);
            //System.out.println(in.next() + " " + in.next());
        }
        in.close();
    }

    public void writeElements() {

        System.out.println("----------------------" +
                "\n" +
                "----------------------");


        for (Trolls type : types) {
            System.out.println(type.getname() + "," + type.getdate() + "," + type.getage());

        }

        System.out.println("----------------------" +
                "\n" +
                "----------------------");

    }



    public void save() throws IOException {




        out = new FileOutputStream("/home/s242096/str.csv");

        byte[] buffer;
        String curStr = "";
        int i = 0;
        for(Trolls type: types) {
            if(i!=types.size()) {
                curStr += type.getname() + "," + type.getdate() + "," + type.getage() + "\n";
            } else
                curStr += type.getname() + "," + type.getdate() + "," + type.getage();

            i++;

            //System.out.println(curStr + "cur))))-------------------");
        }

        //System.out.println(buffer);

        buffer = curStr.getBytes();
        out.write(buffer, 0, buffer.length);

        out.close();

    }

    public void remove_greater(JSONObject jsonCommand) throws IOException {
        //System.out.println(1);
        System.out.println(jsonCommand.get("name") + " " + jsonCommand.get("date") + " " + jsonCommand.get("age"));

        Trolls curElement = new Trolls(jsonCommand.get("name").toString(), jsonCommand.get("date").toString(), String.valueOf(jsonCommand.get("age")));

        //SortedSet<Citizens> setGreate = types.tailSet(curElement,);
        String consolemssg;
        for (Iterator<Trolls> iterator = types.iterator(); iterator.hasNext(); ) {
            Trolls curTroll = iterator.next();

            if (Trollcomp.compare(curTroll, curElement) > 0) {
                iterator.remove();
                consolemssg = "Was removed...";
                connection.sendmessage(consolemssg);
            }
        }

        //System.out.println(types.ceiling(curElement).getName() + " " + types.ceiling(curElement).getAge());

        writeElements();

    }

    public void add_if_max(JSONObject jsonCommand) {
        //System.out.println(2);
        System.out.println(jsonCommand.get("name") + " " + jsonCommand.get("date") + " " + jsonCommand.get("age"));

        Trolls maxElement = types.last();
        Trolls curElement = new Trolls(jsonCommand.get("name").toString(), jsonCommand.get("date").toString(), String.valueOf(jsonCommand.get("age")));
        String consolemssg;
        if (types.higher(curElement) == null) {
            types.add(curElement);
            consolemssg = "Element successfully added...";
            System.out.println(consolemssg);

        } else {
            consolemssg = "Element is not max...";
            System.out.println("Element is not max...");
        }

        //System.out.println(types.higher(curElement));

        writeElements();
        connection.sendfile(consolemssg);
    }

    public void add_if_min(JSONObject jsonCommand) {
        //System.out.println(3);
        System.out.println(jsonCommand.get("name") + " " + jsonCommand.get("date") + " " + jsonCommand.get("age"));

        Trolls curElement = new Trolls(jsonCommand.get("name").toString(), jsonCommand.get("date").toString(), String.valueOf(jsonCommand.get("age")));
        String consolemssg;
        if (types.lower(curElement) == null) {
            types.add(curElement);

            consolemssg = "Element successfully added...";
            System.out.println(consolemssg);

        } else{
            consolemssg = "Element is not min...";
            System.out.println(consolemssg);}

        writeElements();
        connection.sendfile(consolemssg);

    }

    public void add_element(JSONObject jsonCommand) throws IOException {
        //System.out.println(4);
        System.out.println(jsonCommand.get("name") + " " + jsonCommand.get("date") + " " + jsonCommand.get("age"));
        String consolemssg;
        try {
            types.add(new Trolls(jsonCommand.get("name").toString(),jsonCommand.get("date").toString(), String.valueOf(jsonCommand.get("age"))));
            consolemssg = "Element successfully added...";
            System.out.println(consolemssg);

            writeElements();
            connection.sendfile(consolemssg);

        } catch (ClassCastException e) {
            System.out.println("Incorrect element types...");
            connection.sendmessage("Incorrect element types...");

        } catch (NullPointerException e) {
            System.out.println("Error...");
            connection.sendmessage("Error...");
        }
    }

}