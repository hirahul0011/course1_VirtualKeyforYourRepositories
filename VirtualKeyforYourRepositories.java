package course1_VirtualKeyforYourRepositories;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class VirtualKeyforYourRepositories {

	static String filesPath="H:\\Documents\\Study\\Simpli Learn\\PGP Program - CALTECH\\PG FSD Implement OOPS using JAVA with Data Structures and Beyond\\Assessment-VirtualKeyforYourRepositories\\File Folder";
	
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
                    	displayingTheFiles();
                        optionsSelection();
                        break;
                    case 2:
                    	optionsInnerSelection();                        
                        break;
                    case 3:                       
                        closeApp();
                        break;
                    default:
                        System.out.println("You have made an invalid choice!");
                        optionsSelection();
                        break;
                }

    }
	
	private static void optionsInnerSelection() throws IOException {
		String[] arr1 = {"\n\n1. Add a file to the existing directory list",
                "2. Delete a specified file from the existing directory list",
                "3. Search a user specified file from the directory",
                "4. Return to the main menu"
    	};		
    	System.out.println("\nPlease select the operation that you want to perform on the files\t");
    	int slen = arr1.length;    	
        for(int i=0; i<slen;i++){
            System.out.println(arr1[i]);
            // display the all the Strings mentioned in the String array
        }
        Scanner sc = new Scanner(System.in);
        int  optionsI =  sc.nextInt();
        switch (optionsI){
        	case 1:
        		System.out.println("Please enter the name for the file:");
        		String fileName =  sc.next();
        		System.out.println("Please enter the info that you want to put in the file:");
        		String data =  sc.next();
        		addAFileToDirectory(filesPath, fileName, data);
        		displayingTheFiles();  
            	System.out.println("File added to the directory successfully");
        		optionsInnerSelection();                
                break;
        	case 2:
        		System.out.println("Please enter file name that you want to delete:");
        		String fileNameD =  sc.next();
        		deleteSpecifiedFileFromDirectory(filesPath, fileNameD);        		
        		optionsInnerSelection();                
                break;
        	case 3:
        		System.out.println("Please enter file name that you want to search:");
        		String fileNameS =  sc.next();
        		searchSpecifiedFileFromDirectory(filesPath, fileNameS);
        		optionsInnerSelection();                
                break;
        	case 4:	
        		optionsSelection();
                break;
        	default:
                System.out.println("You have made an invalid choice!");
                optionsInnerSelection(); 
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
	
	private static void addAFileToDirectory(String filesPath,String fileName,String data) throws IOException
    {        
        FileOutputStream out = new FileOutputStream(filesPath+"\\"+fileName+".txt");
        out.write(data.getBytes());
        out.close();
    }
	
	private static void deleteSpecifiedFileFromDirectory(String filesPath,String fileName) throws IOException
    {        
		try
        { 
            Files.delete(Paths.get(filesPath+"\\"+fileName+".txt")); 
            System.out.println("Deletion successful.");
            System.out.println("Here is the list of remaining files:");
    		displayingTheFiles();
        } 
        catch(NoSuchFileException e) //Not throwing NoSuchFileException
        { 		        	
            System.out.println("No such file exists"); 
        } 
        catch(DirectoryNotEmptyException e) 
        { 
            System.out.println("Directory is not empty."); 
        } 
        catch(IOException e) 
        { 
            System.out.println("Invalid permissions."); 
        }	          
        
    }
	
	private static void searchSpecifiedFileFromDirectory(String filesPath,String fileName) throws IOException
	{
		File fObj = new File(filesPath);                    	  
    	if(fObj.exists() && fObj.isDirectory())  
    	{  
        	// array for the files of the directory pointed by fObj  
        	File a[] = fObj.listFiles();
        	for(int i=0;i<a.length;i++) {
        		if(a[i].isFile() && a[i].getName().equals(fileName)) {
        			System.out.println(fileName+" is available in the directory");
        			return;
        		}
        	}
        	System.out.println("Ooops! "+fileName+" is not available in the directory");
    	}		
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
	
	public static void displayingTheFiles() {
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
	}
	
	private static void closeApp() {
        System.out.println("Closing your application... \nThank you!");
            }    

}
