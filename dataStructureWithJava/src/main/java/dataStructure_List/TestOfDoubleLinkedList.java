package dataStructure_List;

import java.util.Iterator;

public class TestOfDoubleLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new DoubleLinkedList<Integer>();

		// ������ �߰�
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(2, 25);
//		list.remove(3);

//		// ��ü ������ ������� ��������
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + "��° ������ : " + list.get(i));
		}
//
//		// ��ü ������ �� ���
//		System.out.println("���� ������ ��:" + list.size());

		// Iterator ����ϱ�
//		Iterator<Integer> it = list.iterator();
//		while (it.hasNext()) {
//			int i = it.next();
//			System.out.println(i);
//		}
//
//		System.out.println();
//
//		for (int i : list) {
//			System.out.println(i);
//		}
		
	}

}
