import java.util.ArrayList;

public class BackTracking {
    private Escola escola;

    // Construtor para instanciar as classes e os alunos
    // Sorteia um numero e atribui esse numero ao nome e nota daquele aluno
    // Cada escola tem 3 classes e cada classe 5 alunos
    public BackTracking() {
        this.escola = new Escola();
        var classes = new ArrayList<Classe>();
        for (int i = 0; i < 3; i++) {
            var classe = new Classe();
            classe.alunos = new ArrayList<Aluno>();
            classe.id = String.valueOf(i);
            for (int j = 0; j < 5; j++) {
                Aluno aluno = new Aluno();
                int nota = (int)(Math.random() * 99) + 1;
                    aluno.nome = String.valueOf(nota);
                    aluno.nota = nota;
                classe.alunos.add(aluno);
            }
            classes.add(classe);
        }
        this.escola.classes = classes;

        // Aqui ele sorteia dois index e faz uma sequencia de For para atribuir uma nota maxima a um aluno aleatório
        // O nome e nota de algum dos alunos será 100
        int randomIndexClasse = (int) (Math.random() * 3);
        int randomIndexAluno = (int) (Math.random() * 5);
        for (int i = 0; i < this.escola.classes.size(); i++) {
            if (i == randomIndexClasse) {
                for (int j = 0; j < this.escola.classes.get(i).alunos.size(); j++) {
                    if (j == randomIndexAluno) {
                        this.escola.classes.get(i).alunos.get(j).nota = 100;
                        this.escola.classes.get(i).alunos.get(j).nome = "100";
                    }
                }
            }
        }
    }

    // Algoritmo de backtracking para achar o aluno nota 100
    public void printPrimeiroAlunoNotaMaximaBacktracking() {
        Aluno alunoMaisNerd = null;
        Classe classe = null;
        int indexAluno = 0;

        // For para percorrer todos os alunos, verificando suas notas e descobrindo se é a máxima
        // Se for nota máxima ele da um break nos fors e printa o aluno
        for (int i = 0; i < this.escola.classes.size(); i++) {
            for (int j = 0; j < this.escola.classes.get(i).alunos.size(); j++) {
                if (this.escola.classes.get(i).alunos.get(j).nota == 100) {
                    classe = this.escola.classes.get(i);
                    alunoMaisNerd = this.escola.classes.get(i).alunos.get(j);
                    indexAluno = j;
                    break;
                }
            }
            if (alunoMaisNerd != null || classe != null) break;
        }
        // Lembrando que printa o index, então pode existir sala 0
        System.out.println("O aluno mais nerd é o " + indexAluno + "º da sala " + classe.id);
    }

    // Método para printar todos os alunos
    public void printAlunos() {
        this.escola.classes.forEach(classe -> {
            System.out.println("Classe: " + classe.id);
            classe.alunos.forEach(aluno -> {
                System.out.println(aluno.nota);
                System.out.println(aluno.nome);
                System.out.println("\n");
            });
            System.out.println("---");
        });
    }
}
