package ua.springboot.web.domain;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@Getter
@Setter
public class EditUserRequest {

    	private int id;
    	private String email;
	private String firstName;
	private String lastName;
	private String address;
	private String telephone;
	private Date birthday;
	private MultipartFile file;
    
}
