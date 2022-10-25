package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
public class BasicDoubleLinkedList<T> implements Iterable<T> {
	
	 DoubleNode head, tail;
	 int size;
	public class DoubleNode{
		DoubleNode next, previous;
		T data;
		public DoubleNode(T data) {
			this.previous = null;
			this.data = data;
			this.next = null;
			
			
		}
		public DoubleNode( DoubleNode Previous,T data, DoubleNode Next) {
			this.previous = Previous;
			this.data = data;
			this.next = Next;
			
			
		}
	}
	
	public BasicDoubleLinkedList(){
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public void addToFront(T data){
		
		if( head == null && tail == null) 
			head = tail = new  DoubleNode(null, data, null);
		else {
			DoubleNode n1 = new DoubleNode(null, data, head);
		head.previous = n1;
		head = n1;
	}
		
		size++;
		
	}
	
	 public void addToEnd (T data) {
		  DoubleNode list = new DoubleNode(null, data, null);
		 if(head == null && tail == null) {
			 tail = head =  list;
		 }else {
			
			 DoubleNode list1 = new DoubleNode(tail ,data, null);
			 tail.next = list1;
			 tail = list1;
		 }
		
	 size++;
		
		
	}
	
	public T getFirst() {
		
		return head.data;
		
	}
	public T getLast() {
	
		return tail.data;
	}
	public ListIterator<T> iterator()
            throws UnsupportedOperationException,
                  NoSuchElementException{
		
		return new DoubleNodeiterators();
	}
	 
		
	public BasicDoubleLinkedList<T> remove(T targetData,
            Comparator<T> comparator){

		 DoubleNode previous = null, current = head;
		  while (current != null) {
		  if (comparator.compare(current.data, targetData) == 0) {
		  if (current == head) {
		  head = head.next;
		  current = head;
		  } else if (current == tail) {
		  current = null;
		  tail = previous;
		  previous.next = null;
		  } else {
		  previous.next = current.next;
		  current = current.next;
		  }
		  size--;
		  } else {
		  previous = current;
		  current = current.next;
		  }
		  }
		  return this;
	}
	public T retrieveFirstElement() {
		if (head == null) {
			  throw new NoSuchElementException("Linked list is empty");
			  }
		DoubleNode node = head;
		  head = head.next;
		  head.previous = null;
		  size--;
		return node.data;
	}
	public T retrieveLastElement() {
		if (head == null) {
			  throw new NoSuchElementException("Linked list is empty");
			  }
		DoubleNode currentNode = head;
		 DoubleNode previousNode = null;

		  while (currentNode != null) {
		  if (currentNode.equals(tail)) {
		  tail = previousNode;
		  break;
		  }
		  previousNode = currentNode;
		  currentNode = currentNode.next;
		  }
		  size--;
		  return currentNode.data;
	}

	public ArrayList<T> toArrayList(){
		 ArrayList<T> list  = new ArrayList<T>();
		 ListIterator<T> it = new DoubleNodeiterators();
			while(it.hasNext()) {
				list.add(it.next());
			}
		 	
		return list;
	}
	class DoubleNodeiterators implements ListIterator<T>{	
		DoubleNode current = head, beforeCurrent = null;
		
		public T next()
		  {
			  if(current != null)
			  {
			  T elem = current.data;
			  beforeCurrent = current;
			  current = current.next;
			  if(current != null) {
				  current.previous = beforeCurrent;
				  }
			  return elem;
			  }
			  else
			  throw new NoSuchElementException();
			  }

		@Override
		public boolean hasNext() {
			if(current != null) {
				return true;
			}
			return false;
		}

		@Override
		public boolean hasPrevious() {
			if(beforeCurrent!= null) {
				return true;
			}
			return false;
		}

		@Override
		public T previous() {
			if(beforeCurrent!= null) {
				current = beforeCurrent;
				beforeCurrent = current.previous;
				T e = current.data;
				return e;
			  }
			  else
			  throw new NoSuchElementException();
		}

		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException();
			
		}

		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T e) {
			throw new UnsupportedOperationException();
			
		}

		@Override
		public void add(T e) {
			throw new UnsupportedOperationException();
		
			
		}	
		
		}
	public int getSize() {
		
		return size;
	}
	
	
}

	
	
