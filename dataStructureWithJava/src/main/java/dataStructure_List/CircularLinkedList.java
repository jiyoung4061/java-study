package dataStructure_List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularLinkedList<E> implements List<E> {

	private int size;
	private Node<E> tail;

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<E>() {

//			// �����
//			private Node<E> x = tail.next; // ù��° ���
//			private int count = 0;
			
			private Node<E> position = tail == null ? null : tail.next;
			private boolean isFirst = true;
			
			@Override
			public boolean hasNext() { // ������ ����� ��� false, �ƴϸ� true
				// TODO Auto-generated method stub
				
//				// ����� => �����Ͱ� ���°�쵵 �׽�Ʈ �غ���!!
//				if( count < size) { // true
//					count++;
//					return true;
//				} else { // false = ��������Ҹ� ����Ű�� �ִ� ���
//					return false;
//				}
				
				if(position == null) {
					return false;
				}
				if(isFirst) {
					isFirst = false;
					return true;
				}
				
				return (position != tail.next);
			}

			@Override
			public E next() { // ���� ��� ��ȯ
				// TODO Auto-generated method stub
//				// �����
//				if (x == tail) {
//					E data = x.data;
//					return data;
//				}
//				E data = x.data;
//				x = x.next;
//				return data;
				
				// �����Թ��
				E data = position.data;
				position = position.next;
				return data;
			}
		};
	}

	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		Node<E> newNode = new Node<E>(element);

		if (tail == null) { // node�� �ƹ��͵� ����
			tail = newNode.next = newNode;
			// newNode.next = newNode
			// tail = newNode.next
		} else {
			newNode.next = tail.next; // newNode�� next�� ù��° node�ּҰ�(tail.next)�� ���� => newNode�� ù��° node����Ŵ
			tail.next = newNode; // ������ ��Ұ� newNode�� ����Ŵ
			tail = tail.next; // tail�̵�
		}

		size++;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		checkBoundExclusive(index);
		Node<E> newNode = new Node<E>(element);

		if (index == size) {
			add(element);
			return;
		}
		
		Node<E> pos;
		
		// ������ ���
		if(index == 0) {
			pos = tail;
		} else {
			pos = tail.next;
			for(int i = 0 ; i < index -1 ;i++) {
				pos = pos.next;
			}
		}
//		// ������ ���
//		pos = tail;
//		for (int i = 0; i < index; i++) {
//			pos = pos.next;
//		}
		size++;
		newNode.next = pos.next;
		pos.next = newNode;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		checkBoundExclusive(index);
		Node<E> x = tail.next;

		for (int i = 0; i < index; i++) {
			x = x.next;
		}
		return x.data;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		checkBoundExclusive(index);
		
//		// ���� �� ���
//		E element;
//		Node<E> pos = tail.next;
//		if (index == 0) { // ù��° ��������
//			tail.next = pos.next;
//			element = pos.data;
//			pos.next = null;
//			size--;
//		} else {
//			pos = tail;
//			for (int i = 0; i < index; i++) {
//				pos = pos.next;
//			}
//			element = pos.next.data;
//			pos.next = pos.next.next;
//			size--;
//		}
//		return element;
		
		// ������ ���
		Node<E> pos;
		if(index == 0) {
			pos = tail;
		} else {
			pos = tail.next;
		}
		
		for(int i = 0 ; i < index -1 ; i++) {
			pos = pos.next;
		}
		
		if(pos.next == tail) { // ���� ��尡 ������ ����� ���
			tail = pos;
		}
		Node<E> deleted;
		deleted = pos.next;
		pos.next = deleted.next;
		size--;
		return deleted.data;
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		Node<E> x = tail.next; // x : ù��° ���

		while (x != tail) {
			Node<E> next = x.next; // x�� ���� ���
			x.next = null; // x�� ���� ����� ������ ����
			x = next; // x�� ���� ��带 ����Ŵ
		}
		tail.next = null;
		tail = null;
		size = 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	private static class Node<E> {
		private Node<E> next;
		private E data;

		private Node(E element) {
			this.data = element;
			this.next = null;
		}

		private Node(E element, Node<E> next) {
			this.data = element;
			this.next = next;
		}
	}

	private void checkBoundExclusive(int index) { // ��谪 ����O
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
	}

	private void checkBoundInclusive(int index) { // ��谪 ����X
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
	}

}
