import java.util.Scanner;
public class week1
{
    public static void main(String[] args) 
    {
        Scanner i1=new Scanner(System.in);
        System.out.println("Enter the dataword: ");
        String a=i1.next();
        computeParity(a);
        i1.close();
    }
    static void computeParity(String a)
    {
        int c=0;
        for(int i=0;i<a.length();i++)
        {
            if(a.charAt(i)=='1')
                c++;
        }
        if(c%2==0)
            System.out.println("Parity bit: "+0);
        else
            System.out.println("Parity bit: "+1);
    }
}
