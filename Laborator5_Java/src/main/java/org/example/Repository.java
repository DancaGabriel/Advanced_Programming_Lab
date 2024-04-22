package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Repository {
    private String directory;
    private Map<Person, List<Document>> documents = new HashMap<>();
    public Repository(String directory) {
        this.directory = directory;
        loadDocuments();
    }

    private void loadDocuments() {
        try {
            Path start = Paths.get(directory);
            Files.walk(start)
                    .forEach(path -> System.out.println(path));
        } catch (IOException e) {
            System.err.println("A apărut o eroare la parcurgerea directorului: " + e.getMessage());
        }
       // Read all sub-directories
       // c:/documents/Popescu_1001, ...
       // Read all files in the sub-directories
       // diploma_bac.pdf, copie_buletin.png, ...
    }


}
