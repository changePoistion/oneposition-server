package com.shopin.oneposition.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author changePosition
 * @version 2017年7月7日 下午6:03:21
 * @DESC 测试
 */
@RestController
@RequestMapping("/cart")
public class Test {
//	@RequestMapping(value = "/addCart/{cardId}", produces = "application/json;charset=UTF-8")
//	private String addCart(CartEntity cartEntity, @PathVariable("cardId") String cardId) {
//		return cardId + "   method:addCart" + cartEntity.getPro() + " " + cartEntity.getMobile();
//	}

	@RequestMapping("/deleteCart")
	private String deleteCart() {
		return "method:deleteCart";
	}

}
