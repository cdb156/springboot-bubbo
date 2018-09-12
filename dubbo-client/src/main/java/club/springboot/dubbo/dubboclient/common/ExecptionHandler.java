package club.springboot.dubbo.dubboclient.common;

import club.springboot.dubbo.dubboclient.exception.SystemErrorException;
import org.omg.CORBA.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ldj
 * @date 2018/09/12
 */
@ControllerAdvice
public class ExecptionHandler {

    private static Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public @ResponseBody SystemErrorException dealSystemErrorException(HttpServletRequest request, Exception ex) {
        return new SystemErrorException(request.getRequestURI(), ex.getMessage());
    }

}
