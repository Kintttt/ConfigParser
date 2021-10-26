package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConfigParser {
    private Map<String, String> configMap = new HashMap<>();
    private BufferedReader br;


    public ConfigParser(String str) {
        try {
            switch (str.toLowerCase()){
                case "staging" :
                    br = new BufferedReader(new FileReader("/Users/mac/Desktop/Task-Two/src/main/java/config.txt.staging"));
                    break;
                case "development" :
                case "dev" :
                    br = new BufferedReader(new FileReader("/Users/mac/Desktop/Task-Two/src/main/java/config.txt.dev"));
                    break;
                default:
                    br = new BufferedReader(new FileReader("/Users/mac/Desktop/Task-Two/src/main/java/config.txt"));

            }

            parseFile();


        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void parseFile(){
        configMap = new HashMap();
        String text;
        String app = "";
        String[] arr;
        int count = 0;

        try {

            while ((text = br.readLine()) != null){
                if(text.isEmpty()){
                    app = "";

                }else{
                    if(text.startsWith("[") && text.endsWith("]")){
                        count += 1;
                        app = text.substring(1, text.length()-1) + (count) + ".";
                    } else {
                        arr = text.split("=");
                        configMap.put(app + arr[0], arr[1]);
                    }
                }
            }

        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }

    }

    public String get(String key) {
        return configMap.get(key);
    }
}
