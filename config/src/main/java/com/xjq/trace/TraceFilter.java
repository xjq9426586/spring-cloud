package com.xjq.trace;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@WebFilter("/**")
@Component
public class TraceFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // 从请求头中获取traceId
        String traceId = (String) request.getAttribute("traceId");
        // 不存在就生成一个
        if (traceId == null || "".equals(traceId)) {
            traceId = UUID.randomUUID().toString();
        }
        // 放入MDC中
        MDC.put("traceId", traceId);
        request.setAttribute("traceId", traceId);
        chain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}