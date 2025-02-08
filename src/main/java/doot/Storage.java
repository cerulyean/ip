package doot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

//used for loading and saving lists.
public class Storage {
    public static void saveList(TaskList list) throws IOException {
        File folder = new File("data");
        if (!folder.exists()) {
            if (!folder.mkdirs()) {
                throw new IOException("folder creation broke");
            }
        }
        File f = new File("data/list.txt");
        if (!f.exists()) {
            f.createNewFile();
        }
        FileWriter fw = new FileWriter("data/list.txt");
        fw.write(list.listData());
        fw.close();
    }

    //this just creates an empty list and saves it, to empty anything that used to be there
    public static void clearSave() throws IOException {
        TaskList list = new TaskList();
        Storage.saveList(list);
    }

    //loads a list saved to the file location. It also checks if the file exists or if it is corrupted
    public static TaskList loadList(String path) {
        File f = new File(path);
        TaskList list = new TaskList();
        if (f.exists()) {
            try {
                list.loadTask(f);
                Ui.showMessage(list.returnList());
            } catch (FileNotFoundException e) {
                Ui.showMessage("this should never be seen");
            } catch (Doot.InvalidFormatException e) {
                Ui.showMessage("file corrupted, go see if theres anything salvagable because upon next list mod its all going to be overwritten");
            }
        }
        return list;
    }
}