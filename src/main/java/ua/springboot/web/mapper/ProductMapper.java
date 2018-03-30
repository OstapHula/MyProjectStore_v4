package ua.springboot.web.mapper;

import ua.springboot.web.domain.ProductRequest;
import ua.springboot.web.domain.UploadImageRequest;
import ua.springboot.web.entity.ParametersProductEntity;
import ua.springboot.web.entity.ProductEntity;

public interface ProductMapper {
    
    public static ProductEntity ProductRequestToProductEntity(ProductRequest request){
	ParametersProductEntity parameters = new ParametersProductEntity();
	
	parameters.setStyle(request.getStyle());
	parameters.setMaterialStrap(request.getMaterialStrap());
	parameters.setMaterialBody(request.getMaterialBody());
	parameters.setFaseType(request.getFaseType());
	parameters.setFaseColor(request.getFaseColor());
	parameters.setWeight(request.getWeight());
	parameters.setWaterproof(request.getWaterproof());
	parameters.setGlass(request.getGlass());
	parameters.setWidthStrap(request.getWidthStrap());
	parameters.setDiametrBody(request.getDiametrBody());
	parameters.setThicknessBody(request.getThicknessBody());
	
	ProductEntity entity = new ProductEntity();
	entity.setName(request.getName());
	entity.setPrice(request.getPrice());
	entity.setDescription(request.getDescription());
	entity.setImagePath(request.getImagePath());
	entity.setParameters(parameters);
	
	return entity;
    }
    
    public static ProductEntity UploadImageRequestToPoductImageEntity(UploadImageRequest request){
	ProductEntity entity = new ProductEntity();
	
	entity.setImagePath(request.getFile().getOriginalFilename());
	
	return entity;
    }
     
}
