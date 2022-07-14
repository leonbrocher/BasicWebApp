package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class QueryProcessor {

    public static int getLargest(int[] a){
        Arrays.sort(a);
        return a[a.length-1];
    }
    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "MyTeam";
        } else if (query.contains("largest")){
            String numberOnly = query.replaceAll("[^0-9,]", "");
            System.out.println(Arrays.toString(numberOnly.split(",")));
            int[] numbers  = Arrays.stream(numberOnly.split(",")).mapToInt(Integer::parseInt).toArray();
            return String.valueOf(getLargest(numbers));
        }else if (query.contains("plus")){
            String pattern = "([0-9]+) plus ([0-9]+)";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(query);
            m.find();
            int one = Integer.parseInt(m.group(1));
            int two = Integer.parseInt(m.group(2));
            return String.valueOf(one + two);
        }else{
            return "";
        }
    }
}
