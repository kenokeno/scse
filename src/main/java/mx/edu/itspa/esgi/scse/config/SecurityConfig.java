package mx.edu.itspa.esgi.scse.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import mx.edu.itspa.esgi.scse.service.UsuarioServiceImpl;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	@Qualifier("usuarioServiceImpl")
	private UsuarioServiceImpl usarioServiceImpl;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(usarioServiceImpl).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	private static final String[] PUBLIC_MATCHERS = {
            "/css/**",
            "/js/**",
            "/data/**",
            "/sound/**",
            "/img/**",
            "/",
            "/login",
            "/logout",
            "/error",
    };
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers(PUBLIC_MATCHERS).permitAll()
		.antMatchers("/home*").authenticated()
		.antMatchers("/department/**").authenticated()
		.antMatchers("/streport/**").hasAnyAuthority("TUTOR","REPRESENTANTE COORDINACION DE TUTORIAS","JEFE DEL DEPARTAMENTO DE DESARROLLO ACADÉMICO","SUBDIRECTOR ACADÉMICO", "JEFE DE DIVISIÓN")
		.antMatchers("/cmreport/**").hasAnyAuthority("DOCENTE","JEFE DE DIVISIÓN","SUBDIRECTOR ACADÉMICO")
		.and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/home/", true)
		.permitAll()
		.successHandler(successHandler())
		.and()
		.exceptionHandling().accessDeniedHandler(accessDeniedHandler())
		.and()
		.logout().permitAll();
		
	}
	
	@Bean
	public AuthenticationSuccessHandlerImpl successHandler() {
	    return new AuthenticationSuccessHandlerImpl();
	}

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
	   return new CustomAccessDeniedHandler();
	}
}
