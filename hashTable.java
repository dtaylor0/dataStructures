public class hashTable
{
    private static LLNode[] arr=null;
    private static int TABLE_SIZE=13;
    private static int NUM_VALUES=0;
    private static int MAX_NUM=13;
    public static void main(String[] args)
    {
        arr=new LLNode[TABLE_SIZE];
        put(1,arr);
        put(2,arr);
        put(3,arr);
        put(3,arr);
        put(4,arr);
        put(5,arr);
        put(6,arr);
        put(7,arr);
        put(8,arr);
        put(9,arr);
        put(10,arr);
        put(66,arr);
        put(72,arr);
        put(89,arr);
        put(91,arr);
        System.out.println("Num of values: "+NUM_VALUES);
        print();
        System.out.println("\n\n");
        put(11,arr);
        System.out.println("Num of values: "+NUM_VALUES);
        print();
        System.out.println("\n\n");
        LLNode ptr=get(7);
        System.out.println("Get 7: ["+ptr.getData()+"]");
    }

    public static int hash(int key)
    {
        return (54*key+23)%71;
    }

    public static int put(int key,LLNode[] someArr)
    {
        if(key<0)
        {
            System.out.println("Invalid key ["+key+"], must be zero or above");
            return -1;
        }
        if(NUM_VALUES>=MAX_NUM)
        {
            resize();
            someArr=arr;
        }
        int index=(hash(key))%TABLE_SIZE;
        LLNode newNode=new LLNode(key);
        if(someArr[index]==null)
        {
            someArr[index]=newNode;
            NUM_VALUES++;
            return 0;
        }
        LLNode ptr=someArr[index];
        if(ptr.getData()==key)
            return -1;
        while(ptr.next!=null)
        {
            if(ptr.getData()==key)
                return -1;
            ptr=ptr.next;
        }
        ptr.next=newNode;
        NUM_VALUES++;
        return 0;
    }

    public static LLNode get(int key)
    {
        if(key<0)
        {
            System.out.println("Invalid key ["+key+"'] must be zero or above");
            return null;
        }
        int index=hash(key)%TABLE_SIZE;
        LLNode ptr=arr[index];
        while(ptr!=null)
        {
            if(ptr.getData()==key)
                return ptr;
            ptr=ptr.next;
        }
        return null;
    }

    public static void resize()
    {
        int prevSize=TABLE_SIZE;
        TABLE_SIZE*=2;
        MAX_NUM*=2;
        LLNode[] newArr=new LLNode[TABLE_SIZE];
        for(int i=0;i<prevSize;i++)
        {
            LLNode ptr=arr[i];
            while(ptr!=null)
            {
                int data=ptr.getData();
                if(put(data,newArr)==0)
                    NUM_VALUES--;
                ptr=ptr.next;
            }
        }
        arr=newArr;
    }

    public static void print()
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
            else
                System.out.println();
        }
    }
}
