package AOP;

import controllers.ProductController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductController productController = context.getBean("productController", ProductController.class);

        System.out.println(productController.getClass());

        context.close();
    }
}
