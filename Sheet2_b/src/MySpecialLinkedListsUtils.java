public class MySpecialLinkedListsUtils {
	 static LinkedListNode head,temphead;
	 public static void main(String []args) {
        add(5);add(3);add(1);add(4);add(0);add(-1);
        insertionSort(head);
        show(head);clearList();
        add(5);add(3);add(1);add(4);add(0);add(-1);
        mergeSort(head);
        show(head);
		if(palindrome(head)==true) System.out.println("List is palindrome");
		else System.out.println("List is not palindrome");
		revesre(head);show(head);
		 removeCentralNode(head) ;show(head);
		double[] a=summary(head);
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);
		evenIndexElement(head);show(head);
	}
    public static double[] summary(LinkedListNode head) {
		LinkedListNode n=head;double sum=0,average=0,median=0,min_value=n.value,max_value=n.value,median1=0,median2=0;int size=0;
		while(n!=null) {
			sum+=n.value;size++;n=n.next;
		}average=sum/size;n=head;LinkedListNode m=n.next;
		while(m!=null) {
			if(min_value>m.value) {min_value=m.value;m=m.next;}
			else if(max_value<m.value) {max_value=m.value;m=m.next;}
			else m=m.next;
		}
		if(size%2!=0) {
			int l=size/2;
			for(int i=0;i<=l;i++) {median=n.value;n=n.next;}
		}
		else {
			int l=size/2-1;
			for(int i=0;i<=l;i++) {median1=n.value;n=n.next;}
			median2=n.value;median=(median1+median2)/2;
		}
	    double []a= {sum,average,median,min_value,max_value};
		return a;
	}
	public static void revesre(LinkedListNode head) {
		LinkedListNode x=head;int size=0;
		while(x!=null) {x=x.next;size++;}
	    x=head;int s=0,e=size-1;
		while(s<e) {
			LinkedListNode y=head;
			for(int i=0;i<e;i++) y=y.next;
			int temp=x.value;x.value=y.value;y.value=temp;s++;e--;x=x.next;
		}
	}
	public static LinkedListNode evenIndexElement(LinkedListNode head) {
		LinkedListNode n=head;int size=0;
		while(n!=null) {size++;n=n.next;}n=head;
		if(size%2!=0) {
		while(n.next!=null) {
			LinkedListNode m=n.next;LinkedListNode l=m.next;n.next=l;n=n.next;}}
		else {
			while(n.next.next!=null) {
				LinkedListNode m=n.next;LinkedListNode l=m.next;n.next=l;n=n.next;}
			n.next=null;
		}return head;
	}
	public static LinkedListNode insertionSort(LinkedListNode head) {
		LinkedListNode n=head;LinkedListNode k=n.next;
        while(k!=null) {
        	while(n!=k) {
        		if(k.value<n.value) {
        			int temp=k.value;
        			k.value=n.value;
        			n.value=temp;
        		}n=n.next;
        	}k=k.next;n=head;
        }
		return head;
	}
	public static LinkedListNode mergeSort(LinkedListNode head) {
		LinkedListNode n=head;int size=0;
		while(n!=null) {size++;n=n.next;}
		merge(0,size-1);
		return head;
	}
	public static void merge(int low,int high) {
		if(low<high) {
			int mid=(low+high)/2;
			merge(low,mid);
			merge(mid+1,high);
			sorting(low, mid, high);
		}
	}
	public static void sorting(int low,int mid,int high) {
		LinkedListNode n=head;clearTempList();
		while(n!=null) {addtemp(n.value);n=n.next;}
	    int i=low,j=mid+1,k=low;
		while(i<=mid&&j<=high) {
			if(getTempList(i)<getTempList(j)) {
				add(k,getTempList(i));i++;
			}
			else {
				add(k,getTempList(j));j++;
			}k++;
		}
		while(i<=mid) {
			add(k,getTempList(i));i++;k++;
		}
		while(j<=high) {
			add(k,getTempList(j));j++;k++;
		}
		
	}
	public static LinkedListNode removeCentralNode(LinkedListNode head) {
		LinkedListNode n=head;int size=0;
		while(n!=null) {size++;n=n.next;}n=head;
		if(size%2!=0) {
			int l=size/2;
			for(int i=0;i<l-1;i++) n=n.next;
			LinkedListNode m=n.next;LinkedListNode k=m.next;
			n.next=k;
		}
		else {
			int l=size/2-1;
			for(int i=0;i<l-1;i++) n=n.next;
			LinkedListNode m=n.next;LinkedListNode k=m.next;LinkedListNode q=k.next;
			n.next=q;
		}
		return head;
	}
	public static boolean palindrome(LinkedListNode head) {
		LinkedListNode n=head,m=head;int size=0;
		while(n!=null) {size++;n=n.next;}n=head;
		for(int i=0;i<size-1;i++)m=m.next;int s=0,e=size-1;
		while(s<e) {
			if(n.value==m.value) {
				n=n.next;s++;e--;m=head;
				for(int i=0;i<e;i++) m=m.next;
			}
			else break;
		}
		if(s>=e) return true;
		else return false;
	}
	public static void add(Integer element) {
		LinkedListNode node=new LinkedListNode();node.value=element;
		if(head==null) head=node;
		else {
			LinkedListNode n=head;
			while(n.next!=null) n=n.next;
			n.next=node;
		}
	}
	public static void addtemp(Integer element) {
		LinkedListNode node=new LinkedListNode();node.value=element;
		if(temphead==null) temphead=node;
		else {
			LinkedListNode n=temphead;
			while(n.next!=null) n=n.next;
			n.next=node;
		}
	}
	public static void add(int index,int element) {
		if(index==0) head.value=element;
		else {
			LinkedListNode m=head;
			for(int i=0;i<index;i++) m=m.next;
			m.value=element;
			
		}
	}
	public static int getTempList(int index) {
		LinkedListNode n=temphead;int element=0;
		for(int i=0;i<=index;i++) {
			element=n.value;
			n=n.next;}
		return element;
	}
	public static void clearList() {
		head=null;
	}
	public static void clearTempList() {
		temphead=null;
	}
	public static void show(LinkedListNode head) {
		LinkedListNode n=head;
		while(n.next!=null) {System.out.println(n.value);n=n.next;}
		System.out.println(n.value);
	}
	public static void showtemp(LinkedListNode temphead) {
		LinkedListNode n=temphead;
		while(n.next!=null) {System.out.println(n.value);n=n.next;}
		System.out.println(n.value);
	}
}
