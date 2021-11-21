package debmalya.jash.odysses.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

class FileStorageImplTest {

  private FileStorageImpl fileStorageImpl = new FileStorageImpl();

  @Test
  void testGetFileContent_SingleLine() {
    MockMultipartFile mockMultipartFile =
        new MockMultipartFile("Meeting.txt", "09:00-10:00".getBytes());
    List<String> retrievedRecords = fileStorageImpl.getFileContent(mockMultipartFile);
    assertTrue(!retrievedRecords.isEmpty());
    assertTrue(retrievedRecords.size() == 1);
    assertEquals("09:00-10:00", retrievedRecords.get(0));
  }
  
  @Test
  void testGetFileContent_MultipleLine() {
    MockMultipartFile mockMultipartFile =
        new MockMultipartFile("Meeting.txt", "09:00-10:00\n10:00-11:00".getBytes());
    List<String> retrievedRecords = fileStorageImpl.getFileContent(mockMultipartFile);
    assertTrue(!retrievedRecords.isEmpty());
    assertTrue(retrievedRecords.size() == 2);
    assertEquals("09:00-10:00", retrievedRecords.get(0));
    assertEquals("10:00-11:00", retrievedRecords.get(1));
  }
}
