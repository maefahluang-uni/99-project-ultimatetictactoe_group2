package th.mfu;



import java.util.HashSet;

import java.util.Locale;
import java.util.Random;

import javax.transaction.Transactional;
import java.util.Set;

import org.apache.tomcat.jni.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import th.mfu.domain.game;
import th.mfu.domain.loser;
import th.mfu.domain.player;
import th.mfu.domain.winner;

@Controller
public class TictactoeController {
    private static final Logger logger = LoggerFactory.getLogger(TictactoeController.class);
    private static final Random random = new Random();
    private static final Set<String> useIds = new HashSet<>();
    player p1=null;
    player p2= null;

    // @Autowired
    // NameRepository namerepo;

    // @Autowired
    // IDRepository idrepo;

    @Autowired
    Playerrepository playerrepo;

    @Autowired
    WinnerRepository winnerrepo;

    @Autowired
    LoserRepository loserrepo;

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

    public TictactoeController(Playerrepository playerrepio, WinnerRepository winnerrepo, LoserRepository loserrepo) {

        // this.namerepo = namerepo;
        // this.idrepo = idrepo;
        this.playerrepo = playerrepio;
        this.winnerrepo = winnerrepo;
        this.loserrepo = loserrepo;
    }

    @GetMapping("/tictactoe")
    public String tictactoe(Model model) {
        model.addAttribute("Model", model);
        return "homepageX";
    }

    @GetMapping("/XSignUp")
    public String signUp(Model model) {
        
        return "Xsignup1";
    }

    @PostMapping("/XSignUp")
    public String UserName(Model model,@RequestParam String ingamename) {
        model.addAttribute("name", new game());
        Long id= Long.parseLong(generateUniqueRandomNumericId(5));
        p1= new player( id,ingamename);
        playerrepo.save(p1);
        model.addAttribute("id",p1.getId() );
        return "Xsignup2";
    }

    @GetMapping("/XSignUp/{id}")
    public String Xsignup(@ModelAttribute player newplayer, @PathVariable long id){
        String uniqueId = generateUniqueRandomNumericId(5);
        newplayer.setId(Long.valueOf(uniqueId));
        //idrepo.save(newplayer);
        return "homepageO";
    }
    

    @GetMapping("/OSignUp")
    public String signUp1(Model model) {
        return "Osignup1";
    }

    @PostMapping("/OSignUp")
    public String UserName1(Model model,@RequestParam String ingamename) {
        model.addAttribute("name", new game());
        Long id= Long.parseLong(generateUniqueRandomNumericId(5));
        p2= new player( id,ingamename);
        playerrepo.save(p2);
        model.addAttribute("id",p2.getId() );
        return "Osignup2";
    }

    @Transactional
    @GetMapping("/OSignUp/{id}")
    public String Osignup(@ModelAttribute player newplayer, @PathVariable long id){
        String Id = generateRandomNumericId(5);
        id = Long.valueOf(Id);
        newplayer.setId(id);
        //idrepo.save(newplayer);
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
    public String Xwinner(@ModelAttribute winner winner, @ModelAttribute loser loser){
        player player = playerrepo.findById(p1.getId()).get();
        winner.setPlayer(player);
        winnerrepo.save(winner);
        logger.info("Inside Xwinner method");

        player player2 = playerrepo.findById(p2.getId()).get();
        loser.setPlayer(player2);
        loserrepo.save(loser);
        logger.info("Inside Oloser method");

        return "Xwinner";
    }

    @GetMapping("/Owin")
    public String Owinner(@ModelAttribute winner winner){
        player player = playerrepo.findById(p2.getId()).get();
        winner.setPlayer(player);
        winnerrepo.save(winner);
        logger.info("Inside Owinner method");
        return "Owinner";
    }

    @GetMapping("/Xlogin")
    public String showXLoginPage() {
        return "Xlogin";
    }

    @PostMapping("/Xlogin")
    public String loginX(@RequestParam Long playerId, Model model) {
        player player = playerrepo.findById(playerId).orElse(null);

        if (player != null) {
            model.addAttribute("player", player);
            return "homepageO";
        } else {
            return "homepageX";
        }
    }

     @GetMapping("/Ologin")
    public String showOLoginPage() {
        return "Ologin";
    }

    @PostMapping("/Ologin")
    public String loginO(@RequestParam Long playerId, Model model) {
        player player = playerrepo.findById(playerId).orElse(null);

        if (player != null) {
            model.addAttribute("player", player);
            return "final";
        } else {
            return "homepageO";
        }
    }

    
}
