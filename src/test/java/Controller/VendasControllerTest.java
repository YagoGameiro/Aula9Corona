package Controller;


import Aula7.MyApplication;
import Aula7.model.Vendas;
import Aula7.service.VendasService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApplication.class)
@WebAppConfiguration
public class VendasControllerTest {

    @Autowired
    private VendasService vendasService;

    @Test
    public void save() throws Exception {

        long qtd = 200;

        vendasService.deleteAll();

        for ( int i = 1 ; i <= qtd ; i++){
            vendasService.sendVendasRabbit(new Vendas("teste"+i));
        }

        Thread.sleep(5000);
        List<Vendas> lst = vendasService.findAll();

        System.out.println("Qtd:" + lst.size());
        Assert.assertEquals(lst.size(), qtd);
    }

}