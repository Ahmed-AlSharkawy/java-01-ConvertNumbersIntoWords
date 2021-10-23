public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(printNumberInWord(0));
        System.out.println(printNumberInWord(5));
        System.out.println(printNumberInWord(10));
        System.out.println(printNumberInWord(-15));
        System.out.println(printNumberInWord(20));
        System.out.println(printNumberInWord(25));
        System.out.println(printNumberInWord(75));
        System.out.println(printNumberInWord(-90));
        System.out.println(printNumberInWord(99));
        System.out.println();
        System.out.println(printNumberInWord(100));
        System.out.println(printNumberInWord(150));
        System.out.println(printNumberInWord(-260));
        System.out.println(printNumberInWord(590));
        System.out.println(printNumberInWord(-900));
        System.out.println(printNumberInWord(999));
        System.out.println();
        System.out.println(printNumberInWord(1000));
        System.out.println(printNumberInWord(1500));
        System.out.println(printNumberInWord(-2640));
        System.out.println(printNumberInWord(5970));
        System.out.println(printNumberInWord(-9000));
        System.out.println(printNumberInWord(9999));
        System.out.println();
        System.out.println(printNumberInWord(11_000));
        System.out.println(printNumberInWord(15_500));
        System.out.println(printNumberInWord(-12_640));
        System.out.println(printNumberInWord(15_970));
        System.out.println(printNumberInWord(-19_000));
        System.out.println(printNumberInWord(19_999));
        System.out.println();
        System.out.println(printNumberInWord(10_000));
        System.out.println(printNumberInWord(25_500));
        System.out.println(printNumberInWord(-62_640));
        System.out.println(printNumberInWord(75_970));
        System.out.println(printNumberInWord(-99_000));
        System.out.println(printNumberInWord(99_999));
    }

     public static String printNumberInWord(int number) {
        if (number == 0) return "zero";
        return printNumberInWord(number, "");
    }

    public static String printNumberInWord(int number, String numberName) {
        if (number == 0) return numberName;
        String[] oneToNine =
                {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        String[] tens =
                {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] elevenToNineteen =
                {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

        int positiveNumber = Math.abs(number);

        if (positiveNumber > 0 && positiveNumber < 10)
            numberName += oneToNine[positiveNumber];
        else if (positiveNumber > 10 && positiveNumber < 20)
            numberName += elevenToNineteen[positiveNumber - 10];
        else if (positiveNumber > 0 && positiveNumber < 100 & positiveNumber % 10 == 0)
            numberName += tens[positiveNumber / 10];
        else if (positiveNumber > 10 && positiveNumber < 100)
            numberName += tens[positiveNumber / 10] + " " + oneToNine[positiveNumber % 10];
        else if (positiveNumber > 99 && positiveNumber < 1000) {
            numberName += oneToNine[positiveNumber / 100] + (positiveNumber / 100 == 1 ? " hundred " : " hundreds " );
            if (positiveNumber % 100 != 0)
                return printNumberInWord(number % 100, numberName + "and ");
        }
        else if (positiveNumber > 999 && positiveNumber < 10_000) {
            numberName += oneToNine[positiveNumber / 1000] + (positiveNumber / 1000 == 1 ? " thousand " : " thousands " );
            if (positiveNumber % 1000 != 0)
                return printNumberInWord(number % 1000, numberName + "and ");
        }
        else if (positiveNumber > 10_000 && positiveNumber < 20_000){
            numberName += elevenToNineteen[positiveNumber / 1000 - 10] + " thousands ";
            if (positiveNumber % 1000 != 0)
                return printNumberInWord(number % 1000, numberName + "and ");
        }
        else if (positiveNumber > 9999 && positiveNumber < 100_000){
            if (positiveNumber % 10_000 == 0)
                numberName += tens[positiveNumber / 10_000] + " thousands ";
            else {
                numberName += tens[positiveNumber / 10_000] + " " +
                        oneToNine[(positiveNumber % 10_000) / 1000] + " thousands ";
                if (positiveNumber % (positiveNumber / 1000 * 1000) != 0)
                    return printNumberInWord(number % (number / 1000 * 1000),
                            (positiveNumber % 1000 == 0) ? numberName : numberName + "and ");
            }
        }

        if (number < 0) return "minus " + numberName;
        return numberName;
    }
}
