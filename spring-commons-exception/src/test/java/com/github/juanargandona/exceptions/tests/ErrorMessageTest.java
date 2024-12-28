package com.github.juanargandona.exceptions.tests;

import com.github.juanargandona.exceptions.impl.BadRequestException;
import com.github.juanargandona.exceptions.model.ErrorMessage;
import com.github.juanargandona.exceptions.model.ExceptionDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;

class ErrorMessageTest {

	@Test
	public void ErrorMessageTest() {
		//new ExceptionFactory().getException(null,null);
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		ExceptionDetail detail = new ExceptionDetail("", "", Optional.empty());
		ErrorMessage errorMessage = new ErrorMessage(Arrays.asList(detail), request);
		ErrorMessage errorMessage1 = new ErrorMessage(Arrays.asList(detail), request);
		System.out.println(errorMessage);
		Assertions.assertEquals(errorMessage.getDetails(), errorMessage1.getDetails());
		Assertions.assertEquals(errorMessage.getPath(), errorMessage1.getPath());
		Assertions.assertEquals(errorMessage.getDetails().get(0).getErrorCode(), errorMessage1.getDetails().get(0).getErrorCode());
		Assertions.assertEquals(errorMessage.getDetails().get(0).getErrorDetail(), errorMessage1.getDetails().get(0).getErrorDetail());
		Assertions.assertEquals(errorMessage.getDetails().get(0).getErrorMessage(), errorMessage1.getDetails().get(0).getErrorMessage());
		Assertions.assertEquals(errorMessage.getDetails().get(0).getMetaData(), errorMessage1.getDetails().get(0).getMetaData());

	}

	@Test
	public void ErrorMessageTestStack() {
		try {
			throw new BadRequestException("a", "b", Optional.of("asd"));
		} catch (BadRequestException e) {
			e.printStackTrace();
		} catch (Exception e) {
			Assertions.fail("error in exception create");
		}
	}
}
