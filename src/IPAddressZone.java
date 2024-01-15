//50 marks for this question
//        Range of IP addresses were mentioned in the question. It should be declared by us in the code as static itself.
//        Zone 1 : 0.0.0.0 - 127.255.255.255
//        Zone 2 : 128....... - ..........................
//        Zone 3 : ............. - ..........................
//        Zone 4 : ......... - 255.255.255.255
//        Array of IP addresses were given as strings. Find out to which region zone they belong to. If an IP address does not fall into any region, just put -1 for that.
//        Input : ["0.0.0.123","129.234.233.24","256.256.2.1"]
//        output : [1,2,-1]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class IPAddressZone {

    public static void main(String[] args) {
        String[] inputArray = {"0.0.0.123","129.234.233.24","256.256.2.1"};
        String regex = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
        String stop = "\\.";
        String finalRegex = regex+stop+regex+stop+regex+stop+regex;
        Pattern pattern = Pattern.compile(finalRegex);

        for (String input: inputArray
        ) {
            if (pattern.matcher(input).matches()) {
                String[] split = input.split("\\.");
                int val = Integer.parseInt(split[0]);
                if (val >= 0 && val < 128) {
                    System.out.println("Zone 1");
                } else if (val >= 129 && val < 191) {
                    System.out.println("Zone 2");
                }
            } else {
                System.out.println(-1);
            }
        }
    }

//    public static void main(String[] args) {
//        String[] input = {"0.0.0.123", "129.234.233.24", "256.256.2.1"};
//        int[] output = findIPZones(input);
//        System.out.println(Arrays.toString(output));
////        for (int zone : output) {
////            System.out.print(zone + " ");
////        }
//    }

    public static int[] findIPZones(String[] ips) {
        int[] result = new int[ips.length];

        for (int i = 0; i < ips.length; i++) {
            String[] ipParts = ips[i].split("\\.");
            if (ipParts.length == 4) {
                int firstPart = Integer.parseInt(ipParts[0]);

                if (firstPart >= 0 && firstPart <= 127) {
                    result[i] = 1;
                } else if (firstPart >= 128 && firstPart <= 191) {
                    result[i] = 2;
                } else if (firstPart >= 192 && firstPart <= 223) {
                    result[i] = 3;
                } else if (firstPart >= 224 && firstPart <= 255) {
                    result[i] = 4;
                } else {
                    result[i] = -1;
                }
            } else {
                result[i] = -1;
            }
        }

        return result;
    }
}