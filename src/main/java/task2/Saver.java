package task2;

import task2.annotation.SaveMethod;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by admin on 02.06.2017.
 */
public class Saver {

    @SaveMethod
    public void save(String path,String text){
        try (FileWriter fileWriter=new FileWriter(path)){

            fileWriter.write(text);
        }
         catch (IOException e) {
            e.printStackTrace();
        }


    }
}
