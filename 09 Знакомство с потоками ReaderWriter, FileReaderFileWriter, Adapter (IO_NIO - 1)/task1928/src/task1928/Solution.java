package task1928;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* 
Исправить ошибку. Классы и интерфейсы
Программа содержит всего 1 логическую ошибку.
Найди и исправь ее.


Requirements:
1. Класс Solution должен содержать интерфейс Example.
2. Класс Solution должен содержать класс A который реализует интерфейс Example.
3. Класс Solution должен содержать класс B который реализует интерфейс Example.
4. Класс Solution должен содержать класс C который наследуется от класса A.
5. Исправь всего одну логическую ошибку.*/

public class Solution {
    static {
        System.out.println("This is the Solution class");
    }

    public static void main(String... args) throws IOException {
        try (
                FileOutputStream outputStream = new FileOutputStream(args[0]);
                InputStream is = Solution.class.getClassLoader().getResourceAsStream(args[1]);
        ) {
            ;
            byte[] b = new byte[is.available()];
            outputStream.write(is.read(b));

            int value = 123_456_789;
            System.out.println(value);

            Example result = null;
            String s = "a";
            switch (s) {
                case "a": {
                    result = new Solution().new A();
                    break;
                }
                case "b": {
                    result = new Solution().new B();
                    break;
                }
                case "c": {
                    result = new Solution().new C();
                    break;
                }
            }
            //Неверная логика проверки типа объекта - if (result instanceof A){...}
//            мы пытаемся произвести "сужение" некоего объекта result до типа  С. При этом Java-машина выполняет проверку,
//            а действительно ли данный объект унаследован от Типа, к которому мы хотим его преобразовать.
//            Если что-то не так, выползет ClassCastException - это исключение,
//            которое может возникнуть при попытке неправильно преобразовать класс из одного типа в другой.
//            Потому лучше сразу произвести проверку самим используя instanceof и в случае успеха проводить "ссужение".
//                    Т.е. чтоб исключить ошибку и  "ссузить" до С, надо в условии сверяться с  самим типом С,
//                    либо с его наследником, но никак не с А, который вообще не знает что С есть.
            if (result instanceof C) {
                C p = (C) result;
                System.out.println(p.getClass().getSimpleName());
            }

        } catch (IOException e) {
        }
    }

    interface Example {
    }

    class A implements Example {
        {
            System.out.println("This is the A class");
        }
    }

    class B implements Example {
        {
            System.out.println("This is the B class");
        }
    }

    class C extends A {
        {
            System.out.println("This is the C class");
        }
    }
}
