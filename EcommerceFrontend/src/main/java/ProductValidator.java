import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.niit.EcommerceBackend.model.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Product product=(Product)target;
		if(product.getFile()==null || product.getFile().getOriginalFilename().equals(""))
		{
			errors.rejectValue("file",null,"Please select the file to Upload !!!");
			return;
		}
		
		if(! (product.getFile().getContentType().equals("images/jpg") ||
				product.getFile().getContentType().equals("images/jpeg")||
				product.getFile().getContentType().equals("images/png")||
				product.getFile().getContentType().equals("images/gif") )) 
		{
			errors.reject(null);
			
		}
	}

}
