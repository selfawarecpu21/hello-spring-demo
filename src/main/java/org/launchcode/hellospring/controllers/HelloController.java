package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


// @ResponseBody putting this annotation here will allow all methods in controller class to inherit @ResponseBody
// @RequestMapping("/") every method in this class the url will begin with /, http://localhost:8080/
@Controller // Controller class specifies that there are methods within the class that can handle HTTP methods
public class HelloController {

    @GetMapping("hello") // @GetMapping designates a controller action with URL path http://localhost:8080/hello
    @ResponseBody //
    public String hello(){
        return "hello";
    }




    // Controllers with parameters
    @GetMapping("queryparam")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name){ // http://localhost:8080/queryparam?name=Chris
        return "Hello, " + name + "!";
    }

    @GetMapping("queryparam2/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){ // http://localhost:8080/queryparam/Chris
        return "Hello, " + name + "!";
    }

    // Form submission

    // Method to display the form
    @GetMapping("form")
    @ResponseBody
    public String helloForm(){ // http://localhost:8080/queryparam?name=Chris
        return "<html>" +
                "<body>" +
                "<form action='queryparam'>" + // queryparam is coming from the handler method helloWithQueryParam()
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }



    // Controller method that handles GET and POST with path http://localhost:8080//hellogoodbye
    @RequestMapping(value="formwithgetpost", method={RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String helloGetPost(@RequestParam String name){
        return "Hello, " + name + " This method handles GET and POST";
    }

    // Form using POST
    @GetMapping("form4getpost")
    @ResponseBody
    public String helloFormPost(){ // http://localhost:8080/queryparam?name=Chris
        return "<html>" +
                "<body>" +
                "<form action='formwithgetpost' method='post'>" + // formwithgetpost is coming from the handler method helloGetPost()
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }






}
