/**
 * Created by cwecker on 15.10.2016.
 */

package filereader;

import com.google.gson.Gson;
import objects.ERPFile;

import java.io.BufferedReader;
import java.io.File;
import java.util.Vector;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.Files;
import java.util.List;


public class ERPFileReader implements Runnable {
    private Gson gson = new Gson();
    private String observedPath;
    private String processedPath;

    private static Vector<ERPFile> erpfiles = new Vector<ERPFile>();

    public ERPFileReader(String observedPath, String processedPath){
        this.observedPath = observedPath;
        this.processedPath = processedPath;
    }

    private void read() throws Exception {
        File f = new File(observedPath);
        File[] fileArray = f.listFiles();
        String erppath;
        Path moveSourcePath = null;
        Path moveTargetPath = null;

        for (int i = 0; i < fileArray.length; i++) {
            erppath = observedPath + fileArray[i].getName();
            BufferedReader input = new BufferedReader(new java.io.FileReader(erppath));
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
            moveTargetPath = Paths.get(processedPath + fileArray[i].getName());
            Files.move (moveSourcePath, moveTargetPath);

            }

    }

    private void watch () throws Exception {

        Path watchpath = Paths.get(observedPath);
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

    public void run() {
        try {
            //initial read
            read();

            //watching files
            watch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
