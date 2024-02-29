public class Graph {
    private boolean matrice[][];
    private int num_noduri;

    public void adauga_muchii(int a, int b) {
        matrice[a][b] = true;
        matrice[b][a] = true;
    }

    public Graph(int number) {
        this.num_noduri = number;
        this.matrice = new boolean[num_noduri + 1][num_noduri + 1];
        for (int i = 1; i < number - 1; i++) {
            adauga_muchii(i, i + 1);
        }
        adauga_muchii(number - 1, 1);
        for (int i = 1; i < number; i++) {
            adauga_muchii(number, i);

        }


    }
    public void print_matrice() {
        System.out.printf("    ");
        for(int i=1;i<= num_noduri;i++){
            System.out.printf(i + " ");
        }
        System.out.println();
        for(int i=1;i<=num_noduri;i++){
            System.out.printf(i + " : ");
            for(int j=1;j<= num_noduri;j++){
                System.out.print(((boolean) matrice[i][j] ? 1 : 0) + " ");
            }
            System.out.println();
        }
    }
    public void numar_cicluri(){
        int cnt=0;
        for(int i=1;i<=num_noduri;i++){
            for(int j=i+1;j<=num_noduri;j++){
                if(matrice[i][j] == true){
                    for(int k=j+1;k<=num_noduri;k++){
                        if(matrice[i][k] == true){
                            cnt++;
                            break;
                        }
                    }
                }
            }
        }
    }

}