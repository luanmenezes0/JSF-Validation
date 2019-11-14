package formulario;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator ("emailValidator")
public class EmailValidator implements Validator {
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException{
		System.out.println("EmailValidator.validate()");
		String email = (String) value;
		Pattern pattern = Pattern.compile(".+@.+\\.[a-z]+");
		Matcher matcher = pattern.matcher(email);
		
		boolean matchFound = matcher.matches();
		if(!matchFound) {
			FacesMessage facesMessage = new FacesMessage();
			facesMessage.setDetail("Email inválido.");
			
			facesMessage.setSummary("o email ' " + email + 
					" ' informado é inválido");
			facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(facesMessage);
			
		}
	}
}
