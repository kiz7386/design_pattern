package composite_pattern.second_version;

public class Utils {
    public static String shouldMatch(String regex, String name){
        return name.matches(regex) ? name : "";
    }
}
