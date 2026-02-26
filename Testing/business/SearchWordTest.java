package business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import bll.SearchWord;
import dto.Documents;
import dto.Pages;

class SearchWordTest {

    @Test
    void testSearchWordAllPages() {
        // Setup: Create a document with the keyword "test" on page 1 AND page 2
        // IF the bug exists (break after first match), it would only return 1 result
        // (lines from page 1)
        // IF fixed, it should return lines from both pages.

        // Note: SearchWord.searchKeyword(keyword, List<Documents>)

        // Mock a Document
        List<Pages> pages = new ArrayList<>();
        pages.add(new Pages(1, 1, 1, "This is a test on page one."));
        pages.add(new Pages(2, 1, 2, "This is another test on page two."));

        Documents doc = new Documents(1, "Doc1", "hash", "date", "date", pages);
        List<Documents> allDocs = new ArrayList<>();
        allDocs.add(doc);

        List<String> results = SearchWord.searchKeyword("test", allDocs);

        // Expected: 2 hits (one from page 1, one from page 2)
        assertEquals(2, results.size(), "Should find 'test' on both pages. If bug #6 persists, size will be 1.");
    }
}
