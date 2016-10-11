package jdbcTest;

import java.util.ArrayList;

import com.chinamobile.entity.Operator;

public class TestArrayList1 {
	public static void main(String[] args) {
		Operator o1 = new Operator();
		o1.setOperatorId("111");
		o1.setOperatorName("tom");
		
		Operator o2 = new Operator();
		o2.setOperatorId("222");
		o2.setOperatorName("john");
		
		
		Operator o3 = new Operator();
		o3.setOperatorId("333");
		o3.setOperatorName("rose");
		
		ArrayList<Operator>  oprList = new ArrayList<Operator>();
		oprList.add(o1);
		oprList.add(o2);
		oprList.add(o3);
	
		for(int i=0; i<oprList.size(); i++){
			Operator o = oprList.get(i);
			System.out.println(o.getOperatorId() + "|" +o.getOperatorName());
		}
		
	}
}
