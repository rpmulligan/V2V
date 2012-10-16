package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import repository.LoginRepository;
import repository.UserRepository;

@Controller
public class LoginController {

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request) {

		return new ModelAndView("login");
	}

	@RequestMapping("/welcomePage")
	public ModelAndView welcome(HttpServletRequest request) {

		return new ModelAndView("welcomePage");
	}

	@RequestMapping("/loginUser")
	public ModelAndView addDonor(@RequestParam Map<String, String> params,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String username = params.get("username");
		String password = params.get("password");
		String targetUrl = params.get("targetUrl");
		User user = loginRepository.getUser(username);
		if (user != null && password.equals(user.getPassword())) {
			request.getSession().setAttribute("user", user);
			userRepository.updateLastLogin(user);
			if (StringUtils.hasText(targetUrl)) {
				response.sendRedirect("/v2v" + targetUrl);
			} else {
				response.sendRedirect("/v2v/welcomePage.html");
			}
		}
		ModelAndView modelAndView = new ModelAndView("login");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("loginFailed", true);
		modelAndView.addObject("targetUrl", targetUrl);
		modelAndView.addObject("model", model);
		return modelAndView;
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {

		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("donor");
		return new ModelAndView("login");
	}

	@RequestMapping("/adminAccessOnly")
	public ModelAndView adminAccessError(HttpServletRequest request) {

		return new ModelAndView("adminAccessOnly");
	}
}
