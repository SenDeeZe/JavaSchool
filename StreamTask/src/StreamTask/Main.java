package StreamTask;


import StreamTask.Cryptor.XorCryptor;
import StreamTask.Stream.MyStream;

public class Main {

    public static void main(String[] args) {
        System.out.println("Own Stream:");
        MyStream<Integer> integerStream = MyStream.of(1, 2, 2, 3, 4, 5, 6, 7, 8, 8, 9).filter(i -> i%2 == 0)
                .map(i -> i*i).distinct();
        integerStream.forEach(System.out::println);
        System.out.println();

        System.out.println("Tribonachi:"+Tribonachi.tribonachi(9));
        System.out.println();

        System.out.println("Lambda task:");
        ILambda<String> myLambda1 = (a, b) -> a + b;
        ILambda<Integer> myLambda2 = (a, b) -> a + b;
        System.out.println(myLambda1.getSum("abc", "def"));
        System.out.println(myLambda2.getSum(1, 1));
        System.out.println();

        System.out.println("Xor decorder encoder:");
        String message = "In cryptography, the simple XOR cipher is a type of additive cipher, " +
                "an encryption algorithm that operates according to the principles:";
        String key="Гаммирование (или Шифр XOR) — метод симметричного шифрования, " +
                "заключающийся в «наложении» последовательности,";
        String crypted = XorCryptor.xor_encrypt(message,key);
        System.out.println("Зашифрованное сообщение: "+ crypted);
        System.out.println("Расшифрованное сообщение: "+ XorCryptor.xor_decrypt(crypted,key));
    }
}
