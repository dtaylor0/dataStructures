public class linkedList
{
    public static void main(String[] args)
    {
        LLNode a=new LLNode(6);
        LLNode b=new LLNode(4);
        LLNode c=new LLNode(2);
        LLNode d=new LLNode(1);
        a.next=b;
        b.next=c;
        c.next=d;
        LLNode root=a;
        System.out.println("Original linked list:");
        printLinkedList(root);
        System.out.println("delete 4:");
        root=deleteNode(4,root);
        printLinkedList(root);
        System.out.println("delete 1:");
        root=deleteNode(1,root);
        printLinkedList(root);
        System.out.println("delete 6:");
        root=deleteNode(6,root);
        printLinkedList(root);
        System.out.println("delete 2:");
        root=deleteNode(2,root);
        printLinkedList(root);
    }

    public static void printLinkedList(LLNode root)
    {
        if(root==null)
            System.out.print("Linked list is empty.");
        while(root!=null)
        {
            System.out.print(root.toString());
            root=root.next;
        }
        System.out.println();
    }

    public static LLNode deleteNode(int target,LLNode root)
    {
        LLNode ptr=root;
        LLNode prev=null;
        while(ptr!=null)
        {
            if(ptr.getData()==target)
                break;
            prev=ptr;
            ptr=ptr.next;
        }
        if(ptr==null)  //target not found
            return root;
        if(prev==null) //target is root node
        {
            if(ptr.next==null)  //target is only node
                return null;
            return ptr.next;
        }
        if(ptr.next==null)  //target is last node
        {
            prev.next=null;
            return root;
        }
        prev.next=ptr.next;
        return root;
    }

}
