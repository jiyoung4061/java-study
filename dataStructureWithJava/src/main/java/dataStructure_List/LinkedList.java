package dataStructure_List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {

	private int size;
	private Node<E> head;

	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		Node<E> newNode = new Node<E>(element);

		if (head == null) { // ���� ��� ����X
			head = newNode;
		} else {
			Node<E> last = head; // head����(index=0) �������� �ɶ�(null) ���� ������ ��带 ã�ư�
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
		}

		size++;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		checkBoundExclusive(index);
		Node<E> newNode = new Node<E>(element);
		Node<E> last = head;

		for (int i = 0; i < index - 1; i++) {
			last = last.next;
		}

//		// M1. �� ��� => ù��° index, ������ index�� �߰��� ��츦 ����!!
//		last.next = newNode;
//		newNode.next = last.next;

		// M2. ������ ���
		if (index == size) { // ������ index �߰��� ���!
			add(element);
			return;
		}
		if (index == 0) { // �Ǿտ� �߰��� ���
			head = newNode;
			newNode.next = last;
		} else {
			newNode.next = last.next;
			last.next = newNode;
		}

		size++;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		checkBoundExclusive(index);
		Node<E> x = head;
		for (int i = 0; i < index; i++) {
			x = x.next;
		}
		return x.data;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		checkBoundExclusive(index);

		// M2. ������ ���
		E element;
		if (index == 0) {
			element = head.data;
			head = head.next;
		} else {
			Node<E> last = head;
			for (int i = 0; i < index - 1; i++) {
				last = last.next;
			}

			element = last.next.data;
			last.next = last.next.next;
		}
		size--;
		return element;

//		// M1. ���� �� ��� => ù��° ��� ����Ⱑ ����. && ��ȯ�� üũ!
//		Node<E> last = head;
//		
//		for(int i = 0 ; i< index-1 ;i++) {
//			last = last.next; // for�� ������ last���� index�� �ּҰ���������
//		}
//		last.next = last.next.next; // remove�� ��� ���� �ּ�
//		size--;
//		
//		return last.data;	

	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		for (Node<E> x = head; x != null;) {
			Node<E> next = x.next;
			x.data = null;
			x.next = null;
			x = next;
		}
		head = null;
		size = 0;
	}

	private void checkBoundExclusive(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
	}

	private void checkBoundInclusive(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	private class Node<E> { // inner Class
		private Node<E> next; // next : ���� ��� ����Ű�� ��
		private E data;

		private Node(E element) { // ������1
			this.data = element;
			this.next = null;
		}

		private Node(E element, Node<E> next) { // ������2
			this.data = element;
			this.next = next;
		}
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub

		return new Iterator<E>() {

			private Node<E> x = head;

			@Override
			public boolean hasNext() { // ���� ��� ����� true, ���� ���ϸ� false
				// TODO Auto-generated method stub
				return x != null;
			}

			@Override
			public E next() { // ���� ��� ��ȯ
				// TODO Auto-generated method stub
				
				if (x == null) {
					throw new NoSuchElementException();
				}
				E data = x.data;
				x = x.next;
				return data;
			}

		};
	}

}
