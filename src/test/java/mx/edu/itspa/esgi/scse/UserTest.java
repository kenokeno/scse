package mx.edu.itspa.esgi.scse;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserTest {

	@Test
	public void generarPassword() {
		BCryptPasswordEncoder passGen=new BCryptPasswordEncoder();
		System.out.println(passGen.encode("coordtut2022"));
	}
}
