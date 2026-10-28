public class AccessCheck {
    public static void main(String[] args) {
        int age = 17;
        int securityPin = 4321;

        if (age >= 18) {
            System.out.println("Adult Account Verified.");
        }

        if (securityPin == 4321) {
            System.out.println("Access Granted");
        } else {
            System.out.println("Access Denied: Invalid PIN");
        }
    }
}