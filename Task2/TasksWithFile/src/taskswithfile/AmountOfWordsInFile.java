package taskswithfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class AmountOfWordsInFile {

    //количество различных слов в файле
    public int amountOfWordsInFile(String fileName) {
        File file = new File(fileName);
        if (file.length() == 0) {
            System.out.println("File is empty!");
            return -1;
        } else {
            try (FileReader fr = new FileReader(file);
                 BufferedReader br = new BufferedReader(fr)) {
                int result = 0;
                String anyString;
                while ((anyString = br.readLine()) != null) {
                    String[] words = anyString.split("[ ,.!?-]+");
                    result += words.length;
                }
                fr.close();
                br.close();
                return result;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    //вывод на экран списка различных слов из файла, отсортированного по возрастанию длинны
    public void sortedBySize(String fileName) {
        File file = new File(fileName);
        if (file.length() == 0) {
            System.out.println("File is empty!");
        } else {
            try (FileReader fr = new FileReader(file);
                 BufferedReader br = new BufferedReader(fr)) {
                String anyString;
                LinkedList<String> al = new LinkedList<>();
                while ((anyString = br.readLine()) != null) {
                    String[] words = anyString.split("[ ,.!?-]+");
                    for (String word : words) {
                        if (!al.isEmpty()) {
                            for (int i = 0; i < al.size(); i++) {
                                if (al.get(i).length() >= word.length()) {
                                    al.add(i, word);
                                    break;
                                }
                                if (i == (al.size() - 1)) {
                                    al.add(word);
                                }
                            }
                        } else
                            al.add(word);
                    }
                }
                System.out.println(al);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //количество различных слов в файле
    public void amountOfEveryWord(String fileName) {
        File file = new File(fileName);
        if (file.length() == 0) {
            System.out.println("File is empty!");
        } else {
            try (FileReader fr = new FileReader(file);
                 BufferedReader br = new BufferedReader(fr)) {
                int result = 0;
                Map<String, Integer> uniq = new HashMap<String, Integer>();
                String anyString;
                while ((anyString = br.readLine()) != null) {
                    String[] words = anyString.split("[ ,.!?-]+");
                    for (String word : words) {
                        if (uniq.containsKey(word)) {
                            uniq.put(word, uniq.get(word) + 1);
                        } else
                            uniq.put(word, 1);
                    }
                }
                for (Map.Entry<String, Integer> item : uniq.entrySet()) {
                    System.out.printf("Key: %s  Value: %d \n", item.getKey(), item.getValue());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //вывод всех строк из файла в обратном порядке
    public void printReverseStrings(String fileName) {
        File file = new File(fileName);
        if (file.length() == 0) {
            System.out.println("File is empty!");
        } else {
            try (FileReader fr = new FileReader(file);
                 BufferedReader br = new BufferedReader(fr)) {
                String anyString;
                while ((anyString = br.readLine()) != null) {
                    char[] ch = anyString.toCharArray();
                    for (int i = ch.length - 1; i >= 0; i--)
                        System.out.print(ch[i]);
                    System.out.println();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //вывод строки, которая задается пользователем
    public void printAnyStrings(String fileName, int n) {
        File file = new File(fileName);
        if (file.length() == 0) {
            System.out.println("File is empty!");
        } else {
            try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
                {
                    if (n < 1)
                        System.out.println("File is empty!");
                    String anyString;
                    int counter = 0;
                    while ((anyString = br.readLine()) != null) {
                        counter++;
                        if (counter == n)
                            System.out.println(anyString);
                    }
                    System.out.println("No line with that number");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
