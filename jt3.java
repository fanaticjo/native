import java.io.*;
public class Copy
        {
        public static void main(String args[])
                {
                try{
                FileInputStream fis=new FileInputStream("d:/Summer4pm/c23/Copy.java");
                FileOutputStream fos=new FileOutputStream("d:/Summer4pm/jt3.java");
                int ch;
                System.out.println("\nCopy the contents.\n");
                while((ch=fis.read())!=-1)
                        {
                        fos.write(ch);
                        }
                fis.close();
                fos.close();
                }catch(FileNotFoundException fe)
                        {
                        System.out.println("File Not Found.");
                        }
                catch(IOException ie)
                        {
                        }
                }
                }





