
package projects;

public class LibraryService {

    /**
     * Returns the copy count after issuing one copy of a book.
     * @throws BookUnavailableException if no copies are available.
     */
    public static int issueBook(int availableCopies, String title)
            throws BookUnavailableException {

        if (availableCopies <= 0) {
            throw new BookUnavailableException(
                "'" + title + "' has no copies available."
            );
        }

        return availableCopies - 1;
    }

    /**
     * Finds a library member by their ID.
     * @param memberId the ID of the member to find
     * @return the member's name, or "Member not found"
     */
    public static String findMemberById(int memberId) {
        if (memberId == 101) {
            return "Ali";
        }

        return "Member not found";
    }
/**
 * Demonstrates book issuing and member lookup operations.
 */
    public static void main(String[] args) {

        // Test member lookup
        System.out.println("Member: " + findMemberById(101));
        System.out.println("Member: " + findMemberById(102));

        try {
            System.out.println(
                "Remaining copies: " + issueBook(3, "Clean Code")
            );

            issueBook(0, "Clean Code");

        } catch (BookUnavailableException e) {
            System.out.println(
                "Transaction failed: " + e.getMessage()
            );
        }
    }
}
