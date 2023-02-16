package mx.edu.itspa.esgi.scse.config;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import mx.edu.itspa.esgi.scse.commons.Mapping;
import mx.edu.itspa.esgi.scse.commons.WSConsume;
import mx.edu.itspa.esgi.scse.model.Paths;
import mx.edu.itspa.esgi.scse.model.Person;
import mx.edu.itspa.esgi.scse.model.Student;
import mx.edu.itspa.esgi.scse.model.Teacher;
import mx.edu.itspa.esgi.scse.model.WebServices;
import mx.edu.itspa.esgi.scse.repositories.UsuarioDAO;

@Component
public class AuthenticationSuccessHandlerImpl extends SavedRequestAwareAuthenticationSuccessHandler {

	@Autowired
	private UsuarioDAO usuarioDAO;

	private static final Logger LOG = LoggerFactory.getLogger(AuthenticationSuccessHandlerImpl.class);
	private final GrantedAuthority adminAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// if redirected from some specific url, need to remove the cachedRequest to
		// force use defaultTargetUrl
		final RequestCache requestCache = new HttpSessionRequestCache();
		final SavedRequest savedRequest = requestCache.getRequest(request, response);
		if (!isAdminAuthority(authentication)) {
			String targetUrl = super.determineTargetUrl(request, response);
			// this logic is only for demo purpose, please do not use it on production
			// application.
			if (StringUtils.isBlank(targetUrl) || StringUtils.equals(targetUrl, "/")) {
				targetUrl = Paths.HOME.getPath(); // we can build custom logic
			}
			clearAuthenticationAttributes(request);
			mx.edu.itspa.esgi.scse.model.User user = usuarioDAO.findByUsername(authentication.getName());
			LOG.info("Redirecting customer to the following location {} ", targetUrl);
			Person person = getDataPerson(authentication);
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("person", person);
			// authentication.getAuthorities().forEach(role->System.out.println(role.getAuthority()));
			redirectStrategy.sendRedirect(request, response, targetUrl);

			// You can let Spring security handle it for you.
			// super.onAuthenticationSuccess(request, response, authentication);
		} else {
			// we invalidating the session for the admin user.
			invalidateSession(request, response);
		}
		clearAuthenticationAttributes(request);
	}

	protected void invalidateSession(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {
		SecurityContextHolder.getContext().setAuthentication(null);
		request.getSession().invalidate();
		redirectStrategy.sendRedirect(request, response, "/admin");
	}

	protected boolean isAdminAuthority(final Authentication authentication) {
		return CollectionUtils.isNotEmpty(authentication.getAuthorities())
				&& authentication.getAuthorities().contains(adminAuthority);
	}

	private Person getDataPerson(Authentication authentication) {
		Teacher teacher = null;
		Student student = null;
		Person manager = null;
		Set<GrantedAuthority> docente = new HashSet<GrantedAuthority>();
		Set<GrantedAuthority> estudiante = new HashSet<GrantedAuthority>();

		authentication.getAuthorities().forEach(role -> {
			switch (role.getAuthority()) {
			case Mapping.TEACHER://Debe coinsidir con la del Enum Roles
				docente.add(role);
				break;
			case Mapping.STUDENT:
				estudiante.add(role);
				break;
			}
		});
		String ws=WebServices.TEACHER_BY_KEY.getValue() + authentication.getName();
		if (docente.size() != 0) {
			teacher = WSConsume.get(ws,
					new Teacher());// agregarmos /services/ si se corre el servicio web en tomcat instalado y no en
									// el predefinido (que no se como configurarlo)
		} else if (estudiante.size() != 0) {
			student = WSConsume.get(WebServices.STUDENT_BY_CONTROL_NUMBER.getValue() + "/" + authentication.getName(),
					new Student());// agregarmos /services/ si se corre el servicio web en tomcat instalado y no en
									// el predefinido (que no se como configurarlo)
		} else {
			manager = new Person(0, "ADMINISTRATIVO", "DEL", "ITSPA");
		}
		try {
			if (teacher != null) {
				return teacher;
			} else if (student != null) {
				return student;
			} else {
				return manager;
			}
		} catch (Exception e) {
			System.out.print("Error: " + e.getMessage());
			return null;
		}
	}
}