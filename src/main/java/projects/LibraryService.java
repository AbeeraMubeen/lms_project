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

    public static void main(String[] args) {

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