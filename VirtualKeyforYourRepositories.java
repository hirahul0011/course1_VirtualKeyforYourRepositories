package course1_VirtualKeyforYourRepositories;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class VirtualKeyforYourRepositories {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to LockedMe - From Rahul Sharma \n");
        System.out.println("**************************************");
        optionsSelection();
	}
	
	private static void optionsSelection() throws IOException {
        String[] arr = {"\n\n1. I wish to review my files",
                "2. I wish to manage my files",
                "3. Close the application"
        };
        String filesPath="H:\\Documents\\Study\\Simpli Learn\\PGP Program - CALTECH\\PG FSD Implement OOPS using JAVA with Data Structures and Beyond\\Assessment-VirtualKeyforYourRepositories\\File Folder";

        int  slen = arr.length;
        for(int i=0; i<slen;i++){
            System.out.println(arr[i]);
            // display the all the Strings mentioned in the String array
        }
        
        char my_temp;
        for(my_temp= 'A'; my_temp <= 'Z'; ++ my_temp)
            createFileUsingFileOutputStreamClass(filesPath, String.valueOf(my_temp));        
        
        
        System.out.println("\nEnter your choice:\t");
        Scanner sc = new Scanner(System.in);
        int  options =  sc.nextInt();

                switch (options){
                    case 1:
                    	File fObj = new File(filesPath);                    	  
                    	if(fObj.exists() && fObj.isDirectory())  
                    	{  
	                    	// array for the files of the directory pointed by fObj  
	                    	File a[] = fObj.listFiles();  
	                    	// display statements  
	                    	System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");  
	                    	System.out.println("Displaying Files from the directory : " + fObj);  
	                    	System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");  
	                    	// Calling the method  
	                    	printFileNames(a, 0, 0);  
                    	}  
                        
                        optionsSelection();
                        break;
                    case 2:
                        
                        optionsSelection();
                        break;
                    case 3:                       
                        closeApp();
                        break;
                    default:
                        System.out.println("You have made an invalid choice!");
                        break;
                }

    }
	
	private static void createFileUsingFileOutputStreamClass(String filesPath,String fileName) throws IOException
    {
        String data = "Test data";
        FileOutputStream out = new FileOutputStream(filesPath+"\\"+fileName+".txt");
        out.write(data.getBytes());
        out.close();
    }
	
	public static void printFileNames(File[] a, int i, int lvl)  
	{
		if(i == a.length)  
		{  
		return;  
		}	  
		if(a[i].isFile())  
		{  
		System.out.println(a[i].getName());  
		}	  
		printFileNames(a, i + 1, lvl);  
	} 
	
	private static void closeApp() {
        System.out.println("Closing your application... \nThank you!");
            }
    private static void search() {
        
    }
    private static void sort() {
        
    }

}
