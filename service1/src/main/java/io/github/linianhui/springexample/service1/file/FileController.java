package io.github.linianhui.springexample.service1.file;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import io.github.linianhui.springexample.service2.Service2FileClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "/v1/file")
public class FileController {

    @Autowired
    private Service2FileClient service2FileClient;

    @Autowired
    private HttpServletRequest request;

    @PostMapping("upload")
    public Object uploadFile(
        final @RequestPart(name = "id") String id,
        final @RequestPart(name = "pojo", required = false) Map pojo,
        final @RequestPart(name = "files") MultipartFile multipartFiles
    ) {
        return service2FileClient.uploadFile(id, multipartFiles);
    }
}
