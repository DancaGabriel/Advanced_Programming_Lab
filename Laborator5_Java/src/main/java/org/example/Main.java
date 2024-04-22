package org.example;

public class Main {
    public static void main(String[] args) {
        if(args.length == 0 ){
            System.out.println("Please insert a command!");
        }
        else {
            String command = args[0];
            System.out.println(command);
            Main app = new Main();
            //app.testRepo();
            var p = new Person(1001, "Popescu");
        }
    }

    private void testRepo() {
        var repo = new Repository("C:\\Documente");

//        var service = new RepositoryService();
//        service.print(repo);
//        service.export(repo, "c:/repository.json");
//        var doc = repo.findDocument("...");
//        service.view(doc);

    }
}


