package Practicefile;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Fileutil {
	public static void createFile(final String dirPath, final String fileName, final String fileData) throws Exception {
        final File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        final File file = new File(dirPath + fileName);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        final Path path = Paths.get(dirPath + fileName, new String[0]);
        Files.write(path, fileData.getBytes(StandardCharsets.UTF_8), new OpenOption[0]);
    }
}
