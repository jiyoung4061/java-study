package dataStructure_List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E>{
	private int size;
	private E[] data;

	public ArrayList() { // arrayList ������
		this.size = 0;
		resize();
	}
	private void resize() {
		if(size == 0 ) {
			data = (E[]) new Object[10]; // ���׸�Ÿ������ �迭�� ����� ��� : objectŸ������ �迭�� ����� ����ȯ����
		} else {
			E[] newData = (E[]) new Object[size + 10];
			System.arraycopy(data, 0, newData, 0, size);
			// System.arraycopy(src, srcPos, des, desPos, length); // src�� srcPos���� length��ŭ des�� desPos���� copy�� 
			data = newData; // copy�� �� �迭�� ���� �迭 ��ü!
		}
	}
	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		if(data.length == size) {
			resize();
		}
		
		data[size++] = element;
	}
	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		checkBoundExclusive(index);
		
		if(data.length == size) {			
			resize();
		}
		
//		//M1. ���� �� ���
//		for(int i = size ; i >= index ; i--) {
//			if(i == index) {
//				data[index] = element;
//			} else {
//				data[i] = data[i-1];
//			}
//		}
		
		//M2. ������ ���
		if(index != size)
			System.arraycopy(data, index, data, index+1, size-index);
		data[index] = element;
		
		size++;
	}
	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		checkBoundExclusive(index);
		return data[index];	
	}
	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		checkBoundExclusive(index);
		
//		//M1. ���� �� ���
//		for(int i = index ; i < size ; i++) {
//			data[i] = data[i+1];
//		}
//		size--;
//		return (E) data;
		
		//M2. ������ ���
		E r = data[index];
		if(index != --size)
			System.arraycopy(data, index+1, data, index, size-index);
		
		return r;
	}
	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		size = 0;
		// �����ʹ� �������ֳ�? => ������ �����Ͱ��� �����Ⱚ���� ����� size�� 0�����ϸ� �����͸� ���� ����������
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	private void checkBoundExclusive(int index) { // ��谪 ����O
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
		}
	}
	private void checkBoundInclusive(int index) { // ��谪 ����X
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: "+index+", Size: "+ size);
		}
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		
		return new Iterator<E> () {
			
			private int pos = 0;
			private int size = size();
			
			@Override
			public boolean hasNext() { // ���� ��� ����� true, ���� ���ϸ� false
				// TODO Auto-generated method stub
				return pos < size;
			}
			
			@Override
			public E next() { // ���� ��� ��ȯ
				// TODO Auto-generated method stub
				if(pos == size) {
					throw new NoSuchElementException();
				}
				
				return data[pos++];
			}
			
		};
		
		
	}
}
