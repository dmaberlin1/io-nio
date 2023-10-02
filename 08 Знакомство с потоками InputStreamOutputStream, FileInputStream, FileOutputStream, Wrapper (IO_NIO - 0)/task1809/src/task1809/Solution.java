package task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке.
Закрыть потоки.


Requirements:
1. Программа должна два раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файл - FileOutputStream
3. Во второй файл нужно записать все байты из первого в обратном порядке.
4. Потоки FileInputStream и FileOutputStream должны быть закрыты.*/

public class Solution {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        try (var fileInputStream = new FileInputStream(file1); var fileOutputStream = new FileOutputStream(file2)) {
            ArrayList<Byte> bytes = new ArrayList<>();
            while (fileInputStream.available() > 0) {
                bytes.add((byte) fileInputStream.read());
            }
            Collections.reverse(bytes);
            for (Byte b : bytes) {
                fileOutputStream.write(b);
            }
        }
    }
}
