package org.com.howtodo.controller;

import org.com.howtodo.helpers.ZXingHelper;
import org.com.howtodo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private UserRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.put("products", repository.findAll());
        return "product";
    }

    @RequestMapping(value = "qrcode/{id}", method = RequestMethod.GET)
    public void qrcode(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("image/png");
        OutputStream outputStream = response.getOutputStream();
        Resource resource = new ClassPathResource("static/images/logo_url.png");
        InputStream resourceInputStream = resource.getInputStream();
        System.out.println("TEST" + resourceInputStream);
        outputStream.write(ZXingHelper.generate(resourceInputStream));
        outputStream.flush();
        outputStream.close();
    }

}
