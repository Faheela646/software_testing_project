package dal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.List;
import dto.Pages;

class PaginationDAOTest {

    @Test
    void testPaginationByWords() {
        // Create a string with 150 words
        StringBuilder contentBuilder = new StringBuilder();
        for (int i = 0; i < 150; i++) {
            contentBuilder.append("word").append(i).append(" ");
        }
        String content = contentBuilder.toString();

        List<Pages> pages = PaginationDAO.paginate(content);

        // Should be 2 pages (100 words + 50 words)
        assertEquals(2, pages.size(), "Should verify 150 words are split into 2 pages (100 + 50)");

        // Verify first page has 100 words
        String page1 = pages.get(0).getPageContent();
        assertEquals(100, page1.split("\\s+").length, "First page should have 100 words");
    }
}
