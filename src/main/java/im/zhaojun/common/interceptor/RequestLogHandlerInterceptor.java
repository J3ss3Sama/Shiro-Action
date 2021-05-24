package im.zhaojun.common.interceptor;

import cn.hutool.json.JSONUtil;
import im.zhaojun.common.util.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RequestLogHandlerInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(RequestLogHandlerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        TimeUtils.start();
        if (log.isDebugEnabled()) {
            log.debug("请求 URL:" + request.getRequestURI());
            log.debug("请求参数:" + JSONUtil.toJsonStr(request.getParameterMap()));
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        TimeUtils.timing("总请求");
    }
}