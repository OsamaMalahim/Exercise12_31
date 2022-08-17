import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hellow World !");
        int year=0;
        String gender= null;
        // ask user to enter year gender name print ranking result
        Scanner input = new Scanner(System.in);
        // ask for year and check
        System.out.print("Enter Year (2001 - 2003) : ");
        if (input.hasNextInt()){        // check if input is integer
             year = input.nextInt();
            if (!   (   year ==2001  || year == 2002 ||  year == 2003  )){      // check allowed year
                System.out.println("Year Shall be only 2001 - 2003");
                System.exit(150);
            }
        }else {
            System.out.println("only years allowed !");
            System.exit(151);
        }

        // ask for gender and check
        System.out.print("Enter Gender (M/F): ");
        if (input.hasNext()){       //check for input is string
             gender = input.next();
            if (!(gender.equals("M")|| gender.equals("F"))){        // check for F or M only
                System.out.println("Gender Should be M or F only !");
                System.exit(140);
            }
        }

        // ask for name and check
        System.out.print("Enter Name: ");       // name check will be for is letter only
        String name = input.next();
        char[] c = name.toCharArray();
        for (int i=0;i<c.length;i++){
            if (!Character.isLetter(c[i])){
                System.out.println("Names allowed in Alphabet Only");
                System.exit(160);
            }
        }
        // read the required file based on year
        String boyRank = null;
        String  girlRank = null;
        File file= new File("population/Popularityin"+year+".txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            if (gender.equals("M")){
                String[] s= line.split("\t");
                if (name.equals(s[1])){
                    boyRank=s[0];
                }
            }
            if (gender.equals("F")){
                String[] s= line.split("\t");
                if (name.equals(s[3])){
                    girlRank = s[0];
                }
            }
        } // end while
        if (gender.equals("M") && boyRank != null){
            System.out.println(name+" is ranked: "+boyRank+" in year: "+year);
        }else if (gender.equals("F") && girlRank != null){
            System.out.println(name+" is ranked: "+girlRank+" in year: "+year);
        } else if (gender.equals("M") && boyRank == null) {
            System.out.println("The name: "+ name+" is not ranked in year "+year);
        } else if (gender.equals("F") && girlRank == null) {
            System.out.println("The name: "+ name+" is not ranked in year "+year);
        }





    }
}
