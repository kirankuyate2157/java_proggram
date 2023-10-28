// package mykkJava;
import java.util.HashSet;
import java.util.Scanner;
public class pairSum{ 
	
	public static void main(String []args){
		try {Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int sum=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		HashSet<Integer> set=new HashSet<>();
		for(int i=0;i<n;i++) {
			if(set.contains(sum-arr[i])) {
				System.out.print("("+arr[i]+","+(sum-arr[i])+"),");
			}
			set.add(arr[i]);
		}}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

