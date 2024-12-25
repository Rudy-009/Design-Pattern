public class ProxyWordsList implements IWordsList {
    private IWordsList lst;
    private Word word;

    public ProxyWordsList(String word) {
        add(word);
    }

    public void add(String word) {
        if (this.word == null) {
            this.word = new Word(word);
        }
        else if (this.word.equals(word)) {
            this.word.increaseCount();
        }
        else if (lst == null) {
            lst = new WordsList(this.word);
            lst.add(word);
        }
        else {
            lst.add(word);
        }
    }

    public void print() {
        if (lst == null) {
            System.out.println(word);
        }
        else {
            lst.print();
        }
    }
}
