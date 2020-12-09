import java.util.ArrayList;
import java.util.Random;

//SUCCESSFUL

public class MergeKSortedLists {
	public static ListNode mergeKLists(ListNode[] lists) {
		
		if(lists == null || lists.length == 0)
			return  null;
		
		ArrayList<Integer> seq = new ArrayList<Integer>();
		
		for(int i=0; i<lists.length; i++) {
			while(lists[i] != null) {
				seq.add(lists[i].val);
				lists[i] = lists[i].next;
			}
		}
		
		if(seq.size() == 0)
			return null;
		
		System.out.println("ArrayList: "+seq.toString());
		
		inPlaceQuickSort(seq, 0, seq.size()-1);
		
		ListNode result = new ListNode(seq.get(0));
		ListNode it = result;
		
		seq.remove(0);
		
		for(Integer i: seq) {
			it.next = new ListNode(i);
			it = it.next;
		}
		it = null;
		return result;
	}
	
	public static void inPlaceQuickSort(ArrayList<Integer> seq, int l, int r) {
		Random rand = new Random();
		int pivot, x, h=l, k=l;
		
		if(l>=r)
			return;
		
		pivot = rand.nextInt(r-l+1)+l;
		System.out.println("Random Value: "+pivot);
		x = seq.get(pivot);
		moveTo(seq, l, pivot);
		
		System.out.print("Iterations: ");
		for(int i=l+1; i<=r; i++) {
			System.out.print(1);
			if(seq.get(i)<x) {
				moveTo(seq, h, i);
				h++;
				k++;
			}
			else if(seq.get(i)==x) {
				moveTo(seq, k, i);
				k++;
			}
		}
		
		inPlaceQuickSort(seq, l, h-1);
		inPlaceQuickSort(seq, k+1, r);
		
	}
	
	public static void moveTo(ArrayList<Integer> seq, int locationIndex, int valIndex) {
		seq.add(locationIndex, seq.get(valIndex));
		if(locationIndex<valIndex)
			seq.remove(valIndex+1);
		else
			seq.remove(valIndex);
	}
	
	public static void main(String[] args) {
		ListNode[] lists = new ListNode[3];
		
		lists[0] = new ListNode(1);
		lists[0].next = new ListNode(4);
		lists[0].next.next = new ListNode(5);
		
		lists[1] = new ListNode(1);
		lists[1].next = new ListNode(3);
		lists[1].next.next = new ListNode(4);
		
		lists[2] = new ListNode(2);
		lists[2].next = new ListNode(6);
		
		ListNode result = mergeKLists(lists);
		
		ArrayList<Integer> seq = new ArrayList<Integer>();
		
		ListNode temp = result;
		
		while(temp != null) {
			seq.add(temp.val);
			temp = temp.next;
		}
		System.out.println();
		for(Integer i: seq) {
			System.out.print(i+"->");
		}
	}
}
