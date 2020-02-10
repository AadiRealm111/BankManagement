import java.io.*;
public class Account
{
    long accno;
    String acchold;
    long mondep;
    String acctyp;
    void create_account(long a, String s, long m, String b)
    {
        accno = a;
        acchold = s;
        mondep = m;
        acctyp = b;
    }
    void display()
    {
        System.out.println("Account Number - "+accno);
        System.out.println("Account holder - "+acchold);
        System.out.println("Amount Deposited - "+mondep);
        System.out.println("Account Type - "+acctyp);
    }
    void modify()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     System.out.println("Do you want to modify anything?");
     System.out.println("Enter Yes or No");
     String s = br.readLine();
     s = s.toUpperCase();
     if(s=="YES")
     {
         System.out.println("Enter A to change Account Holder Name");
         System.out.println("Enter B to change Account Number");
         System.out.println("Enter C to change Money Deposited");
         System.out.println("Enter D to change Account Type");
         int c = 0;
         while(c==0)
         {
             String st = br.readLine();
             st = st.toUpperCase();
             if(st =="A")
             {
                 System.out.println("Enter the new Account Holder name");
                 acchold = br.readLine();
                 c = 1;
             }
             else if(st=="B")
             {
                 System.out.println("Enter the new Account Number");
                 accno = Integer.parseInt(br.readLine());
                 c = 1;
             }
             else if(st=="C")
             {
                 System.out.println("Enter the Money deposited");
                 mondep = Integer.parseInt(br.readLine());
                 c = 1;
             }
             else if(st=="D")
             {
                 System.out.println("Enter the new Account type");
                 acctyp = br.readLine();
                 c = 1;
             }
             else
             {
                 System.out.println("Wrong choice. Enter again");
                 c = 0;
             }
         }

     }
    }
    void deposit(long a)
    {
        mondep += a;
        System.out.println("The new amount in the account is"+mondep);
    }
    void draw(long a)
    {
        mondep -= a;
        System.out.println("The new amount in the account is"+mondep);
    }
    void report()
    {
        System.out.println("Account no \t Account Holder name \t Account type \t Total Amount");
        System.out.println(accno+"\t"+acchold+"\t"+acctyp+"\t"+mondep);
    }
    long getAccno()
    {
        return accno;
    }
    long getMondep()
    {
        return mondep;
    }
    String getAcctyp()
    {
        return acctyp;
    }
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Account ob = new Account();
        System.out.println("Enter the Account number, Account Holder name, Money deposited, Account type");
        ob.create_account(Long.parseLong(br.readLine()),br.readLine(),Long.parseLong(br.readLine()),br.readLine());
        ob.display();
        ob.report();
    }

}
