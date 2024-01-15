// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // Press Ctrl+R or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Ctrl+D to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Cmd+F8.
            System.out.print(i);
        }
    }
}

// Run-length encoding is a fast and simple method of encoding strings. The basic idea is to represent repeated
//    successive characters as a single count and character. For example, the string "111122233411" would be encoded as "4132231421".
//    Write a class that will implement the Iterator interface and would be able to iterate over the encoded string to produce
//    a decoded result (every call to next() method should produce one number at a time). However, for simplicity, we will
//    only operate with numbers. Please, note that 0 is a valid number in the sequence.
//    Example input sequence #1:
//            1341
//    Example output sequence #1:
//            31111
//    Example sequence #2:
//            482714
//    Example output #2:
//            8888774
//
//
//        nums[] = { 5, 6, -5, 5, 3, 5, 3, -2, 0 }
//        target = 8
//        Subarrays with sum 8 are
//
//        { -5, 5, 3, 5 }
//        { 3, 5 }
//        { 5, 3 }