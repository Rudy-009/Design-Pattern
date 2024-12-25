import java.util.ArrayList;
import java.util.List;

public class WordsList implements IWordsList {
    private List<Word> words;

    public WordsList(Word word) {
        words = new ArrayList<Word>();
        words.add(word);
    }

    public void add(String word) {
        for (Word w : words) {
            if (w.equals(word)) {
                w.increaseCount();
                return ;
            }
        }
        words.add(new Word(word));
    }

    public void print() {
//        System.out.printf("words.size() = %d\n", words.size());
        for (int i = 0; i < words.size() - 1; i++) {
            System.out.print(words.get(i));
            System.out.print(", ");
        }
        System.out.printf("%s\n", words.get(words.size() - 1));
    }
}
