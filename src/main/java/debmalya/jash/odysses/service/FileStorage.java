package debmalya.jash.odysses.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorage {

  /**
   * @param multipartFile to be read.
   * @return all the records of file as list of String.
   */
  List<String> getFileContent(MultipartFile multipartFile);
}
