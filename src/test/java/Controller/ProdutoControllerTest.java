package Controller;


import Aula7.MyApplication;
import Aula7.model.Produto;
import Aula7.service.ProdutoService;
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
public class ProdutoControllerTest {

    @Autowired
    private ProdutoService produtoService;

    @Test
    public void save() throws Exception {

        long qtd = 200;

        produtoService.deleteAll();

        for ( int i = 1 ; i <= qtd ; i++){
            produtoService.sendProdutoRabbit(new Produto("teste"+i));
        }

        Thread.sleep(5000);
        List<Produto> lst = produtoService.findAll();

        System.out.println("Qtd:" + lst.size());
        Assert.assertEquals(lst.size(), qtd);
    }

}