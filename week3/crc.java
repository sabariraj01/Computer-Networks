import java.util.Scanner;
class week3_1 
{
    public static void main(String[] ar) 
    {
        Scanner i1 = new Scanner(System.in);

        String dataword = getDataFromUser(i1);
        System.out.println("Enter the degaree of the polynomial equation : ");
        int d=i1.nextInt();
        String crcGenerator = getCRCgenerator(i1,d);
        String dividend = findDividend(d, dataword);
        String crc = division(dividend, crcGenerator);
        String codeword = dataword + crc;
        System.out.println("Codeword : " +codeword);
    }
    static String getDataFromUser(Scanner i1)
    {
        System.out.println("Enter dataword : ");
        String dw=i1.next();
        return dw;
    }

    static String getCRCgenerator(Scanner i1,int d)
    {
        String g="";
        for(int i=d;i>=0;i--)
        {
            System.out.println("Enter degree of "+i+" ");
            g=g+i1.next();
        }
        return g;
    }

    static String findDividend(int d,String dw)
    {
        String z="";
        for(int i=1;i<=d;i++)
        {
            z=z+"0";
        }
        return dw+z;
    }

    static String division(String div,String crc)
    {
        int crcLen = crc.length();
        char[] dividend = div.toCharArray();

        for (int i = 0; i <= dividend.length - crcLen; i++) 
        {
            if (dividend[i] == '1') 
            {
                for (int j = 0; j < crcLen; j++) 
                {
                    dividend[i + j] = dividend[i + j] == crc.charAt(j) ? '0' : '1';
                }
            }
        }
        return String.valueOf(dividend, dividend.length - crcLen + 1, crcLen - 1);
    }
}

