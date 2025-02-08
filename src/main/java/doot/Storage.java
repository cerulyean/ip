package doot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * used for loading and saving lists.
 */
public class Storage {
    /**
     * Makes a tasklist
     * @param list of tasks
     * @throws IOException incase the file cant be made for some reason
     */
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

    /**
     * this just creates an empty list and saves it, to empty anything that used to be there
     * @throws IOException if the save cant be overwritten
     */
    public static void clearSave() throws IOException {
        TaskList list = new TaskList();
        Storage.saveList(list);
    }

    /**
     * this just creates an empty list and saves it, to empty anything that used to be there
     * @param path to where the file is saved
     * @return the tasklist that is saved there
     */
    public static TaskList loadList(String path) {
        File f = new File(path);
        TaskList list = new TaskList();
        if (f.exists()) {
            try {
                list.loadTask(f);
                Ui.showMessage(list.returnList());
            } catch (FileNotFoundException e) {
                Ui.showMessage("this should never be seen");
            } catch (InvalidFormatException e) {
                Ui.showMessage("file corrupted, go see if theres anything salvagable because upon next list mod its all going to be overwritten");
            }
        }
        return list;
    }
}
