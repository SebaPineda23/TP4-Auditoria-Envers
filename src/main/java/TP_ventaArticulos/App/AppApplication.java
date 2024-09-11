package TP_ventaArticulos.App;


import TP_ventaArticulos.App.Servicio.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AppApplication.class, args);
		MyService myService = context.getBean(MyService.class);
		myService.run();
	}
}
