import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Storage {
    File file;
String name = "Data";

    public Storage () throws IOException {
        file = new File(this.name);
        file.createNewFile();
    }

    void myExport(String s) throws IOException {
        FileWriter fr = new FileWriter(name);
        fr.write(s);
        fr.close();
    }
}
