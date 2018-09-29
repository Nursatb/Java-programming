
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.*;


public class TreeSetCompare {
    //add
    //{ "name":"Jhonson", "detachment":"LOL", "age":30}

    Comparator<Trolls> Trollcomp = new Trolls_name_comp().thenComparing(new Trolls_detachment_comp()).thenComparing(new Trolls_age_comp());
    TreeSet<Trolls> types = new TreeSet<>(Trollcomp);


    Scanner in = null;
    static FileOutputStream out = null;
    Scanner dataScanner = null;
    String path = "";

    public void setPath(String path) throws FileNotFoundException {

        this.path = path;

        in = new Scanner(new File(path + "/str.csv"));
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
            System.out.println(type.getname() + " " + type.getage() + " " + type.getdetachment());
        }

        System.out.println("----------------------" +
                "\n" +
                "----------------------");

    }

    public void save() throws IOException {

        out = new FileOutputStream(path + "/str.csv");

        byte[] buffer;
        String curStr = "";
        int i = 0;
        for (Trolls type : types) {
            if (i != types.size()) {
                curStr += type.getname() + "," + type.getage() + "\n";
            } else
                curStr += type.getname() + "," + type.getage();

            i++;

            //System.out.println(curStr + "cur))))-------------------");
        }

        //System.out.println(buffer);

        buffer = curStr.getBytes();
        out.write(buffer, 0, buffer.length);

        out.close();

    }

    public void remove_greater(JSONObject jsonCommand) {
        //System.out.println(1);
        System.out.println(jsonCommand.get("name") + " " + jsonCommand.get("detachment") + " " + jsonCommand.get("age"));

        Trolls curElement = new Trolls(jsonCommand.get("name").toString(), jsonCommand.get("detachment").toString(), String.valueOf(jsonCommand.get("age")));

        //SortedSet<Citizens> setGreate = types.tailSet(curElement,);

        for (Iterator<Trolls> iterator = types.iterator(); iterator.hasNext(); ) {
            Trolls curTroll = iterator.next();

            if (Trollcomp.compare(curTroll, curElement) > 0) {
                iterator.remove();
            }
        }

        //System.out.println(types.ceiling(curElement).getName() + " " + types.ceiling(curElement).getAge());

        writeElements();
    }

    public void add_if_max(JSONObject jsonCommand) {
        //System.out.println(2);
        System.out.println(jsonCommand.get("name") + " " + jsonCommand.get("detachment") + " " + jsonCommand.get("age"));

        Trolls maxElement = types.last();
        Trolls curElement = new Trolls(jsonCommand.get("name").toString(), jsonCommand.get("detachment").toString(), String.valueOf(jsonCommand.get("age")));

        if (types.higher(curElement) == null) {
            types.add(curElement);
            System.out.println("Element successfully added...");
        } else
            System.out.println("Element is not max...");


        //System.out.println(types.higher(curElement));

        writeElements();
    }

    public void add_if_min(JSONObject jsonCommand) {
        //System.out.println(3);
        System.out.println(jsonCommand.get("name") + " " + jsonCommand.get("detachment") + " " + jsonCommand.get("age"));

        Trolls curElement = new Trolls(jsonCommand.get("name").toString(), jsonCommand.get("detachment").toString(), String.valueOf(jsonCommand.get("age")));

        if (types.lower(curElement) == null) {
            types.add(curElement);
            System.out.println("Element successfully added...");
        } else
            System.out.println("Element is not min...");

        writeElements();
    }

    public void add_element(JSONObject jsonCommand) {
        //System.out.println(4);
        System.out.println(jsonCommand.get("name") + " " + jsonCommand.get("detachment") + " " + jsonCommand.get("age"));

        try {
            types.add(new Trolls(jsonCommand.get("name").toString(), jsonCommand.get("detachment").toString(), String.valueOf(jsonCommand.get("age"))));
            System.out.println("Element successfully added...");
            writeElements();
        } catch (ClassCastException e) {
            System.out.println("Incorrect element types...");
        } catch (NullPointerException e) {
            System.out.println("Error...");
        }
    }

}