import java.util.Random;

class matrica {

    int n;
    int m;
    double[][] thismatrica;


    public matrica(int n, int m) {
        this.thismatrica = new double[n][m];
        this.n = n;
        this.m = m;
        this.initiliser();

    }


    public matrica(double[][] thismatrica) {
        this.thismatrica = thismatrica;
        this.n = thismatrica.length;
        this.m = thismatrica[0].length;
    }


    private void initiliser() {

        Random random = new Random();
        for (int i = 0; i < thismatrica.length; i++) {
            for (int j = 0; j < thismatrica[i].length; j++) {
                thismatrica[i][j] = random.nextInt(100);
            }
        }
    }



    public void getvalue() {
        for (int i = 0; i < thismatrica.length; i++) {
            for (int j = 0; j < thismatrica[i].length; j++) {
                System.out.printf("%.2f  ", thismatrica[i][j]);
            }
            System.out.print("\n");
        }
    }


    public matrica numberMultiplication(double inputNumber){
        double[][] resultmatrica = new double[this.n][this.m];

        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                double result = this.thismatrica[i][j] * inputNumber;
                resultmatrica[i][j] = result;
            }
        }
        return new matrica(resultmatrica);
    }


    public matrica transpose() {

        double[][] resultmatrica = new double[this.m][this.n];
        for (int i = 0; i < this.n; i++)
            for (int j = 0; j < this.m; j++)
                resultmatrica[j][i] = thismatrica[i][j];
        return new matrica(resultmatrica);
    }


    public matrica exponentiation(int N) {

        if (this.n != this.m) {
            System.out.println("Необходима квадратная матрица для ее возведения в степень!");
            return null;
        }

        matrica newMatrica = this;
        matrica currentMatrica = this;

        int currentN = 1;
        while (currentN < N) {
            matricaExecuter obj = new matricaExecuter(newMatrica, currentMatrica);
            newMatrica = obj.composition();
            currentN++;
        }
        return newMatrica;
    }
}


class matricaExecuter {

    matrica matrica1;
    matrica matrica2;

    public matricaExecuter(matrica obj1, matrica obj2) {
        this.matrica1 = obj1;
        this.matrica2 = obj2;
    }

    //умножение матриц
    public matrica composition() {

        if (matrica1.m != matrica2.n) {
            System.out.println("Кол-во стольбцов матрицы не равно кол-ву строк");
            return null;
        }
        double[][] resultmatrica = new double[matrica1.n][matrica2.m];

        for (int i = 0; i < matrica1.n; i++) {
            for (int j = 0; j < matrica2.m; j++) {
                for (int k = 0; k < matrica1.m; k++) {
                    resultmatrica[i][j] += matrica1.thismatrica[i][k] * matrica2.thismatrica[k][j];
                }
            }
        }
        return new matrica(resultmatrica);
    }

    //сумма матриц
    public matrica summ() {
        if ((matrica1.n != matrica2.n) || (matrica1.m != matrica2.m)) {
            System.out.println("Неправильная размерность матрицы");
            return null;
        } else {

            double[][] resultmatrica = new double[matrica1.n][matrica1.m];

            for (int i = 0; i < matrica1.n; i++) {
                for (int j = 0; j < matrica1.m; j++) {
                    double result = matrica1.thismatrica[i][j] + matrica2.thismatrica[i][j];
                    resultmatrica[i][j] = result;
                }
            }
            return new matrica(resultmatrica);
        }
    }

    //вычитание матриц
    public matrica difference() {
        if ((matrica1.n != matrica2.n) || (matrica1.m != matrica2.m)) {
            System.out.println("Неправильная размерность матрицы");
            return null;
        } else {

            double[][] resultmatrica= new double[matrica1.n][matrica1.m];

            for (int i = 0; i < matrica1.n; i++) {
                for (int j = 0; j < matrica1.m; j++) {
                    double result = matrica1.thismatrica[i][j] - matrica2.thismatrica[i][j];
                    resultmatrica[i][j] = result;
                }
            }

            return new matrica(resultmatrica);
        }
    }
}


public class Main {

    public static void main(String[] args) {

        matrica obj1 = new matrica(3, 5);
        matrica obj2 = new matrica(3, 5);
        System.out.println("Матрица А:");
        obj1.getvalue();
        System.out.println("\nМатрица B:");
        obj2.getvalue();

        System.out.println("\nТранспонированная матрица A:");
        matrica transposed_obj1 = obj1.transpose();
        transposed_obj1.getvalue();
        System.out.println("\nТранспонированная матрица B:");
        matrica transposed_obj2 = obj2.transpose();
        transposed_obj2.getvalue();

        double multiNumber = 4;
        System.out.println("\nУмножение матрицы А на число " + multiNumber);
        matrica result = obj1.numberMultiplication(multiNumber);
        if (result != null)
            result.getvalue();

        //сумма матриц
        matricaExecuter executerObj = new matricaExecuter(obj1, obj2);
        System.out.println("\nСумма:");
        result = executerObj.summ();
        if (result != null)
            result.getvalue();

        //вычитание матриц
        System.out.println("\nРазность:");
        result = executerObj.difference();
        if (result != null)
            result.getvalue();

        //другая размерность матриц для произведения
        matrica obj3 = new matrica(2, 3);
        matrica obj4 = new matrica(3, 2);
        System.out.println("\nМатрица C:");
        obj3.getvalue();
        System.out.println("\nМатрица D:");
        obj4.getvalue();
        executerObj = new matricaExecuter(obj3, obj4);
        System.out.println("\nПроизведение C*D:");
        result = executerObj.composition();
        if (result != null)
            result.getvalue();

        //возведение в степень другой матрицы
        int N = 5;
        matrica obj5 = new matrica(2, 2);
        System.out.println("\nМатрица E:");
        obj5.getvalue();
        System.out.println("\nМатрица E в степени " + N);
        result = obj5.exponentiation(N);
        if (result != null)
            result.getvalue();

    }
}