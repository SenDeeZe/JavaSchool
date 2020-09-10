package taskswithfile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        String fileName = "cars.txt";
        AmountOfWordsInFile am = new AmountOfWordsInFile();
        //количество различных слов в файле
        System.out.println(am.amountOfWordsInFile(fileName));
        //вывод на экран списка различных слов из файла, отсортированного по возрастанию длинны
        am.sortedBySize(fileName);
        //количество различных слов в файле
        am.amountOfEveryWord(fileName);
        //вывод всех строк из файла в обратном порядке
        am.printReverseStrings(fileName);
        //вывод строки, которая задается пользователем
        am.printAnyStrings(fileName, 6);

        //Задание на итератор
        List<String> data = new ArrayList<String>();
        data.add("0");
        data.add("1");
        data.add("2");
        ReversedIterator<String> reversedList = new ReversedIterator<String>(data);
        for (String s : reversedList) {
            System.out.println(s);
        }
    }
}
