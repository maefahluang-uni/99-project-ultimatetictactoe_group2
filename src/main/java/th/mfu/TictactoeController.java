package th.mfu;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.transaction.Transactional;

import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/*@Controller
public class TictactoeController {
    
   
    @Autowired
    IDRepository IDrepo;

    @Autowired
    OmoveRepository Omove;

    @Autowired
    XmoveRepository Xmove;



    public TictactoeController( IDRepository idrepo, OmoveRepository omove, XmoveRepository xmove){
      
        this.IDrepo = idrepo;
        this.Omove = omove;
        this.Xmove = xmove;
    }

    @GetMapping("/tictactoe")
    public String tictactoe(Model model){
       model.addAttribute("", model);
       return "";
    }

    @GetMapping("/SignUp")
    public String signUp(Model model){
        model.addAttribute("name", new Tictactoe());
        return "";
    }

    @PostMapping("/GenerateID")
    public String GenerateID(@ModelAttribute Tictactoe newTictactoe){
        IDrepo.save(newTictactoe);
        return "";
    }

    @PostMapping("/login")
    public String logIn(Model model){
        model.addAttribute("ID", model);
        return "";
    }
    
    @GetMapping("/game")
    public String Game(Model model){
<<<<<<< HEAD
        return "";
=======
                  return "";
>>>>>>> 4febb31313dc037447a9cdddf45c3b35c5211907
    }
}*/




import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TictactoeController {
    private Tictactoe tictactoeModel = new Tictactoe();

    @GetMapping("/tictactoe")
    public String showTictactoeBoard(Model model) {
        model.addAttribute("mainBoard", tictactoeModel.getMainBoard());
        model.addAttribute("subBoards", tictactoeModel.getSubBoards());
        model.addAttribute("currentPlayer", tictactoeModel.getCurrentPlayer());
        model.addAttribute("gameEnded", tictactoeModel.isGameEnded());
        model.addAttribute("winner", tictactoeModel.getWinner());
        return "tictactoe"; // This should correspond to your view template name (tictactoe.html)
    }

    @PostMapping("/tictactoe/makeMove")
    public String makeMove(
            @RequestParam int mainRow,
            @RequestParam int mainCol,
            @RequestParam int subRow,
            @RequestParam int subCol) {
        tictactoeModel.makeMove(mainRow, mainCol, subRow, subCol);
        return "redirect:/tictactoe";
    }
}


