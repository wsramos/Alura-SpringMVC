package br.com.alura.mvc.mudi.interceptor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;

public class InterceptadorDeAcessos implements HandlerInterceptor {


	public static List<Acesso> acessos = new ArrayList<Acesso>();
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Acesso acesso = new Acesso();
		acesso.path = request.getRequestURI();
		acesso.data = LocalDateTime.now();
		
		request.setAttribute("acesso", acesso);
		
		return true;
	}
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		Acesso acesso = (Acesso)request.getAttribute("acesso");
		acesso.duracao = Duration.between(acesso.data, LocalDateTime.now());
		acessos.add(acesso);
	}
	
	@Getter @Setter
	public static class Acesso{
		private String path;
		private LocalDateTime data;
		private Duration duracao;
	}

}
