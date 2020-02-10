import java.io.*;
public class Account
{
    static int n;
    static long accno[]= new long[n];
    static String acchold[] = new String[n];
    static long mondep[] = new long[n];
    static String acctyp[] = new String[n];
    static int p;
    Account(int z)
    {
      n = z;
      p =0;
    }
    void create_account(long a, String s, long m, String b)
    {
        accno[p++] = a;
        acchold[p++] = s;
        mondep[p++] = m;
        acctyp[p++] = b;
    }
    void display()
    {
        System.out.println("Account Number - "+accno);
        System.out.println("Account holder - "+acchold);
        System.out.println("Amount Deposited - "+mondep);
        System.out.println("Account Type - "+acctyp);
    }
    void modify(int x)throws IOException
    {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
                 acchold[x] = br.readLine();
                 c = 1;
             }
             else if(st=="B")
             {
                 System.out.println("Enter the new Account Number");
                 accno[x] = Integer.parseInt(br.readLine());
                 c = 1;
             }
             else if(st=="C")
             {
                 System.out.println("Enter the Money deposited");
                 mondep[x] = Integer.parseInt(br.readLine());
                 c = 1;
             }
             else if(st=="D")
             {
                 System.out.println("Enter the new Account type");
                 acctyp[x] = br.readLine();
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
    void deposit(long a,int b)
    {
        mondep[b] += a;
        System.out.println("The new amount in the account is"+mondep);
    }
    void draw(long a,int b)
    {
        mondep[b] -= a;
        System.out.println("The new amount in the account is"+mondep);
    }
    void report()
    {
        System.out.println("Account Number" + "\t" + "Account Holder Name" + "\t" + "Amount" + "\t" + "Account Type");
        for (int i = 0; i <= p; i++) {
            System.out.println(accno[i] + "\t" + acchold[i] + "\t" + mondep[i] + "\t" + acctyp[i]);
        }
    }
    static long getAccno(int c)
    {
        return accno[c];
    }
    static long getMondep(int c)
    {
        return mondep[c];
    }
    static String getAcctyp(int c)
    {
        return acctyp[c];
    }
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("------------This is your command line interface---------------");
        System.out.println("Type input followed by Account Holder name, Account Number, Money Deposited, Account Type");
        System.out.println("Type mod to modify along with query number");
        System.out.println("Type mondep followed by query number to deposit money");
        System.out.println("Type dis to display the database");
        System.out.println("Type mondep followed by query followed by amount");
        System.out.println("Type mondraw followed by query followed by amount");
        System.out.println("Type get followed by command follwed by query no");
        System.out.println("Enter the range of databse");
        int n =Integer.parseInt(br.readLine());
        Account ob = new Account(n);
        int c = 1;
        while(c==1)
        {
        String s = br.readLine();
        String ar[] = s.split(" ");
        if(ar[0]=="input")
        {
            if(p<n) {
                int m = Integer.parseInt(ar[2]);
                int h = Integer.parseInt(ar[3]);
                ob.create_account(m,ar[1],h,ar[4]);
            }
            else{
                System.out.println("Database Full");
            }
        }
        else if(ar[0]=="mod") {
            if (Integer.parseInt(ar[1]) <= n) {
                ob.modify(Integer.parseInt(ar[1]) - 1);
            } else {
                System.out.println("Wrong query input");
            }
        }
        else if(ar[0]=="dis")
        {
            if(p==0)
            {
                System.out.println("Empty Databse");
            }
            else {
                ob.display();
            }
        }
        else if(ar[0]=="mondep")
        {
            int a = Integer.parseInt(ar[1]);
            long b = Integer.parseInt(ar[2]);
            if(a<=(p+1))
            {
                ob.deposit(b,a-1);
            }
            else
            {
                System.out.println("Invalid Query No");
            }
        }
        else if(ar[0]=="mondraw")
        {
            int a = Integer.parseInt(ar[1]);
            long b = Integer.parseInt(ar[2]);
            if(a<=(p+1)) {
                if (mondep[a - 1] >= b)
                    ob.draw(b, a - 1);
                else
                    System.out.println("Not Sufficient Amount");
            }
            else
            {
                System.out.println("Invalid Query No");
            }
        }
        else if(ar[0]=="get")
        {
            if((Integer.parseInt(ar[2])-1)<=p)
            {
                if (ar[1] == "accno") {
                    System.out.println(getAccno(Integer.parseInt(ar[2]) - 1));
                } else if (ar[1] == "mondep") {
                    System.out.println(getMondep(Integer.parseInt(ar[2]) - 1));
                } else if (ar[1] == "acctype") {
                    System.out.println(getAcctyp(Integer.parseInt(ar[2]) - 1));
                } else {
                    System.out.println("wrong command");
                }
            }
            else
                System.out.println("Invalid query no");
        }
        else
        {
            System.out.println("Wrong Command");
        }
        System.out.println("Enter 1 to continue 2 to end");
        c = Integer.parseInt(br.readLine());
        }


    }

}
