public class Word {
    private String word;
    private int count;

    public Word(String word) {
        this.word = word;
        count = 1;
    }

    @Override
    public boolean equals(Object word) {
        String w = (String) word;
        return word.equals(this.word);
    }

    public void increaseCount() {
        count++;
    }

    public String toString() {
        return word + "(" + count + ")";
    }
}
