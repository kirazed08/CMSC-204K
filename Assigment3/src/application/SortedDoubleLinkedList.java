package application;
import java.util.Comparator;
import java.util.ListIterator;
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	Comparator<T> comp;  
	public SortedDoubleLinkedList(Comparator<T> comparator2) {
		 comp = comparator2;
		 
	}
	public void add(T data){
		DoubleNode h = head, t = tail;
	
		if (data == null) {
			data = null;
			}

			DoubleNode node = new DoubleNode( null, data,null);
			if (h == null) {
			h = t = node;
			} else {
			if (comp.compare(data, h.data) <= 0) {
			node.next = h;
			h = node;
			} else if (comp.compare(data, t.data) >= 0) {
			t.next = node;
			t = node;
			} else {
			DoubleNode a = h.next;
			DoubleNode b = h;
			while (comp.compare(data, a.data) > 0) {
			b = a;
			a = a.next;
			}
			b.next = node;
			node.next = a;
			}
			}
			size++;
			
			
		
	}
	public void addToEnd(T data)
            throws UnsupportedOperationException{
					
		throw new UnsupportedOperationException("Invalid operation for sorted list");
				
		
	}
	public void addToFront(T data){
	throw new UnsupportedOperationException("Invalid operation for sorted list");
						
		
	}
	public ListIterator<T> iterator(){
		return new DoubleNodeiterators();
		
	}
	public SortedDoubleLinkedList<T> remove(T data,
            Comparator<T> comparator){
		DoubleNode a = head;
		DoubleNode b = null;
		while (a != null) {
		if (comparator.compare(a.data, data) == 0) {
		size--;
		if (b != null) {
		b.next = a.next;
		} else {
		head = a.next;
		}
		if (a == tail) {
		tail = b;
		}
		}
		b = a;
		a = a.next;
		}

		return this;


	}
}
