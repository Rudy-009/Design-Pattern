public class Main {
    public static void main(String[] args) {
        Line<Integer> intLine = new Line<>();
        for (int i = 0; i < 10; i++) {
            intLine.push(i);
        }

        // Iterator 사용
        for (Integer n : intLine) {
            System.out.println(n);
        }

    }
}