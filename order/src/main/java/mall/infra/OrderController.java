package mall.infra;
import mall.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/orders")
@Transactional
public class OrderController {
    @Autowired
    OrderRepository orderRepository;




    @RequestMapping(value = "/orders/place",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public Order place(HttpServletRequest request, HttpServletResponse response, 
        @RequestBody PlaceCommand placecommand) throws Exception {
            System.out.println("##### /order/place  called #####");
            Order order = New Order();
            order.place(placecommand);
            orderRepository.save(order);
            return order;
    }

}
//>>> Clean Arch / Inbound Adaptor
