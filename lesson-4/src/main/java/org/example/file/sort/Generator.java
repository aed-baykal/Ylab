package org.example.file.sort;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Generator {

    public File generate(String name, int count) throws IOException {
        Random random = new Random();
        File file = new File(new File("").getAbsoluteFile() + "/lesson-4/src/main/resources/" + name);
        try (PrintWriter pw = new PrintWriter(file)) {
            for (int i = 0; i < count; i++) {
                pw.println(random.nextLong());
            }
            pw.flush();
        }
        return file;
    }
}
