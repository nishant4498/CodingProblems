
public class LinkedListBinaryToDec {

	public static long TestMyCode(Node head) {
		// TODO Auto-generated constructor stub
		String number = "";	
		Node temp = head;
		while(temp.next != null){
			number += temp.data;
			temp = temp.next;
		}

		double decimalNum = 0;

		for(int i =0;i< number.length();i++){
			int bin = (number.charAt(i) == '1')?1:0;
			decimalNum = decimalNum + bin * Math.pow(2, (number.length() - i));
		}
		
		long result = (long) decimalNum;
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node one = new Node(0);
		Node one1 = new Node(0);
		Node one2 = new Node(1);
		Node one3 = new Node(1);
		Node one4 = new Node(0);
		Node one5 = new Node(1);
		Node one6 = new Node(0);
		
		Node head = one;
		
		one.next = one1;
		one1.next = one2;
		one2.next = one3;
		one3.next = one4;
		one4.next = one5;
		one5.next = one6;
		one6.next = null;
		
		long result =  LinkedListBinaryToDec.TestMyCode(head);
		System.out.println(result);

	}

}

class Node{
	int data;
	Node next;
	
	public Node(int data){
		this.data = data;
	}
	
}
