import java.lang.Math;
public class hashTable
{
    private static int TABLE_SIZE=10;
    public static void main(String[] args)
    {
        LLNode[] arr=new LLNode[TABLE_SIZE];
        put(3,arr);
        put(9,arr);
        put(55,arr);
        put(55,arr);
        put(-55,arr);
        print(arr);
    }

    public static int hash(int key)
    {
        return key*(int)Math.pow(2,32);
    }

    public static void put(int key, LLNode[] arr)
    {
        if(key<0)
        {
            System.out.println("Invalid key '"+key+"', must be zero or above");
            return;
        }
        int index=hash(key)%TABLE_SIZE;
        LLNode newNode=new LLNode(key);
        if(arr[index]==null)
        {
            arr[index]=newNode;
            return;
        }
        LLNode ptr=arr[index];
        if(ptr.getData()==key)
            return;
        while(ptr.next!=null)
        {
            if(ptr.getData()==key)
                return;
            ptr=ptr.next;
        }
        ptr.next=newNode;
    }

    public static void print(LLNode[] arr)
    {
        for(int i=0;i<TABLE_SIZE;i++)
        {
            System.out.print(i);
            LLNode ptr=arr[i];
            if(ptr==null)
                System.out.print("->empty");
            while(ptr!=null)
            {
                System.out.print("->["+ptr.getData()+"]");
                ptr=ptr.next;
            }
            if(i<TABLE_SIZE-1)
                System.out.print("\n|\n");
        }
    }
}
