import java.util.Scanner;

public class EncryptDecrypt {
    private String message;
    private String encrypted;
    private int shift;

    private EncryptDecrypt()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Message : ");
        message = scanner.nextLine();
        System.out.println("Input Shift : ");
        shift = scanner.nextInt();

        Encrypt();
        System.out.println(encrypted);
        Decrypt();
    }

    private void Encrypt()
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < message.length(); i++)
        {
            char v = Shift(message.charAt(i), shift);
            stringBuilder.append(v);
        }
        encrypted = stringBuilder.toString();
    }

    private void Decrypt()
    {
        for (int s = 1; s < 26; s++)
        {
            for (int i = 0; i < encrypted.length(); i++)
            {
                char v = Shift(encrypted.charAt(i), s);
                System.out.print(v);
            }
            System.out.println();
        }
    }

    private char Shift(int v, int s)
    {
        v += s;
        if (v < 97 + shift && v > 90)
        {
            v -= 26;
        }
        if (v > 122)
        {
            v -= 26;
        }
        return (char) v;
    }

    public static void main(String[] args)
    {
        new EncryptDecrypt();
    }
}
