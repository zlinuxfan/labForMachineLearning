import java.util.Scanner;

class Matrix {
  public int size;
  public int[][] body;

  public void fillingSnake() {
    body = new int[size][size];
    int cycle,
        endLine = 0,
        value = 1;

    if (size % 2 == 0) {
      cycle = size / 2;
    } else {
      cycle = (int) (size / 2) + 1;
    }

    while (cycle > 0) {
      for (int m = endLine; m < size - endLine; m++) {           // сверху
          body[m][endLine] = value;
          value++;
      }
      for (int m = endLine + 1; m < size- endLine; m++) {         // справа
          body[size - 1 - endLine][m] = value;
          value++;
      }
      for (int m = size - 2 - endLine; m >= endLine; m--) {         // внизу
          body[m][size - 1 - endLine] = value;
          value++;
      }
      for (int m = size - 2 - endLine; m > endLine; m--) {         // слева
          body[endLine][m] = value;
          value++;
      }
      cycle--;
      endLine++;
    }
  }

  public void print() {
    for (int m = 0; m < size; m++) {
      for (int n = 0; n < size; n++) {
        System.out.print(body[n][m] + " ");
      }
    System.out.println();
    }
  }
}

class FillingTheMatrix {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Введите целое число: ");
    if (sc.hasNextInt()) {
      Matrix matrix = new Matrix();
      matrix.size = sc.nextInt();
      matrix.fillingSnake();
      matrix.print();
    } else {
      System.out.println("Извините, Вы ввели не целое число.");
    }
  }
}
