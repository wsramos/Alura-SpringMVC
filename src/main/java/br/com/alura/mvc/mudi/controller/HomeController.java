package br.com.alura.mvc.mudi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.mudi.model.Pedido;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String home(Model model) {
		
		Pedido pedido = new Pedido();
		pedido.setNomeProduto("Xiaomi Redmi Note 11");
		pedido.setUrlImagem("https://m.media-amazon.com/images/I/51e3KdrHuCL._AC_SL1080_.jpg");
		pedido.setUrlProduto("https://www.amazon.com.br/Xiaomi-Redmi-Note-11-Graphite/dp/B09QSB4N2C?ref_=Oct_Oct_d_otopr_d_16243803011_0&pd_rd_w=QeMru&content-id=amzn1.sym.ecc25cc1-ec38-4678-aabf-b9da0181edb4&pf_rd_p=ecc25cc1-ec38-4678-aabf-b9da0181edb4&pf_rd_r=G8P92N9VX3PW1ATCXQAY&pd_rd_wg=SYuGc&pd_rd_r=f9f831ad-4dd3-4914-bb88-3916a15bf40c&pd_rd_i=B09QSB4N2C");
		pedido.setDescricao("Lorem Ipsum");
		
		Pedido pedido2 = new Pedido();
		pedido2.setNomeProduto("Xiaomi Redmi Note 11");
		pedido2.setUrlImagem("https://m.media-amazon.com/images/I/51e3KdrHuCL._AC_SL1080_.jpg");
		pedido2.setUrlProduto("https://www.amazon.com.br/Xiaomi-Redmi-Note-11-Graphite/dp/B09QSB4N2C?ref_=Oct_Oct_d_otopr_d_16243803011_0&pd_rd_w=QeMru&content-id=amzn1.sym.ecc25cc1-ec38-4678-aabf-b9da0181edb4&pf_rd_p=ecc25cc1-ec38-4678-aabf-b9da0181edb4&pf_rd_r=G8P92N9VX3PW1ATCXQAY&pd_rd_wg=SYuGc&pd_rd_r=f9f831ad-4dd3-4914-bb88-3916a15bf40c&pd_rd_i=B09QSB4N2C");
		pedido2.setDescricao("Lorem Ipsum");
		
		List<Pedido> pedidos = new ArrayList<>();
		pedidos.add(pedido);
		pedidos.add(pedido2);
		
		model.addAttribute("pedidos", pedidos);
		
		return "home";
	}
}
