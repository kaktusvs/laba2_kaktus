package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/")
    public String home() {
        return """
               <!DOCTYPE html>
               <html lang="en">
               <head>
                   <meta charset="UTF-8">
                   <meta name="viewport" content="width=device-width, initial-scale=1.0">
                   <title>Simple Calculator</title>
               </head>
               <body>
                   <h1>Calculator</h1>
                   <form action="/calculate" method="post">
                       <label for="expression">Enter Expression:</label>
                       <input type="text" id="expression" name="expression" required>
                       <button type="submit">Calculate</button>
                   </form>
                   <h2>Result: <span id="result"> </span></h2>
               </body>
               </html>
               """;
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam String expression) {
        try {
            Expression exp = new ExpressionBuilder(expression).build();
            double result = exp.evaluate();
            return "<h1>Result: " + result + "</h1><br><a href='/'>Go Back</a>";
        } catch (Exception e) {
            return "<h1>Error: Invalid expression</h1><br><a href='/'>Go Back</a>";
        }
    }
}
