package task1824;

import java.io.*;
import java.util.ArrayList;

/* 
Файлы и исключения
Читайте с консоли имена файлов.
Если файла не существует (передано неправильное имя файла), то перехватить исключение FileNotFoundException,
 вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки.
Не используй System.exit();


Requirements:
1. Программа должна считывать имена файлов с консоли.
2. Для каждого файла нужно создавать поток для чтения.
3. Если файл не существует, программа должна перехватывать исключение FileNotFoundException.
4. После перехвата исключения, программа должна вывести имя файла в консоль и завершить работу.
5. Потоки для чтения из файла должны быть закрыты.
6. Команду "System.exit();" использовать нельзя.*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";
        ArrayList<FileInputStream> streams = new ArrayList<>();


        while (true) {
            try {
                fileName = reader.readLine();
                streams.add(new FileInputStream(fileName));

            } catch (FileNotFoundException e) {
                //ловим FileNotFoundException
             handleFileNotFoundException(fileName);
                break;
            } catch (IOException e) {
                //ловим IOException
                e.printStackTrace();
                break;
            }
        }
        for (FileInputStream stream : streams) {
            stream.close();
        }
    }


    private static void handleFileNotFoundException(String fileName){
        System.out.println(fileName);
    }
}
