public class LLNode
{
    private int data;
    public LLNode next;

    public LLNode(int data)
    {
        this.data=data;
        this.next=null;
    }

    public String toString()
    {
        return "->["+this.data+"]";
    }

    public int getData()
    {
        return this.data;
    }

    public void setData(int newData)
    {
        this.data=newData;
    }
}
