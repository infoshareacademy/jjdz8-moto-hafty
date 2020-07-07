package MotoHafty.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



import java.io.File;

public class FileUtils {

    private static Logger LOGGER = LogManager.getLogger(FileUtils.class.getName());

    public static void createFile(String pathName) {
        File file = new File(pathName);
        try {
            file.createNewFile();
            LOGGER.info("New file created");
        } catch (Exception e) {
            LOGGER.error("Something went wrong: " + e);
        }
    }
}
