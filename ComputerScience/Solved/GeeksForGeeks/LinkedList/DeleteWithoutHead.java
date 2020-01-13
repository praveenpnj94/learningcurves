//https://www.geeksforgeeks.org/given-only-a-pointer-to-a-node-to-be-deleted-in-a-singly-linked-list-how-do-you-delete-it/


class GfG
{
    void deleteNode(Node node)
    {
         Node temp = node.next;
         node.data = temp.data;
         node.next = temp.next;
         temp = null;
    }
}