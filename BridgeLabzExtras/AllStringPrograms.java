import java.util.Scanner;

public class AllStringPrograms {

    // 1. Count Vowels and Consonants
    public static void countVowelsAndConsonants(Scanner sc) {
        System.out.println("\n--- Count Vowels and Consonants ---");
        System.out.println("Enter a string:");
        String a = sc.next();
        int v = 0, c = 0;
        a = a.toLowerCase();
        for (int i = 0; i < a.length(); i++) {
            char d = a.charAt(i);
            if (d >= 'a' && d <= 'z') {
                if (d == 'a' || d == 'e' || d == 'i' || d == 'o' || d == 'u') {
                    v++;
                } else {
                    c++;
                }
            }
        }
        System.out.println("Vowels: " + v);
        System.out.println("Consonants: " + c);
    }

    // 2. Reverse a String
    public static void reverseString(Scanner sc) {
        System.out.println("\n--- Reverse a String ---");
        System.out.println("Enter a string to reverse:");
        String a = sc.next();
        String b = "";
        for (int i = a.length() - 1; i >= 0; i--) {
            b = b + a.charAt(i);
        }
        System.out.println("Reversed string: " + b);
    }

    // 3. Check for Palindrome
    public static void checkPalindrome(Scanner sc) {
        System.out.println("\n--- Check for Palindrome ---");
        System.out.println("Enter a string to check:");
        String a = sc.next();
        String b = "";
        for (int i = a.length() - 1; i >= 0; i--) {
            b = b + a.charAt(i);
        }
        if (a.equalsIgnoreCase(b)) { // Using equalsIgnoreCase for better checking
            System.out.println("Result: It is a Palindrome");
        } else {
            System.out.println("Result: It is Not a Palindrome");
        }
    }

    // 4. Remove Duplicate Characters
    public static void removeDuplicates(Scanner sc) {
        System.out.println("\n--- Remove Duplicate Characters ---");
        System.out.println("Enter a string:");
        String a = sc.next();
        String b = "";
        for (int i = 0; i < a.length(); i++) {
            char d = a.charAt(i);
            if (b.indexOf(d) == -1) {
                b = b + d;
            }
        }
        System.out.println("String with duplicates removed: " + b);
    }

    // 5. Find the Longest Word in a Sentence
    public static void findLongestWord(Scanner sc) {
        System.out.println("\n--- Find the Longest Word ---");
        System.out.println("Enter a sentence:");
        sc.nextLine(); // Consume the leftover newline
        String a = sc.nextLine();
        String[] b = a.split(" ");
        String d = "";
        for (int i = 0; i < b.length; i++) {
            if (b[i].length() > d.length()) {
                d = b[i];
            }
        }
        System.out.println("The longest word is: " + d);
    }

    // 6. Count Occurrences of a Substring
    public static void countSubstringOccurrences(Scanner sc) {
        System.out.println("\n--- Count Substring Occurrences ---");
        sc.nextLine(); // Consume the leftover newline
        System.out.println("Enter the main string:");
        String a = sc.nextLine();
        System.out.println("Enter the substring to count:");
        String b = sc.next();
        int c = 0;
        for (int i = 0; i <= a.length() - b.length(); i++) {
            String d = a.substring(i, i + b.length());
            if (d.equals(b)) {
                c++;
            }
        }
        System.out.println("The substring appears " + c + " times.");
    }

    // 7. Toggle Case of Characters
    public static void toggleCase(Scanner sc) {
        System.out.println("\n--- Toggle Case of Characters ---");
        System.out.println("Enter a string:");
        sc.nextLine(); // Consume the leftover newline
        String a = sc.nextLine();
        String b = "";
        for (int i = 0; i < a.length(); i++) {
            char d = a.charAt(i);
            if (Character.isLowerCase(d)) {
                b += Character.toUpperCase(d);
            } else if (Character.isUpperCase(d)) {
                b += Character.toLowerCase(d);
            } else {
                b += d;
            }
        }
        System.out.println("Toggled case string: " + b);
    }

    // 8. Compare Two Strings Lexicographically
    public static void compareStrings() {
        System.out.println("\n--- Compare Two Strings (Lexicographically) ---");
        String a = "apple";
        String b = "banana";
        System.out.println("Comparing '" + a + "' and '" + b + "'");
        int d = a.compareTo(b);
        if (d < 0) {
            System.out.println(a + " comes before " + b + " alphabetically.");
        } else if (d > 0) {
            System.out.println(b + " comes before " + a + " alphabetically.");
        } else {
            System.out.println("The strings are identical.");
        }
    }

    // 9. Find the Most Frequent Character
    public static void findMostFrequentCharacter(Scanner sc) {
        System.out.println("\n--- Find the Most Frequent Character ---");
        System.out.println("Enter a string:");
        String a = sc.next();
        int m = 0;
        char r = ' ';
        for (int i = 0; i < a.length(); i++) {
            char d = a.charAt(i);
            int c = 0;
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) == d) {
                    c++;
                }
            }
            if (c > m) {
                m = c;
                r = d;
            }
        }
        System.out.println("The most frequent character is: '" + r + "'");
    }

    // 10. Remove a Specific Character
    public static void removeSpecificCharacter(Scanner sc) {
        System.out.println("\n--- Remove a Specific Character ---");
        System.out.println("Enter a string:");
        String a = sc.next();
        System.out.println("Enter the character to remove:");
        char r = sc.next().charAt(0);
        String b = "";
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != r) {
                b = b + a.charAt(i);
            }
        }
        System.out.println("String after removing '" + r + "': " + b);
    }

    // 11. Check for Anagrams
    public static void checkAnagrams(Scanner sc) {
        System.out.println("\n--- Check for Anagrams ---");
        sc.nextLine(); // Consume the leftover newline
        System.out.println("Enter the first string:");
        String a = sc.nextLine().toLowerCase();
        System.out.println("Enter the second string:");
        String b = sc.nextLine().toLowerCase();

        int[] f1 = new int[26];
        int[] f2 = new int[26];

        for (char d : a.toCharArray()) {
            if (d >= 'a' && d <= 'z') f1[d - 'a']++;
        }
        for (char d : b.toCharArray()) {
            if (d >= 'a' && d <= 'z') f2[d - 'a']++;
        }

        boolean r = true;
        for (int i = 0; i < 26; i++) {
            if (f1[i] != f2[i]) {
                r = false;
                break;
            }
        }

        if (r) {
            System.out.println("Result: The strings are Anagrams.");
        } else {
            System.out.println("Result: The strings are Not Anagrams.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println("  Java String Programs Menu");
            System.out.println("=================================");
            System.out.println("1. Count Vowels and Consonants");
            System.out.println("2. Reverse a String");
            System.out.println("3. Check for Palindrome");
            System.out.println("4. Remove Duplicate Characters");
            System.out.println("5. Find the Longest Word");
            System.out.println("6. Count Substring Occurrences");
            System.out.println("7. Toggle Case of Characters");
            System.out.println("8. Compare Two Strings (Demo)");
            System.out.println("9. Find Most Frequent Character");
            System.out.println("10. Remove a Specific Character");
            System.out.println("11. Check for Anagrams");
            System.out.println("0. Exit");
            System.out.println("=================================");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: countVowelsAndConsonants(sc); break;
                case 2: reverseString(sc); break;
                case 3: checkPalindrome(sc); break;
                case 4: removeDuplicates(sc); break;
                case 5: findLongestWord(sc); break;
                case 6: countSubstringOccurrences(sc); break;
                case 7: toggleCase(sc); break;
                case 8: compareStrings(); break;
                case 9: findMostFrequentCharacter(sc); break;
                case 10: removeSpecificCharacter(sc); break;
                case 11: checkAnagrams(sc); break;
                case 0: System.out.println("Exiting program. Goodbye!"); break;
                default: System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}