package controllers;

import models.Order;
import org.codehaus.jackson.JsonNode;
import play.Configuration;
import play.libs.Json;
import play.libs.WS;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

  private static String hostname = Configuration.root().getString("railsapp.host");
  public static Result index() {
    return ok(index.render("Your new application is ready."));
  }

  public static Result getStatus(String orderId){
      String url_order = "http://" + hostname + "/order/show/" + orderId;
      Order orderObject;
      try{
          WS.Response promise = WS.url(url_order).get().get();
          JsonNode order = promise.asJson();
          orderObject = Json.fromJson(order,Order.class);
      }catch (RuntimeException e)
      {
          return ok(views.html.failure.render());
      }

      return ok(views.html.order.render(orderObject));
  }

  public static Result sendOrder(String orderId){
    return ok("success");
  }
  public static Result update(String orderId){

      String url_order = "http://" + hostname + "/order/update/"+ orderId;
      WS.Response promise = WS.url(url_order).post("status=Delivered").get();

      return ok(views.html.updated_message.render());
  }

}