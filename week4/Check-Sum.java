//Implementation of CheckSum algorithm in Computer Networks.

import java.util.*;
class week4 
{
    static String complement(String sum, int n) 
    {
        char bits[] = sum.toCharArray();
        for (int i = 0; i < n; i++) 
        {
            if (bits[i] == '1')
                bits[i] = '0';
            else
                bits[i] = '1';
        }
        return new String(bits);
    }

    static String computeCheckSum(String data[], int k) 
    {
        int n=data[0].length();
        int a = 0;
        int b = 0;
        for (int i = 0; i < k; i++) 
        {
            a = Integer.parseInt(data[i], 2);//radix 2 represents its data is a binary value
            b = b + a;
            String temp = Integer.toBinaryString(b);
            if (temp.length() > n) 
            {
                temp = temp.substring(1);
                b = Integer.parseInt(temp, 2);
                b = b + 1;
            }
        }
        String sum = Integer.toBinaryString(b);

        //to adjust 0 values on the msb
        if (sum.length() < n) 
        {
            int dif = n - sum.length();
            for (int i = 0; i < dif; i++) 
            {
                sum = sum+"0";
            }
        }
        return sum;
    }

    public static void main(String args[]) 
    {
        Scanner i1 = new Scanner(System.in);

        System.out.println("Enter number of segments (k): ");
        int k = i1.nextInt();

        System.out.println("Enter Dataword :");
        String dataword=i1.next();
        String data[] = new String[k];

        int n=dataword.length()/k;
        int c=0;

        for (int i = 0; i < k; i++) 
        {
            data[i] = dataword.substring(c,c+8);//contains data after splitted into blocks
            c=c+n;
        }

        //displays the contents - for debugging
        // for(int i=0;i<k;i++)
        // {
        //     System.out.print(data[i]);
        //     System.out.println();
        // }

        String checksum = complement(computeCheckSum(data, k), n);
        System.out.println("Check sum : " + checksum);
        System.out.print("Codeword : ");
        for(int i=0;i<k;i++)
        {
            System.out.print(data[i]);
        }
        System.out.print(checksum);
        i1.close();
    }
}


//Sample input dataword : 100110011110001000100100
// Output checksum : 01011111
