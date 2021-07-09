//https://www.geeksforgeeks.org/sort-linked-list-order-elements-appearing-array/

// Efficient JAVA program to sort given list in order 
// elements are appearing in an array 
import java.util.*; 

class GFG 
{ 

// Linked list node 
static class Node 
{ 
	int data; 
	Node next; 
}; 

// Function to insert a node at the 
// beginning of the linked list 
static Node push(Node head_ref, int new_data) 
{ 
	Node new_node = new Node(); 
	new_node.data = new_data; 
	new_node.next = head_ref; 
	head_ref = new_node; 
	return head_ref; 
} 

// function to print the linked list 
static void printList(Node head) 
{ 
	while (head != null) 
	{ 
		System.out.print(head.data+ "->"); 
		head = head.next; 
	} 
} 

// Function that sort list in order of apperaing 
// elements in an array 
static void sortlist(int arr[], int N, Node head) 
{ 
	// Store frequencies of elements in a 
	// hash table. 
	HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>(); 
	Node temp = head; 
	while (temp != null) 
	{ 
		if(hash.containsKey(temp.data)) 
			hash.put(temp.data,hash.get(temp.data) + 1); 
		else
			hash.put(temp.data,1); 
		temp = temp.next; 
	} 

	temp = head; 

	// One by one put elements in lis according 
	// to their appearance in array 
	for (int i = 0; i < N; i++) 
	{	 

		// Update 'frequency' nodes with value 
		// equal to arr[i] 
		int frequency = hash.get(arr[i]); 
		while (frequency-->0) 
		{ 

			// Modify list data as element 
			// appear in an array 
			temp.data = arr[i]; 
			temp = temp.next; 
		} 
	} 
} 

// Driver Code 
public static void main(String[] args) 
{ 
	Node head = null; 
	int arr[] = { 5, 1, 3, 2, 8 }; 
	int N = arr.length; 

	// creating the linked list 
	head = push(head, 3); 
	head = push(head, 2); 
	head = push(head, 5); 
	head = push(head, 8); 
	head = push(head, 5); 
	head = push(head, 2); 
	head = push(head, 1); 

	// Function call to sort the list in order 
	// elements are apperaing in an array 
	sortlist(arr, N, head); 

	// print the modified linked list 
	System.out.print("Sorted List:" +"\n"); 
	printList(head); 
} 
} 

// This code is contributed by PrinciRaj1992 
