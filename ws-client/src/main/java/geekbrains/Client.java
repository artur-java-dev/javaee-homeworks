package geekbrains;


import ru.geekbrains.soap.SoapServiceService;
import ru.geekbrains.soap.WebServiceInterface;

import static java.lang.System.out;


public class Client
{

  private static SoapServiceService service = new SoapServiceService();


  public static void main(String[] args)
  {
	WebServiceInterface port = service.getSoapServicePort();
	port.getAllProducts().forEach(out::println);
  }

}