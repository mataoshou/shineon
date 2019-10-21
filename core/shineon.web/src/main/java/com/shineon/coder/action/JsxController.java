package com.shineon.coder.action;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

@RestController
@Slf4j
public class JsxController {

    @RequestMapping("/JSX/*.jsx")
    public void getFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String url = request.getRequestURI();

        log.info(url);

        int p1 = url.lastIndexOf("/");
        int p2 = url.lastIndexOf(".");


        String name = url.substring(p1+1,p2);

        String config =getConfig(name);
        log.info(name);
        log.info(config);

        OutputStream out = response.getOutputStream();
        out.write(config.getBytes("UTF-8"));
    }


    public String getConfig(String name)
    {
        if(name.equals("web"))
        {
            return String.format("var %s ='web';",name);
        }
        else{
            return String.format("var %s= null;",name);
        }
    }
}
