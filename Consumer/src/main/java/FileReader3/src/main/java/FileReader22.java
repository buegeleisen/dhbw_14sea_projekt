/**
 * Created by cwecker on 15.10.2016.
 */

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.Files;
import java.util.List;


public class FileReader22 {

    private static final String path = "C:/Users/cwecker/Documents/ERPData_jarFile/ERPs/";
    private static final String endpath = "C:/Users/cwecker/Documents/ERPData_jarFile/ERPs_gelesen/";
    private static Vector<ERPFile> erpfiles = new Vector<ERPFile>();

    public static void main(String[] args) throws Exception {
        read();
        watch();
    }

    public static void read() throws Exception {
        Gson gson = new Gson();
        File f = new File(path);
        File[] fileArray = f.listFiles();
        String erppath;
        Path moveSourcePath = null;
        Path moveTargetPath = null;

        for (int i = 0; i < fileArray.length; i++) {
            erppath = path + fileArray[i].getName();
            BufferedReader input = new BufferedReader(new FileReader(erppath));
            String zeile = null;
            zeile = input.readLine();
            while (zeile != null) {
                String jsonInString = zeile;
                ERPFile test  = gson.fromJson(jsonInString, ERPFile.class);
                erpfiles.add(test);
                zeile = input.readLine();
                System.out.println(erpfiles.elementAt(i).getA1());
            }
            input.close();
            moveSourcePath = Paths.get(erppath);
            moveTargetPath = Paths.get(endpath + fileArray[i].getName());
            Files.move (moveSourcePath, moveTargetPath);

            }

    }

    public static void watch () throws Exception {

        Path watchpath = Paths.get(path);
        WatchService watcher = watchpath.getFileSystem().newWatchService();
        watchpath.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

        WatchKey watchKey = watcher.take();

        List<WatchEvent<?>> events = watchKey.pollEvents();
        for (WatchEvent event : events) {
            if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                read();
            }
        }


    }
}
