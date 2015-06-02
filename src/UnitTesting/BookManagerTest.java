package UnitTesting;

import Model.Book;
import Model.BookManager;
import Model.BookMapper;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;


import static org.junit.Assert.assertEquals;

public class BookManagerTest {

    private Long testISBN,existingISBN;
    private String testTitle,testGenre,existingTitle,existingGenre;
    private ArrayList<String> testAuthor;
    private int testQuantity;
    private float testPrice;
    private Book testBook;
    private BookManager bookManager;

    @Before
    public void setUp()
    {
        existingISBN=1234567891120L;
        existingTitle="Harry Potter";
        existingGenre="Fantasy";
        testISBN=1111111111111L;
        testTitle="Harry Potter and the bla bla bla";
        testGenre="Fantasy";
        testAuthor=new ArrayList<String>();
        testAuthor.add("J.K. Rowling");
        testQuantity=120;
        testPrice=22.99f;
        testBook=new Book(testISBN,testTitle,testAuthor,testGenre,testQuantity,testPrice);
        bookManager = BookMapper.loadBooks();
    }

    @Test
    public void testGetBookByISBN() throws Exception {
        Book book=bookManager.getBookByISBN(existingISBN);
        if (book!=null)
        assertEquals((long) book.getISBN(),(long)existingISBN);
    }

    @Test
    public void testGetBooksByTitle() throws Exception {
        ArrayList<Book> books= bookManager.getBooksByTitle(existingTitle);
        if (!books.isEmpty()) {
            Book book = books.get(0);
            assertEquals(book.getTitle(), existingTitle);
        }
    }

    @Test
    public void testGetBooksByGenre() throws Exception {
        ArrayList<Book> books= bookManager.getBooksByGenre(testGenre);
        if (!books.isEmpty()) {
            Book book = books.get(0);
            assertEquals(book.getGenre(), testGenre);
        }
    }

    @Test
    public void testGetBooksByAuthor() throws Exception {
        ArrayList<Book> books= bookManager.getBooksByAuthor(testAuthor.get(0));
        if (!books.isEmpty()) {
            Book book = books.get(0);
            assertEquals(book.getAuthor().get(0), testAuthor.get(0));
        }
    }

    @Test
    public void testAddBooks() throws Exception {
        bookManager.addBook(testISBN, testTitle,testAuthor,testGenre,testQuantity,testPrice);
        Book book=bookManager.getBookByISBN(testISBN);
        assertEquals(testBook,book);
    }

    @Test
    public void testSellBook() throws Exception {
        int preQuantity=bookManager.getBookByISBN(existingISBN).getQuantity();
        bookManager.sellBook(existingISBN);
        int postQuantity=bookManager.getBookByISBN(existingISBN).getQuantity();
        assertEquals(preQuantity-1,postQuantity);
    }

    @Test
    public void testUpdateBook() throws Exception {

        Long newISBN=testISBN+1;
        String newTitle=testTitle+" ";
        ArrayList<String> newAuthor=new ArrayList<String>();
        newAuthor.addAll(testAuthor);
        newAuthor.add("Author X");
        String newGenre=testGenre+" ";
        int newQuantity=testQuantity+1;
        float newPrice=testPrice+1;
        Book newBook=new Book(newISBN,newTitle,newAuthor,newGenre,newQuantity,newPrice);

        bookManager.updateBook(existingISBN, newISBN, newTitle, newAuthor, newGenre, newQuantity, newPrice);
        Book updatedBook=bookManager.getBookByISBN(newISBN);
        Book oldBook = bookManager.getBookByISBN(existingISBN);

        assertEquals(oldBook,null);
        assertEquals(newBook,updatedBook);

        //rollback
        bookManager.updateBook(newISBN,existingISBN, existingTitle, testAuthor, testGenre, testQuantity, testPrice);
    }

    @Test
      public void testDeleteBook() throws Exception {

        bookManager.addBook(testISBN,testTitle,testAuthor,testGenre,testQuantity,testPrice);
        Book book=bookManager.getBookByISBN(testISBN);
        assertEquals(book,testBook);
        bookManager.deleteBook(testISBN);
        book=bookManager.getBookByISBN(testISBN);
        assertEquals(book,null);
    }
}