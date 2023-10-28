    package mykkJava;
    import java.io.File; 
    import java.io.FileInputStream;
    import java.io.FileWriter;
     
    import java.io.IOException;   
     class fileHandl {  
                   public static void main(String args[]) {  
                   int i=5;
                   String table="";
                   for(int j=0; j<10;j++){ 
                       table+=i+ "X"+(j+1)+ "="+ i*(j+1); 
                       table+="\n"; 
                   }
                   try {
                       FileWriter file=new FileWriter("multiplication.txt");
                       file.write(table);
                       file.close();
                   }catch (IOException e){
                       e.printStackTrace();
                   }
       
                }  
    }  