import java.util.Iterator;

public class LineIterator<T> implements Iterator<T> {
	private Line<T> line;
    int index;

    public LineIterator(Line<T> oda) {
        this.line = oda;
        index = 0;
    }

    public boolean hasNext() {
        return (index < line.size() - 1);
    }
    
	public T next() {
		T o = (T) line.get(index);
		index++;
		return o;
	}
}