package jdbcTest;

import java.util.ArrayList;

public class TestArrayList {

	public static void main(String[] args) {
		
		//ArrayList的优势是长度可以不限制 使用<数据类型>，表示一个限制，ArrayList中只能保存该数据类型的数据
		ArrayList<String> list = new ArrayList<String>();
		//list里面可以保存任何类型的数据
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
//		list.add(100);
		
		//迭代ArrayList
		for(int i=0; i<list.size();i++){
			/*Object s =  list.get(i);
			String s1 = (String)s;
			System.out.println(s1);*/
			
			String s1 = list.get(i);
			System.out.println(s1);
		}
	}

}
