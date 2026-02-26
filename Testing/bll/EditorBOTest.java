package bll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import dal.IFacadeDAO;
import dto.Documents;

class EditorBOTest {

    @Test
    void testImportTextFilesExtension() {
        // Mock IFacadeDAO to avoid DB calls
        MockFacadeDAO mockDAO = new MockFacadeDAO();
        EditorBO editorBO = new EditorBO(mockDAO);

        // Test .md file (should be allowed now)
        // String ext = editorBO.getFileExtension("myreadme.md");
        // assertEquals("md", ext, "Extension should be 'md'");

        // Let's test getFileExtension directly
        String ext = editorBO.getFileExtension("myreadme.md");
        assertEquals("md", ext, "Extension should be 'md'");
    }

    // Helper Stub
    class MockFacadeDAO implements IFacadeDAO {
        public boolean createFileInDB(String name, String content) {
            return true;
        }

        public boolean updateFileInDB(int id, String n, int p, String c) {
            return true;
        }

        public boolean deleteFileInDB(int id) {
            return true;
        }

        public List<Documents> getFilesFromDB() {
            return new ArrayList<>();
        }

        public String transliterateInDB(int p, String t) {
            return "";
        }

        public Map<String, String> lemmatizeWords(String t) {
            return null;
        }

        public Map<String, List<String>> extractPOS(String t) {
            return null;
        }

        public Map<String, String> extractRoots(String t) {
            return null;
        }

        public double performTFIDF(List<String> u, String s) {
            return 0.0;
        }

        public Map<String, Double> performPMI(String c) {
            return null;
        }

        public Map<String, Double> performPKL(String c) {
            return null;
        }

        public Map<String, String> stemWords(String t) {
            return null;
        }

        public Map<String, String> segmentWords(String t) {
            return null;
        }
    }
}
