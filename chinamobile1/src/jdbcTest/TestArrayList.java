package jdbcTest;

import java.util.ArrayList;

public class TestArrayList {

	public static void main(String[] args) {
		
		//ArrayList�������ǳ��ȿ��Բ����� ʹ��<��������>����ʾһ�����ƣ�ArrayList��ֻ�ܱ�����������͵�����
		ArrayList<String> list = new ArrayList<String>();
		//list������Ա����κ����͵�����
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
//		list.add(100);
		
		//����ArrayList
		for(int i=0; i<list.size();i++){
			/*Object s =  list.get(i);
			String s1 = (String)s;
			System.out.println(s1);*/
			
			String s1 = list.get(i);
			System.out.println(s1);
		}
	}

}
