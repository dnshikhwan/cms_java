import java.util.ArrayList;

public class Contact {
    private int id;
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(int id, String name, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void updateContactId(ArrayList<Contact> contacts) {
        for (int i = 0; i < contacts.size(); i++) {
            contacts.get(i).setId(i + 1);
        }
    }

    public static void displayAllContacts(ArrayList<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("There is no contacts");
            System.out.println();
            return;
        }

        for (int i = 0; i < contacts.size(); i++) {
            System.out.println("Id: " + contacts.get(i).getId());
            System.out.println("Name: " + contacts.get(i).getName());
            System.out.println("Phone number: " + contacts.get(i).getPhoneNumber());
            System.out.println("Email: " + contacts.get(i).getEmail());
            System.out.println();
        }
    }
}
