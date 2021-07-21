public class Main {
    public static void main(String[] args) throws Exception {
        int numeroFilosofos = 6;
        int tempoEspera = 500;
        Filosofo[] filosofos = new Filosofo[numeroFilosofos];
        Object[] talheres = new Object[numeroFilosofos];

        for (int i = 0; i < 6; i++) {
            talheres[i] = new Object();
        }

        for (int i = 0; i < numeroFilosofos; i++) {
            Object talherEsquerda = talheres[i];
            Object talherDireita = talheres[(i + 1) % numeroFilosofos];
            if (i == numeroFilosofos - 1) {
                filosofos[i] = new Filosofo(talherEsquerda, talherDireita, tempoEspera);
            } else {
                filosofos[i] = new Filosofo(talherDireita, talherEsquerda, tempoEspera);
            }
            Thread t = new Thread(filosofos[i], "Filosofo " + (i + 1));
            t.start();
        }
    }
}
