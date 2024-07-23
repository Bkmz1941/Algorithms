package sort;

abstract public class AbstractSort {
    protected void print(int[] list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            sb.append(list[i]);
            if (i != list.length - 1) sb.append(" ");
        }
        System.out.print(sb + System.lineSeparator());
    }
}
