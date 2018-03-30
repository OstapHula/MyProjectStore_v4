package ua.springboot.web.controller;


import java.io.IOException;
import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.springboot.web.domain.EditUserRequest;
import ua.springboot.web.domain.ProductRequest;
import ua.springboot.web.domain.UploadImageRequest;
import ua.springboot.web.entity.UserEntity;
import ua.springboot.web.mapper.UserMapper;
import ua.springboot.web.service.UserService;
import ua.springboot.web.service.utils.CustomFileUtils;

@Controller
@RequestMapping({"/user", "/admin"})
@SessionAttributes("editUserModel")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public String showUserProfile(Model model, Principal principal) throws IOException{
	UserEntity entity = userService.findUserByEmail(principal.getName());
	if(entity == null) return "redirect:/";
	
	CustomFileUtils.createFolder("user_" + entity.getId());
	entity.setImagePath(CustomFileUtils.getImage("user_" + entity.getId(), entity.getImagePath()));
	
	model.addAttribute("title", entity.getRole().getRole() + " profile");
	model.addAttribute("userProfile", UserMapper.entityUserToUserRequest(entity));
	return "user/profile";
    }
    
    
//  @PostMapping("/profile/image")
//  private String saveImage(@ModelAttribute ("uploadImage") ImageRequest request, Principal principal) throws IOException{
//	UserEntity entity = userService.findUserByEmail(principal.getName());
//	entity.setImagePath(request.getFile().getOriginalFilename());
//	CustomFileUtils.createFolder("user_" + entity.getId());
//	CustomFileUtils.createImage("user_" + entity.getId(), request.getFile());
//	
//	return "redirect:/user";
//  }
	
    
    @GetMapping("/edit")
    public String editUserProfile(Model model, Principal principal){
	UserEntity entity = userService.findUserByEmail(principal.getName());	
	EditUserRequest request = UserMapper.entityUserToEditRequest(entity);
	
	model.addAttribute("title", "Edit profile page");
	model.addAttribute("editUserModel", request);
	return "user/edit";
    }
    
    @PostMapping("/edit")
    public String saveEditedProfile(
	    @ModelAttribute ("editUserModel") @Valid EditUserRequest request, 
	    BindingResult result){
	if(result.hasErrors()) return "redirect:/user/edit";
	
	UserEntity entity = UserMapper.editRequestToUserEntity(request);
	userService.updateUser(entity);
	
	return "redirect:/user";
    }
    
    @GetMapping("/new_product")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String createProduct(Model model){
	model.addAttribute("title", "Create new product");
	model.addAttribute("productModel", new ProductRequest());
	model.addAttribute("ImageModel", new UploadImageRequest());
	return "admin/new_product";
    }
    
    
    
}
