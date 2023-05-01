package cibertec.edu.pe.projectowebfinal.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
public class CustomErrorController {
    @RequestMapping("*")
    public String handleNotFound() {
        return "error/404";
    }
}
