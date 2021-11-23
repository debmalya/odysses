package debmalya.jash.odysses.service;

import debmalya.jash.odysses.exception.StorageException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
public class FileStorageImpl implements FileStorage {

	@Override
	public List<String> getFileContent(MultipartFile multipartFile) {
		if (multipartFile.isEmpty()) {
			throw new StorageException("No input file specified");
		}

		List<String> lines = new ArrayList<>();
		try {
			String content = new String(multipartFile.getBytes());
			lines = Arrays.asList(content.split("\\n"));
		} catch (IOException e) {
			log.error(e.getMessage());
			throw new StorageException(String.format("Failed to read file: %s", multipartFile.getOriginalFilename()),
					e);
		}

		return lines;
	}

	@Override
	public List<String> getFileContent(String fileName) throws IOException {
		Path path = Paths.get(fileName);
		return Files.readAllLines(path);
	}
}
