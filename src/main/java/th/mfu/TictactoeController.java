package th.mfu;



import java.util.HashSet;

import java.util.Locale;
import java.util.Random;

import javax.transaction.Transactional;
import java.util.Set;

import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TictactoeController {

    private static final Random random = new Random();
    private static final Set<String> useIds = new HashSet<>();

    @Autowired
    NameRepository namerepo;

    @Autowired
    IDRepository idrepo;

    public static String generateUniqueRandomNumericId(int length) {
        while (true) {
            String id = generateRandomNumericId(length);
            if (!useIds.contains(id)) {
                useIds.add(id);
                return id;
            }
        }
    }

    private static String generateRandomNumericId(int length) {
        StringBuilder id = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            id.append(random.nextInt(10));
        }
        return id.toString();
    }

    public TictactoeController(NameRepository namerepo, IDRepository idrepo) {

        this.namerepo = namerepo;
        this.idrepo = idrepo;
    }

    @GetMapping("/tictactoe")
    public String tictactoe(Model model) {
        model.addAttribute("Model", model);
        return "homepageX";
    }

    @GetMapping("/XSignUp")
    public String signUp(Model model) {
        model.addAttribute("name", new game());
        return "Xsignup1";
    }

    @PostMapping("/XSignUp")
    public String UserName(@ModelAttribute player newPlayer) {
        namerepo.save(newPlayer);
        return "Xsignup2";
    }

    @Transactional
    @GetMapping("/XSignUp/{id}")
    public String Xsignup(@ModelAttribute player newplayer, @PathVariable long id){
        String uniqueId = generateUniqueRandomNumericId(5);
        newplayer.setId(Long.valueOf(uniqueId));
        idrepo.save(newplayer);
        return "homepageO";
    }
    

    @GetMapping("/OSignUp")
    public String signUp1(Model model) {
        model.addAttribute("name", new game());
        return "Osignup1";
    }

    @PostMapping("/OSignUp")
    public String UserName1(@ModelAttribute player newPlayer) {
        namerepo.save(newPlayer);
        return "Osignup2";
    }

    @Transactional
    @GetMapping("/OSignUp/{id}")
    public String Osignup(@ModelAttribute player newplayer, @PathVariable long id){
        String Id = generateRandomNumericId(5);
        id = Long.valueOf(Id);
        newplayer.setId(id);
        idrepo.save(newplayer);
        return"final";
    }

    @GetMapping("/restartgame")
    public String restart(Model model){
        return "final";
    }

    @GetMapping("/replay")
    public String replay(Model model){
        return "final";
    }

    @GetMapping("/tie")
    public String Tie(Model model){
        return "XOtie";
    }

    @GetMapping("/Xwin")
    public String Xwinner(Model model){
        return "Xwinner";
    }

    @GetMapping("/Owin")
    public String Owinner(Model model){
        return "Owinner";
    }

    @GetMapping("/Xlogin")
    public String showXLoginPage() {
        return "Xlogin";
    }

    @PostMapping("/Xlogin")
    public String loginX(@RequestParam Long playerId, Model model) {
        player player = idrepo.findById(playerId).orElse(null);

        if (player != null) {
            model.addAttribute("player", player);
            return "redirect:/Ologin";
        } else {
            return "redirect:/homepageX.html";
        }
    }

     @GetMapping("/Ologin")
    public String showOLoginPage() {
        return "Ologin";
    }

    @PostMapping("/Ologin")
    public String loginO(@RequestParam Long playerId, Model model) {
        player player = idrepo.findById(playerId).orElse(null);

        if (player != null) {
            model.addAttribute("player", player);
            return "redirect:/final.html";
        } else {
            return "redirect:/homepageO.html";
        }
    }

    @GetMapping("/game")
    public String Game(Model model) {
        return "ttt";
    }

}
