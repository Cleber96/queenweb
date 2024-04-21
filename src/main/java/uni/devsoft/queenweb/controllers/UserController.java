package uni.devsoft.queenweb.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.io.InputStream;

@RestController
public class UserController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<byte[]> getInit() {
        return getFileContent("templates/login.html");
    }

    @GetMapping(value = "/login", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<byte[]> getLogin() {
        return getFileContent("templates/login.html");
    }

    @GetMapping(value = "/register", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<byte[]> getRegister() {
        return getFileContent("templates/register.html");
    }

    @GetMapping(value = "/board", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<byte[]> getBoard() {
        return getFileContent("templates/board.html");
    }

    private ResponseEntity<byte[]> getFileContent(String filePath) {
        try {
            Resource resource = new ClassPathResource(filePath);
            byte[] data = StreamUtils.copyToByteArray(resource.getInputStream());
            return ResponseEntity.ok().headers(getHeaders(data)).body(data);
        } catch (IOException e) {
            return ResponseEntity.notFound().build();
        }
    }

    private HttpHeaders getHeaders(byte[] data) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);
        headers.setContentLength(data.length);
        return headers;
    }
}