import layout.EstoqueLayout;
import models.Peca;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Peca> pecas = new ArrayList<>();
        pecas.add(new Peca(1, "Rolamento", 50, 25.90));
        pecas.add(new Peca(2, "Motor", 5, 1200.00));
        pecas.add(new Peca(3, "Vela", 120, 15.50));
        pecas.add(new Peca(4, "Pistao", 30, 45.00));
        pecas.add(new Peca(5, "Valvula", 12, 320.50));

        EstoqueLayout.mostrar(pecas);
    }
}
