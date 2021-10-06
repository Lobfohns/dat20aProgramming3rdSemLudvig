import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        //Anonymous class
        AbstractClass abstractClassImplemented = new AbstractClass() {
            @Override
            public void makeSurrealArt(){

            }
        };

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String firstString, String secondStrng) {
                return 0;
            }
        };
        System.out.println(comparator.compare("a", "b"));

        Concatenator concat = (preprendorString, appendorString) -> preprendorString + appendorString;

        System.out.println(concat.cat("Jan", "Jan"));
    }

}
