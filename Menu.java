
import java.util.Scanner;

public class Menu {
    static boolean quit;  
    Menu m = new Menu();
    
    public static void main(String ards[]) {
        printMenu();
        runMenu();
        
    }
   private static void printMenu() {
       System.out.println("(0) Quit");
       System.out.println("---------");
       System.out.println("(1) créer un Client");
       System.out.println("(2) trouver un Client");
       System.out.println("(3) supprimer un Client");
       System.out.println("(4) mettre à jour un Client");
   }
   public static void runMenu(){
        while (!quit) {
          int choice=getInput();
          performAction(choice);
           
       }
   }   
       private static int getInput() {
           Scanner kb = new Scanner(System.in);
           int choice = -1;
           while (choice <0 || choice >4) {
               try {
                   System.out.print("\n entrer votre choix: ");
                   choice =Integer.parseInt(kb.nextLine());
                }
               catch (NumberFormatException e) {
                   System.out.println("selection Invalide. please try again");
               }
            }
           return choice;
       }
       private void  performAction(int choice)   { 
           switch(choice) {
               case 0: { quit = true;
                         System.out.println("merci d'avoir utiliser notre application");
                         break;
               }
               case 1: { m.createClient();
                         break;
               }
               case 2: { Client c = findClient(String id);
                         break;
               }
               case 3: { removeClient(String id);
                         break;
               }
               case 4: { updateClient(String id);
                         break;
               }
               default: System.out.println(" erreur");
           }
       }
    }
       
}
