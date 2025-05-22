
public class DemoLinkedList {

	public static void main(String[] args) {
		LinkedList numList = new LinkedList();
		Node nodeA = new Node(10);
		Node nodeB = new Node(20);
		Node nodeC = new Node(30);
		Node nodeD = new Node(40);
		Node nodeE = new Node(50);
		Node nodeF = new Node(60);

		numList.append(nodeB); // Add 20
		numList.append(nodeC); // Add 30, make the tail
		numList.append(nodeE); // Add 50, make the tail

		numList.prepend(nodeA); // Add 10, make the head

		numList.insertAfter(nodeC, nodeD); // Insert 40 after 30
		numList.insertAfter(nodeE, nodeF); // Insert 60 after tail (50)

		// Output list
		System.out.print("List after adding nodes: ");
		numList.printList();

		// Remove the tail node, then the head node
		numList.removeAfter(nodeE);
		numList.removeAfter(null);

		// Output final list
		System.out.print("List after removing nodes: ");
		numList.printList();
	}

}
