import java.util.ArrayList;
import java.util.Iterator;

public class Line<T> implements Iterable<T> {
	private ArrayList<T> data;
	int index = 0;
	
	public Line() { data = new ArrayList<T>(); }
	
	public Iterator<T> iterator() { // Iterable 필수 조건
        return new LineIterator<T>(this); // Iterator를 반환
    }

    public void push(T t) {
        data.add(t);
    }

    public T get(int index) {
        return data.get(index);
    }

    public int size() {
        return data.size();
    }
}