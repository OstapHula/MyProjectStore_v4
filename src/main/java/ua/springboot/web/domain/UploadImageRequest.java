package ua.springboot.web.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@Getter
@Setter
public class UploadImageRequest {
    
    private MultipartFile file;
    
}
