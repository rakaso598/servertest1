package com.kh.product.web;

import com.kh.product.dao.entity.Product;
import com.kh.product.svc.ProductSVC;
import com.kh.product.web.form.CreateForm;
import com.kh.product.web.form.FindAllForm;
import com.kh.product.web.form.ReadForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductSVC productSVC;

    /*  -------------------- 상품등록 ------------------------- */

    // 상품등록양식 호출 GET
    @GetMapping("/create") // GET http://localhost:9090/products/create
    public String createForm(Model model){
        log.info("!! GET create 호출 !!");

        model.addAttribute("createForm", new CreateForm());
        return "/product/create";
        // http://localhost:9090/products/createForm?pname=%EB%85%B8%ED%8A%B8%EB%B6%81&quantity=1&price=80000
    }

    // 상품등록 행위 POST
    @PostMapping("/create") // POST http://localhost:9090/products/create
    public String create(@ModelAttribute CreateForm createForm,
                         RedirectAttributes redirectAttributes){
        log.info("!! POST create 호출 !!");

        Product product = new Product();
        product.setPname(createForm.getPname());
        product.setQuantity(createForm.getQuantity());
        product.setPrice(createForm.getPrice());
        Long pid = productSVC.createProduct(product);

        log.info("상품아이디={}",pid);

        redirectAttributes.addAttribute("pid", pid);

        // {id} 파라미터에 pid 를 넣은 후 => read 로 리다이렉트 (등록 후 상세조회)
        return "redirect:/products/{pid}/read";   // 302 GET http://localhost:9090/products/1/read
    }

    /*  -------------------- 상품등록 끝 ------------------------- */



    /*  -------------------- 상품목록조회 ------------------------- */
    //GET http://localhost:9090/products
    @GetMapping
    public String findAllForm(Model model){
        List<Product> list = productSVC.findAll();
        List<FindAllForm> allFormList = new ArrayList<>();

        for(Product product : list){
            FindAllForm findAllForm = new FindAllForm();
            findAllForm.setPid(product.getPid());
            findAllForm.setPname(product.getPname());
            allFormList.add(findAllForm);
        }
        model.addAttribute("allFormList",allFormList);
        return "product/findAll";

    }
    /*  -------------------- 상품목록조회 끝 ------------------------- */


    /*  -------------------- 상품상세조회 ------------------------- */
    @GetMapping("/{pid}/read")  //GET http://localhost:9090/products/{pid}/read
    public String readForm(
            @PathVariable("pid") Long pid,
            Model model){

        Optional<Product> readedProduct = productSVC.readById(pid); // {pid} 파라미터
        Product product = readedProduct.orElseThrow();

        ReadForm readForm = new ReadForm();
        readForm.setPid(product.getPid());
        readForm.setPname(product.getPname());
        readForm.setQuantity(product.getQuantity());
        readForm.setPrice(product.getPrice());

        model.addAttribute("readForm", readForm);
        return "product/read";
    }
    /*  -------------------- 상품상세조회 끝 ------------------------- */

    /*  -------------------- 상품삭제 ------------------------------ */
    // DELETE http://localhost:9090/products/{pid}
    @DeleteMapping("/{pid}")
    public String delete(@PathVariable("pid") Long pid){

        productSVC.deleteProduct(pid);

        //상품 삭제 후 상품 목록으로 이동
        return "redirect:/products/findAll";
        //상품 목록의 GET 주소 : http://localhost:9090/products/findAll
    }
    /*  -------------------- 상품수정 화면 ------------------------- */
    // GET http://localhost:9090/products/{pid}/update
    @GetMapping("/{pid}/update")
    public String update(@PathVariable("pid") Long pid){
        return null;
    }
    /*  -------------------- 상품수정 화면 끝 ------------------------- */
    /*  -------------------- 상품수정 처리 ------------------------- */








    /*  -------------------- 상품수정 처리 끝 ------------------------- */

}
