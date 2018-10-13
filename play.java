import java.util.Scanner;

class tictac
{
	String name;
	int id;
	static String b[][]=new String[9][12];
	tictac(String s,int i)
	{
		id = i;
		name = s;
	}
	
	static void initial()
	{
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<12;j++)
			{
				if(i==0 || i==8 || j==0 || j==11)
					b[i][j]=" ";
				else if(i%3==0)
					b[i][j]="_";
				else if(j%4==0)
					b[i][j]="|";
				else
					b[i][j]=" ";
			}
		}
	}
	boolean plays()
	{
	Scanner sc=new Scanner(System.in);
		System.out.println("It's "+this.name+" turn"+"\n enter position to be enter");
		int a = sc.nextInt();
		if(a>=0 && a<9)
		{
			int r = (a/3)*3+1;
			int c = (a%3)*4+2;
			if(this.id==0)
				b[r][c]="x";
			else
				b[r][c]="o";
		}
		print();
		if(check(a))
		{
			System.out.println(this.name +" win this match ");
			return true;
		}
		else
		{
			return false;
		}
		
	}
	boolean check(int a)
	{
		if(a==0)
			return(frow()||fcol()||fdig());
		else if(a==1)
			return(frow()||scol());
		else if(a==2)
			return(frow()||fcol()||sdig());
		else if(a==3)
			return(srow()||fcol());
		else if(a==4)
			return(srow()||scol()||fdig()||sdig());
		else if(a==5)
			return(srow()||tcol());
		else if(a==6)
			return(trow()||fcol()||sdig());
		else if(a==7)
			return(trow()||scol());
		else
			return(trow()||tcol()||fdig());
	}
	boolean frow()
	{
		if(b[1][2]==b[1][6] && b[1][2]==b[1][10])
			return true;
		return false;
	}
	boolean srow()
	{
		if(b[4][2]==b[4][6] && b[4][2]==b[4][10])
			return true;
		return false;
	}
	boolean trow()
	{
		if(b[7][2]==b[7][6] && b[7][2]==b[7][10])
			return true;
		return false;
	}
	boolean fcol()
	{
		if(b[1][2]==b[4][2] && b[1][2]==b[7][2])
			return true;
		return false;
	}
	boolean scol()
	{
		if(b[1][6]==b[4][6] && b[1][6]==b[7][6])
			return true;
		return false;
	}
	boolean tcol()
	{
		if(b[1][10]==b[4][10] && b[1][10]==b[7][10])
			return true;
		return false;
	}
	boolean fdig()
	{
		if(b[1][2]==b[4][6] && b[1][2]==b[7][10])
			return true;
		return false;
	}
	boolean sdig()
	{
		if(b[1][10]==b[4][6] && b[1][10]==b[7][2])
			return true;
		return false;
	}
	void print()
	{
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<12;j++)
			{
				System.out.print(b[i][j]);
			}
		System.out.println();
		}
	}
}

class play
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name of first player");
		String a = sc.next();
		tictac t[]=new tictac[2];
		t[0] = new tictac(a,0);
		System.out.println("Enter name of second player");
		String b = sc.next();
		t[1] = new tictac(b,1);
	tictac.initial();
		t[0].print();
		int i=0;
		for(;i<9;i++)
		{
			int j=i%2;
			boolean w=t[j].plays();
			if(w)
				break;
		}
		if(i==9)
			System.out.println("Match draw");
	}
}