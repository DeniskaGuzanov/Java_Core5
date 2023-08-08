import java.io.FileOutputStream;
import java.io.IOException;

public class PlayToBin {


    public static void main(String[] args) {
        int[] values = {0, 1, 2, 1, 2, 0, 0, 3, 3};
        byte[] bytes = new byte[3];

        // Собираем биты в байты
        for (int i = 0; i < values.length; i++) {
            int shift = i % 4 * 2;
            bytes[i / 4] |= (values[i] << shift);
            System.out.println(shift);
        }

        // Записываем байты в файл
        try (FileOutputStream fos = new FileOutputStream("file.bin")) {
            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
