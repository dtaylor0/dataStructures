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
        delete(5);
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

    public static int delete(int target)
    {
        if(root==null)
            return -1;
        bstNode ptr=root;
        bstNode prev=null;
        while(ptr!=null)
        {
            if(ptr.data==target)
            {
                if(prev==null)
                {
                    bstNode tempPtr=ptr.right;
                    bstNode tempPrev=null;
                    while(tempPtr.left!=null)
                    {
                        tempPrev=tempPtr;
                        tempPtr=tempPtr.left;
                    }
                    if(tempPrev==null)
                    {
                        tempPtr.left=ptr.left;
                        root=tempPtr;
                        ptr=null;
                    }
                    else
                    {
                        tempPrev.left=null;
                        tempPtr.left=ptr.left;
                        tempPtr.right=ptr.right;
                        root=tempPtr;
                        ptr=null;
                    }
                    return 0;
                }
                if(ptr.left==null&&ptr.right==null)
                {
                    if(prev.right==ptr)
                        prev.right=null;
                    else if(prev.left==ptr)
                        prev.left=null;
                    return 0;
                }
                else if(ptr.left==null)
                {
                    if(prev.right==ptr)
                    {
                        prev.right=ptr.right;
                        ptr.right=null;
                        return 0;
                    }
                    else if(prev.left==ptr)
                    {
                        prev.left=ptr.right;
                        ptr.right=null;
                        return 0;
                    }
                }
                else if(ptr.right==null)
                {
                    if(prev.right==ptr)
                    {
                        prev.right=ptr.left;
                        ptr.left=null;
                        return 0;
                    }
                    else if(prev.left==ptr)
                    {
                        prev.left=ptr.left;
                        ptr.left=null;
                        return 0;
                    }
                }
                else
                {

                }
            }
            prev=ptr;
            if(ptr.data<target)
                ptr=ptr.right;
            else if(ptr.data>target)
                ptr=ptr.left;
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
    }
}
