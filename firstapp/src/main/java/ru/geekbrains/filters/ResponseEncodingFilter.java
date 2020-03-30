package ru.geekbrains.filters;


import org.slf4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;


@WebFilter("/*")
public class ResponseEncodingFilter
		implements Filter
{

  private static Logger logger = getLogger(ResponseEncodingFilter.class);
  private FilterConfig filterConfig;


  @Override
  public void init(FilterConfig fc)
  {
	filterConfig = fc;
  }


  @Override
  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
  throws IOException, ServletException
  {
	resp.setCharacterEncoding("UTF-8");
	resp.setContentType("text/html;charset=UTF-8");
	logger.info("кодировка ответа установлена");
	chain.doFilter(req, resp);
  }


  @Override
  public void destroy()
  {
	filterConfig = null;
  }

}