package com.example.springkadaiform.controller;

import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;



@Controller
public class ContactFormController {
	// フォーム画面の表示
	@GetMapping("/form")
	public String form(Model model) {
	
		if (!model.containsAttribute("contactForm")) {
			model.addAttribute("contactForm", new ContactForm()); 
			
		}
		return "contactFormView"; // ビューの呼び出し
	}

	// 確認画面の表示
	@PostMapping("/confirm")
	public String confirm(RedirectAttributes redirectAttributes,
			@Validated ContactForm contactForm,BindingResult result) {
		
		// バリデーションエラーがあったら
		if (result.hasErrors()) {
			// フォームクラスをビューに受け渡す
			redirectAttributes.addFlashAttribute("contactForm", contactForm);
			
			// バリデーション結果をビューに受け渡す
			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX
					+ Conventions.getVariableName(contactForm), result);
			
			// お問い合わせフォーム画面を再表示
			return "redirect:/form";
		}
		
		// エラーがなければ確認画面を表示
		return "confirmView";
		
	}

}


