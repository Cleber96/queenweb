package uni.devsoft.queenweb.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController //@Controller
public class UserController {

    @RequestMapping
    public ResponseEntity<byte[]> getInit() {
        return getFileContent("static/login.jsp");
    }
    @RequestMapping("/login")
    public ResponseEntity<byte[]> getLogin() {
        return getFileContent("static/login.jsp");
    }

    @RequestMapping("/register")
    public ResponseEntity<byte[]> getRegister() {
        return getFileContent("static/register.jsp");
    }

    @RequestMapping("/board")
    public ResponseEntity<byte[]> getBoard() {
        return getFileContent("static/board.jsp");
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