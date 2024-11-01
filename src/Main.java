/*
1. Add a new contact with fields (name, phone number, email) [X]
2. Remove existing contact by name [X]
3. View all contacts with details displayed [X]
4. Search contact by name to display details [X]
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Contact> contacts = new ArrayList<>();

        int command = 0;


        boolean flag = true;
        while (flag) {

            printMenu();

            try {
                command = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                scanner.next();
            }

            switch (command) {
                case 1:
                    System.out.println("Please enter name:");
                    scanner.nextLine();
                    String name = scanner.nextLine();

                    String phoneNumber = "";
                    boolean flag_2 = true;
                    while (flag_2) {
                        System.out.println("Please enter phone number:");
                        phoneNumber = scanner.nextLine();
                        Pattern pattern = Pattern.compile("[\\d]{11}");
                        Matcher matcher = pattern.matcher(phoneNumber);

                        if (matcher.matches()) {
                            flag_2 = false;
                        } else {
                            System.out.println("Please enter a valid phone number!");
                        }
                    }


                    String email = "";
                    boolean flag_3 = true;
                    while (flag_3) {
                        System.out.println("Please enter email address:");
                        email = scanner.nextLine();
                        Pattern pattern = Pattern.compile("^[\\w-\\.]+@[\\w-\\.]+\\.[a-z]{2,}$");
                        Matcher matcher = pattern.matcher(email);

                        if (matcher.matches()) {
                            flag_3 = false;
                        } else {
                            System.out.println("Please enter a valid email address!");
                        }
                    }

                    Contact contact = new Contact(contacts.size() + 1, name, phoneNumber, email);
                    //add contact to contacts list
                    contacts.add(contact);

                    System.out.println("---CONTACT CREATED---");

                    break;
                case 2:
                    Contact.displayAllContacts(contacts);

                    System.out.println("Please enter contact name to be removed: ");
                    scanner.nextLine();
                    name = scanner.nextLine();

                    boolean found = false;
                    for (int i = 0; i < contacts.size(); i++) {
                        if (name.equalsIgnoreCase(contacts.get(i).getName())) {
                            contacts.remove(i);
                            System.out.println("---CONTACT REMOVED---");
                            found = true;
                            break;
                        }
                    }

                    // update contact id
                    Contact.updateContactId(contacts);

                    // what happen if not found
                    if (!found) {
                        System.out.println("Not found");
                    }

                    break;
                case 3:
                    System.out.println("Contacts list:");
                    Contact.displayAllContacts(contacts);
                    break;
                case 4:
                    if (contacts.isEmpty()) {
                        System.out.println("No contacts, please add one");
                        break;
                    }

                    System.out.println("Please enter contact name:");
                    scanner.nextLine();
                    name = scanner.nextLine();

                    found = false;
                    for (int i = 0; i < contacts.size(); i++) {
                        if (name.equalsIgnoreCase(contacts.get(i).getName())) {
                            System.out.println("Name: " + contacts.get(i).getName());
                            System.out.println("Phone number: " + contacts.get(i).getPhoneNumber());
                            System.out.println("Email: " + contacts.get(i).getEmail());
                            System.out.println();
                            found = true;
                            break;
                        }
                    }

                    // what if name not found
                    if (!found) {
                        System.out.println("Not found");
                    }

                    break;
                case 5:
                    System.out.println("---GOODBYE!---");
                    flag = false;
                    break;
            }
        }

        scanner.close();
    }

    public static void printMenu() {
        System.out.println();
        System.out.println("Please choose a command:");
        System.out.println("1. Add a new contact");
        System.out.println("2. Remove an existing contact");
        System.out.println("3. View all contacts");
        System.out.println("4. Search contacts");
        System.out.println("5. Exit");
        System.out.println();
    }
}