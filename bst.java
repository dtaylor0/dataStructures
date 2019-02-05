public class bst
{
    private static bstNode root=null;
    private static int numNodes=0;

    public static void main(String[] args)
    {
        System.out.println("Starting bst.java.");
        add(5);
        add(9);
        add(7);
        add(6);
        add(8);
        add(3);
        add(4);
        printBST(root);
        System.out.println();
    }

    public static int add(int newData)
    {
        bstNode newNode=new bstNode(newData);
        bstNode ptr=root;
        if(ptr==null)
        {
            root=newNode;
            numNodes++;
            return 0;
        }
        while(ptr!=null)
        {
            if(ptr.data<newData)
            {
                if(ptr.right==null)
                {
                    ptr.right=newNode;
                    numNodes++;
                    return 0;
                }
                else
                {
                    ptr=ptr.right;
                    continue;
                }
            }
            else if(ptr.data==newData)
                return -1;
            else if(ptr.data>newData)
            {
                if(ptr.left==null)
                {
                    ptr.left=newNode;
                    numNodes++;
                    return 0;
                }
                else
                {
                    ptr=ptr.left;
                    continue;
                }
            }
        }
        return -1;
    }

    public static void printBST(bstNode current)
    {
        if(current==null)
            return;
        System.out.print("(");
        printBST(current.left);
        System.out.print(current.data);
        printBST(current.right);
        System.out.print(")");
        /*
        if(current.left!=null)
        {
            System.out.print("<-");
            printBST(current.left);

        }
        if(current.right!=null)
        {
            System.out.print("->");
            printBST(current.right);
        }
        System.out.print(current.data);
        */
    }
}
