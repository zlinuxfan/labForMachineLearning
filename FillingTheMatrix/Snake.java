import java.util.Scanner;

class FillingTheMatrix {
  public int size; // размер матрици
  public int[][] body;

  public void filling() {
    body = new int[size][size];
    int startLine = size % 2 == 0 ? startLine = size / 2 : startLine = (int) (size / 2) + 1;
    int endLine = 0;
    int value = 1;

    while (startLine != 0) {

        for (int m = endLine; m < size - endLine; m++) {           // сверху
            body[endLine][m] = value;
            value++;
        }
        for (int m = endLine + 1; m < size- endLine; m++) {         // справа
            body[m][size - 1 - endLine] = value;
            value++;
        }
        for (int m = size - 2 - endLine; m >= endLine; m--) {         // внизу
            body[size - 1 - endLine][m] = value;
            value++;
        }
        for (int m = size - 2 - endLine; m > endLine; m--) {         // слева
            body[m][endLine] = value;
            value++;
        }
        startLine--;
        endLine++;
    } // while (lineInCicle!=0)
  }

  public void print() {

    filling();

    for (int m = 0; m < size; m++) {
      System.out.print(body[0][m] + " ");
    }

    System.out.println();
  }
}

class Snake {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Введите целое число: ");
    if (sc.hasNextInt() && sc.nextInt() > 0) {
      FillingTheMatrix matrix = new FillingTheMatrix();
      matrix.size = sc.nextInt();
      matrix.print();
    } else {
      System.out.println("Извините, Вы ввели не целое число.");
    }
  }
}
