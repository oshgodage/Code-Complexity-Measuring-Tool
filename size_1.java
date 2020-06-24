import java.util.Arrays;
import java.util.List;

public class size_1 {

    //List of Operators
    List<String> operators = Arrays.asList("+", "-", "*", "/", "%", "++", "--", "==", "!=", ">", "<", ">=", "<=",
            "&&", "||", "!", "&", "|", "^",
            "|", "^", "~", "<<", ">>", ">>>", "<<<",
            ",", "->", ".", "::",
            "+=", "-=", "*=", "/=", "=", ">>>=", "|=", "&=", "%=", "<<=", ">>=", "^=");

    //List of the keywords in C++
    List<String> ckeywords = Arrays.asList("auto", "struct",
            "break", "enum", "register", "typedef",
            "extern", "return", "union", "const", "unsigned",
            "continue", "signed", "void",
            "default", "goto", "sizeof", "volatile", "static", "asm", "dynamic_cast", "namespace", "reinterpret_cast",
            "explicit", "new", "static_cast", "catch", "false", "operator", "template",
            "class", "friend", "private", "this", "const_cast", "inline", "public", "throw",
            "delete", "mutable", "protected", "true", "try", "typeid", "typename", "using",
            "using", "virtual", "char_t");

    //List of the keywords
    List<String> keywords = Arrays.asList("abstract", "assert",
            "break", "catch", "class", "const",
            "continue", "default", "extends", "false",
            "final", "finally", "goto", "implements",
            "import", "instanceof", "interface", "native",
            "new", "null", "package", "private", "protected", "public",
            "return", "static", "strictfp", "super",
            "synchronized", "this", "throw", "throws", "transient", "true",
            "try", "void", "volatile", "else");

    //List of data types
    List<String> dataTypes = Arrays.asList("byte", "short", "int", "long", "float", "double", "boolean", "char", "String");

    //List of control structures
    List<String> controlStructures = Arrays.asList("for", "while", "do-while", "if", "switch", "case");

    //List of other non identifies
    List<String> other = Arrays.asList("main");

    public int keywordCount(String line) {

        String word = ""; //initial word
        int Nkw = 0; //keywordCount
        int charNo = 0; //character no of the line

        while (line.length() > charNo) {

            if (Character.isLetter(line.charAt(charNo))) {
                word = word + line.charAt(charNo);
            } else {
                //System.out.println(word);
                if (keywords.contains(word)) {
                    //System.out.println(word + " ");
                    Nkw++;
                }

                word = "";

            }

            charNo++;
        }

        return Nkw;

    }

    public int operatorCount(String line) {

        String operator = ""; //initial word
        int Nop = 0; //operatorCount
        int charNo = 0; //character no of the line
        int count = 0;
        while (line.length() > charNo) {

            //System.out.println("char  "+ line.charAt(charNo));
            if ((line.charAt(charNo)) == '\"') {
                count = count + 1;
                if (count%2 == 0){
                    operator = "";
                }
                //System.out.println("1count "+ count);

            }

            if (operators.contains(Character.toString(line.charAt(charNo)))) {
                operator = operator + Character.toString(line.charAt(charNo));
                //System.out.println("operator " + operator);
                //System.out.println("2count " + count);
            } else {
                if (!"".equals(operator)) {
                    //  System.out.println(operator);
                    operator = "";
                    if (count % 2 == 0) {
                        //System.out.println("3count " + count);

                        Nop++;
                    }

                }

            }
            charNo++;

        }

        if (!"".equals(operator)) {
            Nop++;
            operator = "";
        }
        return Nop;
    }

    public int numericalValueCount(String line) {

        String numericalValue = ""; //initial word
        int Nnv = 0; //nemeric values Count
        int charNo = 0; //character no of the line

        while (line.length() > charNo) {

            if (Character.isDigit(line.charAt(charNo))) {
                numericalValue = numericalValue + Character.toString(line.charAt(charNo));
                //System.out.println(operator);
            } else {
                if (!"".equals(numericalValue)) {
                    Nnv++;
                    numericalValue = "";
                }
            }
            charNo++;
        }

        return Nnv;

    }

    public int stringLiteralsCount(String line) {

        String numericalValue = ""; //initial value
        int Nsl = 0; // string literal Count
        int charNo = 0; //character no of the line

        while (line.length() > charNo) {

            if (line.charAt(charNo) == '"') {
                Nsl++;
                //System.out.println(operator);
            }
            charNo++;
        }
        return Nsl / 2;

    }

    public int identifierCount(String line) {

        String word = ""; //initial word
        int Nid = 0; //identifier Count
        int charNo = 0; //character no of the line
        int commaCount = 0;

        while (line.length() > charNo) {

            if (line.charAt(charNo) == '"') {
                commaCount++;
            }
            if (commaCount % 2 == 0) {
                if (Character.isLetter(line.charAt(charNo))) {
                    word = word + line.charAt(charNo);
                } else {
                    //System.out.println(word);
                    if (word != "" && !dataTypes.contains(word) && !controlStructures.contains(word) && !keywords.contains(word) && !other.contains(word)) {
                        //System.out.println(word + " ******** ");
                        Nid++;
                    }

                    word = "";

                }
            }

            charNo++;
        }

        return Nid;

    }
    
}
