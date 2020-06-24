import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class method_1 {

    private static final Pattern param = Pattern.compile("\\((.*?)\\)");

    private static final Pattern method = Pattern.compile("(public|protected|private|static|\\s) +[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;])");
    List<String> pDataTypes = Arrays.asList("boolean", "byte", "char", "short", "int", "long", "float", "double");

    public List<Object> methodCount(String line) {
        Matcher matcher = method.matcher(line);

        int npdtp = 0; //number of primitive data types
        int ncdtp = 0; //number of compositive data typrs
        int wmrt = 0; //weight due to return type
        boolean isReturnTypeFound = false;

        //check if the line contains a method
        if (matcher.find()) {
           //System.out.println("method found");
            Matcher p = param.matcher(line);
            while (p.find()) {

                //check for the return type. If retirn type is void assaign 0 to Wmrt
                if (line.contains("void")) {
                    wmrt = 0;
                } else { //check if the return type is primitive data type
                    for (int pType = 0; pType < pDataTypes.size(); pType++) {
                        if (line.substring(0, line.indexOf("(")).contains(pDataTypes.get(pType))) {
                            isReturnTypeFound = true;
                            wmrt = 1;
                        }
                    }
                    //if return type is not void not primitive then compositive
                    if (!isReturnTypeFound) {
                        wmrt = 2;
                    }
                }

                String params = p.group(1);
                List<String> paramList = Arrays.asList(params.split(","));

                //count the mumber of primitive data types
                for (int pCount = 0; pCount < paramList.size(); pCount++) {
                    for (int pType = 0; pType < pDataTypes.size(); pType++) {
                        if (paramList.get(pCount).trim().startsWith(pDataTypes.get(pType))) {
                            npdtp++;
                            break;
                        }
                    }
                }
                //count the number of compositive data types
                if (paramList.get(0).length() != 0) {
                    ncdtp = paramList.size() - npdtp;
                } else {
                    ncdtp = paramList.size() - npdtp - 1;
                }

            }

        }
        // return (weight due to return type, primitive data type parameters, compositive data type parameters)
        return Arrays.asList(wmrt,npdtp, ncdtp);
    }
}
