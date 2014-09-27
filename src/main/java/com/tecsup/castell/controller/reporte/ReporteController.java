
package com.tecsup.castell.controller.reporte;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("reporte")
public class ReporteController {
    
     @RequestMapping("excel")
     public String excel(Model model){
         
         Map<String, String> notas = new HashMap<String, String>();
         notas.put("Pablo","12");
         notas.put("Eduardo","11.5");
         notas.put("Gino","10.5");
         notas.put("Milton","12");
         notas.put("Orlando","10");
         notas.put("Alonso","18");
         notas.put("Rocio","13");
         notas.put("Erick","14");
         notas.put("Renne","11");
        
         model.addAttribute("reporteNotas", notas);
         return "reporteExcel";
     }
     
     @RequestMapping("pdf")
     public String pdf(Model model){
         
         Map<String, String> notas = new HashMap<String, String>();
         notas.put("Pablo","12");
         notas.put("Eduardo","11.5");
         notas.put("Gino","10.5");
         notas.put("Milton","12");
         notas.put("Orlando","10");
         notas.put("Alonso","18");
         notas.put("Rocio","13");
         notas.put("Erick","14");
         notas.put("Renne","11");
        
         model.addAttribute("reporteNotas", notas);
         return "reportePDF";
     }
    
}
